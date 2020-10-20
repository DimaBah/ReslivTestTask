package project.entities.helpers;

import project.entities.pages.OnlineCinemaPage;

public class OnlineCinemaHelper extends AbstractHelper{

    private OnlineCinemaPage onlineCinemaPage = new OnlineCinemaPage();

    public OnlineCinemaHelper selectFilmsGenre(String linkText){
        onlineCinemaPage.clickFilmsGenresDropdown().clickGenreLink(linkText);
        return new OnlineCinemaHelper();
    }

    public OnlineCinemaHelper selectSerialGenre(String linkText){
        onlineCinemaPage.clickSerialGenresDropdown().clickGenreLink(linkText);
        return new OnlineCinemaHelper();
    }

    public OnlineCinemaHelper selectCartoonGenre(String linkText){
        onlineCinemaPage.clickCartoonGenresDropdown().clickGenreLink(linkText).clickCartoonGenresDropdown();
        return new OnlineCinemaHelper();
    }

    public OnlineCinemaHelper dropCartoonGenre(){
        onlineCinemaPage.clickGenreLabel();
        return new OnlineCinemaHelper();
    }

    public String getFilmInfo(){
        return onlineCinemaPage.getFilmInfo().getText();
    }

    public OnlineCinemaHelper moveToSerialTab(){
        onlineCinemaPage.clickSerialTab();
        return new OnlineCinemaHelper();
    }

    public OnlineCinemaHelper moveToFilmsTab(){
        onlineCinemaPage.clickFilmsTab();
        return new OnlineCinemaHelper();
    }

}
