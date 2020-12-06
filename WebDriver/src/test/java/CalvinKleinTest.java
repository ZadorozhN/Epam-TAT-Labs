import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobject.calvinklein.CalvinKleinHomePage;

import java.io.File;

public class CalvinKleinTest {

    private WebDriver driver;
    private ChromeOptions options;

    @BeforeAll
    public void init() {
        System.setProperty("webdriver.chrome.driver", "D://WebDrivers/chromedriver.exe");
        options = new ChromeOptions();
        options.addExtensions(new File("D://Downloads/anticaptcha-plugin_v0.50.zip"));
    }

    @BeforeEach
    public void clearCookies(){
        //clear cookies
    }

    @BeforeMethod(alwaysRun = true)
    public void createDriver() {
        driver = new ChromeDriver(options);
    }

    @Test
    public void addToCartTest(){
        String itemName = new CalvinKleinHomePage(driver)
                .openPage()
                .search("21899318-417")
                .setSize("s")
                .addToCart()
                .openCart()
                .getNameOfFirstItem();

        Assert.assertEquals(itemName, "Monogram Logo Crewneck T-Shirt");
    }

    @Test
    public void addToCartManyItemsTest(){
        String countOfItems = new CalvinKleinHomePage(driver)
                .openPage()
                .search("21899318-417")
                .setSize("s")
                .setCountOfItems("3")
                .addToCart()
                .openCart()
                .getCountOfItems();

        Assert.assertEquals(countOfItems, "3");
    }

    @AfterAll
    public void closeDriver(){
        driver.close();
    }
}
