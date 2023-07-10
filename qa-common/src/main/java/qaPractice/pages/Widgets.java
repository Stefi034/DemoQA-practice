package qaPractice.pages;

import data.Time;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import qaPractice.BasePageClass;

import static data.constants.ButtonNames.WIDGETS;
import static data.constants.Locators.PAGE_HEADER;

public class Widgets extends BasePageClass {

    protected Widgets(WebDriver driver) {
        super(driver);
    }

    public Widgets verifyWidgetsClass(){
        waitForElementToBeVisible(PAGE_HEADER, Time.TIME_SHORT);
        String widgetPage= getValueFromWebElement(PAGE_HEADER);
        Assertions.assertEquals(WIDGETS,widgetPage);
        return this;
    }


}
