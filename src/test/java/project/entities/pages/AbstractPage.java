package project.entities.pages;

import core.FrameworkCore;
import core.utils.PauseLenght;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AbstractPage extends FrameworkCore {

    private static WebDriver driver = getInstance();
    private static final Logger logger = Logger.getLogger(AbstractPage.class.getName());

    public WebDriver getDriver(){
        return driver;
    }

    public void openUrl (String url){
        driver.manage().window().maximize();
        driver.get(url);
        logger.info(driver + "  " + url);
    }

    public void refreshPage(){
        driver.navigate().refresh();
    }

    public void clearData(){
        driver.manage().deleteAllCookies();
    }

    public static void waitForElementVisible(final By by){
        try{
            WebDriverWait waiter = new WebDriverWait(driver, PauseLenght.MIN.value());
            waiter.until(ExpectedConditions.presenceOfElementLocated(by));
        }catch (Throwable e){
            logger.warn(e.getLocalizedMessage(), e);
        }
    }

    public static void waitForElementClickable (final By by){
        try{
            WebDriverWait waiter = new WebDriverWait(driver, PauseLenght.MAX.value());
            waiter.until(ExpectedConditions.elementToBeClickable(by));
        } catch (Throwable e){
            logger.warn(e.getLocalizedMessage(), e);
        }
    }

    public boolean isElementVisible(By by){
        try{
            driver.manage().timeouts().implicitlyWait(PauseLenght.AVG.value(), TimeUnit.SECONDS);
            List<WebElement> list = driver.findElements(by);

            if (list.size() == 0){
                return false;
            } else {
                try {
                    return list.get(0).isDisplayed();
                } catch (StaleElementReferenceException e){
                    logger.error(e.getLocalizedMessage(), e);
                    return false;
                }
            }
        } finally {
            driver.manage().timeouts().implicitlyWait(PauseLenght.AVG.value(), TimeUnit.SECONDS);
        }
    }

    public static By getElementBy(String xpath){
        logger.info("Looking for By " + xpath);
        return By.xpath(xpath);
    }

    public WebElement getElement(String xpath){
        logger.info("Looking for " + xpath);
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement getElementByLinkText(String linkText){
        logger.info("Looking for linkText " + linkText);
        return driver.findElement(By.linkText(linkText));
    }

    public void moveToEl(String element){
        Actions actions = new Actions(getDriver());
        waitForElementVisible(getElementBy(element));
        actions.moveToElement(getElement(element));
        actions.perform();
    }

}
