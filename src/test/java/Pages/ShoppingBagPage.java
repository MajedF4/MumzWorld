package Pages;

import Utilities.Reusable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ShoppingBagPage {

    WebDriver driver;
    Reusable reusable = new Reusable();
    By shoppingLading = By.className("cartPage-heading-3f_");
    By increaseField = By.xpath("(//input[@name='quantity'])[2]");
    By qty = By.xpath("//span[@class='cartItemsQty-rootWithoutVerticalPadding-cwC cartItemsQty-root-1IW']");
   By proceedBtn = By.xpath("(//span[text()='Proceed to Checkout'])[2]");
   By proceedPage = By.className("signIn-title-1Ds");
   By signupLink = By.xpath("//span[text()='Sign up']");
    By priceInteger = By.xpath("(//span[@class='price-integer-2Ym'])[2]");
    By priceFraction = By.xpath("(//span[@class='price-fraction-2nk'])[2]");

    public ShoppingBagPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isShoppingPage(){
        reusable.isDisplayedWaitEvent(driver,shoppingLading,5);
        return driver.findElement(shoppingLading).isDisplayed();
    }

    public void increaseItemQty(){
        System.out.println("********* Price is: "+reusable.getPrice(driver,priceInteger,priceFraction));
        reusable.clearAndType(driver,increaseField,"5");
        driver.findElement(increaseField).click();
        reusable.isDisplayedWaitEvent(driver,qty,5);
        driver.findElement(qty).click();
        try {
            Thread.sleep(2000);
            System.out.println("********* Updated Price is: "+reusable.getPrice(driver,priceInteger,priceFraction));
        }catch (Exception ex){
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
    }
    public RegisterPage proceed(){
        driver.findElement(proceedBtn).click();
        reusable.isDisplayedWaitEvent(driver,proceedPage,5);
        driver.findElement(signupLink).click();
        return new RegisterPage(driver);
    }


}
