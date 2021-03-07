package com.epam.automation.webdriver_course.bring_it_on.page;

import com.epam.automation.webdriver_course.bring_it_on.resources.CommonDataBringItOnTestForJSON;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class ResultPageAfterAddedBin {
    private WebDriver driver;

    @FindBy(xpath = "//li[@class='li1']")
    private List<WebElement> rawLinesWithResult;

    @FindBy(xpath = "//div[@class='de1']")
    private List<WebElement> rawLinesInCreatedBin;

    @FindBy(xpath = "//h1")
    private WebElement headerCreatedBin;

    private String partOfLocatorParticularRawLine = "//div[@class='de1']/../../li";

    public ResultPageAfterAddedBin(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean checkHeaderCreatedBin() {
        new WebDriverWait(driver, 10).withMessage("Header isn't present")
                .until(ExpectedConditions.visibilityOf(headerCreatedBin));

        boolean headerHasTheSameTextLikeInitial = headerCreatedBin.getText().equals(new CommonDataBringItOnTestForJSON().getTitleName());

        if (!headerHasTheSameTextLikeInitial) {
            return false;
        }
        return true;
    }

    public boolean checkHighlightingSyntax() {
        List<WebElement> elements = driver.findElements(By.xpath(partOfLocatorParticularRawLine));

        new WebDriverWait(driver, 10).withMessage("Raw lines isn't present").
                until(ExpectedConditions.visibilityOfAllElements(elements));

        for (int i = 0; i < elements.size(); i++) {
            List<WebElement> spanElementsInRawLine =
                    elements.get(i).findElements(By.xpath(buildLocatorForRawLine(i)));

            for (int j = 0; j < spanElementsInRawLine.size(); j++) {
                if (!checkSpanHasRightColorSyntax(spanElementsInRawLine, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkTextInRawLinesMatchWithInitialText() {
        CommonDataBringItOnTestForJSON data = new CommonDataBringItOnTestForJSON();
        List<String> lines = new ArrayList<>();

        for (WebElement element : rawLinesInCreatedBin) {
            lines.add(element.getText());
        }

        return lines.containsAll(data.getSampleBashCode());
    }

    private String buildLocatorForRawLine(int numberRawLine) {
        return partOfLocatorParticularRawLine + "[" + (numberRawLine + 1) + "]" + "//span";
    }

    private boolean checkSpanHasRightColorSyntax(List<WebElement> part, int indexOfPartElement) {
        CommonDataBringItOnTestForJSON data = new CommonDataBringItOnTestForJSON();

        switch (part.get(indexOfPartElement).getAttribute("class")) {
            case "kw2":
                for (int k = 0; k < data.getCommandsGitBash().size(); k++) {
                    if (part.get(indexOfPartElement).getText().equals(data.getCommandsGitBash().get(k))) {
                        return true;
                    }
                }
                return false;

            case "br0":
                for (int k = 0; k < data.getCharacterBashWrap().size(); k++) {
                    if (part.get(indexOfPartElement).getText().equals(data.getCharacterBashWrap().get(k))) {
                        return true;
                    }
                }
                return false;

            case "re5":
                if (part.get(indexOfPartElement).getText().startsWith("-") ||
                        part.get(indexOfPartElement).getText().startsWith("--")) {
                    return true;
                }
                return false;

            case "st0":
                if (part.get(indexOfPartElement).getText().startsWith("\"") &&
                        part.get(indexOfPartElement).getText().endsWith("\"")) {
                    return true;
                }
                return false;

            default:
                return false;
        }
    }
}
