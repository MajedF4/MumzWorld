package TestCases;

import Pages.RegisterPage;
import Pages.SearchPage;
import Pages.ShoppingBagPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class TestCases{

    public WebDriver driver;
    SearchPage searchPage;
    ShoppingBagPage shoppingBagPage;
    RegisterPage registerPage;
    public static String url = "https://www.mumzworld.com/";
    String firstName = "User1";
    String lastName = "User";
    String phoneNumber = "7400123456";


    @BeforeTest
    public void setup(){
        FirefoxOptions options = new FirefoxOptions();
        options.setAcceptInsecureCerts(true);
        driver = new FirefoxDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        driver.get(url);
    }

    @Test(priority = 1)
    public void searchOperationTest(){
        searchPage = new SearchPage(driver);
        searchPage.search("Aery");
    }

    @Test(priority = 2)
    public void clickOnSearchedProductTest(){
        searchPage = new SearchPage(driver);
        searchPage.search("Aery");
        String productAssert = searchPage.clickOnProduct();
        Assert.assertEquals(productAssert,"Aery - Indian Sandalwood Candle - Black");
    }
    @Test(priority = 3)
    public void addItemToBagTest(){
        searchPage = new SearchPage(driver);
        String addItemAssert = searchPage.addItemToBag();
        Assert.assertEquals(addItemAssert,"Successfully added to bag");
    }

    @Test(priority = 4)
    public void increaseItemQtyTest(){
        shoppingBagPage = searchPage.goToViewBagPage();
        boolean increaseAssert = shoppingBagPage.isShoppingPage();
        Assert.assertTrue(increaseAssert);
        shoppingBagPage.increaseItemQty();
    }

    @Test(priority = 5)
    public void registrationStopOneTest(){
        registerPage = shoppingBagPage.proceed();
        registerPage.registrationStepOne(firstName,lastName,
                "qa.engineer202311@gmail.com","MumzWord@1234");
    }

    @Test(priority = 6)
    public void registrationStopTwoTest(){
       String actual = registerPage.registrationStepTwo("City 2","St 1",
                "32",phoneNumber);
       Assert.assertEquals(actual,"+44"+phoneNumber);
    }
    @AfterTest
    public void teardown(){
        driver.close();
    }

}
