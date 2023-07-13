package qaPractice.pages.category;

import org.openqa.selenium.WebDriver;
import qaPractice.Page;

import static data.constants.ButtonNames.*;
import static data.constants.Labels.*;
import static data.constants.Locators.*;

public class Elements extends Page {
    public Elements(WebDriver driver) {
        super(driver);
    }
    public Elements verifyElementsClass(){
        verifyClass(PAGE_HEADER,3,ELEMENTS);
        return this;
    }
    public Elements openWebTable(){
        openElementFromList(elementFromList(WEB_TABLES));
        return this;
    }
    public Elements openTextBox(){
        openElementFromList(elementFromList(TEXT_BOX));
        return this;
    }
    public Elements insertFullName(String fullName){
        inputTextInputField(FULL_NAME,FULL_NAME,fullName);
        return this;
    }
    public Elements insertEmail(String email){
        inputTextInputField(EMAIL,EMAIL_EXAMPLE,email);
        return this;
    }
    public Elements insertCurrentAddress(String currentAddress){
        inputTextTextArea(CURRENT_ADDRESS,currentAddress);
        return this;
    }
    public Elements insertPermanentAddress(String permanentAddress){
        inputTextTextArea(PERMANENT_ADDRESS,permanentAddress);
        return this;
    }
    public Elements submitSubmitButton(){
        clickOnButton(SUBMIT);
        return this;
    }
    public Elements valueProvera(){

        System.out.println(getTextFromWebElement(submissionOutput(NAME_LOW_CASE)));
        return this;
    }



}
