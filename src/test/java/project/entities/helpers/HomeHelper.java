package project.entities.helpers;

import project.entities.pages.HomePage;

public class HomeHelper extends AbstractHelper{

    private HomePage homePage = new HomePage();

    public HomeHelper navigateToHomePage(){
        homePage.navigateToHomePage();
        return this;
    }

    public boolean isHomeLogo(){
        return homePage.isElementVisible(homePage.getHomeLogo());
    }

    public OnlineCinemaHelper navigateToOnlineCinemaPage(){
        navigateToHomePage();
        homePage.clickAfishaLink().clickOnlineCinemaLink();
        return new OnlineCinemaHelper();
    }

    public OnlineCinemaHelper startFromOnlineCinema(){
        homePage.moveToOnlineCinema();
        return new OnlineCinemaHelper();
    }

    public OnlineCinemaHelper startFromCartoon(){
        homePage.moveToCartoon();
        return new OnlineCinemaHelper();
    }


}
