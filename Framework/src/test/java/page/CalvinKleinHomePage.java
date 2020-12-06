package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalvinKleinHomePage extends AbstractPage {
    private static final String HOMEPAGE_URL = "https://www.calvinklein.us/en";

    @FindBy(xpath = "//div[@id='headerTopRight']/a[contains(@class,'searchButtonWrapper')]")
    private WebElement searchButton;

    @FindBy(xpath = "//input[@id='SimpleSearchForm_SearchTerm']")
    private WebElement searchField;

    public CalvinKleinHomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public CalvinKleinHomePage openPage(){
        driver.navigate().to(HOMEPAGE_URL);
        waitUntilAjaxCompleted();

        return this;
    }

    public CalvinKleinSearchResult search(String request){
        waitUntilElementIsClickableAndClickAvoidModalWindow(searchButton);
        waitUntilVisibilityOf(searchField).sendKeys(request);
        searchField.sendKeys(Keys.ENTER);

        return new CalvinKleinSearchResult(driver);
    }
}
