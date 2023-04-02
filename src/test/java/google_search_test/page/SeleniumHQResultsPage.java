package google_search_test.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class SeleniumHQResultsPage {
    private WebDriver driver;
    private String term;

    public SeleniumHQResultsPage(WebDriver driver,String term){
        this.driver = driver;
        this.term = term;
        PageFactory.initElements(driver,this);
    }

    public int countSearchResults(){
        List<WebElement> searchResults = driver.findElements(By.xpath("//span[*[text()='"+term+"']]"));
        return searchResults.size();
    }
}
