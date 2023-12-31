package d25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {
        //3.	Zadatak
        //Napisati program koji vrsi dodavanje 5 redova
        //●	Maksimizirati prozor
        //●	Ucitati stranicu https://www.tutorialrepublic.com/snippets/bootstrap/table-with-add-and-delete-row-feature.php
        //●	Dodati 5 redova sa istim podacima.Jedan red u jednoj iteraciji
        //●	Klik na dugme Add New
        //●	Unesite name,departmant i phone (uvek iste vrednost)
        //i.	Trazenje po name atributu
        //ii.	Kliknite na zeleno Add dugme.
        //PAZNJA: Pogledajte strukturu stranice i videcete da se u svakom redu poslednje kolone javljaju dugmici edit, add, delete ali zbog prirode reda neki dugmici se vide a neki ne.
        //Morate da dohvatite uvek Add dugme iz poslednjeg reda tabele. Mozete koristeci index iz petlje, a mozete koristeci i last() fukncionalnost za xpath. Koristan link last mehnizma
        //iii.	Cekanje od 0.5s
        //●	Na kraju programa ugasite pretrazivac.
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.tutorialrepublic.com/snippets/bootstrap/table-with-add-and-delete-row-feature.php");

        String name = "Marko";
        String department = "Computer Service";
        String phone = "(123) 555-111";


        for (int i = 0; i < 5; i++){
            WebElement dodavanje = driver.findElement(By.cssSelector("button.btn.add-new"));
            dodavanje.click();

            WebElement nameEl = driver.findElement(By.name("name"));
            nameEl.sendKeys(name);

            WebElement departmentEl = driver.findElement(By.name("department"));
            departmentEl.sendKeys(department);

            WebElement phoneEl = driver.findElement(By.name("phone"));
            phoneEl.sendKeys(phone);

            WebElement add= driver.findElement(By.cssSelector("table >tbody tr:last-child a.add"));
            add.click();

            Thread.sleep(500);
        }

        driver.quit();

    }
}
