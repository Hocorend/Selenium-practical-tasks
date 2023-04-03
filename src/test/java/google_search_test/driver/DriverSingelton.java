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
                    EdgeOptions options = new EdgeOptions();
                    options.addArguments("--no-sandbox"); // Bypass OS security model, MUST BE THE VERY FIRST OPTION
                    options.addArguments("--headless");
                    options.setExperimentalOption("useAutomationExtension", false);
                    options.addArguments("start-maximized"); // open Browser in maximized mode
                    options.addArguments("disable-infobars"); // disabling infobars
                    options.addArguments("--disable-extensions"); // disabling extensions
                    options.addArguments("--disable-gpu"); // applicable to windows os only
                    options.addArguments("--disable-dev-shm-usage");
                    driver = new EdgeDriver(options);
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
