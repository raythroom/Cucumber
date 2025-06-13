package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.DriverManager;
import io.cucumber.java.Scenario;

public class Hooks {

    @Before
    public void setUp() {
        // Initialize the WebDriver before each test
        DriverManager.getDriver();

    }

    @After
    public void tearDown(Scenario scenario) {
        // Log scenario details and quit WebDriver
        if (scenario.isFailed()) {
            System.out.println("Scenario failed: " + scenario.getName());
            // Optionally, take a screenshot here
        }
        DriverManager.quitDriver();
    }
}
