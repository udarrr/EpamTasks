package com.epam.automation.webdriver_stage2.icanwin_bringiton.test;

import com.epam.automation.webdriver_stage2.icanwin_bringiton.page.PasteBinHomePage;
import com.epam.automation.webdriver_stage2.icanwin_bringiton.resources.CommonDataBringItOnTestJSON;
import com.epam.automation.webdriver_stage2.icanwin_bringiton.enums.ExpirationTime;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewPastCreatorTest {
    private ChromeDriver driver;
    CommonDataBringItOnTestJSON data;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        data = new CommonDataBringItOnTestJSON();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(description = "I can win")
    public void createNewPastAndCheckItIsCreated() {
        boolean expectedCreatedOneNewPastBin = new PasteBinHomePage(driver,data)
                .openHomePage()
                .pasteBin("Hello from WebDriver")
                .selectExpirationTime(ExpirationTime.MINUTES_10.getExpiration())
                .pasteNameTitle("helloweb")
                .createNewBin()
                .checkCreatedBin();

        Assert.assertTrue(expectedCreatedOneNewPastBin, "New past bin wasn't created");
    }

    @Test(description = "Bring it on")
    public void createBinAndCheckHeader() {


        boolean expectedHeaderLikeInitial = new PasteBinHomePage(driver, data)
                .openHomePage()
                .pasteBin(data.getSampleBashCode())
                .selectSyntaxType(data.getTypeSyntax())
                .selectExpirationTime(data.getExpirationTime())
                .pasteNameTitle(data.getTitleName())
                .createNewBin()
                .checkHeaderCreatedBin();

        Assert.assertTrue(expectedHeaderLikeInitial, "There is no similar header");
    }

    @Test(description = "Bring it on")
    public void createBinAndCheckSyntaxBash() {
        boolean expectedHighlightingSyntaxInRightWay = new PasteBinHomePage(driver, data)
                .openHomePage()
                .pasteBin(data.getSampleBashCode())
                .selectSyntaxType(data.getTypeSyntax())
                .selectExpirationTime(data.getExpirationTime())
                .pasteNameTitle(data.getTitleName())
                .createNewBin()
                .checkHighlightingSyntax();

        Assert.assertTrue(expectedHighlightingSyntaxInRightWay, "Highlighting isn't working");
    }

    @Test(description = "Bring it on")
    public void createBinAndCheckLines() {
        boolean expectedTextInRawLinesMatchWithInitialLines = new PasteBinHomePage(driver, data)
                .openHomePage()
                .pasteBin(data.getSampleBashCode())
                .selectSyntaxType(data.getTypeSyntax())
                .selectExpirationTime(data.getExpirationTime())
                .pasteNameTitle(data.getTitleName())
                .createNewBin()
                .checkTextInRawLinesMatchWithInitialText();

        Assert.assertTrue(expectedTextInRawLinesMatchWithInitialLines, "Text in lines isn't same");
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
