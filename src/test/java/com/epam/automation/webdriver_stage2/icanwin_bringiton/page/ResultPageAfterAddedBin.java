package com.epam.automation.webdriver_stage2.icanwin_bringiton.page;

import com.epam.automation.webdriver_stage2.icanwin_bringiton.resources.CommonDataBringItOnTestJSON;
import com.epam.automation.webdriver_stage2.icanwin_bringiton.enums.BashColorHighlighting;
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
    private CommonDataBringItOnTestJSON data;

    @FindBy(xpath = "//div[@class='de1']")
    private List<WebElement> rawLinesCreatedBin;

    @FindBy(xpath = "//h1")
    private WebElement headerCreatedBin;

    private String partOfLocatorParticularRawLine = "//div[@class='de1']/../../li";

    public ResultPageAfterAddedBin(WebDriver driver, CommonDataBringItOnTestJSON data) {
        this.driver = driver;
        this.data = data;
        PageFactory.initElements(driver, this);
    }

    public boolean checkCreatedBin() {
        List<WebElement> result =new WebDriverWait(driver,10).
                until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//li[@class='li1']")));

        return result.size() > 0;
    }

    public boolean checkHeaderCreatedBin() {
        new WebDriverWait(driver, 10).withMessage("Header isn't present")
                .until(ExpectedConditions.visibilityOf(headerCreatedBin));

        return headerCreatedBin.getText().equals(new CommonDataBringItOnTestJSON().getTitleName());
    }

    public boolean checkHighlightingSyntax() {
        List<WebElement> elements = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(partOfLocatorParticularRawLine)));

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
        List<String> lines = new ArrayList<>();

        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfAllElements(rawLinesCreatedBin));

        for (WebElement element : rawLinesCreatedBin) {
            lines.add(element.getText());
        }

        return lines.containsAll(data.getSampleBashCode());
    }

    private String buildLocatorForRawLine(int numberRawLine) {
        return partOfLocatorParticularRawLine + "[" + (numberRawLine + 1) + "]" + "//span";
    }

    private boolean checkSpanHasRightColorSyntax(List<WebElement> part, int indexOfPartElement) {
        switch (part.get(indexOfPartElement).getAttribute("class")) {
            case BashColorHighlighting.KW2:
                for (int k = 0; k < data.getCommandsGitBash().size(); k++) {
                    if (part.get(indexOfPartElement).getText().equals(data.getCommandsGitBash().get(k))) {
                        return true;
                    }
                }
                return false;

            case BashColorHighlighting.BR0:
                for (int k = 0; k < data.getCharacterBashWrap().size(); k++) {
                    if (part.get(indexOfPartElement).getText().equals(data.getCharacterBashWrap().get(k))) {
                        return true;
                    }
                }
                return false;

            case BashColorHighlighting.RE5:
                return part.get(indexOfPartElement).getText().startsWith("-") ||
                        part.get(indexOfPartElement).getText().startsWith("--");

            case BashColorHighlighting.ST0:
                return part.get(indexOfPartElement).getText().startsWith("\"") &&
                        part.get(indexOfPartElement).getText().endsWith("\"");

            default:
                return false;
        }
    }
}
