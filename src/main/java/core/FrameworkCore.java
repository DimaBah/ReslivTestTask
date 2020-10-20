package core;

import core.utils.BrowserConstants;
import core.utils.IOUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FrameworkCore {
    private static WebDriver driver;
    public static String browser = IOUtils.loadGenericProperty("browser", "configuration");
    public static String baseUrl = IOUtils.loadGenericProperty("baseUrl", "configuration");
    public static String onlineCinemaUrl = IOUtils.loadGenericProperty("onlineCinemaUrl", "configuration");
    public static String cartoonUrl = IOUtils.loadGenericProperty("cartoonUrl", "configuration");

    public static WebDriver getInstance(){
        if(browser.equals(BrowserConstants.CHROME)){
            driver = new ChromeDriver();
        } else {
            if(browser.equals(BrowserConstants.FIREFOX)){
                driver = new FirefoxDriver();
            } else {
                throw new IllegalArgumentException ("Browser value is incorrect");
            }
        }
        return driver;
    }
}
