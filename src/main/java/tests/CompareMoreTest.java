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
//        driver.get("https://www.yandex.by/");
    }

    @Test
    public void coincidenceOfElements() {

         Assert.assertTrue(getResult(COUNTRY_UK, CITY_LONDON).containsAll(getResult(COUNTRY_FRANCE, CITY_PARIS)));

    }

    private ArrayList<String> getResult( String country, String city) {
        searchPage.clickOnCurrentLocation();

        locationPage.searchCity(country, city);

        return new ArrayList<>(searchPage.getElements());
    }
}
