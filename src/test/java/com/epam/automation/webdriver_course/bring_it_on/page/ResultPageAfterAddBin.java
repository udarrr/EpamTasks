package com.epam.automation.webdriver_course.bring_it_on.page;

import com.epam.automation.webdriver_course.bring_it_on.exceptions.HeaderMatchException;
import com.epam.automation.webdriver_course.bring_it_on.exceptions.HighlightingException;
import com.epam.automation.webdriver_course.bring_it_on.resources.DataForBringItOnTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ResultPageAfterAddBin {
    private WebDriver driver;

    @FindBy(xpath = "//li[@class='li1']")
    private List<WebElement> rawLinesWithResult;

    @FindBy(xpath = "//div[@class='de1']")
    private List<WebElement> rawLinesInCreatedBin;

    @FindBy(xpath = "//h1")
    private WebElement headerCreatedBin;

    private String rawLines = "//div[@class='de1']/../../li";

    public ResultPageAfterAddBin(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ResultPageAfterAddBin checkHeaderCreatedBin() throws HeaderMatchException {
        if(!headerCreatedBin.getText().equals(new DataForBringItOnTest().getTitleName())){
            throw new HeaderMatchException("There is don't match header");
        }
        return this;
    }

    public ResultPageAfterAddBin checkHighlightingSyntax() throws HighlightingException {
        List<WebElement> webElement = driver.findElements(By.xpath(rawLines));

        for (int i = 0; i < webElement.size(); i++) {
            List<WebElement> spanElementsInRawLine =
                    webElement.get(i).findElements(By.xpath(buildLocatorForRawLine(i)));

            for (int j = 0; j < spanElementsInRawLine.size(); j++) {
                if (!checkSpanHasRightColorSyntax(spanElementsInRawLine, j)) {
                    throw new HighlightingException("Highlighting isn't working");
                }
            }
        }
        return this;
    }

    public boolean checkTextInRawLinesMatchWithInitialText(){
        DataForBringItOnTest data = new DataForBringItOnTest();
        List<String> lines = new ArrayList<>();

        for (WebElement element : rawLinesInCreatedBin){
            lines.add(element.getText());
        }

        return lines.containsAll(data.getSampleBashCode());
    }

    private String buildLocatorForRawLine(int numberRawLine){

        return rawLines + "[" + (numberRawLine + 1) + "]" + "//span";
    }

    private boolean checkSpanHasRightColorSyntax(List<WebElement> part, int indexOfPartElement) {
        DataForBringItOnTest data = new DataForBringItOnTest();

        switch (part.get(indexOfPartElement).getAttribute("class")) {
            case "kw2":
                for (int k = 0; k < data.getCommandsGitBash().size(); k++) {
                    if (part.get(indexOfPartElement).getText().equals(data.getCommandsGitBash().get(k))) {
                        return true;
                    }
                }
                break;

            case "br0":
                for (int k = 0; k < data.getCharacterBashWrap().size(); k++) {
                    if (part.get(indexOfPartElement).getText().equals(data.getCharacterBashWrap().get(k))) {
                        return true;
                    }
                }
                break;

            case "re5":
                if (part.get(indexOfPartElement).getText().startsWith("-") || part.get(indexOfPartElement).getText().startsWith("--")) {
                    return true;
                }
                break;

            case "st0":
                if (part.get(indexOfPartElement).getText().startsWith("\"") && part.get(indexOfPartElement).getText().endsWith("\"")) {
                    return true;
                }
                break;
        }
        return false;
    }
}
