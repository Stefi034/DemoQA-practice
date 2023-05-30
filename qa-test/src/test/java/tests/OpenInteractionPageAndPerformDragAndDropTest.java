package tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import qaPractice.pages.Interactions;
import qaPractice.pages.Dashboard;

public class OpenInteractionPageAndPerformDragAndDropTest extends BaseTestClass{

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
                .openDraggableElement();


    }



}
