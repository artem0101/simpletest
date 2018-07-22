package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LocationPage extends BasePage {
    private final By INPUT_SEARCH_CITY_CSS = By.cssSelector("input[id=\"city__front-input\"]");

    public LocationPage(WebDriver driver) {
        super(driver);
    }

    public void searchCity(String country, String city) {
        clearInputField(INPUT_SEARCH_CITY_CSS);
        sendKeysByElement(INPUT_SEARCH_CITY_CSS, city);
        clickByElement(By.cssSelector("li[data-bem*=\"" + country + "\"]"));
    }
}

