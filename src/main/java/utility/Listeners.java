package utility;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;


/**
 * Created by rojandhakal on 4/23/2018.
 */


public class Listeners implements ITestListener {
    private WebDriver driver=null;
    String filePath="E:\\Screenshot";
    public void onFinish(ITestContext Result) {
        // TODO Auto-generated method stub

    }


    public void onStart(ITestContext Result) {
        System.out.println(Result.getName()+" Started");

    }


    public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {
        // TODO Auto-generated method stub

    }


    public void onTestFailure(ITestResult Result)  {
        System.out.println("***** Error "+Result.getName()+" test has failed *****");
        String methodName=Result.getName().toString().trim();

      //  takeScreenShot(methodName);

    }

//    public void takeScreenShot(String methodName) {
//        //get the driver
//
//        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        //The below method will save the screen shot in d drive with test method name
//        try {
//            FileUtils.copyFile(scrFile, new File(filePath+methodName+".png"));
//            System.out.println("***Placed screen shot in "+filePath+" ***");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//    }


    public void onTestSkipped(ITestResult Result) {
        // TODO Auto-generated method stub

    }


    public void onTestStart(ITestResult Result) {
        System.out.println(Result.getName()+" Started");

    }


    public void onTestSuccess(ITestResult Result) {
        System.out.println(Result.getName()+" passed successfully ");

    }



}
