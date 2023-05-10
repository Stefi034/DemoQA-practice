package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public abstract class BasePageClass {

    protected WebDriver driver;
    protected BasePageClass(WebDriver driver){
        this.driver=driver;
    }
    protected void openPage(String pageUrl){
        driver.get(pageUrl);
    }
    protected String getPageUrl(){
        return driver.getCurrentUrl();
    }
    protected WebElement getWebElement(By locator){
        return driver.findElement(locator);
    }
    protected WebElement getWebElement(By locator, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    protected WebElement waitForElementToBeClickable(By locator, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    protected WebElement waitForElementToBeVisible(By locator, int timeout){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    protected WebElement waitElementToBePresent(By locator, int timeout){
        WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    protected boolean isElementDisplayed(By locator){
        try {
            WebElement element = getWebElement(locator);
            return element.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }
    protected String getAttributeFromWebElement(By locator, String attribute){
        return getWebElement(locator).getAttribute(attribute);
    }
    protected String getValueFromWebElement(By locator){
        return getAttributeFromWebElement(locator,"value");
    }
    protected String getTextFromWebElement(By locator) {
        WebElement element = getWebElement(locator);
        return element.getText();
    }
    protected void clickWebElement(By locator){
        getWebElement(locator).click();
    }

    protected void waitAndClickWebElement(By locator, int timeout){
        getWebElement(locator,timeout);
    }
    protected void typeTextToWebElement(By locator, String text){
        getWebElement(locator).sendKeys(text);
    }

    protected void clearAndTypeTextToWebElement(By locator, String text){
        getWebElement(locator).clear();
        getWebElement(locator).sendKeys(text);
    }

    protected boolean waitUrlChange(String url, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.urlToBe(url));
    }
    protected int numberOfElementSelected(By locator){
        List<WebElement> elements = driver.findElements(locator);
        return elements.size();
    }
    protected List<WebElement> listOfWebElements(By locator){
        List<WebElement> elements = driver.findElements(locator);
        return elements;
    }
    protected void moveToElement(By locator){
        WebElement hoverElement = getWebElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverElement)
                .perform();
    }
    protected void scrollToElement(By locator){
        WebElement element = getWebElement(locator);
        Actions actions = new Actions(driver);
        actions.scrollToElement(element);
    }
//    public void switchToNewWindow(){
//        String currentWin = driver.getWindowHandle();
//        for (String handle: driver.getWindowHandles()){
//            if (!handle.equals(currentWin) && !windowHandles.contains)
//        }
//    }
    protected String getWindowHandle(){
        String windowHandle=null;
        if (null !=driver){
            windowHandle=driver.getWindowHandle();
        }
        return windowHandle;
    }
    protected void switchToMainPage(){
        driver.switchTo().window(getWindowHandle());
    }
    public void switchToNextPage(){
        Set<String> allWinHandles = driver.getWindowHandles();
        String firstTab = allWinHandles.iterator().next();
        driver.switchTo().window(firstTab);
    }
    public void closeWindow(){
        driver.close();
    }
    public void inputTextJS(By locator, String text){
        WebElement element = driver.findElement(locator);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].value='"+text+"'" +element);
    }
    public void dragAndDropToLocation(By locator, By targetLocator){
        WebElement fromElement = driver.findElement(locator);
        WebElement toElement = driver.findElement(targetLocator);
        Actions action = new Actions(driver);
        action.dragAndDrop(fromElement, toElement).build().perform();
    }

//    public void dragAndDropByOffset


//    protected void switchWindow(int noWindows){
//        WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.numberOfWindowsToBe(noWindows));
//        Set<String> handles = driver.getWindowHandles();
//        String childTab = handles.iterator().next();
//        driver.switchTo().window(childTab);
//    }

//    protected static WebDriver windowByWinHandle(WebDriver driver, String windowHandle) {
//        Set<String> windowHandles = driver.getWindowHandles();
//        for (String newTab : windowHandles) {
//            driver.switchTo().window(newTab);
//            if (windowHandle.equals(driver.getTitle())) {
//                return driver;
//            }
//        }
//        throw new NoSuchWindowException("Window with title not found: " + windowHandle);
//    }



}
