package seleniumTest;

import Client.ClientListRepo;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import login.LoginRepo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by rojandhakal on 4/26/2018.
 */

@Listeners(utility.Listeners.class)

public class ClientList {

    FirefoxDriver driver = null;
    ClientListRepo clientListRepo;

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
        clientListRepo=new ClientListRepo(driver);
    }


    @Test(enabled = false)
    public void  goToClientList(){
    }


    @Test(priority =4 )
    public void searchClientFromList(){
      String ClientName="jobejee";
        driver.findElement(clientListRepo.getSearchBox()).sendKeys(ClientName);
driver.findElement(clientListRepo.getSearchButton()).click();
        java.util.List<WebElement> collection=driver.findElements(By.xpath("/html/body/app-root/app-list-client/div/div[2]/div[2]/table/tbody/tr"));
        Assert.assertEquals(collection.size(),1);
        for( WebElement webElement:collection){
            Assert.assertNotNull(webElement);
             Assert.assertTrue(webElement.getText().toLowerCase().contains(ClientName)); ;

        }
    }


    @Test(priority = 1)
    public void dataInTable(){
        java.util.List<WebElement> tr_collection=driver.findElements(By.xpath("/html/body/app-root/app-list-client/div/div[2]/div[2]/table/tbody/tr"));
        Assert.assertEquals(tr_collection.size(),10);
    }
    @Test(priority = 3)
    public void dataInTable_20(){
        driver.findElement(clientListRepo.getFilterButton()).click();
        driver.findElement(clientListRepo.getFilterno15()).click();
        java.util.List<WebElement> tr_collection=driver.findElements(By.xpath("/html/body/app-root/app-list-client/div/div[2]/div[2]/table/tbody/tr"));
        Assert.assertEquals(tr_collection.size(),15);
    }

    @Test(priority = 2)
    public  void goTolastandFirstPage() throws  Exception{
        driver.findElement(clientListRepo.getLastPage()).click();
        Thread.sleep(1000);
        driver.findElement(clientListRepo.getFirstPage()).click();

    }


    @Test(priority = 5)
    public void RedirectionTo() throws  Exception{
        driver.findElement(clientListRepo.getSearchBox()).sendKeys(TestData.ClientName);
        driver.findElement(clientListRepo.getSearchButton()).click();
        driver.findElement(clientListRepo.getMoreAction()).click();
        driver.findElement(clientListRepo.getEditClientLink()).click();
        Assert.assertEquals(driver.getCurrentUrl(),Url.url+"/edit-client/"+TestData.ClientID);
   driver.navigate().back();
    //    Assert.assertEquals(driver.getCurrentUrl(),Url.url+"/list-Client");
        driver.findElement(clientListRepo.getSearchBox()).sendKeys(TestData.ClientName);
        driver.findElement(clientListRepo.getSearchButton()).click();
        driver.findElement(clientListRepo.getMoreAction()).click();

        driver.findElement(clientListRepo.getJobCreateLink()).click();
        Assert.assertEquals(driver.getCurrentUrl(),Url.url+"/create-job/"+TestData.ClientID);
        driver.navigate().back();
//
        driver.findElement(clientListRepo.getCreateClientLink()).click();
        Assert.assertEquals(driver.getCurrentUrl(),Url.url+"/create-Client");
        driver.navigate().back();
        driver.findElement(clientListRepo.getSearchBox()).sendKeys(TestData.ClientName);
        driver.findElement(clientListRepo.getSearchButton()).click();
        driver.findElement(clientListRepo.getMoreAction()).click();
        driver.findElement(clientListRepo.getJobsLink()).click();
        Assert.assertEquals(driver.getCurrentUrl(),Url.url+"/job-list/"+TestData.ClientID);
        driver.navigate().back();
    }
@AfterClass
    public void closeBrowser(){
        driver.close();

}


}
