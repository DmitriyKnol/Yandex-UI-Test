package main.pom;

import org.openqa.selenium.By;

public class MainPage {
    // Кнопка входа на главной странице
    private final By loginButton = By.xpath(".//button[@aria-label ='Войти']");
    // Кнопка "Войти с помощью ID"
    private final By loginButtonFromID = By.xpath(".//span[text() ='Войти через Яндекс ID']");
    // Поле поиска
    private final By searchFieald = By.xpath(".//input[@aria-label ='Запрос']");
    // Кнопка "Ещё"
    private final By moreButton = By.className("desktop-services__more-icon");
    // Кнопка сервиса Яндекс Диск
    private final By yaDisk = By.id("services-big-item-disk-title");
}
