package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LeftNavPage extends BasicPage{
    public LeftNavPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement getMenuButton () {
        return driver.findElement(By.id("react-burger-menu-btn"));
    }
    public void clickOnMenuButton () {
        getMenuButton().click();
    }
    public WebElement getLeftMenu () {
        return driver.findElement(By.cssSelector(".bm-menu"));
    }
    public void waitForLeftMenuToBeVisible () {
        wait    .withMessage("Left menu is not visible.")
                .until(ExpectedConditions.visibilityOf(getLeftMenu()));
    }
    public WebElement getButtonLogout () {
        return driver.findElement(By.id("logout_sidebar_link"));
    }
    public void clickOnButtonLogout () {
        getButtonLogout().click();
    }
    public boolean doesLogoutButtonExist () {
        return elementExists(By.linkText("Logout"));
    }

}






