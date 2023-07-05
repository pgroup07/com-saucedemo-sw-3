package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LoginTest extends Utility {

    String baseurl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        // Open browser and launch url
        openBrowser(baseurl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValid() {
        //enter "standard_user" username
        sendTextToElement(By.xpath("//input[@id='user-name']"), "problem_user");
        //Enter “secret_sauce” password
        sendTextToElement(By.xpath("//input[@id='password']"), "secret_sauce");
        //Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//input[@id='login-button']"));
        //Verify the text “PRODUCTS”
        String expectedText = "Products";
        String actualText = getTextFromElement(By.xpath("//span[@class='title']"));
        Assert.assertEquals(expectedText, actualText);

    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        //Enter “standard_user” username
        sendTextToElement(By.xpath("//input[@id='user-name']"), "standard_user");
        //Enter “secret_sauce” password
        sendTextToElement(By.xpath("//input[@id='password']"), "secret_sauce");
        //Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//input[@id='login-button']"));
        //Verify that six products are displayed on page
        int expectedMessage = 6;
        List<WebElement> totalProduct = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        int actualMessage = totalProduct.size();
        Assert.assertEquals(expectedMessage, actualMessage);

    }

    @After
    public void tearDown() {
        //Close all browser
        closeBrowser();
    }
}
