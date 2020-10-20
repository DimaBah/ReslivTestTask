package project.tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;
import project.entities.helpers.HomeHelper;
import project.entities.helpers.OnlineCinemaHelper;

public class Scenario3 {

    HomeHelper homeHelper = new HomeHelper();
    OnlineCinemaHelper onlineCinemaHelper = new OnlineCinemaHelper();
    private static final Logger logger = Logger.getLogger(Scenario3.class.getName());

    @BeforeTest
    public void startFromCartoon(){
        homeHelper.startFromCartoon();
    }

    @Test(dataProvider = "genres")
    public void scenario3(String genre){
        logger.info("Starting Scenario 3 ");
        boolean isCorrectGenre = onlineCinemaHelper.selectCartoonGenre(genre).getFilmInfo().contains(genre);
        logger.info("Working with " + genre);
        logger.info("Expecting for true, Actual is  " + isCorrectGenre);
        Assert.assertTrue(isCorrectGenre);
        onlineCinemaHelper.dropCartoonGenre();
        logger.info("Finishing Scenario 3\n");
    }

    @DataProvider(name = "genres")
    public Object[][] genres(){
        return new Object[][]{{Genres.COMEDY.value()}, {Genres.ACTION.value()}, {Genres.DETECTIVE.value()}, {Genres.FANTASTIC.value()}};
    }

    @AfterSuite
    public void tearDown(){
        homeHelper.quit();
    }
}
