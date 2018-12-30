package rozetka.context;

import org.openqa.selenium.WebDriver;
import rozetka.webobjects.RozetkaPage;

public class SerachContext {

    RozetkaPage rozetkaPage;

    public SerachContext(WebDriver driverParam){ this.rozetkaPage = new RozetkaPage(driverParam);}

    public SerachContext(RozetkaPage rozetkaPageParam){this.rozetkaPage = rozetkaPageParam;}

    public void executeSearch(Integer minPrice, Integer maxPrice){
        rozetkaPage.rozetkaWait();
        rozetkaPage.submitDistrib();
        rozetkaPage.printPageUrl();

        rozetkaPage.rozetkaWait();
        rozetkaPage.enterMaxPrice(maxPrice);
        rozetkaPage.enterMinPrice(minPrice);
        rozetkaPage.rozetkaWait();
        rozetkaPage.submitPrice();
        rozetkaPage.rozetkaWait();
        rozetkaPage.printPageUrl();

        rozetkaPage.goByUrl(rozetkaPage.searchAllGoods().get(0));
        rozetkaPage.printPageUrl();
    }

    public WebDriver getDriver(){ return this.rozetkaPage.getDriver();}

}
