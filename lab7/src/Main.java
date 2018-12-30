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

        buyContext.executeBuy("Антон Антонович","+380500505050","TestMail@gmail.com");

        driver.close();
    }
}
