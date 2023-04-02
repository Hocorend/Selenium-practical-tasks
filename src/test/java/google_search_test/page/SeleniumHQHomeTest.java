package google_search_test.page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.locators.CustomLocator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SeleniumHQHomeTest {

    private WebDriver driver;

    public static final String HOMEPAGE_URL = "https://google.com";

    @FindBy(xpath = "//input[@title='Поиск']")
    private WebElement searchInput;

    @FindBy(xpath = "//input[@value ='Поиск в Google' and @role='button']")
    private WebElement searchButton;

    public SeleniumHQHomeTest(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public SeleniumHQHomeTest openPage(){
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public SeleniumHQResultsPage searchForTerms(String term){
        searchInput.sendKeys(term);
        searchButton.submit();
        new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[text()='"+term+"']")));

        return new SeleniumHQResultsPage(driver, term);
    }
}
