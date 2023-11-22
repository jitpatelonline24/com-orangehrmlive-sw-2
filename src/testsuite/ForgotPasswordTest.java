package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordTest extends BaseTest {

    public String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void openBrowser() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToForgotPasswordPageSuccessfully() {
        // Click the forgot password link
        WebElement forgotLink = driver.findElement(By.cssSelector("p[class^='oxd-text oxd-text--p orangehrm-login-forgot-header']"));
        forgotLink.click();
        //Expected Text display on forgot password
        String expectedText = "Reset Password";
        //Actual message should be display
        WebElement actualMessage = driver.findElement(By.xpath("//div//h6['Reset Password']"));
        //Message declaration
        String actualText = actualMessage.getText();
        //Using Assert method verify displayed messages
        Assert.assertEquals(expectedText, actualText);
    }
        @After
        public void tearDown(){
            closedBrowser();
    }
}
