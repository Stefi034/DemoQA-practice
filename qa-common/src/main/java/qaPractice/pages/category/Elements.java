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

    public Elements verifyElementsClass() {
        verifyClass(PAGE_HEADER, 3, ELEMENTS);
        return this;
    }

    public Elements openTextBox() {
        openElementFromList(elementFromList(TEXT_BOX));
        return this;
    }

    public Elements openRadioButton() {
        openElementFromList(elementFromList(RADIO_BUTTON));
        return this;
    }

    public Elements openWebTables() {
        openElementFromList(elementFromList(WEB_TABLES));
        return this;
    }


    public Elements insertFullName(String fullName) {
        inputTextInputField(FULL_NAME, FULL_NAME, fullName);
        return this;
    }

    public Elements insertEmail(String email) {
        inputTextInputField(EMAIL, EMAIL_EXAMPLE, email);
        return this;
    }

    public Elements insertCurrentAddress(String currentAddress) {
        inputTextTextArea(CURRENT_ADDRESS, currentAddress);
        return this;
    }

    public Elements insertPermanentAddress(String permanentAddress) {
        inputTextTextArea(PERMANENT_ADDRESS, permanentAddress);
        return this;
    }

    public Elements submitSubmitButton() {
        clickOnButton(SUBMIT);
        return this;
    }

    public Elements verifyFullName(String fullName) {
        verifySubmissionOutput(NAME_LOW_CASE, fullName);
        return this;
    }

    public Elements verifyEmail(String email) {
        verifySubmissionOutput(EMAIL_LOW_C, email);
        return this;
    }

    public Elements verifyCurrentAddress(String currentAddress) {
        verifySubmissionOutput(CURRENT_ADDRESS_LOW_C, currentAddress);
        return this;
    }

    public Elements verifyPermanentAddress(String permanentAddress) {
        verifySubmissionOutput(PERMANENT_ADDRESS_LOW_C, permanentAddress);
        return this;
    }

    public Elements verifyEmailError() {
        verifyWebElementIsDisplayed(EMAIL_ERROR_LOCATOR);
        return this;
    }

    public Elements verifyOutputNotVisible() {
        verifyWebElementNotDisplayed(OUTPUT_LOCATOR);
        return this;
    }
    public Elements selectYesRadioButton(){
        clickOnRadioButton(YES);
        return this;
    }
    public Elements verifyRadioButtonPressed(String radioButton){
        verifyWebElementIsDisplayed(radioButtonSuccess(radioButton));
        return this;
    }
    public Elements isSalaryAscending(){
        isIntListSortedAscending(webTableRow(SALARY_INT_ROW));
        return this;
    }
    public Elements salaryAscendingSort(){
        tableSorting(SALARY, ASCENDING_SORT);
        return this;
    }




}
