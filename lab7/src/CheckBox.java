package rozetka.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBox {
    WebElement element;

    public CheckBox(WebDriver driver, String xpath){this.element = driver.findElement(By.xpath(xpath));}

    public void clickBox(){ element.click(); }
}
