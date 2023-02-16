package main.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    // Кнопка входа на главной странице
    private final By loginButton = By.xpath(".//button[@aria-label ='Войти']");
    // Кнопка "Войти с помощью ID"
    private final By loginButtonFromID = By.xpath(".//span[text() ='Войти через Яндекс ID']");

    private final WebDriver driver;

    private final String url = "https://yandex.ru/";

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public void clickLoginFromId() {
        driver.findElement(loginButtonFromID).click();
    }

    public void loginStart() {
        clickLogin();
        clickLoginFromId();
    }
}
