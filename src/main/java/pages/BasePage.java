package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class BasePage {
    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElement(By locator) {
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void clearInputField(By locator) {
        waitForElement(locator);
        driver.findElement(locator).clear();
    }

    public void clickByElement(By locator) {
        waitForElement(locator);
        driver.findElement(locator).click();
    }

    public void sendKeysByElement(By locator, String text) {
        waitForElement(locator);
        driver.findElement(locator).sendKeys(text, Keys.RETURN);
    }

    public ArrayList<String> getChildrenElements(By locator) {
        waitForElement(locator);
        ArrayList<String> textOfChildrenElements = new ArrayList<>();

        new ArrayList<>(driver.findElements(locator)).forEach(e -> {
            if (!textOfChildrenElements.contains(e.getText())) textOfChildrenElements.add(e.getText());
        });

        return textOfChildrenElements;
    }
}
