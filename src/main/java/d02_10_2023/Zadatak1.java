package d02_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
        //Napisati program koji:
        //●	Podesava:
        //○	implicitno cekanje za trazenje elemenata od 10s
        //○	implicitno cekanje za ucitavanje stranice od 10s
        //○	eksplicitno cekanje podeseno na 10s
        //●	Podaci:
        //○	Potrebno je u projektu ukljuciti 4 slike:
        //■	front.jpg
        //■	left.jpg
        //■	right.jpg
        //■	back.jpg
        //●	Koraci:
        //○	Ucitava stranicu https://boomf.com/apps/proxy/boomf-bomb/i-bloody-love-you
        //○	Maksimizuje prozor
        //○	Klik na edit ikonicu
        //○	Klik na delete iz iskacuceg dijaloga
        //○	Klik na Add Image dugme
        //○	Sacekajte da se pojavi desni meni
        //○	Uploadujte front.jpg sliku
        //○	Sacekajte da je ispod uploada slike, broj slika 1.
        //○	Klik na sliku
        //○	Klik na Done dugme
        //○	Sacekajte 2s
        //○	Klik na Add Image dugme
        //○	Sacekajte da se pojavi desni meni
        //○	Uploadujte right.jpg sliku
        //○	Sacekajte da je ispod uploada slike, broj slika 2.
        //○	Klik na sliku
        //○	Klik na Done dugme
        //○	Sacekajte 2s
        //○	Klik na Add Image dugme
        //○	Sacekajte da se pojavi desni meni
        //○	Uploadujte back.jpg sliku
        //○	Sacekajte da je ispod uploada slike, broj slika 3.
        //○	Klik na sliku
        //○	Klik na Done dugme
        //○	Sacekajte 2s
        //○	Klik na Add Image dugme
        //○	Sacekajte da se pojavi desni meni
        //○	Uploadujte back.jpg sliku
        //○	Sacekajte da je ispod uploada slike, broj slika 3.
        //○	Klik na sliku
        //○	Klik na Done dugme
        //○	Sacekajte 2s
        //○	Sacekajte da Next dugme bude klikljivo
        //○	Klik na Next dugme
        //○	Unesite tekst
        //○	Klik na Next
        //○	Klik na Preview
        //○	Klik na Add to cart
        //○	Sacekajte 5s
        //○	Quit
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://boomf.com/apps/proxy/boomf-bomb/i-bloody-love-you");



        driver.findElement(By.className("edit-image")).click();
        wait.withMessage("Delete button not visible.")
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("image-option-remove")));

        driver.findElement(By.id("image-option-remove")).click();

        ArrayList<File> imagesFile = new ArrayList<>();
        imagesFile.add(new File("test_data/front.jpg"));
        imagesFile.add(new File("test_data/right.jpg"));
        imagesFile.add(new File("test_data/beck.jpg"));
        imagesFile.add(new File("test_data/left.jpg"));
        {
            int i = 0;
            while (i < 4) {
                driver.findElement(By.className("edit-image")).click();
                wait.withMessage("Upload an image dialog not shown.")
                        .until(ExpectedConditions.presenceOfElementLocated(By.id("imageUpload")));

                driver.findElement(By.id("imageUpload")).sendKeys(imagesFile.get(i).getAbsolutePath());
                wait.withMessage("Uploaded photo not added to the list.")
                        .until(ExpectedConditions.numberOfElementsToBe(By.xpath("//img[contains(@id, 'image-option-')]"), i + 1));

                driver.findElement(By.id("image-option-0")).click();
                wait.withMessage("Image crop done button is not visible.")
                        .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#image-crop-done-button > button")));
                driver.findElement(By.cssSelector("#image-crop-done-button > button")).click();

                Thread.sleep(2000);
                i++;
            }
        }
        wait.withMessage("Next button is not clickable.")
                .until(ExpectedConditions.elementToBeClickable(By.id("next-button")));
        driver.findElement(By.id("next-button")).click();

        driver.findElement(By.id("textareaID")).click();
        driver.findElement(By.id("textareaID")).sendKeys("Low poly images box");

        driver.findElement(By.id("next-button")).click();
        wait.withMessage("Confetti selection dialog is not visible.")
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@id,'confetti-')]")));

        driver.findElement(By.id("confetti-4")).click();

        driver.findElement(By.id("next-button")).click();

        WebElement box360View = driver.findElement(By.id("input-container"));

        int i = 0;
        while (i < 4) {
            new Actions(driver)
                    .clickAndHold(box360View)
                    .moveByOffset(100, 0)
                    .release()
                    .perform();
            Thread.sleep(500);
            i++;
        }

        driver.findElement(By.id("next-button")).click();
        driver.findElement(By.className("close")).click();
        driver.findElement(By.id("next-button")).click();

        Thread.sleep(5000);


        driver.quit();;
    }
}
