import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class SeleniumTestMain {
    private WebDriver driver;
    private WebDriverWait wait;
    private WebElement inputTextField;
    private WebElement searchButton;
    private WebElement searchLinkText;
    private String wordFromLink;
    private final String searchQuery = "погода пенза";
    private static ArrayList<String> missingWords = new ArrayList<>();

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.yandex.ru/");
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void searchWeather() throws Exception {
        inputTextField = wait.until(visibilityOfElementLocated(By.cssSelector("input[id=\"text\"]")));
        searchButton = wait.until(visibilityOfElementLocated(By.cssSelector("div.search2__button button")));

        inputTextField.sendKeys(searchQuery);

        searchButton.click();

        searchLinkText = wait.until(visibilityOfElementLocated(By.cssSelector("li[data-cid=\"0\"] div.organic__url-text")));

        ArrayList<String> wordsFromSearchQuery = new ArrayList<>(Arrays.asList(searchQuery.split("\\s")));

        wordFromLink = " 1 2 43 погода в пензе";

        // используя этот вариант можено определить есть какое слово из запроса есть в тексте ссылки, а какое нет
        wordsFromSearchQuery.forEach(word -> {
            try {
                Assert.assertTrue(wordFromLink.contains(word));
                System.out.println("Слово из запроса \"" + word + "\" есть в первой ссылке.");
            } catch (AssertionError e) {
                System.out.println("Слово из запроса \"" + word + "\" нет в первой ссылке.");
            }
        });

        // решение умещается в строку, но прекращает работу когда слово находится - падает в ошибку, тем самым завершив тест
        wordsFromSearchQuery.forEach(word -> Assert.assertFalse(wordFromLink.contains(word), "Слово из запроса \"" + word + "\" есть в первой ссылке."));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
