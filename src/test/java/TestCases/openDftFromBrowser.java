package TestCases;

import Pages.facebookPage;
import Pages.googleHomePage;
import Pages.searchResultsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class openDftFromBrowser extends testBase
{
    googleHomePage googleHomePage;
    searchResultsPage searchResultsPage;
    facebookPage facebookPage;

    @Test(dataProvider = "googleSearchData", dataProviderClass = dataProvidersClass.class)
    public void googleOpened(String url, String searchKeyword, String facebookUrl) throws InterruptedException {
        // Open Google
        driver.get(url);

        // Search on DFT
        googleHomePage = new googleHomePage(driver);
        googleHomePage.searchOnGoogle(searchKeyword, wait);
        Assert.assertTrue(driver.getTitle().contains(searchKeyword));

        //Click on Facebook link
        searchResultsPage = new searchResultsPage(driver);
        searchResultsPage.openFacebookPage(actions, wait);
        Thread.sleep(3000);
        Assert.assertTrue(driver.getCurrentUrl().contains(facebookUrl));

        //Close facebook login popup
        facebookPage = new facebookPage(driver);
        facebookPage.closeLoginPopup(wait, actions);
        Assert.assertEquals(searchKeyword, driver.getTitle());
    }
}
