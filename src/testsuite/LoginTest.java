package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    static String baseUrl = " https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() throws InterruptedException {
        //Find the email field and send keys on email field
        WebElement emailField = driver.findElement(By.name("username"));
        emailField.sendKeys("Admin");
        WebElement passField = driver.findElement(By.name("password"));
        passField.sendKeys("admin123");

        WebElement loginLink = driver.findElement(By.xpath("//button[@type='submit']"));
        loginLink.click();

        String expectedLoginMessage = "Dashboard";

        WebElement loginSuccess = driver.findElement(By.xpath("//h6[@class]"));

        String actualLoginMessage = loginSuccess.getText();

        Assert.assertEquals(expectedLoginMessage, actualLoginMessage);


        Thread.sleep(5000);

    }

    @After
    public void tearDown() {
        closedBrowser();
    }

}
