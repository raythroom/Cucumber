package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {


    // Define locators for the login page elements

    @FindBy(how = How.ID, using = "user-name")
    private WebElement loginPage_UsernameField;

    @FindBy(how = How.ID, using = "password")
    private WebElement passwordField;

    @FindBy(how = How.ID, using = "login-button")
    private WebElement loginButton;

    @FindBy(how = How.XPATH, using = "//div[normalize-space(@class)='error-message-container error']")
    private WebElement errorMessage;

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        // Initialize the PageFactory elements
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to enter username
    public void enterUsername(String username) {
        // Code to find the username field and enter the username
        loginPage_UsernameField.clear();
        loginPage_UsernameField.sendKeys(username);

    }

    // Method to enter password
    public void enterPassword(String password) {
        // Code to find the password field and enter the password
        passwordField.clear();
        passwordField.sendKeys(password);

    }

    // Method to click the login button
    public void clickLoginButton() {
        // Code to find the login button and click it
        loginButton.click();

    }

    public void fillLoginForm(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();

    }

    public String getErrorMessage() {
        System.out.println("Error message: " + errorMessage.getText());
        return errorMessage.getText();
    }
}