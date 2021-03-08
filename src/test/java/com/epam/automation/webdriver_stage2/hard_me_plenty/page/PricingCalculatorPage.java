package com.epam.automation.webdriver_stage2.hard_me_plenty.page;

import com.epam.automation.webdriver_stage2.hard_me_plenty.enums.*;
import com.epam.automation.webdriver_stage2.hard_me_plenty.resources.CommonDataHardMePlentyJSON;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class PricingCalculatorPage {
    private WebDriver driver;
    private CommonDataHardMePlentyJSON commonData;

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

    @FindBy(xpath = "//md-checkbox[@aria-label='Add GPUs']")
    private WebElement checkBoxAddGPU;

    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']")
    private WebElement inputContainerGPUNumber;

    @FindBy(xpath = "//md-select[@placeholder='GPU type']")
    private WebElement inputContainerGPUType;

    @FindBy(id = "select_357")
    private WebElement inputContainerLocalSSD;

    @FindBy(id = "select_94")
    private WebElement inputContainerDataCenterLocation;

    @FindBy(id = "select_101")
    private WebElement inputContainerCommittedUsage;

    @FindBy(xpath = "//button[@aria-label='Add to Estimate']")
    private WebElement buttonAddToEstimate;

    String partOfLocatorForPositionDropDownList = "//div[@class='md-select-menu-container md-active md-clickable']//md-option[@value='%s']";

    @FindBy(xpath = "//md-list[@class='cartitem ng-scope']/md-list-item/div")
    private List<WebElement> createdEstimate;

    public PricingCalculatorPage(WebDriver driver, CommonDataHardMePlentyJSON commonData) {
        this.driver = driver;
        this.commonData = commonData;
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

    public boolean checkFieldsCreatedEstimateHasTheSameDataLikeInCalculator(List<String> fields) {
        List<String> lines = new ArrayList<>();
        createdEstimate.forEach(x->lines.add(x.getText()));

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

    public boolean checkPriceCreatedEstimateHasTheSameValueLikeInManualTest(String manualTestValue) {
        return createdEstimate.stream().filter(x -> x.getText()
                .contains(commonData.getPriceField()))
                .anyMatch(z -> z.getText().contains(manualTestValue));
    }

    private boolean findResultInFields(String line, String field) {
        switch (field) {
            case "VM class":
                return line.toLowerCase().endsWith(MachineClass.REGULAR.getDescription().toLowerCase());
            case "Instance type":
                return line.toLowerCase().endsWith(MachineType.N1_STANDART_8.getDescription().toLowerCase());
            case "Region":
                return line.toLowerCase().endsWith(DatacenterLocation.FRANKFURT.getDescription().toLowerCase());
            case "local SSD":
                return line.toLowerCase().endsWith(LocalSSD.X2_375.getDescription().toLowerCase());
            case "Commitment term":
                return line.toLowerCase().endsWith(CommittedUsage.YEAR_1.getDescription().toLowerCase());
            default:
                return false;
        }
    }
}
