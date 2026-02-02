package tests;

import base.BaseTest;
import base.DriverFactory;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import utils.SyncManager;

public class ScenarioBTest extends BaseTest {

    @Test
    public void scenarioB() {

        System.out.println("Scenario B: Starting test...");

        // Login
        LoginPage login = new LoginPage(DriverFactory.getDriver());
        login.login("test@test.com", "password");

        // Open cart
        CartPage cart = new CartPage(DriverFactory.getDriver());
        cart.openCart();

        // Verify 3 items added by Scenario A
        cart.verifyItemsCount(3);

        // Remove one item
        cart.removeOneItem();

        // Signal Scenario A to resume
        System.out.println("Scenario B: Item deleted. Notifying Scenario A...");
        SyncManager.cartUpdateLatch.countDown();

        System.out.println("Scenario B: Test completed successfully.");
    }
}
