package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage {
    private final By INPUT_SEARCH_QUERY_CSS = By.cssSelector("input[id=\"text\"]");
    private final By BUTTON_SEARCH_CSS = By.cssSelector("div.search2__button button");

    public SearchPage(WebDriver driver) {
        super(driver);
        driver.get("https://www.yandex.ru/");
    }

    public void search(String text) {
        sendKeysByElement(INPUT_SEARCH_QUERY_CSS, text);
        clickByElement(BUTTON_SEARCH_CSS);
    }
}
