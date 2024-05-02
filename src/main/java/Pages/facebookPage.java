package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class facebookPage extends pageBase{
    public facebookPage(WebDriver driver) {super(driver);}

    @FindBy(xpath = "//*[@id=\"screen-root\"]/div/div[3]/div/div[4]/div[2]/div[1]")
    WebElement loginPopup;
    @FindBy(xpath = "//*[@id=\"screen-root\"]/div/div[3]/div/div[4]/div[2]/div[1]/div/div[2]")
    WebElement closePopupBtn;

    public void closeLoginPopup(WebDriverWait wait, Actions actions)
    {
        clickInsidePopupButton(loginPopup, closePopupBtn, wait, actions);
    }
}
