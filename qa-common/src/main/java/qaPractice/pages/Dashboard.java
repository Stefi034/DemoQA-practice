package qaPractice.pages;

import org.openqa.selenium.WebDriver;

import static data.PageUrls.DASHBOARD;
import static data.constants.ButtonNames.*;
import static data.constants.Locators.DASHBOARD_BANNER_LOCATOR;
import static data.constants.Locators.categoryCards;

public class Dashboard extends Main {

    public Dashboard(WebDriver driver) {
        super(driver);
    }

    public Dashboard open(){
        openPage(DASHBOARD);
        return this;
    }
    public Dashboard verifyDashboardPage(){
        verifyClass(DASHBOARD_BANNER_LOCATOR,3,DASHBOARD);
        return this;
    }

    public Widgets openWidgetsPage(){
        clickWebElement(categoryCards(WIDGETS));
        Widgets widgets = new Widgets(driver);
        return widgets.verifyWidgetsClass();
    }
    public Interactions openInteractionsPage(){
        clickWebElement(categoryCards(INTERACTIONS));
        Interactions interactions = new Interactions(driver);
        return interactions.verifyInteractionsClass();
    }


}
