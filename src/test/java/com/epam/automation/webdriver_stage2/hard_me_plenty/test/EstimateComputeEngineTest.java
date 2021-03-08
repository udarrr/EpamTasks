package com.epam.automation.webdriver_stage2.hard_me_plenty.test;

import com.epam.automation.webdriver_stage2.hard_me_plenty.page.CloudGoogleHomePage;
import com.epam.automation.webdriver_stage2.hard_me_plenty.resources.CommonDataHardMePlentyJSON;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EstimateComputeEngineTest {
    private ChromeDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(description = "Hard me plenty")
    public void createEstimateAndCheckFields() {
        CommonDataHardMePlentyJSON data = new CommonDataHardMePlentyJSON();

        boolean expectedEstimate = new CloudGoogleHomePage(driver, data)
                .openHomePage()
                .fillSearchInput()
                .openPricingCalculatorPage()
                .chooseComputerEngine()
                .fillInputNumberInstances(data.getQuantityInstances())
                .chooseOperationSystem(data.getOperationSystem())
                .chooseMachineClass(data.getMachineClass())
                .chooseSeries(data.getSeries())
                .chooseMachineType(data.getMachineType())
                .addGPUs(data.getGpuQuantity(),data.getGpuType())
                .chooseLocalSSD(data.getLocalSSD())
                .chooseDataCenterLocation(data.getDataCenterLocation())
                .chooseCommittedUsage(data.getCommittedUsage())
                .pressButtonAddToEstimate()
                .checkFieldsCreatedEstimateHasTheSameDataLikeInCalculator(
                        CommonDataHardMePlentyJSON.instanceTypeField,
                        CommonDataHardMePlentyJSON.vmClassField,
                        CommonDataHardMePlentyJSON.regionField,
                        CommonDataHardMePlentyJSON.localSSDField,
                        CommonDataHardMePlentyJSON.commitmentTermField
                );

        Assert.assertTrue(expectedEstimate, "Created estimate don't have the same info like in calculator");
    }

    @Test(description = "Hard me plenty")
    public void createEstimateAndCheckPriceHasTheSameValueLikeManualTest() {
        CommonDataHardMePlentyJSON commonData = new CommonDataHardMePlentyJSON();

        boolean expectedEstimatePriceIfCompareItWithResultAfterManualTest = new CloudGoogleHomePage(driver, commonData)
                .openHomePage()
                .fillSearchInput()
                .openPricingCalculatorPage()
                .chooseComputerEngine()
                .fillInputNumberInstances(commonData.getQuantityInstances())
                .chooseOperationSystem(commonData.getOperationSystem())
                .chooseMachineClass(commonData.getMachineClass())
                .chooseSeries(commonData.getSeries())
                .chooseMachineType(commonData.getMachineType())
                .addGPUs(commonData.getGpuQuantity(),commonData.getGpuType())
                .chooseLocalSSD(commonData.getLocalSSD())
                .chooseDataCenterLocation(commonData.getDataCenterLocation())
                .chooseCommittedUsage(commonData.getCommittedUsage())
                .pressButtonAddToEstimate()
                .checkPriceCreatedEstimateHasTheSameValueLikeInManualTest(commonData.getResultPriceAfterManualTest());

        Assert.assertTrue(expectedEstimatePriceIfCompareItWithResultAfterManualTest, "Estimate price don't has the same value like value manual test");
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
