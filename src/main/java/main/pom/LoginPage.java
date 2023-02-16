package main.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    // Кнопка "Почта" для входа через почту
    private final By enterUseEmail = By.xpath(".//div[@class = 'AuthLoginInputToggle-type']/button");

    // Поле, для ввода имени пользователя
    private final By emailField = By.id("passp-field-login");

    // Кнопка "Войти"
    private final By enterButton = By.id("passp:sign-in");

    // Поле ввода пароля
    private final By passwordField = By.id("passp-field-passwd");
    // Кнопка найти
    private final By search = By.xpath(".//button[text() = 'Найти']");

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginFromEmail() {
        driver.findElement(enterUseEmail).click();
    }

    public void enterEmailFeild(String login) {
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(login);
    }

    public void clickEnter() {
        driver.findElement(enterButton).click();
    }

    public void enterPasswordFeild(String password) {
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    public void login(String login, String password) {
        clickLoginFromEmail();
        enterEmailFeild(login);
        clickEnter();
        enterPasswordFeild(password);
        clickEnter();
        WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(search));
    }
}
