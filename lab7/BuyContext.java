package rozetka.context;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import rozetka.elements.WaitElement;
import rozetka.elements.HtmlLabel;
import rozetka.elements.TextField;
import rozetka.webobjects.BuyPage;
import rozetka.webobjects.CheckoutPage;
import rozetka.webobjects.DeliveryPage;

public class BuyContext {

    WebDriver driver;

    public  BuyContext(WebDriver driverParam){this.driver = driverParam;}

    public void executeBuy(String name, String mobile, String mail){
        BuyPage buyPage = new BuyPage(driver);
        buyPage.buyPageWait();
        buyPage.clickBuy();
        buyPage.getCurrentUrl();
        buyPage.buyPageWait();
        buyPage.confirmBuy();
        buyPage.buyPageWait();
        buyPage.getCurrentUrl();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.checkoutPageWait();
        checkoutPage.fillNameField(name);
        checkoutPage.fillMobileField(mobile);
        checkoutPage.fillMailField(mail);
        checkoutPage.checkoutPageWait();
        checkoutPage.continueBuy();
        checkoutPage.checkoutPageWait();

        DeliveryPage deliveryPage = new DeliveryPage(driver);
        deliveryPage.deliveryPageWait();
        deliveryPage.checkOrderButtonActive();
    }

    public WebDriver getDriver(){ return driver;}
}
