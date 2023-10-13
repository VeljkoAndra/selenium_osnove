package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage extends BasicPage{
    private String checkoutPageUrl = "https://www.saucedemo.com/checkout-step-one.html";
    public CheckoutPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public String getCheckoutPageUrl() {
        return checkoutPageUrl;
    }
}
