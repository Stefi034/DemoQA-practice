package qaPractice;


import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

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

    protected void verifyElementVisible(By locator) {
        Assertions.assertTrue(isElementDisplayed(locator));
    }

    protected Point dragBoxCoordinates(By locator) {
        return getElementLocation(locator);
    }
    protected Point elementLocationBefore(String dragBoxName){
        return getElementLocation(dragBoxLocator(dragBoxName));
    }
    protected Point elementLocationAfter(String dragBoxName){
        return getElementLocation(dragBoxLocator(dragBoxName));
    }
    protected void verifyObjectMoved(Point beforeAction, Point afterAction){
        Assertions.assertNotEquals(beforeAction,afterAction,"Object didn't move!");
    }
    protected void clickOnButton(String buttonLabel){
        clickWebElement(buttonLocator(buttonLabel));
    }
    protected void inputTextInputField(String label,String placeholderText, String inputText){
        typeTextToWebElement(inputField(label,placeholderText),inputText);
    }
    protected void inputTextTextArea(String label, String inputText){
        typeTextToWebElement(textAreaInputField(label),inputText);
    }


}

