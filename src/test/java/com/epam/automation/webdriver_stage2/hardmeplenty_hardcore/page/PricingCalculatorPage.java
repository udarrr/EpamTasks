package com.epam.automation.webdriver_stage2.hardmeplenty_hardcore.page;

import com.epam.automation.webdriver_stage2.hardmeplenty_hardcore.enums.*;
import com.epam.automation.webdriver_stage2.hardmeplenty_hardcore.resources.CommonDataHardMePlentyJSON;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PricingCalculatorPage {
    private WebDriver driver;
    private CommonDataHardMePlentyJSON data;

    @FindBy(xpath = "//a[@class='gs-title']/b[text()='Google Cloud Platform Pricing Calculator']")
    private WebElement googleCalculatorLink;

    @FindBy(css = "#cloud-site > devsite-iframe > iframe")
    private WebElement iFrame;

    @FindBy(css = "#myFrame")
    private WebElement iFrameCalculatorAfterIFrame;

    @FindBy(xpath = "//md-tab-item/div[@title='Compute Engine' and @class='tab-holder compute']")
    private WebElement tabComputerEngine;

    @FindBy(id = "input_65")
    private WebElement inputNumberInstances;

    @FindBy(id = "select_value_label_58")
    private WebElement inputContainerTypeOperationSystem;

    String partOfLocatorPositionMenuTypeOperationSystem = "//md-option[@value='%s']";

    @FindBy(id = "select_82")
    private WebElement inputContainerMachineClass;

    @FindBy(id = "select_90")
    private WebElement inputContainerSeries;

    @FindBy(id = "select_92")
    private WebElement inputContainerMachineType;

    @FindBy(xpath = "//h2[contains(text(),'Instances')]/..//md-checkbox[@aria-label='Add GPUs']")
    private WebElement checkBoxAddGPU;

    @FindBy(xpath = "//h2[contains(text(),'Instances')]/..//md-select[@placeholder='Number of GPUs']")
    private WebElement inputContainerGPUNumber;

    @FindBy(xpath = "//h2[contains(text(),'Instances')]/..//md-select[@placeholder='GPU type']")
    private WebElement inputContainerGPUType;

    @FindBy(id = "select_357")
    private WebElement inputContainerLocalSSD;

    @FindBy(id = "select_94")
    private WebElement inputContainerDataCenterLocation;

    @FindBy(id = "select_101")
    private WebElement inputContainerCommittedUsage;

    @FindBy(xpath = "//h2[contains(text(),'Instances')]/..//button[@aria-label='Add to Estimate']")
    private WebElement buttonAddToEstimate;

    String partOfLocatorForPositionDropDownList = "//div[@class='md-select-menu-container md-active md-clickable']//md-option[@value='%s']";

    @FindBy(xpath = "//md-list[@class='cartitem ng-scope']/md-list-item/div")
    private List<WebElement> createdEstimate;

    @FindBy(xpath = "//button[@aria-label='Email Estimate']")
    private WebElement buttonEmailEstimate;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement inputEmail;

    @FindBy(xpath = "//button[@aria-label='Send Email']")
    private WebElement buttonSendEmail;


    public PricingCalculatorPage(WebDriver driver, CommonDataHardMePlentyJSON data) {
        this.driver = driver;
        this.data = data;
        PageFactory.initElements(driver, this);
    }

    public WebElement buildFullLocatorForPositionMenu(String condition) {
        String fullLocator = String.format(partOfLocatorForPositionDropDownList, condition);

        return waitBeforeChoosingMenuOption(fullLocator);
    }

    private WebElement waitBeforeChoosingMenuOption(String locator) {
        WebElement position = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(position));

        return position;
    }

    public PricingCalculatorPage chooseComputerEngine() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(iFrame));

        driver.switchTo().frame(iFrame);
        driver.switchTo().frame(iFrameCalculatorAfterIFrame);
        tabComputerEngine.click();

        return this;
    }

    public PricingCalculatorPage fillInputNumberInstances(String number) {
        inputNumberInstances.click();
        inputNumberInstances.sendKeys(number);

        return this;
    }

    public PricingCalculatorPage chooseOperationSystem(String operationSystem) {
        inputContainerTypeOperationSystem.click();

        String fullLocator = String.format(partOfLocatorPositionMenuTypeOperationSystem, operationSystem);

        WebElement position = waitBeforeChoosingMenuOption(fullLocator);
        position.click();

        return this;
    }

    public PricingCalculatorPage chooseMachineClass(String machineClass) {
        inputContainerMachineClass.click();

        WebElement position = buildFullLocatorForPositionMenu(machineClass);
        position.click();

        return this;
    }

    public PricingCalculatorPage chooseSeries(String series) {
        inputContainerSeries.click();

        WebElement position = buildFullLocatorForPositionMenu(series);
        position.click();

        return this;
    }

    public PricingCalculatorPage chooseMachineType(String type) {
        inputContainerMachineType.click();

        WebElement position = buildFullLocatorForPositionMenu(type);
        position.click();

        return this;
    }

    public PricingCalculatorPage addGPUs(String number, String type) {
        checkBoxAddGPU.click();

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(inputContainerGPUNumber));

        inputContainerGPUNumber.click();

        WebElement positionNumber = buildFullLocatorForPositionMenu(number);
        positionNumber.click();

        inputContainerGPUType.click();

        WebElement positionType = buildFullLocatorForPositionMenu(type);
        positionType.click();

        return this;
    }

    public PricingCalculatorPage chooseLocalSSD(String count) {
        inputContainerLocalSSD.click();

        WebElement position = buildFullLocatorForPositionMenu(count);
        position.click();

        return this;
    }

    public PricingCalculatorPage chooseDataCenterLocation(String location) {
        inputContainerDataCenterLocation.click();

        WebElement position = buildFullLocatorForPositionMenu(location);
        position.click();

        return this;
    }

    public PricingCalculatorPage chooseCommittedUsage(String period) {
        inputContainerCommittedUsage.click();

        WebElement position = buildFullLocatorForPositionMenu(period);
        position.click();

        return this;
    }

    public PricingCalculatorPage pressButtonAddToEstimate() {
        buttonAddToEstimate.click();

        return this;
    }

    public PricingCalculatorPage saveCalculatorTotalPriceResult() {
        for (WebElement price : createdEstimate) {
            if (price.getText().contains(data.getDescriptionPriceField())) {
                data.setResultPriceFromCalculator(price.getText());
            }
        }
        return this;
    }

    public PricingCalculatorPage pressButtonEmailEstimate() {
        buttonEmailEstimate.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(inputEmail));

        return this;
    }

    public TemporaryEmailHomePage openNewTab() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        return new TemporaryEmailHomePage(driver, data);
    }

    public PricingCalculatorPage enterEmail() {
        driver.switchTo().frame(iFrame);
        driver.switchTo().frame(iFrameCalculatorAfterIFrame);
        inputEmail.sendKeys(Keys.LEFT_CONTROL, "v");

        return this;
    }

    public PricingCalculatorPage pressButtonSendEmail() {
        buttonSendEmail.click();

        return this;
    }

    public TemporaryEmailHomePage switchTabToTemporaryEmailHomePage() {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        return new TemporaryEmailHomePage(driver, data);
    }

    public boolean checkFieldsCreatedEstimateHasTheSameDataLikeInCalculator(String field1, String field2, String field3, String field4, String field5) {
        List<String> fields = new ArrayList<>(Arrays.asList(field1, field2, field3, field4, field5));
        return getResultComparingFieldsWithCommonData(fields);
    }


    public boolean checkPriceCreatedEstimateHasTheSameValueLikeInManualTest(String manualTestValue) {
        return createdEstimate.stream().filter(x -> x.getText()
                .contains(data.getDescriptionPriceField()))
                .anyMatch(z -> z.getText().contains(manualTestValue));
    }

    private boolean getResultComparingFieldsWithCommonData(List<String> fields) {
        List<String> lines = new ArrayList<>();
        createdEstimate.forEach(x -> lines.add(x.getText()));

        for (int i = 0; i < lines.size(); i++) {
            for (int j = 0; j < fields.size(); j++) {
                if (lines.get(i).contains(fields.get(j))) {
                    if (!findResultInFields(lines.get(i), fields.get(j))) {
                        return false;
                    }
                    break;
                }
            }
        }
        return true;
    }

    private boolean findResultInFields(String line, String field) {
        switch (field) {
            case CommonDataHardMePlentyJSON.vmClassField:
                return line.toLowerCase().endsWith(MachineClass.REGULAR.getDescription().toLowerCase());
            case CommonDataHardMePlentyJSON.instanceTypeField:
                return line.toLowerCase().endsWith(MachineType.N1_STANDART_8.getDescription().toLowerCase());
            case CommonDataHardMePlentyJSON.regionField:
                return line.toLowerCase().endsWith(DatacenterLocation.FRANKFURT.getDescription().toLowerCase());
            case CommonDataHardMePlentyJSON.localSSDField:
                return line.toLowerCase().endsWith(LocalSSD.X2_375.getDescription().toLowerCase());
            case CommonDataHardMePlentyJSON.commitmentTermField:
                return line.toLowerCase().endsWith(CommittedUsage.YEAR_1.getDescription().toLowerCase());
            default:
                return false;
        }
    }
}
