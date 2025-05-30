package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utilities.DriverManager;

public class LoginSteps {

   private final WebDriver driver= DriverManager.getDriver();
    private final LoginPage loginPage=new LoginPage(driver);

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        driver.get("https://www.saucedemo.com/");
    }
    @When("user enters username {string} and password {string}")
    public void user_enters_username_and_password(String userName, String password) {
        loginPage.enterUsername(userName);
          loginPage.enterPassword(password);
    }
    @When("clicks on the login button")
    public void clicks_on_the_login_button() {
        loginPage.clickLoginButton();
    }
    @Then("user should be redirected to the home page")
    public void user_should_be_redirected_to_the_home_page() {
        // Verify that the user is redirected to the inventory page
        String currentUrl = driver.getCurrentUrl();
        if(currentUrl != null) {
            Assert.assertNotNull("Current URL should not be null", currentUrl);
            Assert.assertTrue("User is on the inventory page",
                    currentUrl.contains("inventory.html"));
        }
        else
        {
            System.out.println("Current URL is null, user is not redirected to the inventory page");
        }

    }
}
