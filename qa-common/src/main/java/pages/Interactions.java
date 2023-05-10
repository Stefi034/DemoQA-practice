package pages;

import data.Time;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Interactions extends BasePageClass {

    public Interactions(WebDriver driver) {
        super(driver);
    }

    private final By INTERACTIONS_PAGE_HEADER = By.xpath("//div[@class='body-height']//div[@class='main-header']");

    private By elementFromList(String listElement){
        return By.xpath("//div[@class='body-height']//span[text()='"+listElement+"']/parent::li");
    }
    private By elementFromGroup(String groupElement){
        return By.xpath("//div[@class='body-height']//div[text()='"+groupElement+"']/following-sibling::div");
    }
    private By draggableNav(String item){
        return By.xpath("//div[contains(@class,'col-md-6')]//nav[@class='nav nav-tabs']/a[text()='"+item+"']");
    }
    private By draggableNavIsSelected(String item){
        return By.xpath("//div[contains(@class,'col-md-6')]//nav[@class='nav nav-tabs']/a[text()='"+item+"'][@aria-selected='true']");
    }

    public Interactions verifyInteractionsClass() {
        waitForElementToBeVisible(INTERACTIONS_PAGE_HEADER, Time.TIME_SHORT);
        String interactionsPage = getTextFromWebElement(INTERACTIONS_PAGE_HEADER);
        Assertions.assertEquals("Interactions", interactionsPage);
        return this;
    }
    public Interactions openDraggable (){
        moveToElement(elementFromList("Dragabble"));
        waitForElementToBeClickable(elementFromList("Dragabble"),Time.TIME_MEDIUM);

//        scrollToElement(elementFromList("Dragabble"));
        Assertions.assertTrue(isElementDisplayed(elementFromList("Dragabble")));
        waitAndClickWebElement(elementFromList("Dragabble"),Time.TIME_MEDIUM);
        return this;
    }
    public Interactions openDraggableElement(){
        waitForElementToBeVisible(draggableNav("Simple"),Time.TIME_MEDIUM);
        Assertions.assertTrue(isElementDisplayed(draggableNav("Simple")));
        clickWebElement(draggableNav("Simple"));
        Assertions.assertTrue(isElementDisplayed(draggableNavIsSelected("Simple")));
        return this;
    }





}