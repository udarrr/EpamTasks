package com.epam.automation.webdriver_stage2.hardmeplenty_hardcore.page;

import com.epam.automation.webdriver_stage2.hardmeplenty_hardcore.resources.CommonDataHardMePlentyJSON;
import com.epam.automation.webdriver_stage2.waits.CustomConditions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CloudGoogleHomePage {
    private static final String HOME_PAGE_URL = "https://cloud.google.com/";
    private WebDriver driver;
    private CommonDataHardMePlentyJSON commonData;

    @FindBy(xpath = "//div[@class='devsite-searchbox']/input")
    private WebElement searchInput;

    public CloudGoogleHomePage(WebDriver driver, CommonDataHardMePlentyJSON data) {
        this.driver = driver;
        this.commonData = data;
        PageFactory.initElements(driver, this);
    }

    public CloudGoogleHomePage openHomePage() {
        driver.get(HOME_PAGE_URL);

        new WebDriverWait(driver, 15).withMessage("javascript didn't load")
                .until(CustomConditions.jsLoadCompleted());

        return this;
    }

    public SearchingResultPage fillSearchInput(){
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(searchInput));
        searchInput.click();
        searchInput.sendKeys("Google Cloud Platform Pricing Calculator");
        searchInput.sendKeys(Keys.ENTER);

        return new SearchingResultPage(driver, commonData);
    }
}
