package qaPractice.utils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverUtils {
    public static WebDriver setUpDriver() {

//        System.setProperty("webdriver.chrome.driver", "C:/Selenium/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver","/home/stefi034/Documents/webdriver/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        return driver;

    }

    public static void quitDriver(WebDriver driver){

        driver.quit();

    }
}
