package main.pom;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class YandexDiskPage {
    // Раздел "Файлы"
    private final By filesButton = By.id("/disk");
    // Папка с файлом для копирования
    private final By oldFolder = By.xpath(".//div[@aria-label ='Папка для копирования']");
    // Конечная папка
    private final By newFolder = By.xpath(".//div[@aria-label ='Новая папка']");
    // Файл для копирования
    private final By oldFile = By.xpath(".//div[@aria-label = 'CopyMe.docx']");

    // Кнопка копировать из контекстного меню
    private final By copyButton = By.xpath(".//span[text() ='Копировать']");
    // Кнопка удалить из контекстного меню
    private final By deleteButton = By.xpath(".//span[text() ='Удалить']");
    // Папка в которую нужно сохранить файл
    private final By selectNewFolder = By.xpath(".//div[@title ='Новая папка']");
    // Кнопка копировать
    private final By copyFile = By.xpath(".//button[@class = 'Button2 Button2_view_action Button2_size_m confirmation-dialog__button confirmation-dialog__button_submit ']");
    // Кнопка создать
    private final By create = By.className("create-resource-popup-with-anchor");
    // Кнопка выбора создания Папки
    private final By createFolder = By.xpath(".//button[@aria-label ='Папку']");
    // Поле ввода имени
    private final By enterNameFolder = By.className("Textinput-Control");
    // Кнопка Сохранить
    private final By saveNameFolder = By.xpath(".//div[@class = 'confirmation-dialog__footer']/button");
    // Сообщение об успешном копировании
    private final By copySuccessfullMesage = By.xpath(".//div[text()='Файл «CopyMe.docx» скопирован в папку «Новая папка»']");
    // Значек аккаунта
    private final By logoAccount = By.xpath(".//a[@aria-label = 'Аккаунт']/div");
    // Кнопка выхода из аккаунта
    private final By logoutButton = By.xpath(".//span[text()='Выйти']");
    // Пространство с файлами
    private final By area = By.xpath(".//div[@class='root__content-container']");
    // Кнопка Загрузить файл
    private final By uploadFile = By.xpath(".//input[@class='context-menu-create-popup__upload-input']");
    // Загруженный файл
    private final By fileToTest = By.xpath(".//div[@aria-label='test.txt']");
    // Сообщение Все файлы загружены
    private final By uploadSaccessfull = By.xpath(".//h3[text()='Все файлы загружены']");
    // Текст внутри файла
    // private final By testText = By.xpath("/html/body/div/div/div/div/div[1]/div/div[4]/div/div/div/p");
    // private final By testText = By.cssSelector("p[class='mg1]");
    // Кнопка Поделиться
    private final By sendButton = By.className("hover-tooltip__tooltip-anchor");

    private WebDriver driver;

    private final String urlYandexDisk = "https://disk.yandex.ru/";

    public YandexDiskPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getUrlYandexDisk() {
        return urlYandexDisk;
    }

    public void clickCreate() {
        driver.findElement(create).click();
    }

    public void clickCreateFolder() {
        driver.findElement(createFolder).click();
    }

    public void enterNameFolder() {
        driver.findElement(enterNameFolder).clear();
        driver.findElement(enterNameFolder).sendKeys("Новая папка");
        driver.findElement(saveNameFolder).click();
    }

    public void createNewFolder() {
        clickCreate();
        clickCreateFolder();
        enterNameFolder();
    }

    public void openOldFolder(Actions action) {

        action.doubleClick(driver.findElement(oldFolder)).perform();
    }

    public void contextClickToOldFile(Actions action) {
        action.contextClick(driver.findElement(oldFile)).perform();
    }

    public void copyToNewFolder() {
        driver.findElement(copyButton).click();
        driver.findElement(selectNewFolder).click();
        driver.findElement(copyFile).click();
        WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(copySuccessfullMesage));
    }

    @Step("Копирование в файла в новую папку")
    public void copyFileToNewFolder(Actions action) {
        openOldFolder(action);
        contextClickToOldFile(action);
        copyToNewFolder();
    }

    public void goToAllFiles() {
        driver.findElement(filesButton).click();
        driver.navigate().refresh();
    }

    @Step("Переход в новую папку")
    public void openNewFolder(Actions action) {
        action.doubleClick(driver.findElement(newFolder)).perform();
    }

    public WebElement getFile() {
        return driver.findElement(oldFile);
    }

    @Step("Проверка названия новой папки")
    public String getTextNewFile() {
        return getFile().getText();
    }

    public void contextClickToNewFolder(Actions action) {
        action.contextClick(driver.findElement(newFolder)).perform();
    }

    public void clickDelete() {
        driver.findElement(deleteButton).click();
    }

    @Step("Удаление папки")
    public void deleteNewFolders(Actions action) {
        contextClickToNewFolder(action);
        clickDelete();
    }

    public void clickLogo() {
        driver.findElement(logoAccount).click();
    }

    public void clickLogoutButton() {
        driver.findElement(logoutButton);
    }

    public void clickContext(Actions action) {
        action.contextClick(driver.findElement(area)).perform();
    }

    @Step("Загрузка txt файла")
    public void uploadFile(Actions action) {
        clickContext(action);
        driver.findElement(uploadFile).sendKeys("C:/Users/User/Downloads/test.txt");
    }

    @Step("Открытие файла для проверки текста")  // Не работает, дописать
    public void openText(Actions action) {
        WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(uploadSaccessfull));
        action.doubleClick(driver.findElement(fileToTest)).perform();
    }

    //    public String getTestText() {
//        WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(3))
//            .until(ExpectedConditions.visibilityOfElementLocated(sendButton));
////        JavascriptExecutor js = (JavascriptExecutor) driver;
////        WebElement element;
////        element = (WebElement) js.executeScript("return  document.querySelector(\"p[class='mg1']\");");
////
////        JavascriptExecutor js = (JavascriptExecutor) driver;
////        String text = js.executeScript("return window.getComputedStyle(document.querySelector('.mg1'))")
////                .toString();
//
////               return  element.getText();
//    }
    @Step("Закрытие вкладки")
    public void closedTab() {
        ArrayList tabs2 = new ArrayList(driver.getWindowHandles());//Получение списка табов
        driver.switchTo().window(tabs2.get(1).toString());//Переключение на второй таб в браузере
        driver.close();//Закрытие активного таба
        driver.switchTo().window(tabs2.get(0).toString());//Переключение на первый таб в браузере
    }

    @Step("Выход из аккаунта")
    public void logout() {
        clickLogo();
        clickLogoutButton();
    }
}
