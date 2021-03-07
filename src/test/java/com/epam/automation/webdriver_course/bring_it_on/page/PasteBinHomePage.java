package com.epam.automation.webdriver_course.bring_it_on.page;

import com.epam.automation.webdriver_course.bring_it_on.resources.CommonDataBringItOnTestJSON;
import com.epam.automation.webdriver_course.waits.CustomConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PasteBinHomePage {
    private static final String HOME_PAGE_URL = "http://pastebin.com";
    private WebDriver driver;
    private CommonDataBringItOnTestJSON data;

    @FindBy(id = "postform-text")
    private WebElement textAreaForPasteBin;

    @FindBy(xpath = "//span[@data-select2-id='1']")
    private WebElement selectorSyntaxHighlighting;

    @FindBy(xpath = "//span[@data-select2-id='3']")
    private WebElement selectorPasteExpiration;

    @FindBy(id = "postform-name")
    private WebElement inputNameTitle;

    @FindBy(xpath = "//button[text()='Create New Paste']")
    private WebElement buttonCreateNewPast;

    private String partOfLocatorForElementDropDownList = "//li[text()='%s']";

    public PasteBinHomePage(WebDriver driver, CommonDataBringItOnTestJSON data) {
        this.driver = driver;
        this.data = data;
        PageFactory.initElements(driver, this);
    }

    public PasteBinHomePage openHomePage() {
        driver.get(HOME_PAGE_URL);

        new WebDriverWait(driver, 10).withMessage("JQuery didn't load")
                .until(CustomConditions.jQueryAJAXsCompleted());

        return this;
    }

    public PasteBinHomePage pasteBin(List<String> bin) {
        for (int i = 0; i < bin.size(); i++) {
            if (!(bin.size() - i == 1)) {
                textAreaForPasteBin.sendKeys(bin.get(i));
                textAreaForPasteBin.sendKeys(Keys.RETURN);
            } else {
                textAreaForPasteBin.sendKeys(bin.get(i));
            }
        }
        return this;
    }

    public PasteBinHomePage selectSyntaxType(String element) {
        new WebDriverWait(driver, 10).
                until(ExpectedConditions.elementToBeClickable(selectorSyntaxHighlighting));

        selectorSyntaxHighlighting.click();
        buildFullLocatorForDropDownList(element).click();

        return this;
    }

    public PasteBinHomePage selectExpirationTime(String element) {
        new WebDriverWait(driver, 10).
                until(ExpectedConditions.elementToBeClickable(selectorPasteExpiration));

        selectorPasteExpiration.click();
        buildFullLocatorForDropDownList(element).click();

        return this;
    }

    private WebElement buildFullLocatorForDropDownList(String element) {
        String fullLocator = String.format(partOfLocatorForElementDropDownList, element);

        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(fullLocator)));
    }

    public PasteBinHomePage pasteNameTitle(String nameTitle) {
        inputNameTitle.sendKeys(nameTitle);

        return this;
    }

    public ResultPageAfterAddedBin createNewPaste() {
        new WebDriverWait(driver, 10).
                until(ExpectedConditions.elementToBeClickable(buttonCreateNewPast));

        buttonCreateNewPast.click();

        return new ResultPageAfterAddedBin(driver, data);
    }
}
