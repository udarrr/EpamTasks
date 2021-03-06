package com.epam.automation.webdriver_course.i_can_win_task.page;

import com.epam.automation.webdriver_course.waits.CustomConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ThePasteBinHomePage {
    private static final String HOME_PAGE_URL = "http://pastebin.com";
    private WebDriver driver;

    @FindBy(id = "postform-text")
    private WebElement textAreaForPasteBin;

    @FindBy(xpath = "//span[@data-select2-id='3']")
    private WebElement selectorPasteExpiration;

    @FindBy(id = "postform-name")
    private WebElement inputNameTitle;

    @FindBy(xpath = "//button[text()='Create New Paste']")
    private WebElement buttonCreateNewPast;

    private String partOfLocatorForElementDWLEstimateTime = "//li[text()='%s']";

    public ThePasteBinHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ThePasteBinHomePage openPage() {
        driver.get(HOME_PAGE_URL);
        new WebDriverWait(driver, 10).until(CustomConditions.jQueryAJAXsCompleted());

        return this;
    }

    public ThePasteBinHomePage pasteBin(String bin) {
        textAreaForPasteBin.sendKeys(bin);

        return this;
    }

    public ThePasteBinHomePage selectExpirationTime(String elementText) {
        selectorPasteExpiration.click();

        String fullLocator = String.format(partOfLocatorForElementDWLEstimateTime,elementText);

        WebElement dropDownListElement = new WebDriverWait(driver,10).
                until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath(fullLocator)));

        dropDownListElement.click();

        return this;
    }

    public ThePasteBinHomePage pasteNameTitle(String nameTitle) {
        inputNameTitle.sendKeys(nameTitle);

        return this;
    }

    public ResultPageAfterAddBin createNewBin(){
        buttonCreateNewPast.click();

        return new ResultPageAfterAddBin(driver);
    }
}
