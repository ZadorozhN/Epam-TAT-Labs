package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import service.TestDataReader;

import java.io.File;

public class DriverSingleton {
    private static WebDriver driver;

    private DriverSingleton(){

    }

    public static WebDriver getInstance() {
        if (driver == null) {
            switch (System.getProperty("browser")) {
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addExtensions(new File(TestDataReader.getTestData("test.chrome.anticaptcha")));
                    driver = new ChromeDriver(options);

            }
            driver.manage().window().maximize();
        }

        return driver;
    }

    public static void closeDriver(){
        driver.quit();
        driver = null;
    }

}
