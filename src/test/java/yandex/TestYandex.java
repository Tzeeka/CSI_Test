package yandex;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import  org.testng.Assert;
import org.testng.annotations.Test;

public class TestYandex extends BaseTest {

    String mailTheme = "Тест письмо №1";
    String mailSender = "aviktorov174@gmail.com";
    String mailText = "Это письмо №1";

    String url = "https://www.yandex.ru/";
    String login = "csitest1@yandex.ru";
    String password = "v6R2Xi*zk";
    String logButton= "body > div.container.rows > div.row.rows__row.rows__row_main > div.desk-notif__wrapper > div > div.desk-notif-card.desk-notif-card_type_login-exp.desk-notif-card_bg_default.i-bem.desk-notif-card_js_inited > div > a";
    String loginField = "input.passport-Input-Controller";
    String passwordField = "passwd";
    String enterButton = "span.passport-Button-Text";
    String searchField = "input.textinput__control";
    String searchButton = "button.button2.button2_view_classic.button2_size_m.button2_theme_normal.button2_pin_brick-round.mail-SearchContainer-Button";
    String mailLink = "span.mail-MessageSnippet-FromText";
    String getMailTheme, getMailSender, getMailText;
    String themeSelector = "div.mail-Message-Toolbar-Subject.mail-Message-Toolbar-Subject_message.js-toolbar-subject.js-subject-content.js-invalid-drag-target";
    String senderSelector = "span.mail-Message-Sender-Email.mail-ui-HoverLink-Content";
    String textSelector = "div.mail-Message-Body-Content";
    String username = "div.mail-User-Name";
    String quit = "a.b-mail-dropdown__item__content.js-user-dropdown-item";
    String year = "a.b-mail-paginator__link.b-link_w.item-2018.ns-action";

    @Test
    public void LoginTest() {
        driver.get(url);
        WebElement loginButton = driver.findElement(By.cssSelector(logButton));
        loginButton.click();
        driver.findElement(By.cssSelector(loginField)).sendKeys(login);
        driver.findElement(By.name(passwordField)).sendKeys(password);
        driver.findElement(By.cssSelector(enterButton)).click();
    }


    @Test
    public void findMail() {
        WebElement thatYear = driver.findElement(By.cssSelector(year));
        driver.findElement(By.cssSelector(searchField)).sendKeys(mailTheme);
        driver.findElement(By.cssSelector(searchButton)).click();
        wait.until(ExpectedConditions.stalenessOf(thatYear));
        WebElement mail =  driver.findElement(By.cssSelector(mailLink));
        actions.moveToElement(mail).click().build().perform();
    }

    @Test
    public void senderMailTheme() {
        WebElement theme = driver.findElement(By.cssSelector(themeSelector));
        getMailTheme = theme.getText();
        Assert.assertTrue(getMailTheme.equals(mailTheme));

        WebElement sender = driver.findElement(By.cssSelector(senderSelector));
        getMailSender = sender.getText();
        Assert.assertTrue(getMailSender.equals(mailSender));

        WebElement text = driver.findElement(By.cssSelector(textSelector));
        getMailText = text.getText();
        Assert.assertTrue(getMailText.contains(mailText));

        driver.findElement(By.cssSelector(username)).click();
        driver.findElement(By.cssSelector(quit)).click();
    }
}
