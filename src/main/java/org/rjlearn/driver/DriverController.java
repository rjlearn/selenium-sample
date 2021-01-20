package org.rjlearn.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class DriverController {
    private static WebDriver driver;
    private static WebDriverWait driverWait;

    public static void initialize() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driverWait = new WebDriverWait(driver, 20);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static WebDriverWait getDriverWait() {
        return driverWait;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }


}
