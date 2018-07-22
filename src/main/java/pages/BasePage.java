package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

class BasePage {
    private WebDriver driver;

    BasePage(WebDriver driver) {
        this.driver = driver;
    }

    private void waitForElement(By locator) {
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    void clearInputField(By locator) {
        waitForElement(locator);
        driver.findElement(locator).clear();
    }

    void clickByElement(By locator) {
        waitForElement(locator);
        driver.findElement(locator).click();
    }

    void sendKeysByElement(By locator, String text) {
        waitForElement(locator);
        driver.findElement(locator).sendKeys(text, Keys.RETURN);
    }

    ArrayList<String> getChildrenElements(By locator) {
        waitForElement(locator);
        ArrayList<String> textOfChildrenElements = new ArrayList<>();

        new ArrayList<>(driver.findElements(locator)).forEach(e -> {
            if (!textOfChildrenElements.contains(e.getText())) textOfChildrenElements.add(e.getText());
        });

        return textOfChildrenElements;
    }
}
