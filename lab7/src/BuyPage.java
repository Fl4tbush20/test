package rozetka.webobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import rozetka.context.BuyContext;
import rozetka.elements.HtmlLabel;
import rozetka.elements.WaitElement;

public class BuyPage {

    private String url;
    private WebDriver driver;
    public static final String buyButtonXpath = "/html/body/div[4]/div/div[3]/div/div[2]/div/div/div/div[1]/div[2]/div/div[1]/div[1]/div[1]/div/div[2]/div[2]/div[2]/div/form/span/span/button";
    public static final String confirmBuyButtonXpath = "//*[@id=\"popup-checkout\"]";


    public BuyPage(WebDriver driverParam){
        this.driver = driverParam;
        HtmlLabel.printCurrentUrl(driver);
        this.url = driver.getCurrentUrl();
    }

    public void clickBuy() {driver.findElement(By.xpath(buyButtonXpath)).click();}

    public void confirmBuy() {driver.findElement(By.xpath(confirmBuyButtonXpath)).click();}

    public void buyPageWait(){ WaitElement.driverWait(); }

    public void getCurrentUrl() { HtmlLabel.printCurrentUrl(driver); }
}
