package d29_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak1 {
    public static void main(String[] args) {
        //1.	Zadatak
        //Napisati program koji testira infinity scroll.
        //●	Ucitati stranu https://web.dev/patterns/web-vitals-patterns/infinite-scroll/infinite-scroll/demo.html
        //●	Selektujte delay od 2000ms, koristeci Select klasu.
        //●	Skrol do Show more dugmeta koje se nalazi na dnu stranice
        //●	Sacekajte da dugme bude klikljivo
        //●	Klik na Show more dugme
        //●	Sacekjate da broj elemenata bude X (X je koliko se kod vas ucitava)
        //●	Sacekajte da dugme vise ne bude klikljivo

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.get("https://web.dev/patterns/web-vitals-patterns/infinite-scroll/infinite-scroll/demo.html");
            Select delayDropdown = new Select(driver.findElement(By.id("delay-select")));
            delayDropdown.selectByValue("2000");

            WebElement moreButtons = driver.findElement(By.cssSelector("button#infinite-scroll-button"));
            while (true) {
                moreButtons.click();
                Thread.sleep(2000);
                if (driver.findElements(By.className("item")).size() >= 49) {
                    break;
                }
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("button#infinite-scroll-button")));
            }
            System.out.println("Program zavrsen.");
        } catch (Exception e) {
            System.err.println("Greska: " + e.getMessage());
        }finally {
            driver.quit();
        }
    }
    }
