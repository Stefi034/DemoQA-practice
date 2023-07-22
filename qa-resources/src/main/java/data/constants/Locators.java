package data.constants;

import org.openqa.selenium.By;

public class Locators {
    public static final By PAGE_HEADER = By.xpath("//div[@class='body-height']//div[@class='main-header']");
    public static final By TOOLS_QA_HEADER_LOCATOR = By.xpath("//a[@href='https://demoqa.com']");
    public static final By DASHBOARD_BANNER_LOCATOR = By.xpath("//a[@href='https://www.toolsqa.com/selenium-training/']");

    public static By categoryCards(String name) {
        return By.xpath(String.format("//div[@class='body-height']//div[@class='category-cards']//h5[text()='%s']", name));
    }

    public static final By EMAIL_ERROR_LOCATOR = By.xpath("//label[text()='Email']/parent::div/following-sibling::div//input[contains(@class,'field-error')]");
    public static final By OUTPUT_LOCATOR = By.xpath("//div[@id='output']");

    //Elements
    public static By inputField(String label, String placeholderText) {
        return By.xpath(String.format("//label[text()='%s']/parent::div/following-sibling::div//input[@placeholder='%s']", label, placeholderText));
    }

    public static By textAreaInputField(String label) {
        return By.xpath(String.format("//label[text()='%s']/parent::div/following-sibling::div/textarea", label));
    }

    public static By buttonLocator(String buttonLabel) {
        return By.xpath(String.format("//button[text()='%s']", buttonLabel));
    }

    public static By submissionOutput(String label) {
        return By.xpath(String.format("//div[@id='output']//p[@id='%s']", label));
    }
    public static By tableSortingLocator(String columnLabel, String order){
        return By.xpath(String.format("//div[text()='%s']/parent::div[contains(@class,'%s')]",columnLabel, order));
    }
    public static By columnHeaderLocator(String columnLabel){
        return By.xpath(String.format("//div[text()='%s']/parent::div",columnLabel));
    }

    //    public static By radioButton(String label){
//        return By.xpath(String.format("//label[text()='%s']/preceding-sibling::input[not(contains(@class,'disabled'))]",label));
//    }
    public static By radioButton(String label) {
        return By.xpath(String.format("//input[not(contains(@class,'disabled'))]/following-sibling::label[text()='%s']", label));
    }

    public static By radioButtonSuccess(String radioButton) {
        return By.xpath(String.format("//span[@class='text-success'][text()='%s']", radioButton));
    }
    public static By webTableRow(String row){
        return By.xpath(String.format("//div[@class='rt-tr-group']//div[@class='rt-td'][%s]",row));
    }

    //Interactions
    public static By elementFromGroup(String groupElement) {
        return By.xpath(String.format("//div[@class='body-height']//div[text()='%s']/following-sibling::div", groupElement));
    }

    public static By elementFromList(String listElement) {
        return By.xpath(String.format("//div[@class='body-height']//span[text()='%s']/parent::li", listElement));

    }

    public static By draggableNav(String item) {
        return By.xpath(String.format("//div[contains(@class,'col-md-6')]//nav[@class='nav nav-tabs']/a[text()='%s']", item));
    }

    public static By draggableNavIsSelected(String item) {
        return By.xpath(String.format("//div[contains(@class,'col-md-6')]//nav[@class='nav nav-tabs']/a[text()='%s'][@aria-selected='true']", item));
    }

    public static By dragBoxLocator(String boxName) {
        return By.xpath(String.format("//div[text()='%s']", boxName));
    }


}
