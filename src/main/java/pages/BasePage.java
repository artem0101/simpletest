package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;

class BasePage {
    private WebDriver driver;

    BasePage(WebDriver driver) {
        this.driver = driver;
    }

    private void waitForElement(By locator) {
        (new WebDriverWait(driver, 10000)).until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    void clearInputField(By locator) {
        waitForElement(locator);
        driver.findElement(locator).clear();
    }

    void clickByElement(By locator) {
        waitForElement(locator);
        driver.findElement(locator).click();
    }

    void clickByElement(WebElement element) {
        element.click();
    }

    void sendKeysByElement(By locator, String text) {
        waitForElement(locator);
        driver.findElement(locator).sendKeys(text, Keys.RETURN);
    }

    ArrayList<String> getTextFromElements(By locator) {
        waitForElement(locator);
        ArrayList<String> textOfChildrenElements = new ArrayList<>();

        new ArrayList<>(driver.findElements(locator)).forEach(e -> textOfChildrenElements.add(e.getText()));

        return textOfChildrenElements;
    }

    void moveByElement(By locator) {
        waitForElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(locator)).build().perform();
    }

    int countElements(By locator) {
        waitForElement(locator);
        return new ArrayList<>(driver.findElements(locator)).size();
    }

    ArrayList<WebElement> returnContainsElement(By locator) {
        waitForElement(locator);
        return new ArrayList<>(driver.findElements(locator));
    }

    void scroll(By locator) {
        waitForElement(locator);
        WebElement element = driver.findElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }

    void select(By locator, String text) {
        waitForElement(locator);

        ArrayList<WebElement> selectedElements = (ArrayList<WebElement>) driver.findElements(locator);

        selectedElements.forEach(element -> {
            if (element.getText().equals(text)) {
                element.click();
            }
        });

    }

    String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    String getText(By locator) {
        waitForElement(locator);

        return driver.findElement(locator).getText();
    }
}
