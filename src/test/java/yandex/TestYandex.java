package yandex;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import  org.testng.Assert;
import org.testng.annotations.Test;


public class TestYandex extends BaseTest {



    String mailTheme = "Тест письмо №1";
    String mailSender = "aviktorov174@gmail.com";
    String mailText = "Это письмо №1";



    @Test
    public void Test(){
        LoginPage loginpage = new LoginPage(driver);
        loginpage.login();

        MailPage mailpage = new MailPage(driver);
        mailpage.findMailbyTheme(mailTheme);

        MailCard mailcard = new MailCard(driver);
        mailcard.mailTheme(mailTheme);
        mailcard.mailSender(mailSender);
        mailcard.mailText(mailText);

        mailpage.quit();
    }





}
