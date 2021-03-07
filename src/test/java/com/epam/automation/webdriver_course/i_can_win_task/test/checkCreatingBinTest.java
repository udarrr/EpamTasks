package com.epam.automation.webdriver_course.i_can_win_task.test;

import com.epam.automation.webdriver_course.enums.ExpirationTime;
import com.epam.automation.webdriver_course.i_can_win_task.page.ThePasteBinHomePage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class checkCreatingBinTest {
    private ChromeDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(description = "I can win")
    public void createNewPastAndCheckItIsCreated() {
        boolean expectedCreatedOneNewPastBin = new ThePasteBinHomePage(driver)
                .openPage()
                .pasteBin("Hello from WebDriver")
                .selectExpirationTime(ExpirationTime.MINUTES_10.getExpiration())
                .pasteNameTitle("helloweb")
                .createNewBin()
                .checkResult();

        Assert.assertTrue(expectedCreatedOneNewPastBin, "New past bin wasn't created");
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
