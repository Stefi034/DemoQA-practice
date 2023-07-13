package data.constants;

import org.openqa.selenium.By;

public class Locators {
    public static final By PAGE_HEADER = By.xpath("//div[@class='body-height']//div[@class='main-header']");
    public static final By TOOLS_QA_HEADER_LOCATOR = By.xpath("//a[@href='https://demoqa.com']");
    public static final By DASHBOARD_BANNER_LOCATOR = By.xpath("//a[@href='https://www.toolsqa.com/selenium-training/']");
    public static By categoryCards(String name){
        return By.xpath(String.format("//div[@class='body-height']//div[@class='category-cards']//h5[text()='%s']",name));
    }
    //Elements
    public static By inputField(String label, String placeholderText){
        return By.xpath(String.format("//label[text()='%s']/parent::div/following-sibling::div//input[@placeholder='%s']",label,placeholderText));
    }
    public static By textAreaInputField(String label){
        return By.xpath(String.format("//label[text()='%s']/parent::div/following-sibling::div/textarea",label));
    }
    public static By buttonLocator(String buttonLabel){
        return By.xpath(String.format("//button[text()='%s']",buttonLabel));
    }
    public static By submissionOutput(String label){
        return By.xpath(String.format("//div[@id='output']//p[@id='%s']",label));
    }
    //Interactions
    public static By elementFromGroup(String groupElement){
        return By.xpath(String.format("//div[@class='body-height']//div[text()='%s']/following-sibling::div",groupElement));
    }
    public static By elementFromList(String listElement){
        return By.xpath(String.format("//div[@class='body-height']//span[text()='%s']/parent::li",listElement));

    }
    public static By draggableNav(String item){
        return By.xpath(String.format("//div[contains(@class,'col-md-6')]//nav[@class='nav nav-tabs']/a[text()='%s']",item));
    }
    public static By draggableNavIsSelected(String item){
        return By.xpath(String.format("//div[contains(@class,'col-md-6')]//nav[@class='nav nav-tabs']/a[text()='%s'][@aria-selected='true']",item));
    }
    public static By dragBoxLocator(String boxName){
        return By.xpath(String.format("//div[text()='%s']",boxName));
    }


}
