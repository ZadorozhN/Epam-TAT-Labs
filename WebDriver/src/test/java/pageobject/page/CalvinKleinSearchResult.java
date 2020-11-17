package pageobject.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalvinKleinSearchResult extends Page{

    private static String sizeTemplate = "size_S_%s";
    private static String countTemplate = ".dk_options_inner > li:nth-child(%s)";

    @FindBy(id = "add2CartBtn")
    WebElement addToCartButton;

    @FindBy(id = "mini_cart_link")
    WebElement openBagButton;

    @FindBy(xpath = "//*[@id=\"dk_container_quantity_3074457345629330668\"]")
    WebElement selectQuantity;

    public CalvinKleinSearchResult(WebDriver driver){
        super(driver);
    }

    public CalvinKleinSearchResult setSize(String size){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(
                        By.id(resolveTemplate(sizeTemplate,size))))
                .click();
        return this;
    }

    public CalvinKleinSearchResult addToCart(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(addToCartButton))
                .click();
        return this;
    }

    public CalvinKleinSearchResult setCountOfItems(String count) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(selectQuantity))
                .click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(
                        By.cssSelector(resolveTemplate(countTemplate, count))))
                .click();
        return this;
    }

    public CalvinKleinBagPage openCart(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(jQueryAJAXCompleted());
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(openBagButton))
                .click();
        return new CalvinKleinBagPage(driver);
    }

    private static String resolveTemplate(String template, String data){
        return String.format(template, data);
    }

}
