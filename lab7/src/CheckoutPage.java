package rozetka.webobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import rozetka.elements.HtmlLabel;
import rozetka.elements.TextField;
import rozetka.elements.WaitElement;

public class CheckoutPage {

    private String url;
    private WebDriver driver;
    public static final String nameTextFieldXoath = "//*[@id=\"reciever_name\"]";
    public static final String mobileTextFieldXoath = "//*[@id=\"reciever_phone\"]";
    public static final String mailTextFieldXoath = "//*[@id=\"reciever_email\"]";
    public static final String continueButtonXpath = "//*[@id=\"continue_button\"]";


    public CheckoutPage(WebDriver driverParam){
        this.driver = driverParam;
        HtmlLabel.printCurrentUrl(driver);
        this.url = driver.getCurrentUrl();
    }

    public void fillNameField(String name){
        TextField nameField = new TextField(driver,nameTextFieldXoath);
        nameField.clearTextField();
        nameField.fillTextField(name);
    }

    public void fillMobileField(String mobile){
        TextField mobileField = new TextField(driver,mobileTextFieldXoath);
        mobileField.clearTextField();
        mobileField.fillTextField(mobile);
    }

    public void fillMailField(String mail){
        TextField mailField = new TextField(driver,mailTextFieldXoath);
        mailField.clearTextField();
        mailField.fillTextField(mail);
    }

    public void continueBuy(){driver.findElement(By.xpath(continueButtonXpath)).click();}

    public void checkoutPageWait() { WaitElement.driverWait(); }
}
