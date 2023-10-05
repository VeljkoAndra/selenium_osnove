package d02_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import java.util.List;

public class Zadatak4 {
    //Zadatak
    //Napisati program koji:
    //●	Ucitava stranicu https://itbootcamp.rs/
    //●	Skrola do slajdera na dnu stranice (u kome su slike Java, Php, Selenium, …)
    //●	Cita sve linkove slika iz slajdera
    //●	Proverava url svake slike, i za sve slike koje imaju status veci i jednak od 200 a manji od 300, skida i smesta u folder itbootcamp_slider u okviru projekta
    //●	Azurirajte gitignore da ignorise itbootcamp_slider folder
    public static void main(String[] args) throws IOException, InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://itbootcamp.rs/");

        new Actions(webDriver)
                .scrollToElement(webDriver.findElement(By.id("colophon"))).perform();
        List<WebElement> listOfImages = webDriver.findElements(By.cssSelector(".owl-stage > div"));

        for (int i = 0; i < listOfImages.size(); i++) {
            URL link = new URL(listOfImages.get(i).findElement(By.cssSelector("div > img")).getAttribute("src"));
            HttpURLConnection http = (HttpURLConnection) link.openConnection();
            if (http.getResponseCode() >= 200 && http.getResponseCode() < 300){
                System.out.println(link);
                Image image = ImageIO.read(link);
                String location = "itbootcamp_slider/image_" + (i + 1) + ".png";
                ImageIO.write((RenderedImage) image,"png",new File(location));
            }
        }
        webDriver.quit();
    }
}