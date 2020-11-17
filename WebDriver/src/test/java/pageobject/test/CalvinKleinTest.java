package pageobject.test;

import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobject.page.CalvinKleinHomePage;

public class CalvinKleinTest {
    private WebDriver driver;

    @BeforeTest
    public void init() {
        System.setProperty("webdriver.chrome.driver", "D://WebDrivers/chromedriver.exe");
    }

    @BeforeMethod(alwaysRun = true)
    public void createDriver() {
        driver = new ChromeDriver();
    }

    @Test
    public void addToCartTest(){
        String itemName = new CalvinKleinHomePage(driver)
                .openPage()
                .search("21899318-417")
                .setSize("m")
                .addToCart()
                .openCart()
                .getNameOfFirstItem();
        System.out.println(itemName);

        Assert.assertEquals(itemName, "Monogram Logo Crewneck T-Shirt");
    }

    @Test
    public void addToCartManyItemsTest(){
        String countOfItems = new CalvinKleinHomePage(driver)
                .openPage()
                .search("21899318-417")
                .setSize("m")
                .setCountOfItems("3")
                .addToCart()
                .openCart()
                .getCountOfItems();

        Assert.assertEquals(countOfItems, "3");
    }

    @AfterMethod
    public void closeDriver(){
        //driver.close();
    }
}
