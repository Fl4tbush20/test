import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import rozetka.context.SerachContext;
import rozetka.context.BuyContext;

public class Main {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();

        SerachContext serachContext = new SerachContext(driver);

        serachContext.executeSearch(200,2000);

        BuyContext buyContext = new BuyContext(serachContext.getDriver());

        buyContext.executeBuy("Иван Иванович","+380665155171","example@gmail.com");

        driver.close();
    }
}