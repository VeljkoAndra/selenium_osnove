package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.time.Duration;

public abstract class BasicTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String baseUrl = "https://www.saucedemo.com";
    protected LoginPage loginPage;
    protected LeftNavPage leftNavPage;
    protected InventoryPage inventoryPage;
    protected TopNavPage topNavPage;
    protected CartPage cartPage;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        cartPage = new CartPage(driver, wait);
        loginPage = new LoginPage(driver, wait);
        topNavPage = new TopNavPage(driver, wait);
        inventoryPage = new InventoryPage(driver, wait);
        leftNavPage = new LeftNavPage(driver, wait);
    }

    @BeforeMethod
    public void beforMethod(){
        driver.navigate().to(baseUrl);
    }
    @AfterMethod
    public void afterMethod () {
        driver.manage().deleteAllCookies();
    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
