package d26_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Scanner;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
    //1.	Zadatak
        //Napisati program koji:
        //●	Ucitava stranicu https://demoqa.com/automation-practice-form
        //●	Popunjava formu sta stranice. Korisnik unosi podatke sa tastature za popunu forme.
        //●	(za vezbanje) Probajte da unese i datum. Sa datumom se radi isto kao i sa obicnim inputom sa sendKeys.
        //●	Klik na submit
        Scanner s = new Scanner(System.in);

        System.out.print("Unesite ime ");
        String firstName= s.next();
        System.out.print("Unesite prezime ");
        String lastName = s.next();
        System.out.print("Unesite mejl ");
        String email= s.next();
        System.out.print("Unesite pol (male, female. other ");
        String pol = s.next();
        System.out.print("Unesite broj telefona ");
        String telfon = s.next();
        System.out.print("Unesite subject ");
        String subject = s.next();
        System.out.print("Da li volite muziku? (komentar ostavite kao 'true' ako volite ili 'false' ako ne volite) ");
        boolean muzika = s.nextBoolean();
        System.out.print("Da li volite sport? (komentar ostavite kao 'true' ako volite ili 'false' ako ne volite) ");
        boolean sport = s.nextBoolean();
        System.out.print("Da li volite citati? (komentar ostavite kao 'true' ako volite ili 'false' ako ne volite) ");
        boolean citanje = s.nextBoolean();
        System.out.println("unesite trenutnu adresu ");
        String adresa = s.next();

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/automation-practice-form");

        WebElement firsName = driver.findElement(By.id("firstName"));
        firsName.sendKeys(firstName);
        WebElement prezime=  driver.findElement(By.id("lastName"));
        prezime.sendKeys(lastName);
        WebElement mejl = driver.findElement(By.id("userEmail"));
        mejl.sendKeys(email);
        List<WebElement> polovi = driver.findElements(By.cssSelector("#genterWrapper > div.col-md-9.col-sm-12"));
        if (pol.equals("male")){
            polovi.get(0).findElement(By.cssSelector("#genterWrapper > div.col-md-9.col-sm-12 > div:nth-child(1) > label")).click();
        }else if (pol.equals("female")) {
            polovi.get(1).findElement(By.cssSelector("#genterWrapper > div.col-md-9.col-sm-12 > div:nth-child(2) > label")).click();
        }else if (pol.equals("other")){
            polovi.get(2).findElement(By.cssSelector("#genterWrapper > div.col-md-9.col-sm-12 > div:nth-child(3) > label")).click();
        }
        WebElement brojTel = driver.findElement(By.id("userNumber"));
        brojTel.sendKeys(telfon);

        WebElement subjekat = driver.findElement(By.id("subjectsInput"));
        subjekat.click();
        subjekat.sendKeys(subject);
        subjekat.sendKeys(Keys.ENTER);

        List<WebElement> cekiranje = driver.findElements(By.cssSelector("#hobbiesWrapper > div.col-md-9.col-sm-12"));
        if (sport){
            cekiranje.get(0).findElement(By.id("hobbies-checkbox-1")).click();
        }
        if (citanje) {
            cekiranje.get(1).findElement(By.id("hobbies-checkbox-2")).click();
        }
        if (muzika){
            cekiranje.get(2).findElement(By.id("hobbies-checkbox-3")).click();
        }
        WebElement adress = driver.findElement(By.id("currentAddress"));
        adress.click();
        adress.sendKeys(adresa);
        adress.sendKeys(Keys.ENTER);


        driver.quit();
    }
}
