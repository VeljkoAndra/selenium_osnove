package p05_10_2023;

import com.beust.ah.A;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import javax.swing.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class SwagLabsTests {
    private WebDriver driver;
    private WebDriverWait wait;
    private final String url = "https://www.saucedemo.com";

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @BeforeMethod
    public void beforeMethod(){
        driver.navigate().to(url);
        driver.manage().deleteAllCookies();

    }

    @Test (priority = 1)
    public void verifyErrorIsDisplayedWhenUsernameIsMissing(){
        String expectedErrorMessage= "Epic sadface: Username is required";
        driver.findElement(By.id("login-button")).click();
        wait
                .withMessage("Message is not displayed")
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.error-message-container.error > h3")));

        WebElement errorMessage = driver.findElement(By.cssSelector("[data-test='error']"));
        Assert.assertEquals(errorMessage.getText(), expectedErrorMessage);
    }

    @Test (priority = 2)
    public void VerifyErrorIsDisplayedWhenPasswordIsMissing(){
        String username2="dawrgq";

        driver.findElement(By.id("user-name")).sendKeys(username2);
        driver.findElement(By.name("login-button")).click();

        WebElement errorMessage= wait
                .withMessage("Message is not displayed")
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.error-message-container.error > h3")));


        String expectedErrorMessage = "Epic sadface: Password is required";
        Assert.assertEquals(errorMessage.getText(), expectedErrorMessage);
    }

    @Test (priority = 3)
    public void VerifyErrorIsDisplayedWhenCredentialsAreWrong(){
        String username3 = "standard_user";
        String password3 = "invalidpassword";
        String expectedErrorMessage= "Epic sadface: Username and password do not match any user in this service";

        WebElement usernameField= driver.findElement(By.id("user-name"));
                   usernameField.sendKeys(username3);
        WebElement passwordField= driver.findElement(By.id("password"));
                   passwordField.sendKeys(password3);

        WebElement login = driver.findElement(By.name("login-button"));
        login.click();

        WebElement message = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-test='error']")));

        Assert.assertEquals(message.getText(), expectedErrorMessage, "Expected error message is not visible. ");
    }
    @Test (priority = 4)
    private void verifyErrorIsDisplayedWhenUserIsLocked(){
        String username4 = "locked_out_user";
        String password4 = "secret_sauce";
        String expectedErrorMessage= "Epic sadface: Sorry, this user has been locked out.";

        WebElement usernameField= driver.findElement(By.id("user-name"));
        usernameField.sendKeys(username4);
        WebElement passwordField= driver.findElement(By.id("password"));
        passwordField.sendKeys(password4);

        WebElement login = driver.findElement(By.name("login-button"));
        login.click();

        WebElement message = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-test='error']")));

        Assert.assertEquals(message.getText(), expectedErrorMessage, "Expected message is not visible.");
    }

    @Test (priority = 5)
    public void verifySuccessfulLogin(){
        String username5 = "standard_user";
        String password5 = "secret_sauce";

        WebElement usernameField= driver.findElement(By.id("user-name"));
        usernameField.sendKeys(username5);
        WebElement passwordField= driver.findElement(By.id("password"));
        passwordField.sendKeys(password5);

        WebElement login = driver.findElement(By.name("login-button"));
        login.click();

        Assert.assertEquals(driver.getCurrentUrl(), url+"/inventory.html", "url is not equals.");

        WebElement leftMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("react-burger-menu-btn")));
                   leftMenu.click();
        WebElement logoutButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("logout_sidebar_link")));
                   logoutButton.click();

    }

    @Test (priority = 6)
    public void addingProductsToCart(){
        String username6 = "standard_user";
        String password6 = "secret_sauce";
        WebElement usernameField= driver.findElement(By.id("user-name"));
        usernameField.sendKeys(username6);
        WebElement passwordField= driver.findElement(By.id("password"));
        passwordField.sendKeys(password6);
        WebElement login = driver.findElement(By.name("login-button"));
        login.click();

        Assert.assertEquals(driver.getCurrentUrl(), url+ "/inventory.html");

        WebElement backpackProduct = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        backpackProduct.click();

        WebElement removeButton = driver.findElement(By.id("remove-sauce-labs-backpack"));
        Assert.assertTrue(removeButton.isDisplayed());

        WebElement cartItemCount = driver.findElement(By.cssSelector(".shopping_cart_badge"));
        Assert.assertEquals(cartItemCount.getText(), "1", "Not expected text.");
    }

    @Test (priority = 7)
    public void viewingProductDetails(){
        String username7 = "standard_user";
        String password7 = "secret_sauce";
        WebElement usernameField= driver.findElement(By.id("user-name"));
        usernameField.sendKeys(username7);
        WebElement passwordField= driver.findElement(By.id("password"));
        passwordField.sendKeys(password7);
        WebElement login = driver.findElement(By.name("login-button"));
        login.click();

        Assert.assertEquals(driver.getCurrentUrl(), url+"/inventory.html");
        WebElement backpackProductDetail = driver.findElement(By.id("item_4_title_link"));
        backpackProductDetail.click();

        WebElement price = driver.findElement(By.cssSelector("#inventory_item_container  div.inventory_details_price"));
        String expectedPrice = "$29.99";
        Assert.assertEquals(price.getText(), expectedPrice, "price/text are not equals");

        WebElement text = driver.findElement(By.cssSelector("#inventory_item_container  div.inventory_details_desc"));
        String expectedText= "streamlined Sly Pack that melds uncompromising style";
        Assert.assertTrue(text.getText().contains(expectedText), "Expected text does not show.");

        WebElement addButton = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
        Assert.assertTrue(addButton.isDisplayed(), "button is not visible.");
    }

    @Test (priority = 8)
    public void removingProductsFromCart(){
        String username8 = "standard_user";
        String password8 = "secret_sauce";
        WebElement usernameField= driver.findElement(By.id("user-name"));
        usernameField.sendKeys(username8);
        WebElement passwordField= driver.findElement(By.id("password"));
        passwordField.sendKeys(password8);
        WebElement login = driver.findElement(By.name("login-button"));
        login.click();

        Assert.assertEquals(driver.getCurrentUrl(), url+ "/inventory.html");

        WebElement backpackProduct = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
        backpackProduct.click();

        WebElement cartItemCount = driver.findElement(By.cssSelector(".shopping_cart_badge"));
        Assert.assertEquals(cartItemCount.getText(), "1");

        WebElement shoppingCart = driver.findElement(By.id("shopping_cart_container"));
        shoppingCart.click();
        wait
                .withMessage("Element isnt visible.")
                .until(ExpectedConditions.presenceOfElementLocated(By.id("item_4_title_link")));

        driver.findElement(By.id("remove-sauce-labs-backpack")).click();

        wait
                .withMessage("Element is visible.")
                .until(ExpectedConditions.invisibilityOfElementLocated(By.id("item_4_title_link")));
    }

    @Test (priority = 9)
    public void productCheckout(){
        String username9 = "standard_user";
        String password9 = "secret_sauce";
        String checkOutName9= "Pera";
        String checkOutLastName9= "Peric";
        String checkOutZip9 = "18000";


        WebElement usernameField= driver.findElement(By.id("user-name"));
        usernameField.sendKeys(username9);
        WebElement passwordField= driver.findElement(By.id("password"));
        passwordField.sendKeys(password9);
        WebElement login = driver.findElement(By.name("login-button"));
        login.click();
        Assert.assertEquals(driver.getCurrentUrl(), url+"/inventory.html");

        WebElement backpackProduct = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
        backpackProduct.click();
        WebElement addToCartButton = driver.findElement(By.name("add-to-cart-sauce-labs-backpack"));
        addToCartButton.click();

        WebElement cartItemCount = driver.findElement(By.cssSelector(".shopping_cart_badge"));
        Assert.assertEquals(cartItemCount.getText(), "1");

        WebElement shoppingCart = driver.findElement(By.id("shopping_cart_container"));
        shoppingCart.click();

        WebElement cartCheckout = driver.findElement(By.id("checkout"));
        cartCheckout.click();

        WebElement checkoutName =
                wait
                        .withMessage("First Name is not visible in tab.")
                        .until(ExpectedConditions.visibilityOfElementLocated(By.id("first-name")));
                checkoutName.sendKeys(checkOutName9);

        WebElement checkoutLastname =
                wait
                        .withMessage("Last name is not visible in tab.")
                        .until(ExpectedConditions.visibilityOfElementLocated(By.id("last-name")));
                checkoutLastname.sendKeys(checkOutLastName9);

        WebElement checkoutZip =
                wait
                        .withMessage("Zip/Postal code is not visible in tab.")
                        .until(ExpectedConditions.visibilityOfElementLocated(By.name("postalCode")));
                checkoutZip.sendKeys(checkOutZip9);

        driver.findElement(By.id("continue")).click();

        WebElement finishButton = driver.findElement(By.cssSelector("button#finish"));
        finishButton.click();



        WebElement endtext =
                wait
                        .withMessage("Element is not visible.")
                        .until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#checkout_complete_container > h2"))));

        Assert.assertEquals(endtext.getText(),"Thank you for your order!");

    }
    @Test (priority = 10)
    public void validateSocialLinksInFooter() throws IOException {
        String username10= "standard_user";
        String password10= "secret_sauce";
        WebElement usernameField= driver.findElement(By.id("user-name"));
        usernameField.sendKeys(username10);
        WebElement passwordField= driver.findElement(By.id("password"));
        passwordField.sendKeys(password10);
        WebElement login = driver.findElement(By.name("login-button"));
        login.click();
        Assert.assertEquals(driver.getCurrentUrl(), url+"/inventory.html");

        WebElement footer = driver.findElement(By.tagName("footer"));
        ((ChromeDriver) driver).executeScript("arguments[0].scrollIntoView(true);", footer);

        String[] socialLinks = {"linkedin", "facebook", "twitter"};
        for (String socialLink : socialLinks) {
            WebElement link = driver.findElement(By.xpath("//a[contains(@href, '" + socialLink + "')]"));
            String href = link.getAttribute("href");
            int responseCode = getResponseCode(href);
            Assert.assertTrue(responseCode == 200 || responseCode == 302, "Response code isnt 200 or 302");
        }
    }

    private int getResponseCode(String url) throws IOException {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);
        return con.getResponseCode();
    }

    @AfterTest
    public void afterClass (){
        driver.quit();
    }

}
