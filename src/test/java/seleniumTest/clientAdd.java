package seleniumTest;




import login.LoginRepo;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utility.Url;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.awt.event.MouseEvent.MOUSE_CLICKED;

/**
 * Created by rojandhakal on 3/13/2018.
 */
@Listeners(utility.Listeners.class)
public class clientAdd {



    FirefoxDriver driver = null;
    Robot robot = null;
    LoginRepo objLogin;

    @BeforeClass
    public void getListCientPage() throws Exception {

        System.setProperty("webdriver.gecko.driver", "D://project//geckodriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        driver = new FirefoxDriver(capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(Url.url);
        objLogin=new LoginRepo(driver);
        objLogin.setUsername(utility.Credentials.Username);
        objLogin.setPassword(utility.Credentials.Password);
        objLogin.LoginClick();

        Thread.sleep(2000);
    }



    @Test(priority = 1)
    public void visitCreateClient() {

        driver.findElementByXPath("html/body/app-root/app-list-client/div/div[2]/div[1]/div[2]/div[2]/a").click();
        Assert.assertEquals(driver.getCurrentUrl(), Url.url + "/create-Client");
    }


    @Test(priority = 2,dependsOnMethods = {"visitCreateClient"})
    public void fillClientAdditionForm() throws Exception {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElementByXPath("html/body/app-root/app-create-client/div/div/div[2]/form/div/div[1]/div/div[1]/mat-form-field/div/div[1]/div/input").sendKeys("New Pokhara");
        driver.findElementByXPath("html/body/app-root/app-create-client/div/div/div[2]/form/div/div[2]/div/div[1]/mat-form-field/div/div[1]/div/mat-select/div/div[2]/div").click();

        robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(200);

        driver.findElementByXPath(" html/body/app-root/app-create-client/div/div/div[2]/form/div/div[1]/div/div[2]/mat-form-field/div/div[1]/div/mat-select/div/div[1]/span").click();
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        driver.findElementByXPath("  html/body/app-root/app-create-client/div/div/div[2]/form/div/div[2]/div/div[2]/mat-form-field/div/div[1]/div/mat-select/div/div[2]/div").click();
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        driver.findElementByXPath("html/body/app-root/app-create-client/div/div/div[2]/form/div/div[3]/div/div[1]/mat-form-field/div/div[1]/div/textarea").sendKeys("This is test for new company generation");
        driver.findElementByXPath("html/body/app-root/app-create-client/div/div/div[2]/form/div/div[4]/div/div[1]/mat-form-field[2]/div/div[1]/div/input").sendKeys("4282700");
        driver.findElementByXPath("html/body/app-root/app-create-client/div/div/div[2]/form/div/div[4]/div/div[2]/mat-form-field[1]/div/div[1]/div/input").sendKeys("01");
        driver.findElementByXPath("html/body/app-root/app-create-client/div/div/div[2]/form/div/div[4]/div/div[2]/mat-form-field[2]/div/div[1]/div/input").sendKeys("4283700");
        driver.findElementByXPath("html/body/app-root/app-create-client/div/div/div[2]/form/div/div[14]/div/div[1]/mat-form-field/div/div[1]/div/input").sendKeys("kalanki");
        WebElement element = driver.findElement(By.xpath("html/body/app-root/app-create-client/div/div/div[2]/form/div/div[17]/div/div[2]/mat-form-field/div/div[1]/div"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
        robot.keyPress(KeyEvent.VK_ENTER);
        WebElement element2 = driver.findElement(By.xpath("html/body/app-root/app-create-client/div/div/div[2]/form/div/div[9]/div/div[1]/mat-form-field/div/div[1]/div/mat-select/div/div[1]"));
        executor.executeScript("arguments[0].click();", element2);
        robot.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(1000);

        WebElement element3 = driver.findElement(By.xpath("html/body/app-root/app-create-client/div/div/div[2]/form/div/div[9]/div/div[2]/mat-form-field/div/div[1]/div/mat-select/div/div[1]"));
        executor.executeScript("arguments[0].click();", element3);
        robot.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(1000);
        WebElement element4 = driver.findElement(By.xpath("html/body/app-root/app-create-client/div/div/div[2]/form/div/div[10]/div/div[1]/mat-form-field/div/div[1]/div/mat-select/div/div[1]"));
        executor.executeScript("arguments[0].click();", element4);
        robot.keyPress(KeyEvent.VK_ENTER);


        driver.findElementByXPath("html/body/app-root/app-create-client/div/div/div[2]/form/div/div[10]/div/div[2]/mat-form-field/div/div[1]/div/input").sendKeys("kalanki");
        Thread.sleep(1000);
        WebElement element5 = driver.findElement(By.xpath("html/body/app-root/app-create-client/div/div/div[2]/form/div/div[20]/button"));
        executor.executeScript("arguments[0].click();", element5);
         Thread.sleep(2000);

        WebElement element6 = driver.findElement(By.xpath("html/body/app-root/app-create-client/div/div/div[2]/form/div/div[18]/div/span"));
        executor.executeScript("arguments[0].click();", element6);

        WebElement element7 = driver.findElement(By.xpath("html/body/app-root/app-create-client/div/div/div[2]/form/div/div[19]/div/span"));
        executor.executeScript("arguments[0].click();", element7);
        WebElement element8 = driver.findElement(By.xpath("html/body/app-root/app-create-client/div/div/div[2]/form/div/div[18]/div/span"));
        executor.executeScript("arguments[0].click();", element8);

        driver.findElementByXPath("html/body/app-root/app-create-client/div/div/div[2]/form/div/div[20]/div/div[1]/mat-form-field/div/div[1]/div/input").sendKeys("rojan dhakal");
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), Url.url + "/Client-view");

         driver.quit();
    }









    @Test(priority = 4)
    public void closeCreateClient() throws Exception{
      getListCientPage();
       visitCreateClient();
        WebElement fileUpload=driver.findElement(By.xpath("html/body/app-root/app-create-client/div/div/div[2]/form/div/div[3]/div/div[2]/div/input"));
//        fileUpload.sendKeys("C:\\Users\\rojandhakal\\Desktop\\khaja.png");

        driver.findElementByXPath(" html/body/app-root/app-create-client/div/div/div[2]/form/div/div[20]/a").click();
        Thread.sleep(1000);

            Assert.assertEquals(driver.getCurrentUrl(), Url.url + "/list-Client");

driver.quit();
        }

    }


