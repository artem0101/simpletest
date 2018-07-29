package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.SearchPage;

public class TransitionTest extends BaseTest {
    private static SearchPage searchPage;

    private final String LINK_VIDEO = "https://yandex.ru/video/";
    private final String LINK_PICTURES = "https://yandex.ru/images/";
    private final String LINK_NEWS = "https://news.yandex.ru/";
    private final String LINK_MAPS = "https://yandex.ru/maps";
    private final String LINK_MARKET = "https://market.yandex.ru/";
    private final String LINK_TRANSLATE = "https://translate.yandex.ru/";
    private final String LINK_MUSIC = "https://music.yandex.ru/";

    @BeforeClass
    @Override
    public void setupChromeDriver() {
        super.setupChromeDriver();
        searchPage = PageFactory.initElements(driver, SearchPage.class);
    }

    @Test
    public void checkTransition() {

        Assert.assertTrue(searchPage.checkTheTransition("Видео").startsWith(LINK_VIDEO));
        Assert.assertTrue(searchPage.checkTheTransition("Картинки").startsWith(LINK_PICTURES));
        Assert.assertTrue(searchPage.checkTheTransition("Новости").startsWith(LINK_NEWS));
        Assert.assertTrue(searchPage.checkTheTransition("Карты").startsWith(LINK_MAPS));
        Assert.assertTrue(searchPage.checkTheTransition("Маркет").startsWith(LINK_MARKET));
        Assert.assertTrue(searchPage.checkTheTransition("Переводчик").startsWith(LINK_TRANSLATE));
        Assert.assertTrue(searchPage.checkTheTransition("Музыка").startsWith(LINK_MUSIC));

    }

}
