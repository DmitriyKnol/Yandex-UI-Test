package main.pom;

import org.openqa.selenium.By;

public class LoginPage {
    // Кнопка "Войти в другой аккаунт"
    private final By useNewAccount = By.className("AddAccountButton-text");

    // Кнопка "Почта" для входа через почту
    private final By enterUseEmail = By.xpath(".//button[@data-type ='login']");

    // Поле, для ввода имени пользователя
    private final By emailField = By.id("passp-field-login");

    // Кнопка "Войти"
    private final By enterNameButton = By.id("passp:sign-in");

    // Поле ввода пароля
    private final By passwordField = By.id("passp-field-passwd");

    private static final String url = "https://yandex.ru/";
}
