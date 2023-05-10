package tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.Interactions;
import pages.MainPage;

public class OpenInteractionPageAndPerformDragAndDropTest extends BaseTestClass{

    private static WebDriver driver;

    @BeforeAll
    public static void setUpTest(){
        driver = setUpDriver();
    }
    @Test

    public void test(){
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.openInteractionsPage();
        Interactions interactions = new Interactions(driver);
        interactions.verifyInteractionsClass()
                .openDraggable()
                .openDraggableElement();


    }



}
