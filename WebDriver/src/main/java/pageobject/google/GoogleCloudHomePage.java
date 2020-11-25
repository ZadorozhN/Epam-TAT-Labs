package pageobject.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.Page;

public class GoogleCloudHomePage extends Page {

    private static final String HOMEPAGE_URL = "https://cloud.google.com/";
    private static final String CALCULATOR_REQUEST = "Google Cloud Platform Pricing Calculator";

    @FindBy(xpath = "//input[contains(@class,'devsite-search-field devsite-search-query')]")
    WebElement searchInput;

    @FindBy(xpath = "//a[contains(@class, 'gs-title')]")
    WebElement firstLink;

    @FindBy(xpath = "//*[@id=\"cloud-site\"]/devsite-iframe/iframe")
    WebElement firstFrame;

    @FindBy(id = "myFrame")
    WebElement secondFrame;

    public GoogleCloudHomePage(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudHomePage openPage(){
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public GoogleCloudPricingCalculator search(String request){
        searchInput.sendKeys(request);
        searchInput.submit();

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(jQueryAJAXCompleted());

        return new GoogleCloudPricingCalculator(driver);
    }

    public GoogleCloudPricingCalculator openGoogleCloudSearchResultPage() throws InterruptedException {
        searchInput.sendKeys(CALCULATOR_REQUEST);
        searchInput.submit();

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(firstLink)).click();

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.tagName("html")));

        driver.switchTo().frame(firstFrame);
        driver.switchTo().frame(secondFrame);

        return new GoogleCloudPricingCalculator(driver);
    }
}
