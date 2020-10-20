package project.entities.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

public class OnlineCinemaPage extends AbstractPage{

    private static String afishaLogo = "//a[@href=\"/\"]";
    private String filmsGenresDropdown = "//button[@title=\"Жанры\"]";
    private String genreLink = "//span[@class=\"text\"]";
    private String filmInfo = "//div[@class=\"txt\"]";
    private String genreLabel = "//i[@class=\"b-icon icon-remove-white check-remove\"]";   //"//label[@class=\"check-label js-tabs\"]";
    private String serialTab = "//a[@href=\"https://afisha.tut.by/online-cinema/serial/\"]";
    private String filmsTab = "//a[@href=\"https://afisha.tut.by/online-cinema/\"]";
    private String serialGenresDropdown =  "//div[@id='tab-tv-series']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/button[1]";
    private String cartoonGenresDropdown = "//div[@id='tab-cartoons']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/button[1]/span[1]";

    private static final Logger logger = Logger.getLogger(OnlineCinemaPage.class.getName());

    public static OnlineCinemaPage getOnlineCinemaPage(){
        OnlineCinemaPage onlineCinemaPage = new OnlineCinemaPage();
        waitForElementVisible(getElementBy(afishaLogo));
        logger.info("Online Cinema Page is opened");
        return onlineCinemaPage;
    }

    public OnlineCinemaPage clickFilmsGenresDropdown(){
        waitForElementVisible(getElementBy(filmInfo));
        waitForElementClickable(getElementBy(filmsGenresDropdown));
        getElement(filmsGenresDropdown).click();
        return getOnlineCinemaPage();
    }

    public OnlineCinemaPage clickSerialGenresDropdown(){
        waitForElementVisible(getElementBy(filmInfo));
        waitForElementClickable(getElementBy(serialGenresDropdown));
        getElement(serialGenresDropdown).click();
        return getOnlineCinemaPage();
    }

    public OnlineCinemaPage clickCartoonGenresDropdown(){
        waitForElementVisible(getElementBy(filmInfo));
        waitForElementClickable(getElementBy(cartoonGenresDropdown));
        getElement(cartoonGenresDropdown).click();
        return getOnlineCinemaPage();
    }

    public OnlineCinemaPage clickGenreLabel(){
        waitForElementVisible(getElementBy(filmInfo));
        waitForElementClickable(getElementBy(genreLabel));
        getElement(genreLabel).click();
        return getOnlineCinemaPage();
    }

    public OnlineCinemaPage clickGenreLink(String linkText){
        waitForElementVisible(getElementBy(genreLink));
        getElementByLinkText(linkText).click();
        waitForElementVisible(getElementBy(genreLabel));
        return getOnlineCinemaPage();
    }

    public WebElement getFilmInfo(){
        waitForElementVisible(getElementBy(filmInfo));
        return getElement(filmInfo);
    }

    public OnlineCinemaPage clickSerialTab(){
        waitForElementClickable(getElementBy(serialTab));
        getElement(serialTab).click();
        waitForElementClickable(getElementBy(serialTab));
        return getOnlineCinemaPage();
    }

    public OnlineCinemaPage clickFilmsTab(){
        waitForElementClickable(getElementBy(filmsTab));
        getElement(filmsTab).click();
        return getOnlineCinemaPage();
    }


}
