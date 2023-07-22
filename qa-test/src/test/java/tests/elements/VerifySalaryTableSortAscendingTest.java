package tests.elements;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import qaPractice.pages.Dashboard;
import tests.BaseTestClass;

public class VerifySalaryTableSortAscendingTest extends BaseTestClass {
    private static WebDriver driver;

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
                .salaryAscendingSort()
                .isSalaryAscending();



    }
//    @AfterAll
//    public static void tearDownTest() {
//        tearDown(driver);
//    }
}
