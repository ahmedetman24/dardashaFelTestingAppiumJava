package TestCases;

import io.appium.java_client.android.AndroidDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;


public class testBase
{
    public static Actions actions;
    public static WebDriverWait wait;
    public static AndroidDriver driver;
    //public static AndroidDriver<MobileElement> driver; // Specify the type parameter MobileElement
    protected FileInputStream fis;
    protected Properties props;

    @Parameters({"deviceName", "udid", "platformName", "platformVersion", "browserName", "appType"})
    @BeforeMethod
    public void openBrowser(String deviceName, String udid, String platformName, String platformVersion,
                            String browserName, String appType) throws IOException
    {
        //Read General Properties file
        String filePath = System.getProperty("user.dir")+"/src/test/java/TestData/general.properties";
        File propsFile = new File(filePath);
        fis = new FileInputStream(propsFile);
        props = new Properties();
        props.load(fis);

        //WebDriverManager.chromedriver().driverVersion("124.0.6367.82").setup(); // used in case the current Chrome version is not supported by chrome driver
        WebDriverManager.chromedriver().setup();

        // Set Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", deviceName);
        caps.setCapability("udid", udid);
        caps.setCapability("platformName", platformName);
        caps.setCapability("platformVersion", platformVersion);

        switch (appType) {
            case "browser":
                System.out.println("Open DFT from Browser");
                caps.setCapability("automationName", props.getProperty("automationName"));
                caps.setCapability("browserName", browserName);
                break;
            case "installedApp":
                System.out.println("Open DFT from Facebook App");
                caps.setCapability("automationName", props.getProperty("automationName"));
                caps.setCapability("appPackage", "com.facebook.katana");
                caps.setCapability("appActivity", "com.facebook.katana.LoginActivity");
                //caps.setCapability("appActivity", "com.facebook.katana.MainActivity");
                caps.setCapability("enforceXPath1", true);
                break;
            case "APK":
                System.out.println("APK is in progress");
                break;
        }

        System.out.println("outside switch");
        URL url = new URL(props.getProperty("serverURL"));
        System.out.println("URL: "+ url);
        driver = new AndroidDriver(url, caps);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
    }

    @AfterMethod
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
