package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static util.Resolver.resolveTemplate;

public class CalvinKleinSearchResult extends AbstractPage {
    private static final String SIZE_TEMPLATE = "size_S_%s";
    private static final String COUNT_TEMPLATE = ".dk_options_inner > li:nth-child(%s)";

    @FindBy(id = "add2CartBtn")
    WebElement addToCartButton;

    @FindBy(id = "mini_cart_link")
    WebElement openBagButton;

    @FindBy(xpath = "//*[contains(@id, \"dk_container_quantity_\")]")
    WebElement selectQuantity;

    @FindBy(xpath = "//div[@id='headerTopRight']/a[contains(@class,'searchButtonWrapper')]")
    private WebElement searchButton;

    @FindBy(xpath = "//input[@id='SimpleSearchForm_SearchTerm']")
    private WebElement searchField;

    @Override
    protected CalvinKleinSearchResult openPage() {
        return this;
    }

    public CalvinKleinSearchResult(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public CalvinKleinSearchResult setSize(String size){
        waitUntilElementIsClickableAndClickAvoidModalWindow(By.id(resolveTemplate(SIZE_TEMPLATE,size)));

        return this;
    }

    public CalvinKleinSearchResult addToCart() {
        waitUntilElementIsClickableAndClickAvoidModalWindow(addToCartButton);

        return this;
    }

    public CalvinKleinSearchResult setCountOfItems(String count) {
        waitUntilElementIsClickableAndClickAvoidModalWindow(selectQuantity);
        waitUntilElementIsClickable(By.cssSelector(resolveTemplate(COUNT_TEMPLATE, count))).click();

        return this;
    }

    public CalvinKleinSearchResult setCountOfItems(int count) {
        waitUntilElementIsClickableAndClickAvoidModalWindow(selectQuantity);
        waitUntilElementIsClickable(By.cssSelector(resolveTemplate(COUNT_TEMPLATE, Integer.toString(count)))).click();

        return this;
    }

    public CalvinKleinBagPage openCart(){
        waitUntilAjaxCompleted();
        waitUntilElementIsClickableAndClickAvoidModalWindow(openBagButton);

        return new CalvinKleinBagPage(driver);
    }

    public CalvinKleinSearchResult search(String request){
        waitUntilElementIsClickableAndClickAvoidModalWindow(searchButton);
        waitUntilVisibilityOf(searchField).sendKeys(request);
        searchField.sendKeys(Keys.ENTER);

        waitUntilAjaxCompleted();

        return new CalvinKleinSearchResult(driver);
    }
}