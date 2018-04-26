package yandex;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class MailCard {

    WebDriver driver;

    public MailCard(WebDriver driver) {
        this.driver = driver;
    }


    String getMailTheme, getMailSender, getMailText;
    String themeSelector = "div.mail-Message-Toolbar-Subject.mail-Message-Toolbar-Subject_message.js-toolbar-subject.js-subject-content.js-invalid-drag-target";
    String senderSelector = "span.mail-Message-Sender-Email.mail-ui-HoverLink-Content";
    String textSelector = "div.mail-Message-Body-Content";

    public MailCard mailTheme(String mailTheme) {
        WebElement theme = driver.findElement(By.cssSelector(themeSelector));
        getMailTheme = theme.getText();
        Assert.assertTrue(getMailTheme.equals(mailTheme));
        return this;
    }

    public MailCard mailSender(String mailSender) {
        WebElement sender = driver.findElement(By.cssSelector(senderSelector));
        getMailSender = sender.getText();
        Assert.assertTrue(getMailSender.equals(mailSender));
        return this;
    }

    public MailCard mailText(String mailText) {
        WebElement text = driver.findElement(By.cssSelector(textSelector));
        getMailText = text.getText();
        Assert.assertTrue(getMailText.contains(mailText));
        return this;
    }


}
