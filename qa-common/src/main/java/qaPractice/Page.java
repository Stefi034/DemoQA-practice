package qaPractice;


import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import qaPractice.pages.Interactions;


import static data.constants.Locators.PAGE_HEADER;
import static data.constants.Locators.dragBoxLocator;


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

    public Point dragBoxCoordinates(By locator) {
        return getElementLocation(locator);
    }
    public Point elementLocationBefore(String dragBoxName){
        return getElementLocation(dragBoxLocator(dragBoxName));
    }
    public Point elementLocationAfter(String dragBoxName){
        return getElementLocation(dragBoxLocator(dragBoxName));
    }
    protected void verifyObjectMoved(Point beforeAction, Point afterAction){
        Assertions.assertNotEquals(beforeAction,afterAction,"Object didn't move!");
    }


}

