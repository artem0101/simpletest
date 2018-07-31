package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.TabletsPage;
import java.util.ArrayList;

public class SortedTest extends BaseTest {
    private static TabletsPage tabletsPage;
    private final String referenceLinkSortedTablets = "https://market.yandex.ru/catalog/54545/list?hid=6427100&onstock=1&local-offers-first=0&how=aprice";
    private final String referenceLinkReverseSortedTablets = "https://market.yandex.ru/catalog/54545/list?hid=6427100&onstock=1&local-offers-first=0&how=dprice";

    @BeforeClass
    @Override
    public void setupChromeDriver() {
        super.setupChromeDriver();
        driver.get("https://market.yandex.ru/catalog/54545/list?hid=6427100&track=menuleaf&onstock=1&local-offers-first=0");
        tabletsPage = PageFactory.initElements(driver, TabletsPage.class);

    }

    @Test
    public void sortingCheck() throws InterruptedException {

        tabletsPage.sortedTablets();

        ArrayList<String> sortedElements = tabletsPage.getSortedTablets();
        String linkFromSortedTablets = tabletsPage.getCurrentURL();

        tabletsPage.sortedTablets();

        ArrayList<String> reverseSortedElements = tabletsPage.getSortedTablets();
        String linkReverseSortedTablets = tabletsPage.getCurrentURL();

        Assert.assertTrue(tabletsPage.compareSortedTablets(sortedElements));

        Assert.assertEquals(referenceLinkSortedTablets, linkFromSortedTablets);

        Assert.assertTrue(tabletsPage.compareSortedTablets(reverseSortedElements));

        Assert.assertEquals(referenceLinkReverseSortedTablets, linkReverseSortedTablets);

    }
}

