package yandex;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class MailPage {
    WebDriver driver;
    public MailPage(WebDriver driver) {this.driver = driver;}
    Actions actions = new Actions(driver);
    WebDriverWait wait = new WebDriverWait(driver, 5);

    String searchField = "input.textinput__control";
    String searchButton = "button.button2.button2_view_classic.button2_size_m.button2_theme_normal.button2_pin_brick-round.mail-SearchContainer-Button";
    String mailLink = "span.mail-MessageSnippet-FromText";
    String username = "div.mail-User-Name";
    String quit = "a.b-mail-dropdown__item__content.js-user-dropdown-item";
    String year = "a.b-mail-paginator__link.b-link_w.item-2018.ns-action";


    MailPage findMailbyTheme(String mailTheme) {
        WebElement thatYear = driver.findElement(By.cssSelector(year));
        driver.findElement(By.cssSelector(searchField)).sendKeys(mailTheme);
        driver.findElement(By.cssSelector(searchButton)).click();
        wait.until(ExpectedConditions.stalenessOf(thatYear));
        WebElement mail = driver.findElement(By.cssSelector(mailLink));
        actions.moveToElement(mail).click().build().perform();
        return this;
    }

    MailPage quit() {
        driver.findElement(By.cssSelector(username)).click();
        driver.findElement(By.cssSelector(quit)).click();
        return this;
    }
}
