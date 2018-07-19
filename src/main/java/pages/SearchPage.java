package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage {
    private final WebDriver driver;
    private final By inputSearchQueryCSS = By.cssSelector("input[id=\"text\"]");
    private final By buttonSearchCSS = By.cssSelector("div.search2__button button");

    public SearchPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        driver.get("https://www.yandex.ru/");
    }

    public void search(String text) {
        sendKeysByElement(inputSearchQueryCSS, text);
        clickByElement(buttonSearchCSS);
    }
}
