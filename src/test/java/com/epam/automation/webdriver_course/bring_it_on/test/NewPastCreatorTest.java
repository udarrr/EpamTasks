package com.epam.automation.webdriver_course.bring_it_on.test;

import com.epam.automation.webdriver_course.bring_it_on.page.PasteBinHomePage;
import com.epam.automation.webdriver_course.bring_it_on.page.ResultPageAfterAddedBin;
import com.epam.automation.webdriver_course.bring_it_on.resources.CommonDataBringItOnTestForJSON;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewPastCreatorTest {
    private ChromeDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(description = "I can win")
    public void createNewPastAndCheckItIsCreated() {
        CommonDataBringItOnTestForJSON data = new CommonDataBringItOnTestForJSON();

        ResultPageAfterAddedBin createdBin = new PasteBinHomePage(driver)
                .openHomePage()
                .pasteBin(data.getSampleBashCode())
                .selectSyntaxType(data.getTypeSyntax())
                .selectExpirationTime(data.getExpirationTime())
                .pasteNameTitle(data.getTitleName())
                .createNewPaste();

        boolean expectedHeaderLikeInitial = createdBin.checkHeaderCreatedBin();
        Assert.assertTrue(expectedHeaderLikeInitial, "There is don't similar header");

        boolean expectedHighlightingSyntaxInRightWay = createdBin.checkHeaderCreatedBin();
        Assert.assertTrue(expectedHighlightingSyntaxInRightWay, "Highlighting isn't working");

        boolean expectedTextInRawLinesMatchWithInitialLines = createdBin.checkTextInRawLinesMatchWithInitialText();
        Assert.assertTrue(expectedTextInRawLinesMatchWithInitialLines, "Text in lines isn't same");
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
