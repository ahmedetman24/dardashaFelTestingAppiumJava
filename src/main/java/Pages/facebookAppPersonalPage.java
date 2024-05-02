package Pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class facebookAppPersonalPage extends pageBase{
    public facebookAppPersonalPage(WebDriver driver) {super(driver);}

    @FindBy(xpath = "//*[contains(@content-desc,'Search')]")
    WebElement searchIconBtn;
    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"com.facebook.katana:id/(name removed)\"]")
    WebElement searchTextBox;
    @FindBy(xpath = "(//android.view.ViewGroup[@resource-id=\"com.facebook.katana:id/(name removed)\"])[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup")
    WebElement dftPage;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Switch\"]")
    WebElement switchButton;

    public void searchOnTheBookPage(Actions actions, WebDriverWait wait, String searchKeyword, AndroidDriver driver) throws InterruptedException
    {
        // Search on the book page
        System.out.println("Before counter");
        Thread.sleep(7000);
        System.out.println("After counter");
        moveAndClick(searchIconBtn, actions, wait);
        wait.until(ExpectedConditions.visibilityOf(searchTextBox));
        writeTextWithoutWait(searchTextBox, wait, searchKeyword);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));

        moveAndClick(dftPage, actions, wait);

        moveAndClick(switchButton, actions, wait);
    }
}
