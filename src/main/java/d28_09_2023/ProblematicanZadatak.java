package d28_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ProblematicanZadatak {
    public static void main(String[] args)  throws InterruptedException {
            //Za zadatak iz foldera za domaci izdebagirati i ispraviti da radi.

            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


            driver.get("http://seleniumdemo.com/?product=git-basics");


            WebElement addToCartBtn = driver.findElement(By.name("add-to-cart"));
            addToCartBtn.click();

            Thread.sleep(1000); // cekaj da se osvezi stranica

            wait
                    .until(ExpectedConditions.textToBe(By.cssSelector(".nav__woocart .countz"), "1"));


            System.out.println("KRAJ");

            driver.quit();



        }
}
