package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ComparePage;
import pages.TabletsPage;

import java.util.ArrayList;

public class CompareElementsTest extends BaseTest {
    private static TabletsPage tabletsPage;
    private static ComparePage comparePage;

    @BeforeClass
    @Override
    public void setupChromeDriver() {
        super.setupChromeDriver();
        driver.get("https://market.yandex.ru/catalog/54545/list?hid=6427100&track=menuleaf&onstock=1&local-offers-first=0");
        tabletsPage = PageFactory.initElements(driver, TabletsPage.class);
        comparePage = PageFactory.initElements(driver, ComparePage.class);
    }

    @Test
    public void compareElements() throws InterruptedException {
        ArrayList<String> titlesFromTablets = tabletsPage.compared(1, 2);
        ArrayList<String> titlesFromCompare = comparePage.inCompare();

        Assert.assertTrue(titlesFromCompare.containsAll(titlesFromTablets));


        Assert.assertTrue(comparePage.delete().contains("Товаров нет"));
    }

}
