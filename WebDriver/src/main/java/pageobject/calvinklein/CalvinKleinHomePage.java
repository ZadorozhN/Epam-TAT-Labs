package pageobject.calvinklein;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.Page;

public class CalvinKleinHomePage extends Page {

    private static final String HOMEPAGE_URL = "https://www.calvinklein.us/en";

    @FindBy(xpath = "//div[@id='headerTopRight']/a[contains(@class,'searchButtonWrapper')]")

    private WebElement searchButton;

    @FindBy(xpath = "//input[@id='SimpleSearchForm_SearchTerm']")
    private WebElement searchField;

    public CalvinKleinHomePage(WebDriver driver){
        super(driver);
    }

    public CalvinKleinHomePage openPage(){
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(jQueryAJAXCompleted());
        return this;
    }

    public CalvinKleinSearchResult search(String request){
        searchButton.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(searchField)).sendKeys(request);
        searchField.sendKeys(Keys.ENTER);
        return new CalvinKleinSearchResult(driver);
    }
}
