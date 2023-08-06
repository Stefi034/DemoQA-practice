package qaPractice;


import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static data.constants.Locators.*;


public class Page extends BasePageClass {
    protected Page(WebDriver driver) {
        super(driver);
    }

    protected void verifyClass(By verificationLocator, int time, String pageName) {
        waitForElementToBeVisible(verificationLocator, time);
        String actualPageName = getTextFromWebElement(PAGE_HEADER);
        Assertions.assertEquals(pageName, actualPageName);
    }

    protected void openElementFromList(By locator) {
        scrollToElementJS(locator);
        clickWebElement(locator);
    }


    protected Point dragBoxCoordinates(By locator) {
        return getElementLocation(locator);
    }

    protected Point elementLocationBefore(String dragBoxName) {
        return getElementLocation(dragBoxLocator(dragBoxName));
    }

    protected Point elementLocationAfter(String dragBoxName) {
        return getElementLocation(dragBoxLocator(dragBoxName));
    }

    protected void verifyObjectMoved(Point beforeAction, Point afterAction) {
        Assertions.assertNotEquals(beforeAction, afterAction, "Object didn't move!");
    }

    protected String getSubmissionOutput(String outputElement) {
        return getTextFromWebElement(submissionOutput(outputElement));
    }

    protected void verifySubmissionOutput(String outputElement, String inputElement) {
        Assertions.assertTrue(getSubmissionOutput(outputElement).contains(inputElement), "Names are not equal!");
        System.out.println(getSubmissionOutput(outputElement) + " Ovo je izvukao na get i ide contains");
        System.out.println(inputElement + " sa ovim poredi asssert True");
    }

    protected void clickOnButton(String buttonLabel) {
        clickWebElement(buttonLocator(buttonLabel));
    }

    protected void clickOnRadioButton(String label) {
        clickWebElement(radioButton(label));
    }

    protected void inputTextInputField(String label, String placeholderText, String inputText) {
        typeTextToWebElement(inputField(label, placeholderText), inputText);
    }

    protected void inputTextTextArea(String label, String inputText) {
        typeTextToWebElement(textAreaInputField(label), inputText);
    }
    protected void inputSearchBox(String inputText){
        typeTextToWebElement(SEARCH_BOX_INPUT_LOCATOR,inputText);
    }

    protected void tableSorting(String columnLabel, String order) {
        boolean flagOrder = true;
        while (flagOrder) {
            clickWebElement(columnHeaderLocator(columnLabel));
            if (isElementDisplayed(tableSortingLocator(columnLabel, order))) {
                flagOrder = false;
            }
        }
    }

    protected void isIntListSortedAscending(By locator) {
        List<WebElement> elements = getWebElements(locator);
        int comparingValue = 0;
        for (WebElement element : elements) {
            String value = element.getText().trim();
            if (value.isEmpty()) {
                break;
            }
            int valueInt = Integer.parseInt(value);
            if (valueInt >= comparingValue) {
                comparingValue = valueInt;
            }
            if (comparingValue > valueInt) {
                Assertions.fail("Elements not in ascending order!");
            }
        }
    }

    protected List<String> getTableContent(By locator) {
        List<String> userData = new ArrayList<>();
        List<WebElement> elements = getWebElements(locator);
        for (WebElement element: elements){
            userData.add(element.getText());
        }
        System.out.println(userData);
        return userData;
    }


}

