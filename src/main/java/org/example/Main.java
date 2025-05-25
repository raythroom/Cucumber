package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","driver/chromedriver"); // Update with the path to your chromedriver;
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        System.out.println("Title of the page is: " + driver.getTitle());
        driver.quit();

    }
}