package page;

import model.Item;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Resolver;

import java.util.List;

import static util.Resolver.resolveCost;
import static util.Resolver.resolveTemplate;

public class CalvinKleinBagPage extends AbstractPage {
    public static final String HOMEPAGE_URL = "https://www.calvinklein.us/AjaxOrderItemDisplayView";

    String itemNameTemplate = "//div[contains(@class,'product_title')]/h3/*[@id=\"OrderItemDetailsf_div_2_%d\"]";
    String numberOfItemTemplate = "//div[contains(@class,'product_title')]/h3/*[contains(@id, \"OrderItemDetailsf_div_2_\")]";
    String itemDeleteTemplate = "//*[@id=\"WC_OrderItemDetailsf_links_2_%d\"]";
    String itemCostTemplate = "//*[@id=\"ShopCartPagingDisplay\"]/div[4]/div[4]/div/div[%d]/div[1]/div[1]/div[2]/div[1]/div[1]";
    String itemSizeTemplate = "//*[@id=\"ShopCartPagingDisplay\"]/div[4]/div[4]/div/div[%d]/div[1]/div[1]/div[1]/span[3]";
    String countOfItemTemplate = "//*[@id=\"qty_%d\"]";

    @FindBy(xpath = "//div[@id='headerTopRight']/a[contains(@class,'searchButtonWrapper')]")
    private WebElement searchButton;

    @FindBy(xpath = "//input[@id='SimpleSearchForm_SearchTerm']")
    private WebElement searchField;

    @FindBy(id = "WC_SingleShipmentOrderTotalsSummary_td_2")
    private WebElement subtotalCost;

    @FindBy(id = "promoCodeRegion_Label")
    private WebElement promoCodeLabel;

    @FindBy(id = "promoCode")
    private WebElement promoCodeField;

    @FindBy(id = "WC_SingleShipmentOrderTotalsSummary_td_13")
    private WebElement estimatedTotalCost;

    @FindBy(id = "WC_SingleShipmentOrderTotalsSummary_td_8")
    private WebElement shippingCost;

    @FindBy(id = "guestShopperContinue")
    private WebElement proceedToSecureCheckout;

    @Override
    protected CalvinKleinBagPage openPage() {
        return this;
    }

    public CalvinKleinBagPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public CalvinKleinSearchResult search(String request){
        searchButton.click();
        waitUntilVisibilityOf(searchField).sendKeys(request);
        searchField.sendKeys(Keys.ENTER);

        return new CalvinKleinSearchResult(driver);
    }

    public Item getItem(int number) {
        WebElement itemName = waitUntilPresenceOfElement(By.xpath(resolveTemplate(itemNameTemplate, number)));
        WebElement itemCost = driver.findElements(By.xpath(resolveTemplate(itemCostTemplate, number))).get(number - 1);
        WebElement itemSize = driver.findElements(By.xpath(resolveTemplate(itemSizeTemplate, number))).get(number - 1);
        WebElement itemCount = driver.findElement(By.xpath(resolveTemplate(countOfItemTemplate, number)));
        Select select = new Select(itemCount);

        String name = itemName.getText();
        String size = itemSize.getText().toLowerCase();
        int cost = Resolver.resolveCost(itemCost.getText());
        int amount = Resolver.resolveInt(select.getFirstSelectedOption().getText());

        return Item.of(name, size, cost, amount);
    }

    public CalvinKleinBagPage changeAmountOfItem(int itemNumber, int amountOfItem){
        WebElement itemCount = waitUntilPresenceOfElement(By.xpath(resolveTemplate(countOfItemTemplate, itemNumber)));
        WebElement itemCost = driver.findElements(By.xpath(resolveTemplate(itemCostTemplate, itemNumber)))
                .get(itemNumber - 1);
        Select select = new Select(itemCount);
        String startValue = itemCost.getText();

        select.selectByValue(Integer.toString(amountOfItem));

        waitUntilFieldIsChanged(itemCost, startValue);
        waitUntilAjaxCompleted();

        return this;
    }

    public CalvinKleinBagPage enterPromoCode(String promoCode, int numberOfPromoItem){
        waitUntilVisibilityOf(promoCodeLabel).click();
        waitUntilVisibilityOf(promoCodeField).sendKeys(promoCode);
        WebElement itemCost = driver.findElements(By.xpath(resolveTemplate(itemCostTemplate, numberOfPromoItem)))
                .get(numberOfPromoItem - 1);

        String startValue = itemCost.getText();

        promoCodeField.sendKeys(Keys.ENTER);
        waitUntilFieldIsChanged(itemCost, startValue);

        return this;
    }

    public CalvinKleinBagPage removeItem(int number){
        WebElement removeButton = waitUntilPresenceOfElement(By.xpath(resolveTemplate(itemDeleteTemplate, number)));

        removeButton.click();

        return this;
    }

    public CalvinKleinOrderPage proceedPurchase(){
        waitUntilElementIsClickable(proceedToSecureCheckout).click();

        return new CalvinKleinOrderPage(driver);
    }

    public boolean isEmpty(){
        List<WebElement> items = driver.findElements(By.xpath(numberOfItemTemplate));

        return items.isEmpty();
    }

    public int getSubtotalCost(){
        return resolveCost(subtotalCost.getText());
    }

    public int getEstimatedTotalCost(){
        return resolveCost(estimatedTotalCost.getText());
    }

    public int getShippingCost(){
        return resolveCost(shippingCost.getText());
    }
}