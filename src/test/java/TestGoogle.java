import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestGoogle {

    public void testChrome() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");

        driver.findElement(By.xpath("//input[@title='Поиск']")).sendKeys("Авиационные реактивные двигатели");

        driver.findElement(By.xpath("//input[@value ='Поиск в Google' and @role='button']")).submit();

        Thread.sleep(5000);

        driver.quit();

    }

    public void  testEdge() throws InterruptedException{
        WebDriver driver = new EdgeDriver();
        driver.get("https://google.com");
        driver.findElement(By.xpath("//input[@title='Поиск']")).sendKeys("Авиационные реактивные двигатели");

        driver.findElement(By.xpath("//input[@value ='Поиск в Google' and @role='button']")).submit();

        Thread.sleep(5000);

        driver.quit();
    }

    public void  testFirefox() throws InterruptedException{
        WebDriver driver = new FirefoxDriver();
        driver.get("https://google.com");
        driver.findElement(By.xpath("//input[@title='Поиск']")).sendKeys("Авиационные реактивные двигатели");

        driver.findElement(By.xpath("//input[@value ='Поиск в Google' and @role='button']")).submit();

        Thread.sleep(5000);

        driver.quit();
    }
}
