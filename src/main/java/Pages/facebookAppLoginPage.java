package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;

public class facebookAppLoginPage extends pageBase
{
    public facebookAppLoginPage(WebDriver driver) {super(driver);}

    public void login(WebDriverWait wait, Actions actions) throws InterruptedException, AWTException {

        Thread.sleep(5000);

        // Login or Save Login
        checkExistenceAndClick(wait, "//*[(@content-desc=\"Log in\") or (@content-desc=\"Save\")]", actions);

        // Allow location
        checkExistenceAndClick(wait, "//android.view.ViewGroup[@content-desc=\"Allow\"]", actions);

        // Allow Location Notification
        checkExistenceAndClick(wait, "//android.widget.Button[@resource-id=\"com.android.packageinstaller:id/permission_allow_button\"]", actions);

    }
}
