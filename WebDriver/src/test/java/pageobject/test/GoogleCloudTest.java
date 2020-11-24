package pageobject.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobject.page.GoogleCloudHomePage;
import pageobject.page.TenMinutesMailHomepage;

import java.io.File;

public class GoogleCloudTest {
    private WebDriver driver;
    private ChromeOptions options;


    private static final String REQUEST = "Google Cloud Platform Pricing Calculator";
    private static final String ESTIMATE = "USD 5,413.06";

    @BeforeTest
    public void init() {
        System.setProperty("webdriver.chrome.driver", "D://WebDrivers/chromedriver.exe");
        options = new ChromeOptions();
        options.addExtensions(new File("D://Downloads/anticaptcha-plugin_v0.50.zip"));
    }


    @BeforeMethod(alwaysRun = true)
    public void createDriver() {
        driver = new ChromeDriver();
    }

    @Test
    public void emailTest() throws InterruptedException {
        String email = new TenMinutesMailHomepage(driver)
                .openPage()
                .getEmail();

        new GoogleCloudHomePage(driver)
                .openPage()
                .openGoogleCloudSearchResultPage()
                .setComputerEngine()
                .setNumberOfInstances("4")
                .setWhatTheseInstanceFor("")
                .setDebianOperatingSystem()
                .setMachineClassAsRegular()
                .setSeries("n1")
                .setMachineType("N1-STANDARD-8")
                .addGpus("NVIDIA_TESLA_V100","1")
                .setLocalSsd("2")
                .setDatacenterLocation("us-central1")
                .setCommittedUsage("1")
                .addToEstimate()
                .emailEstimate()
                .inputEmail(email)
                .sendEstimate();

        String estimate = new TenMinutesMailHomepage(driver)
                .openPage()
                .waitingForGoogleCloudEmail()
                .openLastMain()
                .getEstimate();

        Assert.assertEquals(estimate, ESTIMATE);
    }

    @Test
    public void getVirtualMachineClassSummaryTest() throws InterruptedException {
        String virtualMachineClassSummary = new GoogleCloudHomePage(driver)
                .openPage()
                .openGoogleCloudSearchResultPage()
                .setComputerEngine()
                .setNumberOfInstances("4")
                .setWhatTheseInstanceFor("")
                .setDebianOperatingSystem()
                .setMachineClassAsRegular()
                .setSeries("n1")
                .setMachineType("N1-STANDARD-8")
                .addGpus("NVIDIA_TESLA_V100","1")
                .setLocalSsd("2")
                .setDatacenterLocation("us-central1")
                .setCommittedUsage("1")
                .addToEstimate()
                .getVirtualMachineClassSummary();

        Assert.assertEquals(virtualMachineClassSummary, "VM class: regular");
    }

    @Test
    public void getRegionSummaryTest() throws InterruptedException {
        String regionSummary = new GoogleCloudHomePage(driver)
                .openPage()
                .openGoogleCloudSearchResultPage()
                .setComputerEngine()
                .setNumberOfInstances("4")
                .setWhatTheseInstanceFor("")
                .setDebianOperatingSystem()
                .setMachineClassAsRegular()
                .setSeries("n1")
                .setMachineType("N1-STANDARD-8")
                .addGpus("NVIDIA_TESLA_V100","1")
                .setLocalSsd("2")
                .setDatacenterLocation("us-central1")
                .setCommittedUsage("1")
                .addToEstimate()
                .getRegionSummary();

        Assert.assertEquals(regionSummary, "Region: Iowa");
    }

    @Test
    public void getLocalSsdSummaryTest() throws InterruptedException {
        String localSsdSummary = new GoogleCloudHomePage(driver)
                .openPage()
                .openGoogleCloudSearchResultPage()
                .setComputerEngine()
                .setNumberOfInstances("4")
                .setWhatTheseInstanceFor("")
                .setDebianOperatingSystem()
                .setMachineClassAsRegular()
                .setSeries("n1")
                .setMachineType("N1-STANDARD-8")
                .addGpus("NVIDIA_TESLA_V100","1")
                .setLocalSsd("2")
                .setDatacenterLocation("us-central1")
                .setCommittedUsage("1")
                .addToEstimate()
                .getLocalSsdSummary();

        Assert.assertEquals(localSsdSummary, "Total available local SSD space 2x375 GiB");
    }

    @Test
    public void getInstanceTypeSummaryTest() throws InterruptedException {
        String instanceTypeSummary = new GoogleCloudHomePage(driver)
                .openPage()
                .openGoogleCloudSearchResultPage()
                .setComputerEngine()
                .setNumberOfInstances("4")
                .setWhatTheseInstanceFor("")
                .setDebianOperatingSystem()
                .setMachineClassAsRegular()
                .setSeries("n1")
                .setMachineType("N1-STANDARD-8")
                .addGpus("NVIDIA_TESLA_V100","1")
                .setLocalSsd("2")
                .setDatacenterLocation("us-central1")
                .setCommittedUsage("1")
                .addToEstimate()
                .getInstanceTypeSummary();

        Assert.assertEquals(instanceTypeSummary, "Instance type: n1-standard-8");
    }

    @Test
    public void getCommitmentTermSummaryTest() throws InterruptedException {
        String commitmentTermSummary = new GoogleCloudHomePage(driver)
                .openPage()
                .openGoogleCloudSearchResultPage()
                .setComputerEngine()
                .setNumberOfInstances("4")
                .setWhatTheseInstanceFor("")
                .setDebianOperatingSystem()
                .setMachineClassAsRegular()
                .setSeries("n1")
                .setMachineType("N1-STANDARD-8")
                .addGpus("NVIDIA_TESLA_V100","1")
                .setLocalSsd("2")
                .setDatacenterLocation("us-central1")
                .setCommittedUsage("1")
                .addToEstimate()
                .getCommitmentTermSummary();

        Assert.assertEquals(commitmentTermSummary, "Commitment term: 1 Year");
    }

    @Test
    public void getEstimateSummaryTest() throws InterruptedException {
        String estimateSummary = new GoogleCloudHomePage(driver)
                .openPage()
                .openGoogleCloudSearchResultPage()
                .setComputerEngine()
                .setNumberOfInstances("4")
                .setWhatTheseInstanceFor("")
                .setDebianOperatingSystem()
                .setMachineClassAsRegular()
                .setSeries("n1")
                .setMachineType("N1-STANDARD-8")
                .addGpus("NVIDIA_TESLA_V100","1")
                .setLocalSsd("2")
                .setDatacenterLocation("us-central1")
                .setCommittedUsage("1")
                .addToEstimate()
                .getEstimateSummary();

        Assert.assertEquals(estimateSummary, "Total Estimated Cost: USD 5,413.06 per 1 month");
    }

    @AfterMethod(alwaysRun = true)
    public void closeDriver() {
        driver.close();
    }
}
