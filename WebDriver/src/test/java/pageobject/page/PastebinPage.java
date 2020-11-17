package pageobject.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PastebinPage extends Page{
    private static final String HOMEPAGE_URL = "https://pastebin.com";

    @FindBy(id = "postform-text")
    private WebElement codeInput;

    @FindBy(id = "postform-expiration")
    private WebElement expirationSelect;

    @FindBy(id = "postform-format")
    private WebElement highlightingSelect;

    @FindBy(id = "postform-name")
    private WebElement nameInput;

    @FindBy(xpath = "//button[contains(@class, 'btn -big')]")
    private WebElement createNewPasteButton;

    public PastebinPage(WebDriver driver){
        super(driver);
    }

    public PastebinPage openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(jQueryAJAXCompleted());
        return this;
    }

    public PastebinPage pasteCode(String code){
        codeInput.sendKeys(code);
        return this;
    }

    public PastebinPage pasteExpiration(String expiration){
        Select select = new Select(expirationSelect);
        select.selectByVisibleText(expiration);
        return this;
    }


    public PastebinPage setSyntaxHighlighting(String highlighting){
        Select select = new Select(highlightingSelect);
        select.selectByVisibleText(highlighting);
        return this;
    }

    public PastebinPage pasteTitle(String title){
        nameInput.sendKeys(title);
        return this;
    }

    public PastebinCreatePasteResultPage createNewPaste(){
        createNewPasteButton.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(jQueryAJAXCompleted());
        return new PastebinCreatePasteResultPage(driver);
    }
}
