package pageobject.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobject.page.GoogleCloudHomePage;
import pageobject.page.PastebinPage;

public class PastebinTest {
    private WebDriver driver;

    private static final String TITLE = "how to gain dominance among developers";
    private static final String HIGHLIGHTING = "Bash";
    private static final String EXPIRATION = "10 Minutes";
    private static final String CODE = "git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force";

    @BeforeTest
    public void init() {
        System.setProperty("webdriver.gecko.driver", "/home/nikita/Software/WebDrivers/geckodriver");
    }

    @BeforeMethod(alwaysRun = true)
    public void createDriver() {
        driver = new FirefoxDriver();
    }

    @Test
    public void createPasteTest(){
        String pasteData = new PastebinPage(driver)
                .openPage()
                .pasteCode("Hello from WebDriver")
                .pasteExpiration("10 Minutes")
                .pasteTitle("helloWeb")
                .createNewPaste()
                .getPasteData();

        Assert.assertEquals(pasteData, "Hello from WebDriver");
    }

    @Test
    public void contentOfPasteDataTest(){
        String pasteData = new PastebinPage(driver)
                .openPage()
                .pasteCode(CODE)
                .setSyntaxHighlighting(HIGHLIGHTING)
                .pasteExpiration(EXPIRATION)
                .pasteTitle(TITLE)
                .createNewPaste()
                .getPasteData();

        Assert.assertEquals(pasteData, CODE);
    }

    @Test
    public void getTitleTest(){
        String title = new PastebinPage(driver)
                .openPage()
                .pasteCode(CODE)
                .setSyntaxHighlighting(HIGHLIGHTING)
                .pasteExpiration(EXPIRATION)
                .pasteTitle(TITLE)
                .createNewPaste()
                .getTitle();

        Assert.assertEquals(title, TITLE);
    }


    @Test
    public void highlightingTest(){
        String highlighting = new PastebinPage(driver)
                .openPage()
                .pasteCode(CODE)
                .setSyntaxHighlighting(HIGHLIGHTING)
                .pasteExpiration(EXPIRATION)
                .pasteTitle(TITLE)
                .createNewPaste()
                .getHighlighting();

        Assert.assertEquals(highlighting, HIGHLIGHTING);
    }

    @AfterMethod(alwaysRun = true)
    public void closeDriver() {
        driver.close();
    }
}
