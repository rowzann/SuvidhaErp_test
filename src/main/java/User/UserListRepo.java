package User;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by rojandhakal on 5/2/2018.
 */
public class UserListRepo {

    WebDriver driver;

    By searchbox = By.xpath("/html/body/app-root/app-list-user/div/div[2]/div[1]/div[1]/form/div/input");
    By filterButton=By.xpath("/html/body/app-root/app-list-user/div/div[2]/div[1]/div[2]/div[1]/div/a");
    By searchButton=By.xpath("/html/body/app-root/app-list-user/div/div[2]/div[1]/div[1]/form/div/div/button");
    By filter20=By.xpath("/html/body/app-root/app-list-user/div/div[2]/div[1]/div[2]/div[1]/div/ul/li[3]/a");
    By createUser=By.xpath("/html/body/app-root/app-list-user/div/div[2]/div[1]/div[2]/div[2]/a");
    By editButton=By.xpath("/html/body/app-root/app-list-user/div/div[2]/div[2]/table/tbody/tr[1]/td[9]/a");
    By pageLast=By.xpath("/html/body/app-root/app-list-user/div/div[2]/div[2]/div/nav/ul/li[9]/a");
    By pageFirst=By.xpath("/html/body/app-root/app-list-user/div/div[2]/div[2]/div/nav/ul/li[1]/a");


    public By getSearchbox() {
        return searchbox;
    }

    public By getFilterButton() {
        return filterButton;
    }

    public By getSearchButton() {
        return searchButton;
    }

    public By getFilter20() {
        return filter20;
    }

    public By getCreateUser() {
        return createUser;
    }

    public By getEditButton() {
        return editButton;
    }

    public By getPageLast() {
        return pageLast;
    }

    public By getPageFirst() {
        return pageFirst;
    }

    public UserListRepo(WebDriver driver) {
        this.driver=driver;
    }
}
