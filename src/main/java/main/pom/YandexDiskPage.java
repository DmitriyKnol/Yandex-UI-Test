package main.pom;

import org.openqa.selenium.By;

public class YandexDiskPage {
    // Раздел "Файлы"
    private final By filesButton = By.id("/disk");
    // Папка с файлом для копирования
    private final By oldFolder = By.xpath(".//span[text() ='Папка для копирования']");
    // Файл для копирования
    private final By oldFile = By.xpath(".//span[text() ='Файл для копирования']");
    // Кнопка копировать из контекстного меню
    private final By copyButton = By.xpath(".//span[text() ='Копировать']");
    // Папка в которую нужно сохранить файл
    private final By selectNewFolder = By.xpath(".//div[@title ='Новая папка']");
    // Кнопка копировать
    private final By copyFile = By.xpath(".//button/span[text() = 'Копировать']");
    // Кнопка создать
    private final By create = By.className("create-resource-popup-with-anchor");
    // Кнопка выбора создания Папки
    private final By createFolder = By.xpath(".//button[@aria-label ='Папку']");
    // Поле ввода имени
    private final By enterNameFolder = By.className("Textinput-Control");
    // Кнопка Сохранить
    private final By saveNameFolder = By.xpath(".//button/span[text() = 'Сохранить']");

}
