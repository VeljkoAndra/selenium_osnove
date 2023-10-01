package d28_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak3 {
    public static void main(String[] args) {
        //Zadatak
        //●	Ucitati stranicu http://seleniumdemo.com/?post_type=product
        //●	Klik na search dugme u gornjem desnom uglu
        //●	Cekati da forma za pretragu bude vidljiva
        //●	Uneti sledeci tekst za pretragu BDD Cucumber i ENTER
        //●	Dohvatiti prvi rezultat pretrage i proveriti da li u nazivu sadrzi tekst koji je unet za pretragu. Ispisati odgovarajuce poruke u terminalu

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));


        driver.get("http://seleniumdemo.com/?post_type=product");


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        String text = "BDD Cucumber";
        driver.findElement(By.xpath("//a[contains(@class, 'search-toggle_btn icn-search')]")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input#s-651536d633c09")))
                .sendKeys(text + Keys.ENTER);


        WebElement rezultat = driver.findElement(By.xpath("//div[@class='grid__wrapper grid']/section/article[1]"));
        rezultat.findElement(By.cssSelector("article:first-child .czr-title"));
        if (rezultat.getText().contains(text)){
            System.out.println("Rezultat sadrzi tekst koji smo prethodno uneli za pretragu.");
        }
     driver.quit();

    }
}
