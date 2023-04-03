package google_search_test.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverSingelton {

    private static WebDriver driver;

    public static WebDriver getDriver(){
        if(driver == null){
            switch (System.getProperty("browser")){
                case "firefox":{
                    driver = new FirefoxDriver(new FirefoxOptions().setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe"));
                    break;
                }
                case "edge": {
                    System.setProperty("webdriver.edge.driver","C:\\JavaTool\\msedgedriver.exe");
                    driver = new EdgeDriver(new EdgeOptions().addArguments("--no-sandbox").addArguments("--disable-dev-shm-usage"));
                    break;
                }
                default:{
                    System.setProperty("webdriver.chrome.driver","C:\\JavaTool\\chromedriver.exe");
                    driver = new ChromeDriver();
                }
            }
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeDriver(){
        driver.quit();
        driver = null;
    }
}
