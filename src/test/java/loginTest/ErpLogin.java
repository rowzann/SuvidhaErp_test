package loginTest;

import login.LoginRepo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utility.Url;

import java.util.concurrent.TimeUnit;

/**
 * Created by rojandhakal on 4/22/2018.
 */
public class ErpLogin {

    WebDriver driver;
    LoginRepo objLogin;

    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.gecko.driver", "D://project//geckodriver.exe");

        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        WebDriver driver = new FirefoxDriver(capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(Url.url);
    }

    @Test(priority=0)
    public void testlogin(){

        objLogin = new LoginRepo(driver);

       // String loginPageTitle = objLogin.getLoginTitle();
     //   Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));

        objLogin.loginToERP("alex.thapa@suvidhatech.com", "12345");




    }

}
