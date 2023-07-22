package qaPractice;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public abstract class BasePageClass {

    protected WebDriver driver;

    protected BasePageClass(WebDriver driver) {
        this.driver = driver;
    }

    protected void openPage(String pageUrl) {
        driver.get(pageUrl);
    }

    protected String getPageUrl() {
        return driver.getCurrentUrl();
    }

    protected WebElement getWebElement(By locator) {
        return driver.findElement(locator);
    }

    protected List<WebElement> getWebElements(By locator) {
        return driver.findElements(locator);
    }

    protected WebElement getWebElement(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected WebElement waitForElementToBeClickable(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected WebElement waitForElementToBeVisible(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitElementToBePresent(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }


    protected boolean isElementDisplayed(By locator) {
        try {
            WebElement element = getWebElement(locator);
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    protected void verifyWebElementIsDisplayed(By locator) {
        Assertions.assertTrue(isElementDisplayed(locator));
    }
    protected void verifyWebElementNotDisplayed(By locator){
        Assertions.assertTrue(!isElementDisplayed(locator));
    }

    protected String getAttributeFromWebElement(By locator, String attribute) {
        return getWebElement(locator).getAttribute(attribute);
    }

    protected String getValueFromWebElement(By locator) {
        return getAttributeFromWebElement(locator, "value");
    }

    protected String getTextFromWebElement(By locator) {
        WebElement element = getWebElement(locator);
        return element.getText();
    }

    protected void clickWebElement(By locator) {
        getWebElement(locator).click();
    }

    protected void waitAndClickWebElement(By locator, int timeout) {
        getWebElement(locator, timeout);
    }
    protected void rightClick(By locator){
        Actions actions = new Actions(driver);
        WebElement elementLocator = getWebElement(locator);
        actions.contextClick(elementLocator).perform();
    }

    protected void typeTextToWebElement(By locator, String text) {
        getWebElement(locator).sendKeys(text);
    }

    protected void clearAndTypeTextToWebElement(By locator, String text) {
        getWebElement(locator).clear();
        getWebElement(locator).sendKeys(text);
    }

    protected boolean waitUrlChange(String url, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.urlToBe(url));
    }

    protected int numberOfElementSelected(By locator) {
        List<WebElement> elements = driver.findElements(locator);
        return elements.size();
    }

    protected void moveToElement(By locator) {
        WebElement hoverElement = getWebElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverElement)
                .perform();
    }

    protected void scrollToElement(By locator) {
        WebElement element = getWebElement(locator);
        Actions actions = new Actions(driver);
        actions.scrollToElement(element);
    }

    protected void sendKeysAction(String text) {
        Actions action = new Actions(driver);
        action.sendKeys(text).build().perform();
    }
    protected void doubleClickOnWebElement(By locator, int timeout) {
        Actions act = new Actions(driver);
        WebElement element = getWebElement(locator);
        waitForElementToBeClickable(locator, timeout);
        act.doubleClick(element).perform();
    }

    protected void moveCursorToElement(By locator) {
        Actions action = new Actions(driver);
        WebElement element = getWebElement(locator);
        action.moveToElement(element).perform();
    }

    protected void moveCursorAndClickOnElement(By locator) {
        moveCursorToElement(locator);
        clickWebElement(locator);
    }
    protected String getWindowHandle() {
        String windowHandle = null;
        if (null != driver) {
            windowHandle = driver.getWindowHandle();
        }
        return windowHandle;
    }

    protected void switchToMainPage() {
        driver.switchTo().window(getWindowHandle());
    }

    public void switchToNextPage() {
        Set<String> allWinHandles = driver.getWindowHandles();
        String firstTab = allWinHandles.iterator().next();
        driver.switchTo().window(firstTab);
    }

    public void closeWindow() {
        driver.close();
    }

    public void inputTextJS(By locator, String text) {
        WebElement element = driver.findElement(locator);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].value='" + text + "'" + element);
    }
    public void scrollToElementJS(By locator){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();",getWebElement(locator));
    }
    protected Point getElementLocation(By locator){
        return getWebElement(locator).getLocation();
    }

    public void dragAndDropToLocation(By locator, By targetLocator) {
        WebElement fromElement = driver.findElement(locator);
        WebElement toElement = driver.findElement(targetLocator);
        Actions action = new Actions(driver);
        action.dragAndDrop(fromElement, toElement).build().perform();
    }
    public int getXLocationFromWebElement(By locator) {
        WebElement element = getWebElement(locator);
        return element.getLocation().getX();
    }

    public int getYLocationFromWebElement(By locator) {
        WebElement element = getWebElement(locator);
        return element.getLocation().getY();
    }

    protected void dragAndDrop(By sourceLocator, int x, int y) {
        WebElement pointA = getWebElement(sourceLocator);
        Actions action = new Actions(driver);
        action.dragAndDropBy(pointA, x, y).build().perform();
    }

    public void dragAndDropWithRealAxis(By locator, int x, int y) {
        int xOffset1 = getXLocationFromWebElement(locator);
        int yOffset1 = getYLocationFromWebElement(locator);
        int xOffset = x - xOffset1;
        int yOffset = y - yOffset1;
        dragAndDrop(locator, xOffset, yOffset);
    }




}
