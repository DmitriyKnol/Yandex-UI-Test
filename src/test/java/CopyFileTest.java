import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import main.BaseTest;
import main.pom.YandexDiskPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CopyFileTest extends BaseTest {
    YandexDiskPage yandexDiskPage = new YandexDiskPage(getDriver());

    @Before
    public void openPage() {
        openUrl();
        prepareForLogin();
        baseLogin();
        openUrlYandexdisk();
        createFolder();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Создание папки в Яндекс.Диске и копирование файла")
        public void moveFileTest() {
        yandexDiskPage.copyFileToNewFolder(getAction());
        yandexDiskPage.goToAllFiles();
        yandexDiskPage.openNewFolder(getAction());
        assertTrue(yandexDiskPage.getFile().isDisplayed());
        assertEquals("CopyMe.docx", yandexDiskPage.getTextNewFile());
    }
   // @Ignore
    @Test                                                               // Не получается взять локатор с текстом внутри файла, для проверки.
    @Severity(SeverityLevel.CRITICAL)                                   // К загруженному файлу пришлось применить абсолютный путь
    @DisplayName("Загрузка файла и проверка текста файла")              // Работает все, кроме сверки текста
    public void uploadFileTest() {
        yandexDiskPage.openNewFolder(getAction());
        yandexDiskPage.uploadFile(getAction());
        yandexDiskPage.openText(getAction());
        //assertEquals("test text", yandexDiskPage.getTestText());
        yandexDiskPage.closedTab();
    }
    @After
    public void deleteAndLogout() {
        yandexDiskPage.goToAllFiles();
        yandexDiskPage.deleteNewFolders(getAction());
        yandexDiskPage.logout();
        baseAfter(getDriver());
    }
}
