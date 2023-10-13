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
    @Test (priority = 14, retryAnalyzer = SwagLabsRetry.class)
    public void verifyIfAllItemsOptionIsWorking () {
        verifyIfTheHamburgerButtonIsWorking();
        leftNavPage.clickOnTheAllItemsFromMenuOption();
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "/inventory.html",
                "Should be redirected to the products page.");
    }
    @Test (priority = 15, retryAnalyzer = SwagLabsRetry.class)
    public void verifyIfAboutOptionIsWorking () {
        verifyIfTheHamburgerButtonIsWorking();
        leftNavPage.clickOnTheAboutFromMenuOption();
        Assert.assertEquals(driver.getCurrentUrl(),
                "https://saucelabs.com/",
                "Should be redirected to the sauce labs website");
    }
    @Test (priority = 16, retryAnalyzer = SwagLabsRetry.class)
    public void verifyIfLogoutOptionIsWorking () throws InterruptedException {
        verifyIfTheHamburgerButtonIsWorking();
        leftNavPage.clickOnTheLogoutFromMenuOption();
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "/", "Should be redirected to the login page");
    }
    @Test (priority = 17, retryAnalyzer = SwagLabsRetry.class)
    public void verifyIfResetAppStateIsWorking () {
        verifyIfTheHamburgerButtonIsWorking();
        inventoryPage.clickOnAddToCartButtonForSauceLabsBackpack();
        leftNavPage.clickOnTheResetFromMenuOption();
        topNavPage.getTheShoppingCartButton();
        Assert.assertTrue(topNavPage.invisibilityOfNumberItemsInCart());
    }
    @Test (priority = 18, retryAnalyzer = SwagLabsRetry.class)
    public void verifyIfTheEkisButtonIsPresented () {
        verifyIfTheHamburgerButtonIsWorking();
        Assert.assertTrue(leftNavPage.doesEkisButtonExistInMenu(),
                "Ekis button should be visible in menu");
    }
    @Test (priority = 19, retryAnalyzer = SwagLabsRetry.class)
    public void verifyIfTheEkisButtonsIsWorking () {
        verifyIfTheHamburgerButtonIsWorking();
        leftNavPage.clickOnTheEkisButtonFromMenu();
        leftNavPage.waitForLeftMenuToBeInvisible();
    }
    @Test (priority = 20, retryAnalyzer = SwagLabsRetry.class)
    public void verifyIfTheItemsAddedIsPresented () {
        String username = "standard_user";
        String password = "secret_sauce";

        loginPage.clearAndTypeUsername(username);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();
        inventoryPage.clickOnAddToCartButtonForSauceLabsBackpack();
        topNavPage.clickOnTheShoppingCartButton();
        Assert.assertTrue(cartPage.areTheItemsAdded(),
                "Added items should be presented on the page.");
    }
    @Test (priority = 21, retryAnalyzer = SwagLabsRetry.class)
    public void verifyIfTheItemsTitleIsPresented () {
        String username = "standard_user";
        String password = "secret_sauce";

        loginPage.clearAndTypeUsername(username);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();
        inventoryPage.clickOnAddToCartButtonForSauceLabsBackpack();
        topNavPage.clickOnTheShoppingCartButton();
        Assert.assertTrue(cartPage.doesItemTitleIsPresented(),
                "Title of the added item should be visible.");
    }
    @Test (priority = 22, retryAnalyzer = SwagLabsRetry.class)
    public void verifyIfTheItemssDescriptionIsPresented () {
        String username = "standard_user";
        String password = "secret_sauce";

        loginPage.clearAndTypeUsername(username);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();
        inventoryPage.clickOnAddToCartButtonForSauceLabsBackpack();
        topNavPage.clickOnTheShoppingCartButton();
        Assert.assertTrue(cartPage.doesItemTitleIsPresented(),
                "Description of the added item should be visible.");
    }
    @Test (priority = 23, retryAnalyzer = SwagLabsRetry.class)
    public void verifyIfTheItemsPriceIsPresented () {
        String username = "standard_user";
        String password = "secret_sauce";

        loginPage.clearAndTypeUsername(username);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();
        inventoryPage.clickOnAddToCartButtonForSauceLabsBackpack();
        topNavPage.clickOnTheShoppingCartButton();
        Assert.assertTrue(cartPage.doesItemsPriceIsPresented(),
                "Price of the added item should be visible.");
    }
    @Test (priority = 24, retryAnalyzer = SwagLabsRetry.class)
    public void verifyIfTheItemsQuantityIsPresented () {
        String username = "standard_user";
        String password = "secret_sauce";

        loginPage.clearAndTypeUsername(username);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();
        inventoryPage.clickOnAddToCartButtonForSauceLabsBackpack();
        topNavPage.clickOnTheShoppingCartButton();
        Assert.assertTrue(cartPage.doesItemsQuantityIsPresented(),
                "Quantity of the added item should be visible.");
    }
    @Test (priority = 25, retryAnalyzer = SwagLabsRetry.class)
    public void verifyIfTheItemsTitleIsClickable () {
        String username = "standard_user";
        String password = "secret_sauce";

        loginPage.clearAndTypeUsername(username);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();
        inventoryPage.clickOnTheAddToCartButtons();
        topNavPage.clickOnTheShoppingCartButton();
        Assert.assertTrue(cartPage.checkTheTitlesAreClickable(),
                "Title should be clickable.");
    }
    @Test (priority = 26, retryAnalyzer = SwagLabsRetry.class)
    public void verifyIfTheItemsTitleIsWorking () {
        String username = "standard_user";
        String password = "secret_sauce";

        loginPage.clearAndTypeUsername(username);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();
        inventoryPage.clickOnTheAddToCartButtons();
        topNavPage.clickOnTheShoppingCartButton();
        cartPage.clickOnTheFirstTitle();
        Assert.assertEquals(driver.getCurrentUrl(),
                itemPage.SauceLabsBackpackUrl,
                "Should be redirected on the product page.");
    }
    @Test (priority = 27, retryAnalyzer = SwagLabsRetry.class)
    public void verifyIfTheRemoveButtonIsPresented () {
        String username = "standard_user";
        String password = "secret_sauce";

        loginPage.clearAndTypeUsername(username);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();
        inventoryPage.clickOnTheAddToCartButtons();
        topNavPage.clickOnTheShoppingCartButton();
        Assert.assertTrue(cartPage.doesRemoveButtonsAreVisible(),
                "Remove button should be visible.");
    }
    @Test (priority = 28, retryAnalyzer = SwagLabsRetry.class)
    public void verifyIfTheRemoveButtonIsWorking () throws InterruptedException {
        String username = "standard_user";
        String password = "secret_sauce";

        loginPage.clearAndTypeUsername(username);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();
        inventoryPage.clickOnTheAddToCartButtons();
        topNavPage.clickOnTheShoppingCartButton();
        cartPage.clickOnTheRemoveButtonForBackpack();
        Assert.assertTrue(!cartPage.doesItemExistAfterRemoving(),
                "The item should disappear after removing");
    }




}
