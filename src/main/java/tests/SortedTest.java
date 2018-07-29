package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.TabletsPage;

public class SortedTest extends BaseTest {
    private static TabletsPage tabletsPage;

    @BeforeClass
    @Override
    public void setupChromeDriver() {
        super.setupChromeDriver();
        driver.get("https://market.yandex.ru/catalog/54545/list?hid=6427100&track=menuleaf&onstock=1&local-offers-first=0");
        tabletsPage = PageFactory.initElements(driver, TabletsPage.class);

    }

    @Test
    public void calc() throws InterruptedException {

        Assert.assertTrue(tabletsPage.isSorted());

        Assert.assertTrue(tabletsPage.isSorted());

    }
}

