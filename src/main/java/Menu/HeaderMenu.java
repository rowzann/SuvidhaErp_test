package Menu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by rojandhakal on 4/30/2018.
 */
public class HeaderMenu {
WebDriver driver;
    By userMenu = By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a");
    By createUser = By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/ul/li[1]/a");
    By listUser = By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/ul/li[2]/a");

    public By getUserMenu() {
        return userMenu;
    }

    public By getCreateUser() {
        return createUser;
    }

    public By getListUser() {
        return listUser;
    }

    public HeaderMenu(WebDriver driver) {
        this.driver=driver;
    }
}
