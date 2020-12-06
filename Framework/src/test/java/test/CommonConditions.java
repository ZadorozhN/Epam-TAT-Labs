package test;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import util.TestListener;

@Listeners(TestListener.class)
public class CommonConditions {
    protected WebDriver driver;

    @BeforeSuite
    public void init(){
        driver = DriverSingleton.getInstance();
    }

    @AfterMethod(alwaysRun = true)
    public void close(){
        DriverSingleton.deleteAllCookies();
    }

    @AfterSuite(alwaysRun = true)
    public void dispose(){
        DriverSingleton.closeDriver();
    }
}
