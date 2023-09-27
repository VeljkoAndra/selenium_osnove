package d25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
      //2.	Zadatak
        //●	Niz todoa (niz stringova) koje treba da uneti. Niz je:
        //○	Visit Paris
        //○	Visit Prague
        //○	Visit London
        //○	Visit New York
        //○	Visit Belgrade
        //●	Maksimizirati prozor
        //●	Ucitati stranicu https://example.cypress.io/to do
        //●	Program petljom prolazi kroz niz to do-a i svaki unosi na stranicu
        //○	Nakon svakog unosa todoa, unosi se enter. Koristan link
        //●	Nakon svih unosa proci petljom kroz svaki to do koji je na stranici i za svaki cekirati da je completed.
        //●	Cekanje od 5s
        //●	Zatvorite pretrazivac
        ArrayList<String> todo = new ArrayList<>();
        todo.add("Visit Paris"); todo.add("Visit Prague"); todo.add("Visit London");
        todo.add("Visit New York"); todo.add("Visit Belgrade");


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://example.cypress.io/todo");


        for (int i = 0; i < todo.size(); i++){
            WebElement todoNew= driver.findElement(By.cssSelector("input.new-todo"));
            todoNew.click();
            todoNew.sendKeys(todo.get(i));
            todoNew.sendKeys(Keys.ENTER);
        }


        List<WebElement> elements = driver.findElements(By.cssSelector(".toggle"));
        for (int i  = 0; i < elements.size(); i++ ){
            WebElement element= elements.get(i);
            element.click();
        }

        Thread.sleep(5000);

        driver.quit();


    }
}
