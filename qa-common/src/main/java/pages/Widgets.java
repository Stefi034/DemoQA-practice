package pages;

import data.Time;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Widgets extends BasePageClass{

    protected Widgets(WebDriver driver) {
        super(driver);
    }
    private final By WIDGETS_PAGE = By.xpath("//div[@class='body-height']//div[@class='main-header']");

    public Widgets verifyWidgetsClass(){
        waitForElementToBeVisible(WIDGETS_PAGE, Time.TIME_SHORT);
        String widgetPage= getValueFromWebElement(WIDGETS_PAGE);
        Assertions.assertEquals("Widgets",widgetPage);
        return this;
    }


}
