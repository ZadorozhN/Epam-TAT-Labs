package pageobject.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PastebinCreatePasteResultPage extends Page{

    @FindBy(className = "textarea")
    WebElement pasteData;

    @FindBy(className = "textarea")
    WebElement title;

    @FindBy(className = "textarea")
    WebElement highlighting;

    public PastebinCreatePasteResultPage(WebDriver driver){
        super(driver);
    }

    public String getPasteData(){
        return pasteData.getText();
    }

    public String getTitle(){
        return title.getText();
    }

    public String getHighlighting(){
        return highlighting.getText();
    }

}
