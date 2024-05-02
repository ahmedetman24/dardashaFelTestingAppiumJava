package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class googleHomePage extends pageBase
{
    public googleHomePage(WebDriver driver) {super(driver);}

    @FindBy(xpath = "//*[@id=\"tsf\"]/div[1]/div[1]/div[1]/div[1]/div/textarea")
    WebElement googleSearchTextBox;

    public void searchOnGoogle(String searchText, WebDriverWait wait)
    {
        writeTextAndEnter(googleSearchTextBox, wait, searchText);
    }
}
