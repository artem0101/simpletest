package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LocationPage extends BasePage {
    private final By INPUT_SEARCH_CITY_CSS = By.cssSelector("input[id=\"city__front-input\"]");
    private final By POPUP_LONDON_CSS = By.cssSelector("li[data-bem*=\"Великобритания\"]");
    private final By POPUP_PARIS_CSS = By.cssSelector("li[data-bem*=\"Франция\"]");

    public LocationPage(WebDriver driver) {
        super(driver);
    }

    public void searchCity(String country, String city) {
        clearInputField(INPUT_SEARCH_CITY_CSS);
        sendKeysByElement(INPUT_SEARCH_CITY_CSS, city);
        if (POPUP_LONDON_CSS.toString().contains(country)) clickByElement(POPUP_LONDON_CSS);
        else if (POPUP_PARIS_CSS.toString().contains(country)) clickByElement(POPUP_PARIS_CSS);
    }
}

