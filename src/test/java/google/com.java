package google;

import Config.UrlConfig;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by rojandhakal on 3/18/2018.
 */
public class com {



    FirefoxDriver driver=null;

    @Test
    public void getListCientPage() throws Exception{
        System.setProperty("webdriver.firefox.marionette", "E:/geckodriver.exe");

        driver = new FirefoxDriver();
        driver.get("https://www.google.com.np/?gws_rd=cr&dcr=0&ei=PQeuWp6rKsXfvgTt4L-QAQ");
        driver.findElementsByXPath("html/body/div/div[3]/form/div[2]/div[2]/div[1]/div[1]/div[2]/div/div/div[2]/div/input[1]").clear();
        driver.findElementByXPath("html/body/div/div[3]/form/div[2]/div[2]/div[1]/div[1]/div[2]/div/div/div[2]/div/input[1]").click();
        driver.findElementByXPath("html/body/div/div[3]/form/div[2]/div[2]/div[1]/div[1]/div[2]/div/div/div[2]/div/input[1]").sendKeys("java");
        Thread.sleep(3000);
        driver.findElementByXPath("html/body/div/div[3]/form/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/div/ul/li[4]/div/div[2]").click();

    }
}
