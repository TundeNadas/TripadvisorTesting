package stepsDefinition;

import dev.failsafe.internal.util.Assert;
import helpers.StepsDefinitionBase;
import io.cucumber.java.After;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import static java.lang.Thread.sleep;

public class SearchFunctionality extends StepsDefinitionBase {

    //..........Search box is displayed...........
    @When("Verify the webpage title")
    public void verify_the_webpage_title() throws InterruptedException {
        String expectedTitle = "Tripadvisor: Over a billion reviews & contributions for Hotels, Attractions, Restaurants, and more";
        String actualTitle = driver.getTitle();

        Assert.isTrue(expectedTitle == actualTitle, "Verification Failed - An incorrect title is displayed on the web page.");
        sleep(3000);
    }
    @Then("Verify if the search box is displayed")
    public void verify_if_the_search_box_is_displayed() {
        Boolean result = driver.findElement(By.xpath("//input[@placeholder='Where to?']")).isDisplayed();
        Assert.isTrue(result, "Searchbox not found");
    }

    //.............Valid search query with displayed search results on the page..........

    @When("Enter {string} in search textbox")
    public void enter_in_search_textbox(String query) throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("//input[@placeholder='Where to?']"));
        element.click();
        element.sendKeys(query);
        element.sendKeys(Keys.ENTER);
        sleep(3000);
    }

    @Then("Verify that the search results are loaded {string}")
    public void verify_that_the_search_results_are_loaded(String location) {
        boolean isSearchResultVisible = driver.findElement(By.className("search-results-title")).isDisplayed();
        String results = driver.getPageSource();
        boolean isSearchSesultValid = results.contains(location);

        Assert.isTrue(isSearchResultVisible && isSearchSesultValid, "");
    }

    //.............Invalid search query with displayed appropriate error message............


    @Then("Verify the error message if displayed")
    public void verify_the_error_message_if_displayed() throws InterruptedException {
        boolean errormessage = driver.findElement(By.className("no-results-content")).isDisplayed();

        String textErrorMessage = driver.findElement(By.xpath("//div[@class='no-results-content']")).getText();

        Assert.isTrue(textErrorMessage.contains("Sorry, we couldn't find"), "");
        sleep(3000);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
