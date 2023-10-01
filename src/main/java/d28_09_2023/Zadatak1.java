package d28_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak1 {
    public static void main(String[] args) {
//.Zadatak
//●	Napisati program koji ucitava stranicu https://github.com/orgs/embedly/repositories?q=&type=all&language=&sort=
//●	Klik na Type drawdown
//●	Klik na Public iz drowdowna
//●	Ceka da se Clear dugme u desnom uglu prikaze koristeci explicit wait
//●	Kilk na Clear filter u desnom uglu

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://github.com/orgs/embedly/repositories?q=&type=all&language=&sort=");

        WebElement clickType = driver.findElement(By.xpath("//*[@id='type-options']"));
        clickType.click();

        WebElement clickPublick = driver.findElement(By.xpath("//div[@class='SelectMenu-list']/label[2]"));
        clickPublick.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            wait
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.org-repos div.text-right a.issues-reset-query"))).click();



        driver.quit();

    }
}
