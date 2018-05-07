package seleniumTest;

import Menu.HeaderMenu;
import User.UserListRepo;
import login.LoginRepo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;
import utility.TestData;
import utility.Url;

import java.util.concurrent.TimeUnit;

/**
 * Created by rojandhakal on 5/2/2018.
 */

@Listeners(utility.Listeners.class)
public class UserList {
    WebDriver driver ;
    LoginRepo objLogin;
    HeaderMenu menu;
    UserListRepo userListRepo;
    @BeforeClass
    public void login() {
        System.setProperty("webdriver.gecko.driver", "D://project//geckodriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        driver = new FirefoxDriver(capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(Url.url);
        objLogin = new LoginRepo(driver);
        objLogin.setUsername(utility.Credentials.Username);
        objLogin.setPassword(utility.Credentials.Password);
        objLogin.LoginClick();

        menu = new HeaderMenu(driver);
          userListRepo =new UserListRepo(driver);

    }

    @Test(priority = 1)
    public void  goToUserList(){
        driver.findElement(menu.getUserMenu()).click();
        driver.findElement(menu.getListUser()).click();
        Assert.assertEquals(driver.getCurrentUrl(),Url.url+"/list-User");
    }

 @Test(priority = 6)
    public void searchUser(){
     driver.findElement(userListRepo.getSearchbox()).clear();
        driver.findElement(userListRepo.getSearchbox()).sendKeys(TestData.userName);
        driver.findElement(userListRepo.getSearchButton()).click();
        java.util.List<WebElement> collection=driver.findElements(By.xpath("/html/body/app-root/app-list-user/div/div[2]/div[2]/table/tbody/tr"));
        Assert.assertEquals(collection.size(),1);
        for( WebElement webElement:collection){
            Assert.assertNotNull(webElement);
            Assert.assertTrue(webElement.getText().toLowerCase().contains(TestData.userName)); ;

        }


    }
   @Test(priority = 2)
    public void dataInTable(){
    }


    @Test(priority = 3)
    public void dataInTable_20() throws InterruptedException {
driver.navigate().refresh();
        driver.findElement(userListRepo.getFilterButton()).click();
        driver.findElement(userListRepo.getFilter20()).click();
        Thread.sleep(2000);
        java.util.List<WebElement> tr_collection=driver.findElements(By.xpath("/html/body/app-root/app-list-user/div/div[2]/div[2]/table/tbody/tr"));
        Assert.assertEquals(tr_collection.size(),20);
    }

    @Test(priority = 5)
    public void nulldata(){
        driver.findElement(userListRepo.getSearchbox()).sendKeys("sdadadasdas");
        driver.findElement(userListRepo.getSearchButton()).click();
        java.util.List<WebElement> tr_collection=driver.findElements(By.xpath("/html/body/app-root/app-list-user/div/div[2]/div[2]/table/tbody/tr"));
        Assert.assertEquals(tr_collection.size(),0);
    }



   @Test(priority = 4)
    public  void goTolastandFirstPage() throws  Exception{
      driver.navigate().refresh();
        driver.findElement(userListRepo.getPageLast()).click();
        Thread.sleep(1000);
        driver.findElement(userListRepo.getPageFirst()).click();

    }

    @Test(priority = 7)
    public  void redirection() throws  Exception{

        driver.findElement(userListRepo.getEditButton()).click();
        Assert.assertEquals(driver.getCurrentUrl(),Url.url+"/edit-User/"+TestData.userId);
         driver.navigate().back();

        driver.findElement(userListRepo.getCreateUser()).click();
        Assert.assertEquals(driver.getCurrentUrl(),Url.url+"/create-User");
    }

@AfterClass
    public void close(){
        driver.close();
}
}

