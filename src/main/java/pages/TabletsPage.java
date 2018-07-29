package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;

public class TabletsPage extends BasePage {

    private final By LISTBOX_BUTTON = By.cssSelector("button[role=\"listbox\"");
    private final By SELECT_CONTROL = By.cssSelector("div.select__item span");
    private final By COUNTAINS_ELEMENT = By.cssSelector("div[class*=\"n-snippet-card2 i-bem\"]");

    private final By LINK_OF_PRICE = By.cssSelector("div[data-bem*=\"price\"] a");
    private final By LABEL_OF_PRICE = By.cssSelector("a div.price");

    private final By BUTTON_COMPARE = By.cssSelector("div[class*=\"n-product-toolbar__item\"]");
    private final By BUTTON_TO_COMPARE = By.cssSelector("a[href=\"/compare?track=head\"]");
    private final By TITLE_LIST = By.cssSelector("div[class*=\"n-snippet-card2__title\"] a[title*=\"Планшет\"]");

    public TabletsPage(WebDriver driver) {
        super(driver);
    }


    public int countTablets(String value) throws InterruptedException {
        System.out.println("In TabletsPages " + value);

        scroll(LISTBOX_BUTTON);
        clickByElement(LISTBOX_BUTTON);

        select(SELECT_CONTROL, value);
        Thread.sleep(10000);

        return countElements(COUNTAINS_ELEMENT);
    }

    public boolean isSorted() throws InterruptedException {
        clickByElement(LINK_OF_PRICE);
        Thread.sleep(10000);

        ArrayList<WebElement> referElements = returnContainsElement(LABEL_OF_PRICE);
        int[] arr = new int[referElements.size()];

        for (int i = 0; i < referElements.size(); i++) {
            arr[i] = Integer.parseInt(referElements.get(i).getText().replaceAll("[\\s\u20BD]", ""));
        }

        for (int i = 1; i < arr.length; i++) {
            if (getCurrentURL().contains("how=aprice")) {
                if (!(arr[i] >= arr[i - 1])) return false;
            } else if (getCurrentURL().contains("how=hprice")) {
                if (!(arr[i] <= arr[i - 1])) return false;
            }
        }

        return true;
    }

    public ArrayList<String> compared(int i, int j) {
        ArrayList<WebElement> addToCompareButtons = returnContainsElement(BUTTON_COMPARE);
        ArrayList<String> titles = new ArrayList<>();

        clickByElement(addToCompareButtons.get(i - 1));
        clickByElement(addToCompareButtons.get(j - 1));

        titles.add(returnContainsElement(TITLE_LIST).get(i - 1).getText());
        titles.add(returnContainsElement(TITLE_LIST).get(j - 1).getText());


        clickByElement(BUTTON_TO_COMPARE);


        return titles;
    }
}
