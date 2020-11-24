package pageobject.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.Page;

public class GoogleCloudEmailPage extends Page {

    @FindBy(id = "input_475")
    private WebElement inputEmail;

    @FindBy(xpath = "//*[@id=\"dialogContent_481\"]/form/md-dialog-actions/button[2]")
    private WebElement sendEmail;

    protected GoogleCloudEmailPage(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudEmailPage inputEmail(String email){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(inputEmail)).sendKeys(email);
        return this;
    }

    public GoogleCloudPricingCalculator sendEstimate(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(sendEmail)).click();
        return new GoogleCloudPricingCalculator(driver);
    }
}
