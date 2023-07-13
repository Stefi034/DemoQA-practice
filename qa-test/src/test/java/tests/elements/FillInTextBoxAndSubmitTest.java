package tests.elements;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import qaPractice.pages.Dashboard;
import tests.BaseTestClass;

public class FillInTextBoxAndSubmitTest extends BaseTestClass {
    private static WebDriver driver;
    private static final String FULL_NAME = "Radmilo Elemanovic";
    private static final String EMAIL = "radmiloE@fake.com";
    private static final String CURRENT_ADDRESS = "Juznomoravskih brigada 25";
    private static final String PERMANENT_ADDRESS = "29. Novembra 46";

    @BeforeAll
    public static void setUpTest(){
        driver = setUpDriver();
    }
    @Test

    public void test(){
        Dashboard dashboard = new Dashboard(driver);
        dashboard.open();
        dashboard.openElementsPage()
                .openTextBox()
                .insertFullName(FULL_NAME)
                .insertEmail(EMAIL)
                .insertCurrentAddress(CURRENT_ADDRESS)
                .insertPermanentAddress(PERMANENT_ADDRESS)
                .submitSubmitButton()
                .valueProvera();

    }
//    @AfterAll
//    public static void tearDownTest() {
//        tearDown(driver);
//    }

}
