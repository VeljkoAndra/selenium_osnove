package d22_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
        //2.	Napisati program koji:
        //●	ima niz od 5 stringova. Svaki element u nizu je url stranice:
        //○	https://www.google.com/
        //○	https://www.facebook.com/
        //○	https://www.youtube.com/
        //○	https://www.ebay.com/
        //○	https://www.katalon.com/
        //●	zatim koristeci for petlju otvara svaku stranicu iz niza u pretrazivacu prateci sledeca pravila:
        //○	za svaku stranicu se kreira nova infrastuktura
        //○	ucitava stranica
        //○	pravi pauza od 1s
        //○	ponistava testna stuktura
        ArrayList<String> stranice = new ArrayList<>();
        stranice.add("https://www.google.com/");
        stranice.add("https://www.facebook.com/");
        stranice.add("https://www.youtube.com/");
        stranice.add("https://www.ebay.com/");
        stranice.add("https://www.katalon.com/");

        for (int i = 0; i < stranice.size(); i++){
            WebDriverManager.chromedriver().setup();
            WebDriver driver= new ChromeDriver();
            driver.get(stranice.get(i));
            Thread.sleep(1000);
            driver.quit();
        }
    }
}
