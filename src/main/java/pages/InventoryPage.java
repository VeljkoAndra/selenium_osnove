package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InventoryPage extends BasicPage{
    public InventoryPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement getAddToCartButtonForSauceLabsBackpack () {
        return driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
    }
    public void clickOnAddToCartButtonForSauceLabsBackpack () {
        getAddToCartButtonForSauceLabsBackpack().click();
    }
    public boolean doesRemoveButtonForSauceLabsBackpackExist () {
        return elementExists(By.id("remove-sauce-labs-backpack"));
    }
}

