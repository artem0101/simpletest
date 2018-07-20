package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultPage extends BasePage {
    private WebDriver driver;
    private final By LINK_SEARCH_CSS = By.cssSelector("li[data-cid=\"0\"] div.organic__url-text");

    public ResultPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String readText() {
        return driver.findElement(LINK_SEARCH_CSS).getText();
    }
}
