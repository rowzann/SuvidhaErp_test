package seleniumTest;


import apiTEst.Credentials;
import javafx.scene.layout.Priority;
import login.LoginRepo;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;
import utility.Screenshot;
import utility.Url;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by rojandhakal on 3/13/2018.
 */

@Listeners(utility.Listeners.class)
public class Login {

    FirefoxDriver driver = null;
    LoginRepo objLogin;

@BeforeMethod
    public void getDriver() {
    System.setProperty("webdriver.gecko.driver", "D://project//geckodriver.exe");
    DesiredCapabilities capabilities = DesiredCapabilities.firefox();
    capabilities.setCapability("marionette", true);
        driver = new FirefoxDriver(capabilities);
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(Url.url);


    }

    @Test(priority = 0)
    public  void checkPlaceholder() throws Exception{
        objLogin=new LoginRepo(driver);
        objLogin.LoginClick();

            Assert.assertEquals(objLogin.getPlaceholderE(), "Email Required");
            Assert.assertEquals(objLogin.getPlaceholderP(), "Password Required");
Thread.sleep(2000 );


    }


    @Test(priority=2)
    public void passLogin() throws Exception{

        objLogin=new LoginRepo(driver);
        objLogin.setUsername(utility.Credentials.Username);
        objLogin.setPassword(utility.Credentials.Password);
        objLogin.LoginClick();
         Thread.sleep(2000);

             Assert.assertEquals(driver.getCurrentUrl(), Url.url + "/list-Client");



    }



    @Test(priority=3)
    public void failLogin() throws Exception{

        objLogin=new LoginRepo(driver);
        objLogin.setUsername("invalid@invalid.com");
        objLogin.setPassword("invalid");
        objLogin.LoginClick();
        Assert.assertNotEquals(driver.getCurrentUrl(), Url.url + "/list-Client");

    }

    @Test
    public void forgetPassWord() throws InterruptedException {
        objLogin=new LoginRepo(driver);
        objLogin.clickForgetPasswordButton();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(),Url.url + "/forget-Password");



    }

      @AfterMethod
    public void closeBrowser(){



        driver.close();
    }

}

