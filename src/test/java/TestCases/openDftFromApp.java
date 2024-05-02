package TestCases;

import Pages.facebookAppBookPage;
import Pages.facebookAppLoginPage;
import Pages.facebookAppPersonalPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

public class openDftFromApp extends testBase
{
    facebookAppLoginPage fbLoginPage;
    facebookAppPersonalPage fbPersonalPage;
    facebookAppBookPage fbBookPage;

    @Test(dataProvider = "facebookSearchData", dataProviderClass = dataProvidersClass.class)
    public void searchInFacebookApp(String searchKeyword) throws InterruptedException, AWTException
    {
        // Login
        fbLoginPage = new facebookAppLoginPage(driver);
        fbLoginPage.login(wait, actions);

        System.out.println("Search on DFT Page");
        fbPersonalPage = new facebookAppPersonalPage(driver);
        fbPersonalPage.searchOnTheBookPage(actions, wait, searchKeyword, driver);

        fbBookPage = new facebookAppBookPage(driver);
        String dftPage = fbBookPage.viewBookPageProfile(wait, actions);
        Assert.assertTrue(dftPage.contains(searchKeyword));
    }
}
