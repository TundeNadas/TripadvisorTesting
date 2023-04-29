package stepsDefinition;

import helpers.StepsDefinitionBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;

import static java.lang.Thread.sleep;

public class CommonFunctions extends StepsDefinitionBase {

    @Given("Open {string} webpage")
    public void open_tripadvisor_webpage(String webpage) throws InterruptedException {
        driver.get("https://www.tripadvisor.com/");
        sleep(3000);
    }

    @Then("Accept cookie consent Popup")
    public void accept_cookie_consent_popup() throws InterruptedException {
        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
        sleep(3000);
    }
}
