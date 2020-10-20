package project.entities.helpers;

import project.entities.pages.AbstractPage;

public class AbstractHelper {
    AbstractPage abstractPage = new AbstractPage();

    public void quit(){
        abstractPage.clearData();
        abstractPage.getDriver().quit();
    }
}
