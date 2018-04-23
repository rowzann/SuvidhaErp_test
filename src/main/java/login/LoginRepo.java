package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by rojandhakal on 4/22/2018.
 */
public class LoginRepo {
    WebDriver driver;
//    @FindBy(xpath = "//*[@id=\"email\"]")
//    WebElement username;
//
//    @FindBy(xpath = "//*[@id=\"password\"]")
//    WebElement password;
//
//    @FindBy(xpath = "/html/body/app-root/app-app-login/div/div/div[2]/form/div[3]/button")
//    WebElement loginButton;



    By username = By.xpath("//*[@id=\"email\"]");
    By password = By.xpath("//*[@id=\"password\"]");
    By loginButton = By.xpath("/html/body/app-root/app-app-login/div/div/div[2]/form/div[3]/button");

    public LoginRepo(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }






    public void loginToERP(String strUserName, String strPasword) {
        //Fill user name
        driver.findElement(username).sendKeys("alex.thapa")  ;
        driver.findElement(password).sendKeys("12345");
        driver.findElement(loginButton).click();
//        this.setUsername(strUserName);
//        //Fill password
//        this.setPassword(strPasword);
//        //Click Login button
//        this.clickLogin();

    }
}
