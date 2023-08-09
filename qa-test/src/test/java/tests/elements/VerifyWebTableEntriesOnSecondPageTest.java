package tests.elements;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import qaPractice.pages.Dashboard;
import tests.BaseTestClass;

import java.util.stream.Stream;

public class VerifyWebTableEntriesOnSecondPageTest extends BaseTestClass {
    private static WebDriver driver;


    @BeforeAll
    public static void setUpTest() {
        driver = setUpDriver();
    }

    @ParameterizedTest
    @MethodSource("data.TestDataGenerator#provideTestData")


    public void test(String firstName, String lastName, String email, String age, String salary, String department) {
        Dashboard dashboard = new Dashboard(driver);
        dashboard.open();
        dashboard.openElementsPage()
                .openWebTables()
                .clickAddButton()
                .insertFirstName(firstName)
                .insertLastName(lastName)
                .insertEmail(email)
                .insertAge(age)
                .insertSalary(salary)
                .insertDepartment(department)
                .submitSubmitButton();
}}
