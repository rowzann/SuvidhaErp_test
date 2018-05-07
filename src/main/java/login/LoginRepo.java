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


    By username = By.xpath("//*[@id=\"email\"]");
    By password = By.xpath("//*[@id=\"password\"]");
    By loginButton = By.xpath("/html/body/app-root/app-app-login/div/div/div[2]/form/div[3]/button");
    By placeEmail = By.xpath("/html/body/app-root/app-app-login/div/div/div[2]/form/div[1]/div/p");
    By placePassword = By.xpath("/html/body/app-root/app-app-login/div/div/div[2]/form/div[2]/div/p");
    By forgetPasswordButton = By.xpath("/html/body/app-root/app-app-login/div/div/div[2]/form/div[4]/a");


    public LoginRepo(WebDriver driver) {
        this.driver = driver;
        //PageFactory.initElements(driver, this);
    }

    public void setUsername(String userName) {
        driver.findElement(username).sendKeys(userName);
    }

    public void setPassword(String passWord) {
        driver.findElement(password).sendKeys(passWord);
    }


    public void LoginClick() {
        driver.findElement(loginButton).click();
    }

    public String getPlaceholderE() {
        String pe = driver.findElement(placeEmail).getText();
        return pe;
    }

    public String getPlaceholderP() {
        return driver.findElement(placePassword).getText();

    }

    public void clickForgetPasswordButton() {
        driver.findElement(forgetPasswordButton).click();
    }


}
