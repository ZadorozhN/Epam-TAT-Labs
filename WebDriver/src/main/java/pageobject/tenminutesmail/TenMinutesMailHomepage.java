package pageobject.tenminutesmail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.Page;

public class TenMinutesMailHomepage extends Page {
    private static final String HOMEPAGE_URL = "https://10minutemail.net/";

    @FindBy(id = "fe_text")
    private WebElement email;

    @FindBy(xpath = "//*[@id=\"maillist\"]/tbody/tr[2]/td[2]/a")
    private WebElement lastEmail;

    @FindBy(xpath = "//*[@id=\"left\"]/ul/li[1]/a")
    private WebElement reloadButton;

    public TenMinutesMailHomepage(WebDriver driver) {
        super(driver);
    }

    public TenMinutesMailHomepage openPage(){
        driver.get(HOMEPAGE_URL);

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(jQueryAJAXCompleted());

        return this;
    }

    public String getEmail(){
        return email.getAttribute("value");
    }

    public TenMinutesMailHomepage waitingForGoogleCloudEmail() {
        while (!lastEmail.getText().equals("Google Cloud Platform Price Estimate")) {
            driver.get(HOMEPAGE_URL);
            new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                    .until(jQueryAJAXCompleted());
        }
        return this;
    }

    public TenMinutesMailPage openLastMain(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(lastEmail)).click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(jQueryAJAXCompleted());
        return new TenMinutesMailPage(driver);
    }
}
