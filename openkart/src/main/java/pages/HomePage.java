package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.WaitUtils;

public class HomePage {

    private WebDriver driver;
    private WaitUtils wait;

    // Locators
    private By searchInput = By.name("search");
    private By searchButton = By.cssSelector("button.btn.btn-default.btn-lg");
    private By addToCartButton = By.xpath("//button[contains(@onclick,'cart.add')]");
    private By currencyDropdown = By.cssSelector("button.btn.btn-link.dropdown-toggle");
    private By euroCurrency = By.name("EUR");
    private By cartButton = By.id("cart");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }

    // Search and add product by name
    public void addItemToCart(String productName) {
        wait.waitForElementVisible(searchInput).clear();
        searchInput().sendKeys(productName);
        wait.waitForElementClickable(searchButton).click();

        // Wait and click Add to Cart
        wait.waitForElementClickable(addToCartButton).click();
        System.out.println("Added " + productName + " to cart.");
    }

    private org.openqa.selenium.WebElement searchInput() {
        return wait.waitForElementVisible(searchInput);
    }

    // Change currency to Euro
    public void changeCurrencyToEuro() {
        wait.waitForElementClickable(currencyDropdown).click();
        wait.waitForElementClickable(euroCurrency).click();
        System.out.println("Currency changed to Euro.");
    }

    // Go to Checkout page
    public CheckoutPage goToCheckout() {
        wait.waitForElementClickable(cartButton).click();
        return new CheckoutPage(driver);
    }
}
