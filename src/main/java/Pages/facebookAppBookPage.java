package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class facebookAppBookPage extends pageBase{
    public facebookAppBookPage(WebDriver driver) {super(driver);}

    @FindBy(xpath = "//android.view.View[@content-desc=\"Menu, tab 6 of 6\"]")
    WebElement profilesMenuButton;
    @FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.facebook.katana:id/(name removed)\"]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup")
    WebElement profileNameLabel;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"\u200Eدردشة فى التيستينج\u200E, see your profile\"]")
    WebElement dftButton;

    public String viewBookPageProfile(WebDriverWait wait, Actions actions) throws InterruptedException {
        System.out.println("Before counter");
        Thread.sleep(7000);
        System.out.println("After counter");
        moveAndClick(profilesMenuButton, actions, wait);

        wait.until(ExpectedConditions.visibilityOf(dftButton));
        String profileTitle = dftButton.getAttribute("content-desc");
        System.out.println("Profile title: "+profileTitle);
        moveAndClick(dftButton, actions, wait);

        wait.until(ExpectedConditions.visibilityOf(profileNameLabel));
        System.out.println("DFT page loaded successfully");

        return profileTitle;
    }
}
