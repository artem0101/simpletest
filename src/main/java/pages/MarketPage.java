package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MarketPage extends BasePage {
    private final By TOP_MENU = By.cssSelector("li[data-department=\"Компьютеры\"]  a[class*=\"topmenu__link\"]");
    private final By SUB_ITEM_OF_TOP_MENU = By.cssSelector("div.topmenu__sublist a[href*=\"hid=6427100\"]");

     public MarketPage(WebDriver driver) {
        super(driver);
        driver.get("https://market.yandex.ru/");
    }

    public void laptops() throws InterruptedException {

        moveByElement(TOP_MENU);

        Thread.sleep(5000);
        clickByElement(SUB_ITEM_OF_TOP_MENU);
    }
}
