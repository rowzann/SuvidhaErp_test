package seleniumTest;

import Config.UrlConfig;
import apiTEst.Credentials;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by rojandhakal on 3/13/2018.
 */
public class Login {

    FirefoxDriver driver = null;

@BeforeMethod
    public void getDriver() {
        System.setProperty("webdriver.firefox.marionette", "E:/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get(UrlConfig.url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void passLogin() throws Exception{
        Credentials c = new Credentials("Ramesh.khadka@suvidhatech.com", "password123");
        Thread.sleep(3000);
        driver.findElementByXPath("html/body/app-root/app-app-login/div/div/div[2]/form/div[1]/input").sendKeys(c.getUsername());
        driver.findElementByXPath("html/body/app-root/app-app-login/div/div/div[2]/form/div[2]/input").sendKeys(c.getPassword());
        driver.findElementByXPath("html/body/app-root/app-app-login/div/div/div[2]/form/div[3]/button").click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(), UrlConfig.url + "/list-Client");

    }



    @Test
    public void failLogin() throws Exception{
        Credentials c = new Credentials("Ramesh.khadka@suvidhatech.com","password");
        driver.findElementByXPath("html/body/app-root/app-app-login/div/div/div[2]/form/div[1]/input").sendKeys(c.getUsername());
        driver.findElementByXPath("html/body/app-root/app-app-login/div/div/div[2]/form/div[2]/input").sendKeys(c.getPassword());
        driver.findElementByXPath("html/body/app-root/app-app-login/div/div/div[2]/form/div[3]/button").click();
        Thread.sleep(3000);

        Assert.assertNotEquals(driver.getCurrentUrl(), UrlConfig.url + "/list-Client");

    }

      @AfterMethod
    public void closeBrowser(){

        driver.close();
    }

}

