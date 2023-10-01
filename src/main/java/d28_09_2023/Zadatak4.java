package d28_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak4 {
    public static void main(String[] args) {
        //Zadatak
        //●	Ucitati stranicu http://seleniumdemo.com/?product=bdd-cucumber
        //●	Klik na korpu iz gornjeg desnog ugla
        //●	Sacekati da naslov stranice bude Cart – Selenium Demo Page
        //●	Proveriti da li element koji prikazuje stanje korpe ima tekst Your cart is currently empty.

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        try {
            driver.get("http://seleniumdemo.com/?product=bdd-cucumber");
            driver.findElement(By.cssSelector(".mobile-woocart__container a")).click();
            wait.until(ExpectedConditions.titleIs("Cart – Selenium Demo Page"));
            WebElement cartEmpty = null;
            try {
                cartEmpty = driver.findElement(By.cssSelector(".cart-empty"));
            } catch (Exception e) {
            }
            if (cartEmpty != null) {
                System.out.println("Korpa je prazna");
            } else {
                System.out.println("U korpi se nalaze proizvodi");
            }
        } catch (Exception e) {
            System.err.println("Doslo je do greske: " + e.getMessage());
        }


            driver.quit();





    }
}
