package hooks;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import utilities.DriverManager;

public class Hooks {
    WebDriver driver;
    @Before
    public void setUp() {
    // Initialize the WebDriver before each test
        driver = DriverManager.getDriver();

    }
    @After
    public void tearDown() {
    // Quit the WebDriver after each test
        DriverManager.quitDriver();
    }
}
