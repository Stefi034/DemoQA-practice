package tests.elements;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import qaPractice.pages.Dashboard;
import tests.BaseTestClass;

public class VerifyAddNewEntryInWebTableTest extends BaseTestClass {
    private static WebDriver driver;
    private static final String FIRST_NAME = "Miodrag";
    private static final String LAST_NAME = "Rodic";
    private static final String EMAIL = "rodic@fake.fake";
    private static final String AGE = "31";
    private static final String SALARY = "15600";
    private static final String DEPARTMENT = "IT";

    @BeforeAll
    public static void setUpTest() {
        driver = setUpDriver();
    }

    @Test

    public void test() {
        Dashboard dashboard = new Dashboard(driver);
        dashboard.open();
        dashboard.openElementsPage()
                .openWebTables()
                .clickAddButton()
                .insertFirstName(FIRST_NAME)
                .insertLastName(LAST_NAME)
                .insertEmail(EMAIL)
                .insertAge(AGE)
                .insertSalary(SALARY)
                .insertDepartment(DEPARTMENT)
                .submitSubmitButton()
                .searchWebTableByEmail(EMAIL)
                .verifyWebTableFirstName(FIRST_NAME)
                .verifyWebTableLastName(LAST_NAME)
                .verifyWebTableAge(AGE)
                .verifyWebTableEmail(EMAIL)
                .verifyWebTableSalary(SALARY)
                .verifyWebTableDepartment(DEPARTMENT);
    }
    @AfterAll
    public static void tearDownTest() {
        tearDown(driver);
    }
}
