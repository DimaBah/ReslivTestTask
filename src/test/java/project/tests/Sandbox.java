package project.tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Sandbox {

    private static final Logger logger = Logger.getLogger(Sandbox.class.getName());

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tut.by/");

        WebElement afishaLink = driver.findElement(By.xpath("//a[@href=\"https://afisha.tut.by/#ua:top_menu_www.tut.by~75\"]"));
        WebDriverWait waiter = new WebDriverWait(driver, 5);
        waiter.until(ExpectedConditions.elementToBeClickable(afishaLink));
        afishaLink.click();
        logger.info("Start");

//        WebElement onlineCinemaLink = driver.findElement(By.xpath("//a[@href=\"https://afisha.tut.by/online-cinema/\"]"));
//        waiter.until(ExpectedConditions.elementToBeClickable(onlineCinemaLink));
//        onlineCinemaLink.click();

        driver.get("https://afisha.tut.by/online-cinema/");

//        driver.findElement(By.xpath("//a[@href=\"https://afisha.tut.by/online-cinema/serial/\"]")).click();
//        System.out.print(driver.getWindowHandle()+"     ");
//        System.out.println(driver.getWindowHandles().size());
//        driver.findElement(By.xpath("//a[@data-show='animation']")).click();
//        waiter.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class=\"lists__li \"]")));
 //       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        System.out.print(driver.getWindowHandle()+"     ");
//        System.out.println(driver.getWindowHandles().size());
//        driver.findElement(By.xpath("//a[@href=\"https://afisha.tut.by/online-cinema/\"]")).click();
//        System.out.print(driver.getWindowHandle()+"     ");
//        System.out.println(driver.getWindowHandles().size());
//        driver.findElement(By.xpath("//a[@data-show='animation']")).click();
//        logger.info(driver.getWindowHandle()+"     ");
//        logger.info(driver.getWindowHandles().size());

//        WebElement filmInfo = driver.findElement(By.xpath("//div[@class=\"txt\"]"));



        WebElement genresMenu = driver.findElement(By.xpath("//button[@title=\"Жанры\"]"));
        waiter.until(ExpectedConditions.elementToBeClickable(genresMenu));
//        JavascriptExecutor executor = (JavascriptExecutor)driver;
//        executor.executeScript("arguments[0].click();", genresMenu);
//        genresMenu = driver.findElement(By.xpath("//button[@title=\"Жанры\"]"));
        waiter.until(ExpectedConditions.elementToBeClickable(genresMenu));
        genresMenu.click();
        System.out.print(driver.getWindowHandle()+"     ");
        System.out.println(driver.getWindowHandles().size());

        WebElement genreLink = driver.findElement(By.linkText(Genres.ACTION.value()));
 //       executor.executeScript("arguments[0].click();", genreLink);
        waiter.until(ExpectedConditions.elementToBeClickable(genreLink));
        genreLink.click();
        System.out.print(driver.getWindowHandle()+"     ");
        System.out.println(driver.getWindowHandles().size());
 //       driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//        waiter.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@class=\"check-label js-tabs\"]")));

        WebElement filmInfo = driver.findElement(By.xpath("//div[@class=\"txt\"]"));
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"txt\"]")));
        System.out.println(filmInfo.getText());
        Assert.assertTrue(filmInfo.getText().contains(Genres.ACTION.value()));
        driver.quit();
    }
}
