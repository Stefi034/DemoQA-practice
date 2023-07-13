package tests.interactions;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import qaPractice.pages.category.Interactions;
import qaPractice.pages.Dashboard;
import tests.BaseTestClass;

public class OpenInteractionPageAndPerformDragAndDropTest extends BaseTestClass {

    private static WebDriver driver;

    @BeforeAll
    public static void setUpTest(){
        driver = setUpDriver();
    }
    @Test

    public void test(){
        Dashboard dashboard = new Dashboard(driver);
        dashboard.open();
        dashboard.openInteractionsPage();
        Interactions interactions = new Interactions(driver);
        interactions.verifyInteractionsClass()
                .openDraggable()
                .openDraggableSimple()
                .boxLocationBeforeMove()
                .dragAndDropInSimple()
                .boxLocationAfterMove()
                .verifyDragMeMoved();
    }
//    @AfterAll
//    public static void tearDownTest() {
//        tearDown(driver);
//    }



}
