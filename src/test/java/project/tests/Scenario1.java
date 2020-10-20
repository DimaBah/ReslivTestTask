package project.tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import project.entities.helpers.HomeHelper;

public class Scenario1 {

    private HomeHelper homeHelper = new HomeHelper();
    private static final Logger logger = Logger.getLogger(Scenario1.class.getName());

    @Test(enabled = false)
    public void firsttest(){
        boolean isGood = homeHelper.navigateToHomePage().isHomeLogo();
        Assert.assertTrue(isGood, "It`s no good");
    }

    @Test
    public void scenario1(){
        logger.info("Starting Scenario 1 ");
        String genre = Genres.DETECTIVE.value();
        String filmInfo = homeHelper.navigateToOnlineCinemaPage().selectFilmsGenre(genre).getFilmInfo();
        boolean isCorrectGenre = filmInfo.contains(genre) && filmInfo.matches(".*\\d{4}");
        logger.info("Working with " + genre + " & presence of date");
        logger.info("Expecting for true, Actual is  " + isCorrectGenre);
        Assert.assertTrue(isCorrectGenre);
        logger.info("Finishing Scenario 1\n");
    }

//    @AfterSuite
//    public void tearDown(){
//        homeHelper.quit();
//    }
}
