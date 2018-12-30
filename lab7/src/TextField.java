package rozetka.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.UnsupportedEncodingException;

public class TextField {
    WebElement element;

    public TextField(WebDriver driver, String xpath){this.element = driver.findElement(By.xpath(xpath));}

    public void fillTextField(String info){ element.sendKeys(info); }

    public void clearTextField() {
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.DELETE);
    }

}
