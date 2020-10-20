package project.entities.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class HomePage extends AbstractPage{
    private static String homeLogo = "//a[@href=\"https://www.tut.by/\"]";
    private String afishaLink = "//a[@href=\"https://afisha.tut.by/#ua:top_menu_www.tut.by~75\"]";
    private String onlineCinemaLink = "//a[@href=\"https://afisha.tut.by/online-cinema/\"]";

    private static final Logger logger = Logger.getLogger(HomePage.class.getName());


    public static  HomePage getHomePage(){
        HomePage homePage = new HomePage();
//        waitForElementVisible(getElementBy(homeLogo));
        logger.info("Home Page is opened");
        return homePage;
    }

    public By getHomeLogo(){
        waitForElementVisible(getElementBy(homeLogo));
        return getElementBy(homeLogo);
    }

    public HomePage navigateToHomePage (){
        openUrl(baseUrl);
        return getHomePage();
    }

    public HomePage clickAfishaLink(){
        waitForElementVisible(getElementBy(afishaLink));
        getElement(afishaLink).click();
        return HomePage.getHomePage();
    }

    public OnlineCinemaPage clickOnlineCinemaLink(){
        waitForElementVisible(getElementBy(onlineCinemaLink));
        getElement(onlineCinemaLink).click();
        return OnlineCinemaPage.getOnlineCinemaPage();
    }

    public OnlineCinemaPage moveToOnlineCinema (){
        openUrl(onlineCinemaUrl);
        return OnlineCinemaPage.getOnlineCinemaPage();
    }

    public OnlineCinemaPage moveToCartoon () {
        openUrl(cartoonUrl);
        return OnlineCinemaPage.getOnlineCinemaPage();
    }


    }
