package google_search_test.test;

import google_search_test.driver.DriverSingelton;
import google_search_test.page.SeleniumHQHomeTest;
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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class WebDriverSeleniumHQTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){
        driver = DriverSingelton.getDriver();
    }
    @AfterMethod(alwaysRun = true)
    public void browserClosed(){
        DriverSingelton.closeDriver();
    }

    @Test(description = "Link for test")
    public void commonSearchTermResultNotEmpty() throws InterruptedException {

        int expectedSearchResult = new SeleniumHQHomeTest(driver)
                .openPage()
                .searchForTerms("Авиационные двигатели")
                .countSearchResults();
        Assert.assertTrue(expectedSearchResult>0, "The search yielded no results");


    }
}
