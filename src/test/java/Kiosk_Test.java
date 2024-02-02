import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Kiosk_Test {
    private WebDriver driver;

    @BeforeAll
    public static void driverSetup() {
        WebDriverManager.chromedriver().setup();

    }
    @BeforeEach
    public void driverStart() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-fullscreen");
        driver = new ChromeDriver(options);
        driver.get("https://p.w3layouts.com/demos_new/template_demo/03-10-2020/photoflash" +
                "-liberty-demo_Free/685659620/web/index.html?_ga=2.181802926.889871791.1632394818-2083132868.1632394818");
    }
    @AfterEach
    public void driverStop() {
        if (driver!= null) {
            driver.quit();
        }
    }
    @Test
    public void fullScreen() {
        driver.findElement(By.xpath("//li[@data-id=\"id-1\"]")).click();
        WebElement element = driver.findElement(By.xpath("//div[@class='pp_content_container']"));
        Assertions.assertNotNull(element);
    }
}
