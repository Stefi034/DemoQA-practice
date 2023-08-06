package qaPractice.pages.category;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import qaPractice.Page;

import static data.constants.ButtonNames.*;
import static data.constants.Labels.*;
import static data.constants.Locators.*;
import static data.constants.PageHeaders.REGISTRATION_FORM;

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
    public Elements insertFirstName(String firstName) {
        inputTextInputField(FIRST_NAME, FIRST_NAME, firstName);
        return this;
    }
    public Elements insertLastName(String lastName) {
        inputTextInputField(LAST_NAME, LAST_NAME, lastName);
        return this;
    }
    public Elements insertAge(String age) {
        inputTextInputField(AGE, AGE, age);
        return this;
    }
    public Elements insertSalary(String salary) {
        inputTextInputField(SALARY, SALARY, salary);
        return this;
    }
    public Elements insertDepartment(String department) {
        inputTextInputField(DEPARTMENT, DEPARTMENT, department);
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
        isIntListSortedAscending(webTableInputByRow(SALARY_INT_ROW));
        return this;
    }
    public Elements salaryAscendingSort(){
        tableSorting(SALARY, ASCENDING_SORT);
        return this;
    }
    public Elements clickAddButton(){
        clickOnButton(ADD);
        waitForElementToBeVisible(dialogTitleLocator(REGISTRATION_FORM),3);
        return this;
    }
    public Elements verifyWebTableFirstName(String firstName){
        String firstNameInserted = getTableContent(webTableRowInputs(FIRST_ROW)).get(NAME_COLUMN);
        Assertions.assertEquals(firstName, firstNameInserted,"Names not equal" );
        return this;
    }
    public Elements verifyWebTableLastName(String lastName){
        String lastNameInserted = getTableContent(webTableRowInputs(FIRST_ROW)).get(LAST_NAME_COLUMN);
        Assertions.assertEquals(lastName, lastNameInserted,"Surnames not equal" );
        return this;
    }
    public Elements verifyWebTableAge(String age){
        String ageInserted = getTableContent(webTableRowInputs(FIRST_ROW)).get(AGE_COLUMN);
        Assertions.assertEquals(age, ageInserted,"Ages not equal" );
        return this;
    }
    public Elements verifyWebTableEmail(String email){
        String emailInserted = getTableContent(webTableRowInputs(FIRST_ROW)).get(EMAIL_COLUMN);
        Assertions.assertEquals(email, emailInserted,"Emails not equal" );
        return this;
    }
    public Elements verifyWebTableSalary(String salary){
        String salaryInserted = getTableContent(webTableRowInputs(FIRST_ROW)).get(SALARY_COLUMN);
        Assertions.assertEquals(salary, salaryInserted,"Salary not equal" );
        return this;
    }
    public Elements verifyWebTableDepartment(String department){
        String departmentInserted = getTableContent(webTableRowInputs(FIRST_ROW)).get(DEPARTMENT_COLUMN);
        Assertions.assertEquals(department, departmentInserted,"Departments not equal" );
        return this;
    }
    public Elements searchWebTableByEmail(String email){
        inputSearchBox(email);
        clickWebElement(SEARCH_BOX_SEARCH_LOCATOR);
        return this;
    }







}
