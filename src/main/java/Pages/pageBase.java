package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class pageBase
{
    public pageBase(WebDriver driver)
    {
        super();
        PageFactory.initElements(driver, this);
    }


    protected static void clickInsidePopupButton(WebElement popup, WebElement button, WebDriverWait wait, Actions actions)
    {
        actions.moveToElement(popup);
        actions.moveToElement(button);
        wait.until(ExpectedConditions.elementToBeClickable(button));
        button.click();
    }

    protected static void moveAndClick(WebElement button, Actions actions, WebDriverWait wait)
    {
        wait.until(ExpectedConditions.visibilityOf(button));
        actions.moveToElement(button);
        button.click();
    }

    protected static void writeTextAndEnter(WebElement textBox, WebDriverWait wait, String text)
    {
        wait.until(ExpectedConditions.visibilityOf(textBox));
        textBox.clear();
        textBox.sendKeys(text);
        textBox.sendKeys(Keys.ENTER);
    }
    protected static void writeTextWithoutWait(WebElement textBox, WebDriverWait wait, String text)
    {
        //wait.until(ExpectedConditions.visibilityOf(textBox));
        textBox.clear();
        textBox.sendKeys(text);
    }

    public static void checkExistenceAndClick(WebDriverWait wait, String xpath, Actions actions)
    {
        try {
            // Wait for the element to be visible with a timeout of 10 seconds
            WebElement targetButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

            // If element is visible, click on it
            if (targetButton.isDisplayed()) {
                moveAndClick(targetButton, actions, wait);
                //System.out.println("Clicked on target button");
            }
        } catch (TimeoutException e) {
            System.out.println("Target button is not visible within the timeout period");
        }
    }
}
