package rozetka.webobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import rozetka.elements.HtmlLabel;
import rozetka.elements.WaitElement;

public class DeliveryPage {

    private String url;
    private WebDriver driver;
    public static final String confirmOrederButtonXpath = "//*[@id=\"make-order\"]";


    public DeliveryPage(WebDriver driverParam){
        this.driver = driverParam;
        HtmlLabel.printCurrentUrl(driver);
        this.url = driver.getCurrentUrl();
    }

    public void deliveryPageWait(){ WaitElement.driverWait(); }

    public void checkOrderButtonActive(){
        if (driver.findElement(By.xpath(confirmOrederButtonXpath)).isEnabled()) System.out.println("Oder button is active");
        else System.out.println("Order button is unactive");
    }
}
