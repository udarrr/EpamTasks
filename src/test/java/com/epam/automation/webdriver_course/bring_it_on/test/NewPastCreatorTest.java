package com.epam.automation.webdriver_course.bring_it_on.test;

import com.epam.automation.webdriver_course.bring_it_on.exceptions.HeaderMatchException;
import com.epam.automation.webdriver_course.bring_it_on.exceptions.HighlightingException;
import com.epam.automation.webdriver_course.bring_it_on.page.PasteBinHomePage;
import com.epam.automation.webdriver_course.bring_it_on.resources.DataForBringItOnTest;
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
    public void createNewPastAndCheckItIsCreated() throws HeaderMatchException, HighlightingException {
        DataForBringItOnTest data = new DataForBringItOnTest();

        boolean expectedRightCreatedBin = new PasteBinHomePage(driver)
                .openPage()
                .pasteBin(data.getSampleBashCode())
                .selectSyntaxType(data.getTypeSyntax())
                .selectExpirationTime(data.getExpirationTime())
                .pasteNameTitle(data.getTitleName())
                .createNewPaste()
                .checkHeaderCreatedBin()
                .checkHighlightingSyntax()
                .checkTextInRawLinesMatchWithInitialText();

        Assert.assertTrue(expectedRightCreatedBin, "New past bin wasn't created");
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
