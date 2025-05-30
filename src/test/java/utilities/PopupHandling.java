package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Alert;

public class PopupHandling {

    private static WebDriver driver;
    Alert alert;

    public PopupHandling(WebDriver driver) {
        PopupHandling.driver = driver;
    }

    public void switchToAlert() {
        alert = driver.switchTo().alert();
    }

    public String getAlertText() {
        return alert.getText();
    }

    public void acceptAlert() {
        alert.accept();
    }

    public void dismissAlert() {
        alert.dismiss();
    }
}
