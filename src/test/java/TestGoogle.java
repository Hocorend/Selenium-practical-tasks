import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestGoogle {

    public void testGoogle() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");

        Thread.sleep(5000);

        driver.quit();

    }

    public void  testFirefox() throws InterruptedException{
        WebDriver driver = new FirefoxDriver();
        driver.get("https://google.com");

        Thread.sleep(5000);

        driver.quit();
    }
}
