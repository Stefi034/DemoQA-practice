package pages;
import data.PageUrls;

import data.Time;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePageClass{

    public MainPage(WebDriver driver) {
        super(driver);
    }
    public final String MAIN_PAGE_URL = PageUrls.MAIN_PAGE;
    private By CATEGORY_CARDS(String name){
        return By.xpath("//div[@class='body-height']//div[@class='category-cards']//h5[text()='"+name+"']");
    }

    public MainPage open(){
        openPage(MAIN_PAGE_URL);
        return this;
    }
    public Widgets openWidgetsPage(By locator){
        waitForElementToBeVisible(CATEGORY_CARDS("Widgets"), Time.TIME_SHORT);
        clickWebElement(locator);
        Widgets widgets = new Widgets(driver);
        return widgets.verifyWidgetsClass();
    }
    public Interactions openInteractionsPage(){
        waitForElementToBeVisible(CATEGORY_CARDS("Interactions"),Time.TIME_SHORT);
        clickWebElement(CATEGORY_CARDS("Interactions"));
        Interactions interactions = new Interactions(driver);
        return interactions.verifyInteractionsClass();

    }


}
