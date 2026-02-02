package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.WaitUtils;

import java.util.List;

public class CartPage {

    private WebDriver driver;
    private WaitUtils wait;

    // Locators
    private By cartTableRows = By.cssSelector("table.table.table-bordered tbody tr");
    private By removeButtons = By.cssSelector("button.btn.btn-danger");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }

    // Open cart page
    public void openCart() {
        driver.get("https://demo.opencart.com/index.php?route=checkout/cart");
    }

    // Verify total items in cart
    public void verifyItemsCount(int expectedCount) {
        List<WebElement> rows = wait.waitForElementVisible(cartTableRows).findElements(cartTableRows);
        if (rows.size() == expectedCount) {
            System.out.println("Cart has correct number of items: " + expectedCount);
        } else {
            System.out.println("Cart item count mismatch! Expected: " + expectedCount + ", Found: " + rows.size());
        }
    }

    // Remove one item (first in list)
    public void removeOneItem() {
        List<WebElement> removeBtns = driver.findElements(removeButtons);
        if (!removeBtns.isEmpty()) {
            wait.waitForElementClickable(removeButtons).click();
            System.out.println("Removed one item from cart.");
        } else {
            System.out.println("No items to remove.");
        }
    }

}
