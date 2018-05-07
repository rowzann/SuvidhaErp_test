package seleniumTest;

import Menu.HeaderMenu;
import User.CreateUserRepo;
import apiTEst.Credentials;
import login.LoginRepo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utility.TestData;
import utility.Url;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by rojandhakal on 4/30/2018.
 */

@Listeners(utility.Listeners.class)
public class UserCreate {
    WebDriver driver ;
    LoginRepo objLogin;
     HeaderMenu menu;
     CreateUserRepo user;
    Robot robot = null;

    @BeforeClass
    public void login() {
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

            menu = new HeaderMenu(driver);
            user = new CreateUserRepo(driver);

    }

    @Test(priority = 1)
    public void goToUserCreate() throws Exception {

    driver.findElement(menu.getUserMenu()).click();
    driver.findElement(menu.getCreateUser()).click();
    Assert.assertEquals(driver.getCurrentUrl(),Url.url+"/create-User");

    }

    @Test(priority = 2)
    public void UserCreateSuccess() throws Exception {

        Random rnd = new Random();
        char c = (char) (rnd.nextInt(26) + 'a');
    driver.findElement(user.getFullName()).sendKeys(TestData.name+c);
    driver.findElement(user.getEmail()).sendKeys(TestData.email+c);

    driver.findElement(user.getDepartment()).click();
robot=new Robot();

        robot.keyPress(KeyEvent.VK_ENTER);
    robot.keyRelease(KeyEvent.VK_ENTER);
        driver.findElement(user.getRole()).click();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        driver.findElement(user.getRights()).click();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_TAB);
        driver.findElement(user.getMobileNumber()).sendKeys(TestData.number);

        Assert.assertTrue(driver.findElement(user.getSaveButton()).isDisplayed());
        Thread.sleep(2000);
        driver.findElement(user.getSaveButton()).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(),Url.url+"/list-User");
    }

    @Test(priority = 3)
    public void userShouldNotBeCreated() throws Exception {

driver.navigate().to("http://www.suvidhaerp.com/create-User");
        driver.findElement(user.getFullName()).sendKeys(TestData.name);
        driver.findElement(user.getEmail()).sendKeys(TestData.email);

        driver.findElement(user.getDepartment()).click();

        driver.findElement(user.getMobileNumber()).sendKeys(TestData.number);

        Assert.assertTrue(driver.findElement(user.getSaveButton()).isDisplayed());

        Thread.sleep(2000);

    }

    @Test(priority = 4)
    public void checkDuplicateUser() throws Exception {
        driver.navigate().refresh();
        driver.findElement(user.getEmail()).sendKeys(TestData.email);
        driver.findElement(user.getMobileNumber()).click();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"mat-error-0\"]")).isDisplayed());
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"mat-error-0\"]")).getText(),"Email Address already exist.");
    }


@AfterClass
public void close(){
    driver.close();
}


}
