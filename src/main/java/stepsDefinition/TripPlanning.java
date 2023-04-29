package stepsDefinition;

import dev.failsafe.internal.util.Assert;
import helpers.StepsDefinitionBase;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import java.util.List;
import static java.lang.Thread.sleep;

public class TripPlanning extends StepsDefinitionBase {

    //............Trips Menu page is displayed..........
    @When("Click Trips button")
    public void click_trips_button() throws InterruptedException {
        driver.findElement(By.linkText("Trips")).click();
        sleep(1000);
    }
    @Then("Verify if the page is displayed")
    public void verify_if_the_page_is_displayed () throws InterruptedException {
        boolean isTripsUrl = driver.getCurrentUrl().contains("Trips");
        boolean isThePageDisplayed = driver.findElement(By.xpath("//h1[@class='FkVci CdHQj']")).isDisplayed();
        Assert.isTrue(isThePageDisplayed && isTripsUrl, "Failed");
        sleep(2000);
    }

    //...................Create a trip.....................
    @Then("Click Get Started")
    public void click_get_started() throws InterruptedException {
        driver.findElement(By.xpath("//button[@class='ui_button primary']")).click();
        sleep(3000);
    }
    @Then("Continue with email")
    public void continue_with_email() throws InterruptedException {
        List<WebElement> allFrames = driver.findElements(By.tagName("iframe"));

        for (WebElement frame : allFrames) {
            if (frame.getAttribute("id").equals("overlayRegFrame")) {
                driver.switchTo().frame(frame);
                break;
            }
        }

        driver.findElement(By.xpath("//button[contains(@class,'regEmailContinue')]")).click();
        sleep(3000);
    }

    @Then("Click SignIn Button")
    public void click_signin_button() throws InterruptedException {
        driver.findElement(By.xpath("//div[@id='regSignUp']//div[@class='coreRegCTAWrapper']/button[@type='button']/span[@class='coreRegLinkHighlight']")).click();
        sleep(3000);
    }
    @Then("Enter Email Address {string}")
    public void enter_email_address(String EmailAdress) throws InterruptedException {
        driver.findElement(By.id("regSignIn.email")).sendKeys(EmailAdress);
        sleep(3000);
    }

    @Then("Enter  Password {string}")
    public void enter_password(String Password) throws InterruptedException {
        driver.findElement(By.id("regSignIn.password")).sendKeys(Password);
        sleep(3000);
    }

    @Then("Click Inner SignIn Button")
    public void click_inner_signin_button() throws InterruptedException {
        driver.findElement(By.xpath("//button[contains(@class,'coreRegPrimaryButton')]")).click();
        sleep(3000);
    }

    @Then("Click Create trip")
    public void click_create_trip() throws InterruptedException {
        driver.findElement(By.xpath("//button[@class='qwDuD G- C- _J P0 _S AXwnD u Gi z _S _Z w']")).click();
        sleep(3000);
    }
    @Then("Enter Trip name {string}")
    public void enter_trip_name(String triplocation) throws InterruptedException {
        driver.findElement(By.xpath("//input[@name='tripName']")).sendKeys(triplocation);
        sleep(3000);
    }
    @Then("Choose Public")
    public void choose_public() throws InterruptedException {
        WebElement publicRadioButton = driver.findElement(By.xpath("//input[@value='PUBLIC']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;", publicRadioButton);
        sleep(3000);
    }
    @Then("Click Create button")
    public void click_create_button() throws InterruptedException {
        driver.findElement(By.xpath("//button[@class='rmyCe _G B- z _S c Wc wSSLS AeLHi sOtnj ymEbx']")).click();
        sleep(3000);
    }
    @And("Verify if your Trip was created")
    public void verify_if_your_trip_was_created() throws InterruptedException {
        driver.findElement(By.xpath("//div[@class='FGwzt PaRlG']//div[@class='saAkf b o _a']")).click();
        sleep(2000);
        WebElement createdTrip = driver.findElement(By.xpath("//span[@class='biGQs _P fiohW uuBRH']"));
        Assert.isTrue(createdTrip.isDisplayed(), "Trip not displayed");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
