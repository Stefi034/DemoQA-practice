package qaPractice.pages;
import data.PageUrls;

import data.Time;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import qaPractice.Main;

public class Dashboard extends Main {

    public Dashboard(WebDriver driver) {
        super(driver);
    }
    public final String DASHBOARD_URL = PageUrls.DASHBOARD;
    private By CATEGORY_CARDS(String name){
        return By.xpath("//div[@class='body-height']//div[@class='category-cards']//h5[text()='"+name+"']");
    }

    public Dashboard open(){
        openPage(DASHBOARD_URL);
        return this;
    }
    public Widgets openWidgetsPage(By locator){
        waitForElementToBeVisible(CATEGORY_CARDS("Widgets"), 3);
        clickWebElement(locator);
        Widgets widgets = new Widgets(driver);
        return widgets.verifyWidgetsClass();
    }
    public Interactions openInteractionsPage(){
        waitForElementToBeVisible(CATEGORY_CARDS("Interactions"),3);
        clickWebElement(CATEGORY_CARDS("Interactions"));
        Interactions interactions = new Interactions(driver);
        return interactions.verifyInteractionsClass();

    }


}
