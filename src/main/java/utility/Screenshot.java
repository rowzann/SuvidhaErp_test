package utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

/**
 * Created by rojandhakal on 4/24/2018.
 */


public class Screenshot  {
    WebDriver driver;
    public Screenshot getScreenShot(WebDriver driver) {

        TakesScreenshot scrShot =((TakesScreenshot)driver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File("E://Screenshot//"+"test.png");
 try {
     FileUtils.copyFile(SrcFile, DestFile);
 }catch (Exception e){

 }


        return null;
    }
}
