package pageobject.tenminutesmail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobject.Page;

public class TenMinutesMailPage extends Page {

    @FindBy(xpath = "//*[@id=\"tab1\"]/div/div/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/h3")
    private WebElement price;

    protected TenMinutesMailPage(WebDriver driver) {
        super(driver);
    }

    public String getEstimate(){
        return price.getText();
    }
}
