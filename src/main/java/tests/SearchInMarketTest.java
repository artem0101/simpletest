package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.MarketPage;
import pages.TabletsPage;

public class SearchInMarketTest extends BaseTest {
    private static MarketPage marketPage;
    private static TabletsPage tabletsPage;

    @BeforeClass
    @Override
    public void setupChromeDriver() {
        super.setupChromeDriver();
        marketPage = PageFactory.initElements(driver, MarketPage.class);
        tabletsPage = PageFactory.initElements(driver, TabletsPage.class);

    }

    @Test
    public void seeTablets() throws InterruptedException {
        int twelveElements;
        int fortyEightElements;

        marketPage.chouiceSubgroupTablets();

        tabletsPage.changeCountOfDisplayedTablets("Показывать по 12");
        twelveElements = tabletsPage.getCountTablets();

        tabletsPage.changeCountOfDisplayedTablets("Показывать по 48");
        fortyEightElements = tabletsPage.getCountTablets();

        Assert.assertEquals(12, twelveElements);
        Assert.assertEquals(48, fortyEightElements);

    }
}
