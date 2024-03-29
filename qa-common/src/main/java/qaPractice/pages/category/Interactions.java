package qaPractice.pages.category;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import qaPractice.pages.Main;

import static data.constants.ButtonNames.*;
import static data.constants.Locators.*;

public class Interactions extends Main {
    private Point before;
    private Point after;

    public Interactions(WebDriver driver) {
        super(driver);
    }

    public Interactions verifyInteractionsClass() {
        verifyClass(PAGE_HEADER, 3, INTERACTIONS);
        return this;
    }

    public Interactions openDraggable() {
        openElementFromList(elementFromList(DRAGABBLE));
        return this;
    }

    public Interactions openDraggableSimple() {
        clickWebElement(draggableNav(SIMPLE));
        return this;
    }

    public Interactions boxLocationBeforeMove() {
        before = elementLocationBefore("Drag me");
        return this;
    }

    public Interactions boxLocationAfterMove() {
        after = elementLocationBefore("Drag me");
        return this;
    }


    public Interactions dragAndDropInSimple() {
        dragAndDrop(dragBoxLocator("Drag me"), 70, 70);
        return this;
    }

    public Interactions verifyDragMeMoved() {
        verifyObjectMoved(before, after);
        return this;
    }


}