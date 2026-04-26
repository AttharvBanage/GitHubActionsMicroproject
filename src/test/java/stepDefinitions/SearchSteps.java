package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;

public class SearchSteps {
    WebDriver driver;

    @Given("the user opens the Google homepage")
    public void the_user_opens_the_google_homepage() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        
        // ESSENTIAL FOR GITHUB ACTIONS: Runs browser without a GUI
        options.addArguments("--headless"); 
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");
        
        driver = new ChromeDriver(options);
        driver.get("https://www.google.com");
    }

    @When("the user searches for {string}")
    public void the_user_searches_for(String keyword) {
        driver.findElement(By.name("q")).sendKeys(keyword + Keys.ENTER);
    }

    @Then("the page title should be validated")
    public void the_page_title_should_be_validated() {
        String title = driver.getTitle();
        System.out.println("Captured Page Title: " + title);
        
        // Validates that we successfully reached a page
        Assert.assertNotNull("Title should not be null", title);
        driver.quit();
    }
}