package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.WaitUtils;

public class LoginPage {

    private WebDriver driver;
    private WaitUtils wait;

    // Locators
    private By emailInput = By.id("input-email");
    private By passwordInput = By.id("input-password");
    private By loginButton = By.cssSelector("input[value='Login']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }

    // Navigate to login page
    public void openLoginPage() {
        driver.get("https://demo.opencart.com/index.php?route=account/login");
    }

    // Perform login and return HomePage
    public HomePage login(String email, String password) {
        openLoginPage();
        wait.waitForElementVisible(emailInput).sendKeys(email);
        wait.waitForElementVisible(passwordInput).sendKeys(password);
        wait.waitForElementClickable(loginButton).click();
        return new HomePage(driver);
    }
}
