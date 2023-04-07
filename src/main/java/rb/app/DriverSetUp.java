package rb.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverSetUp {
	private static WebDriver driver;

    private DriverSetUp() {
        // Private constructor to prevent instantiation from outside
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            // Create a new instance of WebDriver
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
