package main;

import io.qameta.allure.Step;
import main.pom.LoginPage;
import main.pom.MainPage;
import main.pom.YandexDiskPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class BaseTest {
    /* В этом задании можно было обойтись без класса BaseTest, так как тестируемых сущностей не много
     * однако, если тесты будут разрастаться, чтобы избежать дублирования кода в разных тестовых классах,создан класс BaseTest,
     * он позволит избежать дублирования и повторяющиеся создания экземпляров классов POM */
    private ChromeDriver driver = new ChromeDriver();
    Actions action = new Actions(driver);
    private final String loginEmail = "dmitriy.knol";
    private final String loginPassword = "!Qq8303239";

    MainPage mainPage = new MainPage(driver);
    LoginPage loginPage = new LoginPage(driver);
    YandexDiskPage yandexDiskPage = new YandexDiskPage(driver);

    public WebDriver getDriver() {
        return driver;
    }

    public Actions getAction() {
        return action;
    }
    @Step("Открытие страницы Yandex.ru")
    public void openUrl() {
        driver.get(mainPage.getUrl());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Step("Переход в Яндекс.Диск")
    public void openUrlYandexdisk() {
        driver.get(yandexDiskPage.getUrlYandexDisk());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Step("Подготовка к авторизации пользователя")
    public void prepareForLogin() {
        mainPage.loginStart();
    }

    @Step("Авторизация пользователя")
    public void baseLogin() {
        loginPage.login(loginEmail, loginPassword);
    }

    @Step("Создание новой папки")
    public void createFolder() {
        yandexDiskPage.createNewFolder();
    }

    public void baseAfter(WebDriver driver) {
        driver.quit();
    }
}
