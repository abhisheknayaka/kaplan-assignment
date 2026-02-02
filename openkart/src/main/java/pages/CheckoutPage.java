package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.WaitUtils;

public class CheckoutPage {

    private WebDriver driver;
    private WaitUtils wait;

    // Locators
    private By totalPrice = By.cssSelector("td.text-right:contains('Total')"); // adjust if needed
    private By cartTableRows = By.cssSelector("table.table.table-bordered tbody tr");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }

    // Verify total price decreased after item removal
    public void verifyTotalPriceReduced() {

        // Get initial total price
        double initialTotal = getTotalPrice();
        System.out.println("Initial Total: " + initialTotal);

        // Refresh to get updated cart
        driver.navigate().refresh();

        double updatedTotal = getTotalPrice();
        System.out.println("Updated Total after Scenario B: " + updatedTotal);

        if (updatedTotal < initialTotal) {
            System.out.println("Total price decreased correctly. Validation passed.");
        } else {
            System.out.println("Total price did NOT decrease! Validation failed.");
        }
    }

    private double getTotalPrice() {
        String totalText = wait.waitForElementVisible(totalPrice).getText();
        totalText = totalText.replaceAll("[^0-9.,]", "").replace(",", "");
        return Double.parseDouble(totalText);
    }
}
