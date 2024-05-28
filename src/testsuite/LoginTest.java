package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseUrl = "https://courses.ultimateqa.com/";


    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
        //click on the ‘Sign In’ link
        driver.findElement(By.xpath("//a[normalize-space()='Sign In']")).click();
        //* Verify the text ‘Welcome Back!’
        String expectedResult="Welcome Back!";
        String actualResult =driver.findElement(By.xpath("//h2[@class='page__heading']")).getText();
        Assert.assertEquals("Actual result displayed not correct ",expectedResult,actualResult);
    }
    @Test
    public void verifyTheErrorMessage(){
    //click on the ‘Sign In’ link
        driver.findElement(By.xpath("//a[normalize-space()='Sign In']")).click();
    //* Enter invalid username
        driver.findElement(By.xpath("//input[@id='user[email]']")).sendKeys("shubham@gmail.co");
    //* Enter invalid password
        driver.findElement(By.id("user[password]")).sendKeys("123!@#");
    //* Click on Login button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    //* Verify the error message ‘Invalid email or password.’
        String expectResult = "Invalid email or password.";
        String actualResult = driver.findElement(By.xpath("//li[@class='form-error__list-item']")).getText();
        Assert.assertEquals("Result displayed is not same as expected",expectResult,actualResult);

    }
    //    @After
//    public void tearDown() {
//        closeBrowser();
//    }

}
