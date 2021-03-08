package com.epam.automation.webdriver_stage2.hard_me_plenty.page;

import com.epam.automation.webdriver_stage2.hard_me_plenty.resources.CommonDataHardMePlentyJSON;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchingResultPage {
    private WebDriver driver;
    private CommonDataHardMePlentyJSON commonData;

    @FindBy(xpath = "//a[@class='gs-title']/b[text()='Google Cloud Platform Pricing Calculator']")
    private WebElement googleCalculatorLink;

    public SearchingResultPage(WebDriver driver,CommonDataHardMePlentyJSON commonData) {
        this.driver = driver;
        this.commonData = commonData;
        PageFactory.initElements(driver, this);
    }

    public PricingCalculatorPage openPricingCalculatorPage(){
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.elementToBeClickable(googleCalculatorLink));

        googleCalculatorLink.click();

        return new PricingCalculatorPage(driver, commonData);
    }
}
