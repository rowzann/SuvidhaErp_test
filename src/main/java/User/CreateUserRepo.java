package User;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by rojandhakal on 4/30/2018.
 */
public class CreateUserRepo {

    WebDriver driver;
 By fullName= By.xpath("//*[@id=\"mat-input-0\"]");
 By email= By.xpath("//*[@id=\"mat-input-1\"]");
 By department= By.xpath("/html/body/app-root/app-create-user/div/div/div[2]/div/form/div[3]/mat-form-field/div/div[1]/div");
 By role= By.xpath("/html/body/app-root/app-create-user/div/div/div[2]/div/form/div[4]/mat-form-field/div/div[1]/div");
 By rights= By.xpath("/html/body/app-root/app-create-user/div/div/div[2]/div/form/div[5]/mat-form-field/div/div[1]/div");
 By countryCode= By.xpath("/html/body/app-root/app-create-user/div/div/div[2]/div/form/div[6]/mat-form-field[1]");
    By mobileNumber= By.xpath("//*[@id=\"mat-input-3\"]");
    By saveButton= By.xpath("/html/body/app-root/app-create-user/div/div/div[2]/div/form/div[7]/button");
    By resetButton= By.xpath("/html/body/app-root/app-create-user/div/div/div[2]/div/form/div[7]/a");
    By listUserButton= By.xpath("/html/body/app-root/app-create-user/div/div/div[1]/div/a");


    public By getFullName() {
        return fullName;
    }

    public By getEmail() {
        return email;
    }

    public By getDepartment() {
        return department;
    }

    public By getRole() {
        return role;
    }

    public By getRights() {
        return rights;
    }

    public By getCountryCode() {
        return countryCode;
    }

    public By getMobileNumber() {
        return mobileNumber;
    }

    public By getSaveButton() {
        return saveButton;
    }

    public By getResetButton() {
        return resetButton;
    }

    public By getListUserButton() {
        return listUserButton;
    }

    public CreateUserRepo(WebDriver driver) {
        this.driver=driver;
    }
}
