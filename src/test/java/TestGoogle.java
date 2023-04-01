import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class TestGoogle {

    public void testChrome() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");

        waitForElementLocatedBy(driver,Duration.ofSeconds(10),By.xpath("//input[@title='Поиск']")).sendKeys("Авиационные реактивные двигатели");;

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                        .pollingEvery(Duration.ofSeconds(5))
                                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value ='Поиск в Google' and @role='button']"))).submit();
        //waitForElementLocatedBy(driver,Duration.ofSeconds(10),By.xpath("//input[@value ='Поиск в Google' and @role='button']")).submit();

        Thread.sleep(5000);

        driver.quit();

    }

    private static WebElement waitForElementLocatedBy(WebDriver driver,Duration duration, By by) {
        return new WebDriverWait(driver, duration)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
