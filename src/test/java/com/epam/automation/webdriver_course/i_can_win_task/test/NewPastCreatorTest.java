package com.epam.automation.webdriver_course.i_can_win_task.test;

import com.epam.automation.webdriver_course.enums.ExpirationTime;
import com.epam.automation.webdriver_course.i_can_win_task.page.ThePasteBinHomePage;
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
        boolean expectedCreatedOneNewPastBin = new ThePasteBinHomePage(driver)
                .openPage()
                .pasteBin("Hello from WebDriver")
                .selectExpirationTime(ExpirationTime.MINUTES_10.getExpirationTime())
                .pasteNameTitle("helloweb")
                .resultAfterCreatingNewBin();

        Assert.assertTrue(expectedCreatedOneNewPastBin, "New past bin wasn't created");

//        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//                .withTimeout(Duration.ofSeconds(10))
//                .ignoring(NoSuchElementException.class);
//
//        WebElement result = wait.until(new Function<WebDriver, WebElement>() {
//            @Override
//            public WebElement apply(WebDriver driver) {
//                return driver.findElement(By.xpath(""));
//            }
//        });
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
