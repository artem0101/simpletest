package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class ComparePage extends BasePage {
    private final By TITLES_LABEL = By.cssSelector("a.n-compare-head__name.link");
    private final By DELETE_ELEMENTS = By.cssSelector("div.n-compare-toolbar__action span.link__inner");
    private final By CONTENT = By.cssSelector("div.title_size_18");

    public ComparePage(WebDriver driver) {
        super(driver);
    }

    public ArrayList<String> getTabletsFromCompare() {
        ArrayList<WebElement> webElementsTitles = returnContainsElement(TITLES_LABEL);
        ArrayList<String> titles = new ArrayList<>();

        webElementsTitles.forEach(element -> {
            titles.add(element.getText());
        });

        return titles;
    }


    public String delete() throws InterruptedException {
        clickByElement(DELETE_ELEMENTS);
        Thread.sleep(1000);

        return getText(CONTENT);
    }
}


