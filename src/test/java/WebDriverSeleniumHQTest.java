import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class WebDriverSeleniumHQTest {
    @Test
    public void commonSearchTermResultNotEmpty() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");

        waitForElementLocatedBy(driver,Duration.ofSeconds(10),By.xpath("//input[@title='Поиск']")).sendKeys("Авиационные реактивные двигатели");;

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                        .pollingEvery(Duration.ofSeconds(5))
                                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value ='Поиск в Google' and @role='button']"))).submit();
        //waitForElementLocatedBy(driver,Duration.ofSeconds(10),By.xpath("//input[@value ='Поиск в Google' and @role='button']")).submit();

        List<WebElement> searchResults = driver.findElements(By.xpath("//span[*[text()='двигатель']]"));

        driver.quit();

        Assert.assertTrue(searchResults.size()>0, "The search yielded no results");


    }

    private static WebElement waitForElementLocatedBy(WebDriver driver,Duration duration, By by) {
        return new WebDriverWait(driver, duration)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
