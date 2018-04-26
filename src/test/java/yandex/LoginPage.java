package yandex;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    String login = "csitest1@yandex.ru";
    String password = "v6R2Xi*zk";


    By logButton = By.cssSelector("body > div.container.rows > div.row.rows__row.rows__row_main > div.desk-notif__wrapper > div > div.desk-notif-card.desk-notif-card_type_login-exp.desk-notif-card_bg_default.i-bem.desk-notif-card_js_inited > div > a");
    By loginField = By.cssSelector("input.passport-Input-Controller");
    By passwordField = By.name("passwd");
    By enterButton = By.cssSelector("span.passport-Button-Text");



    public MailPage login() {
        driver.get("https://www.yandex.ru/");
        driver.findElement(logButton).click();
        driver.findElement(loginField).sendKeys(login);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(enterButton).click();
        return new MailPage(driver);
    }
}
