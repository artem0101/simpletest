package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class SearchPage extends BasePage {
    private final By INPUT_SEARCH_QUERY_CSS = By.cssSelector("input[id=\"text\"]");
    private final By BUTTON_SEARCH_CSS = By.cssSelector("div.search2__button button");
    private final By TAB_MORE_CSS = By.cssSelector("div[class=\"home-tabs__more\"] a");
    private final By LINK_MORE_CSS = By.cssSelector("a[data-statlog=\"tabs.more\"]");
    private final By TEXT_CURRENT_LOCATION = By.cssSelector("a[data-statlog=\"head.region.setup\"]");

    public SearchPage(WebDriver driver) {
        super(driver);
        driver.get("https://www.yandex.by/");
    }

    public void searchQuestion(String text) {
        clearInputField(INPUT_SEARCH_QUERY_CSS);
        sendKeysByElement(INPUT_SEARCH_QUERY_CSS, text);
        clickByElement(BUTTON_SEARCH_CSS);
    }

    public ArrayList<String> getElements() {

        clickByElement(LINK_MORE_CSS);

        return new ArrayList<String>(getTextFromElements(TAB_MORE_CSS));
    }

    public void clickOnCurrentLocation() {
        clickByElement(TEXT_CURRENT_LOCATION);
    }
}
