package qaPractice.pages;

import org.openqa.selenium.WebDriver;
import qaPractice.BasePageClass;
import qaPractice.Page;
import qaPractice.pages.Dashboard;

import static data.constants.Locators.TOOLS_QA_HEADER_LOCATOR;

public class Main extends Page {
    protected Main(WebDriver driver) {
        super(driver);
    }

    public Dashboard clickHeaderToolsQA (){
        clickWebElement(TOOLS_QA_HEADER_LOCATOR);
        return new Dashboard(driver).verifyDashboardPage();
    }



}
