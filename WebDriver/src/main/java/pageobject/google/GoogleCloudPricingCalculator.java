package pageobject.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.Page;

public class GoogleCloudPricingCalculator extends Page {

    @FindBy(xpath = "//*[@id=\"mainForm\"]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[1]/div[1]")
    private WebElement computeEngineSwitcher;

    @FindBy(id = "input_61")
    private WebElement numberOfInstances;

    @FindBy(id = "input_62")
    private WebElement inputWhatTheseInstanceFor;

    @FindBy(id = "email_quote")
    private WebElement emailEstimate;

    @FindBy(id = "select_74")
    private WebElement selectOperatingSystem;

    @FindBy(id = "select_78")
    private WebElement selectMachineClass;

    @FindBy(id = "select_85")
    private WebElement selectSeries;

    @FindBy(id = "select_87")
    private WebElement selectMachineType;

    @FindBy(id = "select_353")
    private WebElement selectLocalSsd;

    @FindBy(id = "select_89")
    private WebElement selectDatacenterLocation;

    @FindBy(id = "select_96")
    private WebElement selectCommittedUsage;

    @FindBy(id = "select_394")
    private WebElement selectTypeOfGpu;

    @FindBy(id = "select_392")
    private WebElement selectNumberOfGpu;

    private String optionCommittedUsage = "//*[@id = 'select_container_97']//md-option[@value = '%s']";

    private String optionDatacenterIowa = "//*[@id = 'select_container_90']//md-option[@value = '%s']";

    @FindBy(id = "select_option_63")
    private WebElement optionDebianOperationSystem;

    @FindBy(id = "select_option_76")
    private WebElement optionRegularMachineClass;

    private String optionMachineSeries = "//*[@id = 'select_container_86']//md-option[@value = '%s']";

    private String optionMachineType = "//*[@id = 'select_container_88']//md-option[@value = 'CP-COMPUTEENGINE-VMIMAGE-%s']";

    private String optionLocalSsd = "//*[@id = 'select_container_354']//md-option[@value = '%s']";

    private String optionGpuType = "//*[@id = 'select_container_395']//md-option[@value = '%s']";

    private String optionNumberOfGpus = "//*[@id = 'select_container_393']//md-option[@value = '%s']";

    @FindBy(xpath = "//*[@id=\"mainForm\"]/div[2]/div/md-card/md-card-content/div/div[1]/form/div[8]/div[1]/md-input-container/md-checkbox")
    private WebElement addGpusButton;

    @FindBy(xpath = "//*[@id=\"mainForm\"]/div[2]/div/md-card/md-card-content/div/div[1]/form/div[15]/button")
    private WebElement addToEstimate;

    @FindBy(xpath = "//*[@id=\"compute\"]/md-list/md-list-item[2]/div")
    private WebElement vmClassSummary;

    @FindBy(xpath = "//*[@id=\"compute\"]/md-list/md-list-item[3]/div")
    private WebElement instanceTypeSummary;

    @FindBy(xpath = "//*[@id=\"compute\"]/md-list/md-list-item[4]/div")
    private WebElement regionSummary;

    @FindBy(xpath = "//*[@id=\"compute\"]/md-list/md-list-item[8]/div")
    private WebElement localSsdSummary;

    @FindBy(xpath = "//*[@id=\"compute\"]/md-list/md-list-item[9]/div")
    private WebElement commitmentTerm;

    @FindBy(xpath = "//*[@id=\"resultBlock\"]/md-card/md-card-content/div/div/div/h2/b")
    private WebElement estimateSummary;

    public GoogleCloudPricingCalculator(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudPricingCalculator setComputerEngine(){
        computeEngineSwitcher.click();
        return this;
    }

    public GoogleCloudPricingCalculator setNumberOfInstances(String number){
        numberOfInstances.sendKeys(number);
        return this;
    }

    public GoogleCloudPricingCalculator setWhatTheseInstanceFor(String whatTheseInstanceFor){
        inputWhatTheseInstanceFor.sendKeys(whatTheseInstanceFor);
        return this;
    }

    public GoogleCloudPricingCalculator setDebianOperatingSystem(){
        selectOperatingSystem.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(optionDebianOperationSystem)).click();
        return this;
    }

    public GoogleCloudPricingCalculator setMachineClassAsRegular(){
        selectMachineClass.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(optionRegularMachineClass)).click();
        return this;
    }

    public GoogleCloudPricingCalculator setSeries(String series){
        selectSeries.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(
                        buildXpath(optionMachineSeries,series))).click();
        return this;
    }

    public GoogleCloudPricingCalculator setMachineType(String machineType){
        selectMachineType.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(buildXpath(optionMachineType, machineType))).click();
        return this;
    }

    public GoogleCloudPricingCalculator addGpus(String gpuType ,String numberOfGpus){
        addGpusButton.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(selectTypeOfGpu)).click();

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(
                        buildXpath(optionGpuType, gpuType.toUpperCase()))).click();

        selectNumberOfGpu.click();

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(
                        buildXpath(optionNumberOfGpus, numberOfGpus))).click();
        return this;
    }

    public GoogleCloudPricingCalculator setLocalSsd(String numberOfSsd){
        selectLocalSsd.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(
                        buildXpath(optionLocalSsd, numberOfSsd))).click();
        return this;
    }

    public GoogleCloudPricingCalculator setDatacenterLocation(String location){
        selectDatacenterLocation.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(buildXpath(optionDatacenterIowa, location))).click();
        return this;
    }

    public GoogleCloudPricingCalculator setCommittedUsage(String committedUsage){
        selectCommittedUsage.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(
                        buildXpath(optionCommittedUsage, committedUsage))).click();
        return this;
    }

    public GoogleCloudPricingCalculator addToEstimate(){
        addToEstimate.click();
        return this;
    }

    public GoogleCloudEmailPage emailEstimate(){
        emailEstimate.click();

        return new GoogleCloudEmailPage(driver);
    }

    public String getVirtualMachineClassSummary(){
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(vmClassSummary)).getText();
    }

    public String getInstanceTypeSummary(){
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(instanceTypeSummary)).getText();
    }

    public String getRegionSummary(){
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(regionSummary)).getText();
    }

    public String getLocalSsdSummary(){
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(localSsdSummary)).getText();
    }

    public String getCommitmentTermSummary(){
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(commitmentTerm)).getText();
    }

    public String getEstimateSummary(){
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(estimateSummary)).getText();
    }

    private By buildXpath(String xpath, String value){
        return By.xpath(String.format(xpath, value));
    }
}
