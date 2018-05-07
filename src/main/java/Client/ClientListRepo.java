package Client;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by rojandhakal on 4/26/2018.
 */
public class ClientListRepo {
    WebDriver driver;
  By searchBox = By.xpath("/html/body/app-root/app-list-client/div/div[2]/div[1]/div[1]/form/div/input");
  By searchButton = By.xpath("/html/body/app-root/app-list-client/div/div[2]/div[1]/div[1]/form/div/div/button");
  By filterButton = By.xpath("/html/body/app-root/app-list-client/div/div[2]/div[1]/div[2]/div[1]/div/a");
    By filterno15 = By.xpath("/html/body/app-root/app-list-client/div/div[2]/div[1]/div[2]/div[1]/div/ul/li[2]/a");
    By firstPage = By.xpath("/html/body/app-root/app-list-client/div/div[2]/div[2]/div/nav/ul/li[1]/a/span");
    By lastPage = By.xpath("/html/body/app-root/app-list-client/div/div[2]/div[2]/div/nav/ul/li[18]/a/span");
     By createClientLink =By.xpath("/html/body/app-root/app-list-client/div/div[2]/div[1]/div[2]/div[2]/a");
     By moreAction =By.xpath("//*[@id=\"dropdownMenu1\"]");
     By editClientLink =By.xpath("/html/body/app-root/app-list-client/div/div[2]/div[2]/table/tbody/tr[1]/td[9]/div/ul/li[1]/a");

     By JobCreateLink =By.xpath("/html/body/app-root/app-list-client/div/div[2]/div[2]/table/tbody/tr[1]/td[9]/div/ul/li[2]/a");
     By JobsLink =By.xpath("/html/body/app-root/app-list-client/div/div[2]/div[2]/table/tbody/tr[1]/td[9]/div/ul/li[3]/a");
     By ClientName =By.xpath("/html/body/app-root/app-list-client/div/div[2]/div[2]/table/tbody/tr/td[2]/a");



    public By getSearchBox() {
        return searchBox;
    }

    public By getSearchButton() {
        return searchButton;
    }

    public ClientListRepo(WebDriver driver) {
        this.driver = driver;

    }

    public By getClientName() {
        return ClientName;
    }

    public By getCreateClientLink() {
        return createClientLink;
    }

    public By getMoreAction() {
        return moreAction;
    }

    public By getEditClientLink() {
        return editClientLink;
    }

    public By getJobCreateLink() {
        return JobCreateLink;
    }

    public By getJobsLink() {
        return JobsLink;
    }

    public By getFilterButton() {
        return filterButton;
    }

    public By getFilterno15() {
        return filterno15;
    }

    public By getFirstPage() {
        return firstPage;
    }

    public By getLastPage() {
        return lastPage;
    }
}
