package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import retry.SwagLabsRetry;

public class SwagLabsTests extends BasicTest {

    @Test(priority = 1, retryAnalyzer = SwagLabsRetry.class)
    public void verifyTheUrl() {
        String username = "standard_user";
        String password = "secret_sauce";

        loginPage.clearAndTypeUsername(username);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();

        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "/inventory.html",
                "Should be redirected to inventory page after login.");

        topNavPage.clickOnTheShoppingCartButton();
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "/cart.html",
                "Should be redirected to cart page after click on the cart button.");
    }

    @Test(priority = 2, retryAnalyzer = SwagLabsRetry.class)
    public void verifyTheTitlePage() {
        String username = "standard_user";
        String password = "secret_sauce";

        loginPage.clearAndTypeUsername(username);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();

        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "/inventory.html",
                "Should be redirected to inventory page after login.");

        topNavPage.clickOnTheShoppingCartButton();
        Assert.assertEquals(driver.getTitle(),
                "Swag Labs",
                "Title should be Swag Labs.");
    }

    @Test (priority = 3, retryAnalyzer = SwagLabsRetry.class)
    public void verifyTheTitleInHeader() {
        String username = "standard_user";
        String password = "secret_sauce";

        loginPage.clearAndTypeUsername(username);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();

        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "/inventory.html",
                "Should be redirected to inventory page after login.");

        topNavPage.clickOnTheShoppingCartButton();
        Assert.assertEquals(topNavPage.getTheTitleInHeader(),
                "Swag Labs", "Title in header on the Cart Page should be Swag Labs.");
    }
    @Test (priority = 4, retryAnalyzer = SwagLabsRetry.class)
    public void verifyIfTheHamburgerMenuButtonIsPresented () {
        String username = "standard_user";
        String password = "secret_sauce";

        loginPage.clearAndTypeUsername(username);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();

        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "/inventory.html",
                "Should be redirected to inventory page after login.");

        topNavPage.clickOnTheShoppingCartButton();
        Assert.assertTrue(topNavPage.doesHamburgerMenuButtonExist(),
                "Menu button should be present on the Cart Page.");
    }

    @Test (priority = 5, retryAnalyzer = SwagLabsRetry.class)
    public void verifyIfTheCartIconIsPresented () {
        String username = "standard_user";
        String password = "secret_sauce";

        loginPage.clearAndTypeUsername(username);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();

        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "/inventory.html",
                "Should be redirected to inventory page after login.");
        topNavPage.clickOnTheShoppingCartButton();
        Assert.assertTrue(topNavPage.doesCartIconExist(),
                "Cart icon should be present on the Cart Page.");
    }
    @Test (priority = 6, retryAnalyzer = SwagLabsRetry.class)
    public void verifyIfTheHamburgerMenuButtonIsEnabled () {
        String username = "standard_user";
        String password = "secret_sauce";

        loginPage.clearAndTypeUsername(username);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();

        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "/inventory.html",
                "Should be redirected to inventory page after login.");
        topNavPage.clickOnTheShoppingCartButton();
        topNavPage.clickOnTheHamburgerMenuButton();
        Assert.assertTrue(topNavPage.doesHamburgerMenuIsEnabled(),
                "Hamburger menu button is not enabled.");
    }
    @Test (priority = 7, retryAnalyzer = SwagLabsRetry.class)
    public void verifyIfTheCartIconIsEnabled () {
        String username = "standard_user";
        String password = "secret_sauce";

        loginPage.clearAndTypeUsername(username);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();

        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "/inventory.html",
                "Should be redirected to inventory page after login.");
        topNavPage.clickOnTheShoppingCartButton();

        Assert.assertTrue(topNavPage.doesShoppingCartButtonIsEnabled(),
                "Shopping cart button is not enabled.");
    }
    @Test (priority = 8, retryAnalyzer = SwagLabsRetry.class)
    public void verifyIfTheHamburgerButtonIsWorking () {
        verifyIfTheHamburgerMenuButtonIsEnabled();
        leftNavPage.waitForLeftMenuToBeVisible();
    }
    @Test (priority = 9, retryAnalyzer = SwagLabsRetry.class)
    public void verifyIfTheCartIconIsWorking () {
        verifyIfTheCartIconIsEnabled();
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "/cart.html",
                "Should be redirected to cart page after click on the cart button.");
    }
    @Test (priority = 10, retryAnalyzer = SwagLabsRetry.class)
    public void verifyIfTheCartIconHasCorrectNumberOfAddedItems () {
        String username = "standard_user";
        String password = "secret_sauce";

        loginPage.clearAndTypeUsername(username);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();

        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "/inventory.html",
                "Should be redirected to inventory page after login.");
        inventoryPage.clickOnAddToCartButtonForSauceLabsBackpack();
        topNavPage.clickOnTheShoppingCartButton();
        Assert.assertEquals(cartPage.getNumberInSpan(),
                cartPage.getNumberInSpan(), "Numbers should be equal.");
    }
    @Test (priority = 11,retryAnalyzer = SwagLabsRetry.class)
    public void verifyTheSubHeaderTitle () {
        String username = "standard_user";
        String password = "secret_sauce";

        loginPage.clearAndTypeUsername(username);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();

        topNavPage.clickOnTheShoppingCartButton();
        Assert.assertEquals(subHeaderPage.getTheSubHeader(),
                "Your Cart",
                "Sub-header should be 'Your Cart' on the Cart Page.");
    }
    @Test (priority = 12, retryAnalyzer = SwagLabsRetry.class)
    public void verifyTheTotalNumberOfMenuOptions () {
        verifyIfTheHamburgerButtonIsWorking();
        Assert.assertEquals(leftNavPage.numberOfMenuOptions(), 4,
                "Total number of menu options should be four.");
    }
    @Test (priority = 13, retryAnalyzer = SwagLabsRetry.class)
    public void verifyTheSpellingOfAllOptionsInMenu () {
        verifyIfTheHamburgerButtonIsWorking();
        Assert.assertTrue(leftNavPage.spellingOfAllOptions(),
                "Spelling of options in menu is not correct.");
    }
    @Test (retryAnalyzer = SwagLabsRetry.class)
    public void verifyIfAllItemsOptionIsWorking () {
        verifyIfTheHamburgerButtonIsWorking();
        leftNavPage.clickOnTheAllItemsFromMenuOption();
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "/inventory.html",
                "Should be redirected to the products page.");
    }



}
