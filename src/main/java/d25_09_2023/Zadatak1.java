package d25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
        //●	Maksimizirati prozor
        //●	Ucitati stranicu https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
        //●	Prijavite se na sistem
        //○	Username: Admin
        //○	Password: admin123
        //●	Cekanje od 5s
        //●	U input za pretragu iz navigacije unesite tekst Me
        //●	Kliknite na prvi rezultat pretrage (to ce biti Time)
        //●	Cekanje od 1s
        //●	Kliknite u headeru na svog avatara (to ce biti na ime: Paul Collings)
        //●	Klinkite na logout
        //●	Cekanje od 5s
        //●	Zatvorite pretrazivac
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        WebElement usernameInput = driver.findElement(By.name("username"));
        WebElement passwordInput = driver.findElement(By.className("password"));
        usernameInput.clear();
        usernameInput.sendKeys("Admin");
        passwordInput.clear();
        passwordInput.sendKeys("admin123");
        driver.findElement(By.cssSelector("button.oxd-button")).click();
        Thread.sleep(5000);


        driver.findElement(By.id("searchTerm")).sendKeys("Me");
        driver.findElement(By.xpath("//ul[@id='searchResult']/li[1]")).click();
        Thread.sleep(1000);


        driver.findElement(By.xpath("//div[@class='dropdown']/a/img")).click();
        driver.findElement(By.xpath("//a[@href='/web/index.php/auth/logout']")).click();
        Thread.sleep(5000);


        driver.quit();



    }
}
