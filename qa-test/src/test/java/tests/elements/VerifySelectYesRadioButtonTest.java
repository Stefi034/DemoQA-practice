package tests.elements;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import qaPractice.pages.Dashboard;
import tests.BaseTestClass;

import static data.constants.ButtonNames.YES;

public class VerifySelectYesRadioButtonTest extends BaseTestClass {
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
                .openRadioButton()
                .selectYesRadioButton()
                .verifyRadioButtonPressed(YES);
    }
//    @AfterAll
//    public static void tearDownTest() {
//        tearDown(driver);
//    }
}
