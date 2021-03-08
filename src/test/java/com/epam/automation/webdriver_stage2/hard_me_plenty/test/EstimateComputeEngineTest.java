package com.epam.automation.webdriver_stage2.hard_me_plenty.test;

import com.epam.automation.webdriver_stage2.hard_me_plenty.page.CloudGoogleHomePage;
import com.epam.automation.webdriver_stage2.hard_me_plenty.page.PricingCalculatorPage;
import org.openqa.selenium.chrome.ChromeDriver;
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
    public void createNewPastAndCheckItIsCreated() {
        PricingCalculatorPage estimate = new CloudGoogleHomePage(driver)
                .openHomePage()
                .fillSearchInput()
                .openPricingCalculatorPage()
                .chooseComputerEngine()
                .fillInputNumberInstances("4")
                .chooseOperationSystem("free")
                .chooseMachineClass("regular")
                .chooseSeries("n1")
                .chooseMachineType("CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8")
                .addGPUs("1","NVIDIA_TESLA_V100")
                .chooseLocalSSD("2")
                .chooseDataCenterLocation("europe-west3")
                .chooseCommittedUsage("1")
                .pressButtonAddToEstimate();


//        boolean expectedHeaderLikeInitial = createdBin.checkHeaderCreatedBin();
//        Assert.assertTrue(expectedHeaderLikeInitial, "There is don't similar header");

    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
