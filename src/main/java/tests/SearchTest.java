package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ResultPage;
import pages.SearchPage;

public class SearchTest extends BaseTest {
    private static SearchPage searchPage;
    private static ResultPage resultPage;
    private final String searchQuery = "погода пенза";

    @BeforeClass
    @Override
    public void setup() {
        super.setup();
        searchPage = PageFactory.initElements(driver, SearchPage.class);
        resultPage = PageFactory.initElements(driver,ResultPage.class);
    }

    @Test
    public void searchWeather() {

        searchPage.search(searchQuery);

        Assert.assertTrue(resultPage.readText().toLowerCase().contains("погода"));
    }
}
