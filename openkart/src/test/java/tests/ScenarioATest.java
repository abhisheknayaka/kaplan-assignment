package tests;

import base.BaseTest;
import base.DriverFactory;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import utils.SyncManager;

public class ScenarioATest extends BaseTest {

    @Test
    public void scenarioA() throws InterruptedException {

        System.out.println("Scenario A: Starting test...");

        // Login
        LoginPage login = new LoginPage(DriverFactory.getDriver());
        HomePage home = login.login("abhishek123@gmail.com", "Password*123");

        // Add 3 items
        home.addItemToCart("MacBook");
        home.addItemToCart("iPhone");
        home.addItemToCart("Samsung SyncMaster");

        // Change currency
        home.changeCurrencyToEuro();

        // Go to checkout
        CheckoutPage checkout = home.goToCheckout();

        System.out.println("Scenario A: Waiting for Scenario B to modify cart...");
        // Wait for Scenario B
        SyncManager.cartUpdateLatch.await();

        // Refresh and verify total price reduced
        checkout.verifyTotalPriceReduced();

        System.out.println("Scenario A: Test completed successfully.");
    }
}
