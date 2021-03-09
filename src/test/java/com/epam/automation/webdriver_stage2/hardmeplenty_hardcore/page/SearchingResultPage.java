package com.epam.automation.webdriver_stage2.hardmeplenty_hardcore.page;

import com.epam.automation.webdriver_stage2.hardmeplenty_hardcore.resources.CommonDataHardMePlentyJSON;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchingResultPage {
    private WebDriver driver;
    private CommonDataHardMePlentyJSON data;

    @FindBy(xpath = "//a[@class='gs-title']/b[text()='Google Cloud Platform Pricing Calculator']")
    private WebElement googleCalculatorLink;

    public SearchingResultPage(WebDriver driver, CommonDataHardMePlentyJSON data) {
        this.driver = driver;
        this.data = data;
        PageFactory.initElements(driver, this);
    }

    public PricingCalculatorPage openPricingCalculatorPage(){
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.elementToBeClickable(googleCalculatorLink));

        googleCalculatorLink.click();

        return new PricingCalculatorPage(driver, data);
    }
}
