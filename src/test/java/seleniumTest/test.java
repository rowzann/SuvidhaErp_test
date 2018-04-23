package seleniumTest;

import login.LoginRepo;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by rojandhakal on 4/15/2018.
 */
public class test {
WebDriver driver=null;

@Test
    public void getDriver() throws Exception {
      System.setProperty("webdriver.gecko.driver", "D://project//geckodriver.exe");

    DesiredCapabilities capabilities = DesiredCapabilities.firefox();
    capabilities.setCapability("marionette", true);
    WebDriver driver = new FirefoxDriver(capabilities);
//        driver = new FirefoxDriver();
        driver.get("http://suvidhaerp.com");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

driver.findElement(By.xpath("//*[@id=\"email\"]")).clear();
driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("asdasdasd");

    TakesScreenshot scrShot =((TakesScreenshot)driver);

    //Call getScreenshotAs method to create image file

    File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

    //Move image file to new destination

    File DestFile=new File("E://Screenshot//test.png");

    //Copy file at destination

    FileUtils.copyFile(SrcFile, DestFile);

}

    @Test
    public void getDrriver() {
        System.setProperty("webdriver.chrome.driver", "E:/selenium/chrome/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.jobejee.com/#!/home");
        driver.navigate().to("https://www.jobejee.com/#!/home");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }




    }

