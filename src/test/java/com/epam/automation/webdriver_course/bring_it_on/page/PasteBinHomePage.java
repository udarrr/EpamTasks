package com.epam.automation.webdriver_course.bring_it_on.page;

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

    public PasteBinHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PasteBinHomePage openPage() {
        driver.get(HOME_PAGE_URL);
        new WebDriverWait(driver, 10).until(CustomConditions.jQueryAJAXsCompleted());

        return this;
    }

    public PasteBinHomePage pasteBin(List<String> bin) {
        for (String lines : bin){
            textAreaForPasteBin.sendKeys(lines);
            textAreaForPasteBin.sendKeys(Keys.RETURN);
        }
        return this;
    }

    public PasteBinHomePage selectSyntaxType(String element) {
        selectorSyntaxHighlighting.click();

        buildFullLocatorForDropDownList(element).click();

        return this;
    }

    public PasteBinHomePage selectExpirationTime(String element) {
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

    public ResultPageAfterAddBin createNewPaste() {
        buttonCreateNewPast.click();

        return new ResultPageAfterAddBin(driver);
    }
}
