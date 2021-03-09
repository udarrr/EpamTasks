package com.epam.automation.webdriver_stage2.hardmeplenty_hardcore.page;

import com.epam.automation.webdriver_stage2.hardmeplenty_hardcore.resources.CommonDataHardMePlentyJSON;
import com.epam.automation.webdriver_stage2.waits.CustomConditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class TemporaryEmailHomePage {
    private WebDriver driver;
    private CommonDataHardMePlentyJSON data;
    private String HOME_PAGE_URL= "https://10minutemail.com";

    @FindBy(id= "copy_address")
    private WebElement iconCopyEmail;

    @FindBy(xpath = "//*[@id=\"mail_messages_content\"]//span[text()='Google Cloud Platform Price Estimate']")
    private WebElement containerWithLetter;

    @FindBy(xpath = "//*[@id=\"mobilepadding\"]//td[2]/h3")
    private WebElement fieldTotalPriceEstimateBill;

    public TemporaryEmailHomePage(WebDriver driver, CommonDataHardMePlentyJSON data) {
        this.driver = driver;
        this.data = data;
        PageFactory.initElements(driver, this);
    }

    public TemporaryEmailHomePage openPageTemporaryEmail() {
        driver.get(HOME_PAGE_URL);

        new WebDriverWait(driver, 15).withMessage("javascript didn't load")
                .until(CustomConditions.jQueryAJAXsCompleted());

        return this;
    }

    public TemporaryEmailHomePage copyTemporaryEmail(){
        iconCopyEmail.click();

        return this;
    }

    public PricingCalculatorPage comeBackToCalculator(){
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));

        return new PricingCalculatorPage(driver, data);
    }

    public TemporaryEmailHomePage checkLetterInTemporaryEmailBox(){
        new WebDriverWait(driver,15).until(ExpectedConditions.visibilityOf(containerWithLetter));

        containerWithLetter.click();

        return this;
    }

    public boolean compareCalculatorTotalPriceResultHasTheSamePriceLikeInTemporaryEmailLetter(){
        String priceEmail = fieldTotalPriceEstimateBill.getText();
        String priceCalculator = data.getResultPriceFromCalculator();

        return priceCalculator.contains(priceEmail);
    }
}
