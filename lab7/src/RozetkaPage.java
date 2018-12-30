package rozetka.webobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import rozetka.elements.CheckBox;
import rozetka.elements.TextField;
import rozetka.elements.WaitElement;
import rozetka.elements.HtmlLabel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RozetkaPage {

    public static final String url = "https://rozetka.com.ua/lestnitsy-stremyanki-podmosti/c157092/";
    private WebDriver driver;
    public static final String minTextFieldXpath = "//*[@id=\"price[min]\"]";
    public static final String maxTextFieldXpath = "//*[@id=\"price[max]\"]";
    public static final String distribCheckBoxXpath = "//*[@id=\"filter_strana-proizvoditelj-tovara-2577232_620897\"]";

    public RozetkaPage(WebDriver driverParam){
        this.driver = driverParam;
        driver.get(url);
        HtmlLabel.printCurrentUrl(driver);

    }

    public void enterMinPrice(Integer minPrice){
        TextField minTextField = new TextField(driver,minTextFieldXpath);
        minTextField.clearTextField();
        minTextField.fillTextField(minPrice.toString());
    }

    public void enterMaxPrice(Integer maxPrice){
        TextField maxTextField = new TextField(driver,maxTextFieldXpath);
        maxTextField.clearTextField();
        maxTextField.fillTextField(maxPrice.toString());
    }

    public void submitPrice(){driver.findElement(By.xpath("//*[@id=\"submitprice\"]")).click();}

    public void submitDistrib(){new CheckBox(driver,distribCheckBoxXpath).clickBox();}

    public void printPageUrl(){ HtmlLabel.printCurrentUrl(driver); }

    public ArrayList<String> searchAllGoods(){
        List<WebElement> allGoods = driver.findElements(By.xpath("//*[@class='g-i-tile-i-title clearfix']/a"));
        ArrayList<String> allGoodsHrefs = new ArrayList<String>();

        for (WebElement element: allGoods) allGoodsHrefs.add(element.getAttribute("href"));

        return allGoodsHrefs;
    }

    public void goByUrl(String url){driver.get(url);}

    public void rozetkaWait() {WaitElement.driverWait();}

    public WebDriver getDriver(){return this.driver;}
}
