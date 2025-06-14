package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utilities.ConfigReader;


import static utilities.DriverManager.getDriver;

public class LoginSteps {

    private final WebDriver driver = getDriver();
    private final LoginPage loginPage = new LoginPage(driver);

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        driver.get(ConfigReader.get("base.url"));
    }


    @When("^user enters (\\w+) and (\\w+)$")
    public void user_enters_username_and_password(String username, String password) {
        loginPage.enterUsername(username);
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
        if (currentUrl != null) {
            Assert.assertNotNull("Current URL should not be null", currentUrl);
            Assert.assertTrue("User is on the inventory page",
                    currentUrl.contains(ConfigReader.get("inventory.page")));
        } else {
            System.out.println("Current URL is null, user is not redirected to the inventory page");
        }

    }

    @Then("user should see an error message")
    public void user_should_see_an_error_message() {
        if(loginPage.getErrorMessage().equals("Epic sadface: Password is required"))
        {
            Assert.assertEquals("Epic sadface: Password is required", loginPage.getErrorMessage());
        }
        else if(loginPage.getErrorMessage().equals("Epic sadface: Username is required"))
        {
            Assert.assertEquals("Epic sadface: Username is required", loginPage.getErrorMessage());
        }
        else if(loginPage.getErrorMessage().equals("Epic sadface: Username and password do not match any user in this service"))
        {
            Assert.assertEquals("Epic sadface: Username and password do not match any user in this service", loginPage.getErrorMessage());
        }
        else if(loginPage.getErrorMessage().equals("Epic sadface: Sorry, this user has been locked out."))
        {
            Assert.assertEquals("Epic sadface: Sorry, this user has been locked out.", loginPage.getErrorMessage());
        }
        else
        {
            Assert.fail("Unexpected error message: " + loginPage.getErrorMessage());
        }
    }
}
