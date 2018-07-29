package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.ArrayList;

public class SearchPage extends BasePage {
    private final By INPUT_SEARCH_QUERY_CSS = By.cssSelector("input[id=\"text\"]");
    private final By BUTTON_SEARCH_CSS = By.cssSelector("div.search2__button button");
    private final By TAB_MORE_CSS = By.cssSelector("div[class=\"home-tabs__more\"] a");
    private final By LINK_MORE_CSS = By.cssSelector("a[data-statlog=\"tabs.more\"]");
    private final By TEXT_CURRENT_LOCATION = By.cssSelector("a[data-statlog=\"head.region.setup\"]");

    private final By LINK_VIDEO = By.cssSelector("a[data-id=\"video\"]");
    private final By LINK_PICTURES = By.cssSelector("a[data-id=\"images\"]");
    private final By LINK_NEWS = By.cssSelector("a[data-id=\"news\"]");
    private final By LINK_MAPS = By.cssSelector("a[data-id=\"maps\"]");
    private final By LINK_MARKET = By.cssSelector("a[data-id=\"market\"]");
    private final By LINK_TRANSLATE = By.cssSelector("a[data-id=\"translate\"]");
    private final By LINK_NUSIC = By.cssSelector("a[data-id=\"music\"]");
    private static String currentURL;

    public SearchPage(WebDriver driver) {
        super(driver);
        driver.get("https://www.yandex.ru/");
    }

    public void searchQuestion(String text) {
        clearInputField(INPUT_SEARCH_QUERY_CSS);
        sendKeysByElement(INPUT_SEARCH_QUERY_CSS, text);
        clickByElement(BUTTON_SEARCH_CSS);
    }

    public ArrayList<String> getTextListFromMore() {

        clickByElement(LINK_MORE_CSS);

        return new ArrayList<String>(getTextFromElements(TAB_MORE_CSS));
    }

    public void clickOnCurrentLocation() {
        clickByElement(TEXT_CURRENT_LOCATION);
    }

    public String checkTheTransition(String value) {
        currentURL = null;
        switch (value) {
            case "Видео":
                toCheck(LINK_VIDEO);
                break;
            case "Картинки":
                toCheck(LINK_PICTURES);
                break;
            case "Новости":
                toCheck(LINK_NEWS);
                break;
            case "Карты":
                toCheck(LINK_MAPS);
                break;
            case "Маркет":
                toCheck(LINK_MARKET);
                break;
            case "Переводчик":
                toCheck(LINK_TRANSLATE);
                break;
            case "Музыка":
                toCheck(LINK_NUSIC);
                break;
        }
        return currentURL;
    }

    private void toCheck(By locator) {
        clickByElement(locator);
        currentURL = getCurrentURL();
        toBack();
    }
}
