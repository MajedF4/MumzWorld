package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShoppingBagPage {

    WebDriver driver;
    By shoppingLading = By.className("cartPage-heading-3f_");
    By increaseField = By.xpath("(//input[@name='quantity'])[2]");
    By qty = By.xpath("//span[@class='cartItemsQty-rootWithoutVerticalPadding-cwC cartItemsQty-root-1IW']");
    public ShoppingBagPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isShoppingPage(){
        Wait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d -> driver.findElement(shoppingLading).isDisplayed());
        return driver.findElement(shoppingLading).isDisplayed();
    }

    public void increaseItemQty(){
        WebElement increase = driver.findElement(increaseField);
        increase.clear();
        increase.sendKeys("3", Keys.ENTER);
        Wait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d -> driver.findElement(qty).isDisplayed());
        driver.findElement(qty).click();
        try {
            Thread.sleep(2000);
        }catch (Exception ex){
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
    }


}
