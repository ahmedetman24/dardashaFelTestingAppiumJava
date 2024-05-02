package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class searchResultsPage extends pageBase
{
    public searchResultsPage(WebDriver driver) {super(driver);}

    @FindBy(xpath = "//*[@href='https://www.facebook.com/dardasha.fel.testing/']")
    WebElement facebookLink;

    public void openFacebookPage(Actions actions, WebDriverWait wait)
    {
        moveAndClick(facebookLink, actions, wait);
    }
}
