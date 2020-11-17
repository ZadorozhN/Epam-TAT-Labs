package pageobject.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalvinKleinBagPage extends Page{

    @FindBy(xpath = "//div[contains(@class,'product_title')]/h3/*[@id=\"OrderItemDetailsf_div_2_1\"]")
    WebElement firstItem;

    @FindBy(xpath = "//select[@id = 'qty_1']")
    WebElement countOfFirstItem;

    public CalvinKleinBagPage(WebDriver driver){
        super(driver);
    }

    public String getNameOfFirstItem(){
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(firstItem))
                .getText();
    }

    public String getCountOfItems(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(countOfFirstItem));
        Select countSelect = new Select(countOfFirstItem);
        return countSelect.getFirstSelectedOption().getText();
    }
}
