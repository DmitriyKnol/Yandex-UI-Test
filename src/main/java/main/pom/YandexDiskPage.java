package main.pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YandexDiskPage {
    // Раздел "Файлы"
    private final By filesButton = By.id("/disk");
    // Папка с файлом для копирования
    private final By oldFolder = By.xpath(".//div[@aria-label ='Папка для копирования']");
    // Конечная папка
    private final By newFolder = By.xpath(".//div[@aria-label ='Новая папка']");
    // Файл для копирования
    private final By oldFile = By.xpath(".//div[@aria-label = 'CopyMe.docx']");
    // Скопированный файл
    // private final By newFile = By.xpath(".//div[@aria-label = 'CopyMe.docx']/span");

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

    @Step("Выход из аккаунта")
    public void logout() {
        clickLogo();
        clickLogoutButton();
    }
}
