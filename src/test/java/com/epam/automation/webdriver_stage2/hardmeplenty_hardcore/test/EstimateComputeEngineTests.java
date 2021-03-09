package com.epam.automation.webdriver_stage2.hardmeplenty_hardcore.test;

import com.epam.automation.webdriver_stage2.hardmeplenty_hardcore.page.CloudGoogleHomePage;
import com.epam.automation.webdriver_stage2.hardmeplenty_hardcore.resources.CommonDataHardMePlentyJSON;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EstimateComputeEngineTests {
    private ChromeDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(description = "Hard me plenty - check fields")
    public void createEstimateAndCheckFields() {
        CommonDataHardMePlentyJSON data = new CommonDataHardMePlentyJSON();

        boolean expectedFieldsHasTheSameValueLikeInCalculator = new CloudGoogleHomePage(driver, data)
                .openHomePage()
                .fillSearchInput()
                .openPricingCalculatorPage()
                .chooseComputerEngine()
                .fillInputNumberInstances(data.getQuantityInstances())
                .chooseOperationSystem(data.getOperationSystem())
                .chooseMachineClass(data.getMachineClass())
                .chooseSeries(data.getSeries())
                .chooseMachineType(data.getMachineType())
                .addGPUs(data.getGpuQuantity(), data.getGpuType())
                .chooseLocalSSD(data.getLocalSSD())
                .chooseDataCenterLocation(data.getDataCenterLocation())
                .chooseCommittedUsage(data.getCommittedUsage())
                .pressButtonAddToEstimate()
                .checkFieldsCreatedEstimateHasTheSameDataLikeInCalculator(
                        CommonDataHardMePlentyJSON.instanceTypeField,
                        CommonDataHardMePlentyJSON.vmClassField,
                        CommonDataHardMePlentyJSON.regionField,
                        CommonDataHardMePlentyJSON.localSSDField,
                        CommonDataHardMePlentyJSON.commitmentTermField);
        Assert.assertTrue(expectedFieldsHasTheSameValueLikeInCalculator, "Created estimate don't have the same info like in calculator");
    }

    @Test(description = "Hard me plenty - check total price value with value of manual test")
    public void createEstimateAndCheckPriceWithValueOfManualTest() {
        CommonDataHardMePlentyJSON data = new CommonDataHardMePlentyJSON();

        boolean expectedPriceHasTheSameValueWithResultAfterManualTest = new CloudGoogleHomePage(driver, data)
                .openHomePage()
                .fillSearchInput()
                .openPricingCalculatorPage()
                .chooseComputerEngine()
                .fillInputNumberInstances(data.getQuantityInstances())
                .chooseOperationSystem(data.getOperationSystem())
                .chooseMachineClass(data.getMachineClass())
                .chooseSeries(data.getSeries())
                .chooseMachineType(data.getMachineType())
                .addGPUs(data.getGpuQuantity(), data.getGpuType())
                .chooseLocalSSD(data.getLocalSSD())
                .chooseDataCenterLocation(data.getDataCenterLocation())
                .chooseCommittedUsage(data.getCommittedUsage())
                .pressButtonAddToEstimate()
                .checkPriceCreatedEstimateHasTheSameValueLikeInManualTest(data.getResultPriceAfterManualTest());

        Assert.assertTrue(expectedPriceHasTheSameValueWithResultAfterManualTest, "Estimate price don't has the same value like value manual test");
    }

    @Test(description = "Hardcore")
    public void createEstimateAndComparePriceCalculatorWithEmail() {
        CommonDataHardMePlentyJSON data = new CommonDataHardMePlentyJSON();

        boolean expectedPriceInCalculatorTheSameLineInEmail = new CloudGoogleHomePage(driver, data)
                .openHomePage()
                .fillSearchInput()
                .openPricingCalculatorPage()
                .chooseComputerEngine()
                .fillInputNumberInstances(data.getQuantityInstances())
                .chooseOperationSystem(data.getOperationSystem())
                .chooseMachineClass(data.getMachineClass())
                .chooseSeries(data.getSeries())
                .chooseMachineType(data.getMachineType())
                .addGPUs(data.getGpuQuantity(), data.getGpuType())
                .chooseLocalSSD(data.getLocalSSD())
                .chooseDataCenterLocation(data.getDataCenterLocation())
                .chooseCommittedUsage(data.getCommittedUsage())
                .pressButtonAddToEstimate()
                .saveCalculatorTotalPriceResult()
                .pressButtonEmailEstimate()
                .openNewTab()
                .openPageTemporaryEmail()
                .copyTemporaryEmail()
                .comeBackToCalculator()
                .enterEmail()
                .pressButtonSendEmail()
                .switchTabToTemporaryEmailHomePage()
                .checkLetterInTemporaryEmailBox()
                .compareCalculatorTotalPriceResultHasTheSamePriceLikeInTemporaryEmailLetter();

        Assert.assertTrue(expectedPriceInCalculatorTheSameLineInEmail, "Price in letter don't have the same value like in calculator");
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
