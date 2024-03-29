package tests;
import qaPractice.utils.DriverUtils;
import org.openqa.selenium.WebDriver;
import static qaPractice.utils.DriverUtils.quitDriver;

public abstract class BaseTestClass {
    protected static WebDriver setUpDriver(){
        return DriverUtils.setUpDriver();
    }
    protected static void tearDown(WebDriver driver){
        quitDriver(driver);
    }
}
