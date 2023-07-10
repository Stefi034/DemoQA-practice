package qaPractice.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

import static data.constants.ButtonNames.*;
import static data.constants.Locators.*;

public class Interactions extends Main {
    private Point before;
    private Point after;

    public Interactions(WebDriver driver) {
        super(driver);
    }

    public Interactions verifyInteractionsClass() {
        verifyClass(PAGE_HEADER,3,INTERACTIONS);
        return this;
    }
    public Interactions openDraggable (){
        openElementFromList(elementFromList(DRAGABBLE));
        return this;
    }
    public Interactions openDraggableSimple(){
        clickWebElement(draggableNav(SIMPLE));
        return this;
    }
    public Interactions boxLocationBeforeMove(){
        before = elementLocationBefore("Drag me");
        return this;
    }
    public Interactions boxLocationAfterMove(){
        after = elementLocationBefore("Drag me");
        return this;
    }



    public Interactions dragAndDropInSimple(){
//        before = elementLocationBefore("Drag me");
        dragAndDrop(dragBoxLocator("Drag me"),70,70);
//        after = elementLocationAfter("Drag me");
        return this;
    }
    public Interactions verifyDragMeMoved(){
        verifyObjectMoved(before,after);
        return this;
    }







}