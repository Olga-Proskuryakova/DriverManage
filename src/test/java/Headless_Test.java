
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Headless_Test {
    private WebDriver driver;

    @BeforeAll
    public static void driverSetup() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    public void driverStart() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver = new ChromeDriver(options);
        driver.get("https://duckduckgo.com/");

    }
    @AfterEach
    public void driverStop() {
        if (driver!= null) {
            driver.quit();
        }
    }
    @Test
    public void headless() {
        driver.findElement(By.xpath("//*[@id=\"searchbox_input\"]"))
                .sendKeys("ОТУС" + Keys.ENTER);
        String expectedText = "Онлайн‑курсы для профессионалов, дистанционное обучение современным ...";
        WebElement firstResult = driver.findElement(By.xpath("//span[text()=\"Онлайн‑курсы для" +
                " профессионалов, дистанционное обучение современным ...\"]"));
        String actualText = firstResult.getText().trim();
        Assertions.assertEquals(expectedText, actualText);
    }
}