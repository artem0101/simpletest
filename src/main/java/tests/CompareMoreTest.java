package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LocationPage;
import pages.SearchPage;

import java.util.ArrayList;

public class CompareMoreTest extends BaseTest {
    private static SearchPage searchPage;
    private static LocationPage locationPage;
    private final String CITY_LONDON = "Лондон";
    private final String COUNTRY_UK = "Великобритания";
    private final String CITY_PARIS = "Париж";
    private final String COUNTRY_FRANCE = "Франция";

    @BeforeClass
    @Override
    public void setupChromeDriver() {
        super.setupChromeDriver();
        searchPage = PageFactory.initElements(driver, SearchPage.class);
        locationPage = PageFactory.initElements(driver, LocationPage.class);
    }

    @Test
    public void coincidenceOfElements() {
        ArrayList<String> elementsForLondon;
        ArrayList<String> elementsForParis;

        searchPage.clickOnCurrentLocation();
        locationPage.searchCity(COUNTRY_UK, CITY_LONDON);
        elementsForLondon = new ArrayList<String>(searchPage.getTextListFromMore());

        searchPage.clickOnCurrentLocation();
        locationPage.searchCity(COUNTRY_FRANCE, CITY_PARIS);
        elementsForParis = new ArrayList<String>(searchPage.getTextListFromMore());

        Assert.assertTrue(elementsForLondon.containsAll(elementsForParis));

    }
}
