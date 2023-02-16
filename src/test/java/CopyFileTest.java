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
    @DisplayName("Создание папки в Яндекс.Диске и копирование файла")
    public void moveFileTest() {
        yandexDiskPage.copyFileToNewFolder(getAction());
        yandexDiskPage.goToAllFiles();
        yandexDiskPage.openNewFolder(getAction());
        assertTrue(yandexDiskPage.getFile().isDisplayed());
        assertEquals("CopyMe.docx", yandexDiskPage.getTextNewFile());
    }

    @After
    public void deleteAndLogout() {
        yandexDiskPage.goToAllFiles();
        yandexDiskPage.deleteNewFolders(getAction());
        yandexDiskPage.logout();
        baseAfter(getDriver());
    }
}
