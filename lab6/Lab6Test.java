package ostroverkhiy;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Lab6Test {



    public static WebDriver goByUrl(WebDriver driver,String url){

        driver.get(url);

        System.out.println("Your page: "+driver.getCurrentUrl());

        return driver;
    }

    public static void waitResponse(){

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static WebDriver goToPageFromGoogleByRequest(WebDriver driver, String request){

        driver.findElement(By.xpath("/html/body/div/div[3]/form/div[2]/div/div[1]/div/div[1]/input")).sendKeys(request);
        driver.findElement(By.xpath("/html/body/div/div[3]/form/div[2]/div/div[3]/center/input[1]")).click();

        System.out.println("Now you on page: "+driver.getCurrentUrl());

        return driver;
    }

    public static ArrayList<String> getAllHrefsFromGooglePage(WebDriver driver) {

        List<WebElement> elemnets = driver.findElements(By.xpath("//*[@class='r']/a"));

        ArrayList<String> hrefs = new ArrayList<String>();
        for (WebElement element: elemnets) hrefs.add(element.getAttribute("href"));

        return hrefs;
    }

    public static ArrayList<String> filterTranslateHrefs(ArrayList<String> hrefs){

        for (int i=0; i<hrefs.size(); i=i+1) if (hrefs.get(i).contains("translate.google.com")) hrefs.remove(i);
        return hrefs;
    }

    public static void makeScreenshot(WebDriver driver, String screenName) throws IOException {

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(screenName));
    }

    public static String getHrefToNextPage(WebDriver driver){
        if (driver.findElements(By.xpath("//*[@id=\"pnnext\"]")).size() != 0) return driver.findElement(By.xpath("//*[@id=\"pnnext\"]")).getAttribute("href");
        else return "nan";
    }

    public static String getHrefToPreviousPage(WebDriver driver){
        return driver.findElement(By.xpath("//*[@id=\"pnprev\"]")).getAttribute("href");
    }

    public static String getHrefFromHrefs(ArrayList<String> hrefs,String firmName){
        for (String href: hrefs) if (href.toLowerCase().contains(firmName.toLowerCase())) return href;
        return "nan";
    }

    public static WebDriver enterMaxPrice(WebDriver driver, Integer maxPrice){


        driver.findElement(By.xpath("//*[@id=\"price[max]\"]")).sendKeys(maxPrice.toString());
        driver.findElement(By.xpath("//*[@id=\"submitprice\"]")).click();

        waitResponse();

        System.out.println("Now you on page: "+driver.getCurrentUrl());

        return driver;
    }

    public static WebDriver enterMinPrice(WebDriver driver, Integer minPrice){

        driver.findElement(By.xpath("//*[@id=\"price[min]\"]")).sendKeys(minPrice.toString());
        driver.findElement(By.xpath("//*[@id=\"submitprice\"]")).click();

        waitResponse();


        System.out.println("Now you on page: "+driver.getCurrentUrl());

        return driver;
    }

    public static Integer getMinPriceValue(WebDriver driver){
        WebElement element = driver.findElement(By.xpath("//*[@id=\"price[min]\"]"));

        return Integer.valueOf(element.getAttribute("value"));
    }

    public static Integer getMaxPriceValue(WebDriver driver){
        WebElement element = driver.findElement(By.xpath("//*[@id=\"price[max]\"]"));

        return Integer.valueOf(element.getAttribute("value"));
    }

    public static ArrayList<Float> getPriceList(WebDriver driver){

        List<WebElement> elements = driver.findElements(By.xpath("//*[@class='g-price-uah']"));

        ArrayList<Float> priceList = new ArrayList<Float>();
        for (WebElement elem: elements) priceList.add(Float.valueOf(elem.getText().replaceAll("\\D+","")));

        return priceList;
    }

    @Test
    public void firmnNotonPagesTest() throws IOException {

//      find firm by key word not on the first page

        WebDriver driver = new FirefoxDriver();
        Integer pageCounter = 0;

        driver = goByUrl(driver,"https://www.google.com/");
        driver = goToPageFromGoogleByRequest(driver,"Cats");

        String nextPageHref = new String();
        String firmHref = new String();
        do {
            nextPageHref = getHrefToNextPage(driver);

            if (nextPageHref.equals("nan")) break;

            driver = goByUrl(driver, nextPageHref);
            pageCounter += 1;

            ArrayList<String> hrefs = filterTranslateHrefs(getAllHrefsFromGooglePage(driver));
            firmHref = getHrefFromHrefs(hrefs,"purina");

        } while (firmHref.equals("nan"));

        makeScreenshot(driver, "page_ + pageCounter.toString() + ".png");

        driver.close();

        Assert.assertNotEquals(firmHref,"nan");

    }

    @Test
    public void nextPageFirmTest() throws IOException {

//      find firm by keyword on the first page

        WebDriver driver = new FirefoxDriver();
        Integer pageCounter = 0;

        driver = goByUrl(driver,"https://www.google.com/");
        driver = goToPageFromGoogleByRequest(driver,"Chair");

        ArrayList<String> hrefs = filterTranslateHrefs(getAllHrefsFromGooglePage(driver));
        String firmHref = getHrefFromHrefs(hrefs,"bluecross");

        makeScreenshot(driver, "page_" + pageCounter.toString() + ".png");

        driver.close();

        Assert.assertNotEquals(firmHref,"nan");

    }

    @Test
    public void firstPageFirmTest() throws IOException {

//      find no firm on pages

        WebDriver driver = new FirefoxDriver();
        Integer pageCounter = 0;

        driver = goByUrl(driver,"https://www.google.com/");
        driver = goToPageFromGoogleByRequest(driver,"Wooden chair");

        String nextPageHref = new String();
        String firmHref = new String();
        do {

            makeScreenshot(driver, "page_ + pageCounter.toString() + ".png");

            nextPageHref = getHrefToNextPage(driver);

            if (nextPageHref.equals("nan")) break;

            driver = goByUrl(driver, nextPageHref);
            pageCounter += 1;

            ArrayList<String> hrefs = filterTranslateHrefs(getAllHrefsFromGooglePage(driver));
            firmHref = getHrefFromHrefs(hrefs,"carambainc");

        } while (firmHref.equals("nan"));

        driver.close();

        Assert.assertEquals(firmHref,"nan");

    }

    @Test
    public void rozetkaMaxTest(){

        WebDriver driver = new FirefoxDriver();
        driver = goByUrl(driver,"https://rozetka.com.ua/kompyuternye-stoly/c155285/");

        driver = enterMaxPrice(driver,1005);
        ArrayList<Float> priceList = getPriceList(driver);
        Collections.sort(priceList);

        driver.close();

        Assert.assertTrue(priceList.get(priceList.size()-1) <= 1005);

    }

    @Test
    public void rozetkaMinTest(){

        WebDriver driver = new FirefoxDriver();
        driver = goByUrl(driver,"https://rozetka.com.ua/kompyuternye-stoly/c155285/");

        driver = enterMinPrice(driver,100);
        ArrayList<Float> priceList = getPriceList(driver);
        Collections.sort(priceList);

        driver.close();


        Assert.assertTrue(priceList.get(0) >= 100);

    }

    @Test
    public void rozetkaMinDiapozonTest(){

        WebDriver driver = new FirefoxDriver();
        driver = goByUrl(driver,"https://rozetka.com.ua/kompyuternye-stoly/c155285/");

        driver = enterMinPrice(driver,100);

        Integer minPriceRealValue = getMinPriceValue(driver);

        driver.close();


        Assert.assertTrue(minPriceRealValue == 100);

    }

    @Test
    public void rozetkaMaxDiapozonTest(){

        WebDriver driver = new FirefoxDriver();
        driver = goByUrl(driver,"https://rozetka.com.ua/kompyuternye-stoly/c155285/");

        driver = enterMaxPrice(driver,1000);

        Integer maxPriceRealValue = getMaxPriceValue(driver);

        driver.close();

        Assert.assertTrue(maxPriceRealValue - 1000 == 0);

    }

}