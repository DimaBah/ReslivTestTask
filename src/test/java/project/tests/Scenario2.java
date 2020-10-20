package project.tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import project.entities.helpers.HomeHelper;
import project.entities.helpers.OnlineCinemaHelper;

public class Scenario2 {

    HomeHelper homeHelper = new HomeHelper();
    OnlineCinemaHelper onlineCinemaHelper = new OnlineCinemaHelper();
    private static final Logger logger = Logger.getLogger(Scenario2.class.getName());

    @BeforeTest
    public void startFromOnlineCinema(){
        homeHelper.startFromOnlineCinema();
    }

    @Test
    public void scenario2(){
        logger.info("Starting Scenario 2 ");
        String genre = Genres.FANTASTIC.value();
        boolean isCorrectGenre = onlineCinemaHelper.moveToSerialTab().selectSerialGenre(genre).getFilmInfo().contains(genre);
        logger.info("Working with " + genre);
        logger.info("Expecting for true, Actual is  " + isCorrectGenre);
        Assert.assertTrue(isCorrectGenre);
        logger.info("Finishing Scenario 2\n");
    }

//    @AfterSuite
//    public void tearDown(){
//        homeHelper.quit();
//    }

}
