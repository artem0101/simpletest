import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class SeleniumTestMain {
    private WebDriver driver;
    private WebDriverWait wait;
    private WebElement inputTextField;
    private WebElement searchButton;
    private WebElement searchLinkText;
    private String wordFromLink;
    private final String searchQuery = "погода пенза";

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.yandex.ru/");
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void searchWeather() {
        inputTextField = wait.until(visibilityOfElementLocated(By.cssSelector("input[id=\"text\"]")));
        searchButton = wait.until(visibilityOfElementLocated(By.cssSelector("div.search2__button button")));

        inputTextField.sendKeys(searchQuery);

        searchButton.click();

        searchLinkText = wait.until(visibilityOfElementLocated(By.cssSelector("li[data-cid=\"0\"] div.organic__url-text")));

        wordFromLink = searchLinkText.getText().toLowerCase();

        Assert.assertTrue(wordFromLink.contains("погода"));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
