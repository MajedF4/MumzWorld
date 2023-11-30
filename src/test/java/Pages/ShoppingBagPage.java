package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShoppingBagPage {

    WebDriver driver;
    By shoppingLading = By.className("cartPage-heading-3f_");
    By increaseField = By.xpath("(//input[@name='quantity'])[2]");
    public ShoppingBagPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isShoppingPage(){
        Wait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d -> driver.findElement(shoppingLading).isDisplayed());
        return driver.findElement(shoppingLading).isDisplayed();
    }

    public void increaseItemQty(){

    }


}
