package stepsDefinition;

import dev.failsafe.internal.util.Assert;
import helpers.StepsDefinitionBase;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import static java.lang.Thread.sleep;

public class Authentication extends StepsDefinitionBase {

    //..................Register with existing email adress.........................
    @When("Click Main Page SignIn")
    public void click_main_page_sign_in() throws InterruptedException {
        driver.findElement(By.xpath("//a[@class='rmyCe _G B- z _S c Wc wSSLS w jWkoZ sOtnj']")).click();
        sleep(3000);
    }

    @Then("Choose continue with email")
    public void choose_continue_with_email() throws InterruptedException {
        List<WebElement> allFrames = driver.findElements(By.tagName("iframe"));

        for (WebElement frame : allFrames) {
            if (frame.getAttribute("class").equals("bFOrV _R B- o")) {
                driver.switchTo().frame(frame);
                break;
            }
        }

        driver.findElement(By.xpath("//button[contains(@class,'regEmailContinue')]")).click();
        sleep(3000);
    }

    @Then("Choose Join Option")
    public void choose_join_option() throws InterruptedException {
        driver.findElement(By.xpath("//span[@class='coreRegLinkHighlight']")).click();
        sleep(3000);
    }

    @Then("Enter First name {string}")
    public void enter_first_name(String FirstName) throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='regSignUp.firstName']")).sendKeys(FirstName);
        sleep(3000);
    }

    @Then("Enter Last name {string}")
    public void enter_last_name(String LastName) throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='regSignUp.lastName']")).sendKeys(LastName);
        sleep(3000);
    }

    @Then("Enter Email address {string}")
    public void enter_email_address(String EmailAdress) throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='regSignUp.email']")).sendKeys(EmailAdress);
        sleep(3000);
    }

    @Then("Enter Password {string}")
    public void enter_password(String Password) throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='regSignUp.password']")).sendKeys(Password);
        sleep(3000);
    }

    @And("Click Join Button")
    public void click_join_button() throws InterruptedException {
        driver.findElement(By.id("regSignUp.submit")).click();
        sleep(5000);
        var errorMessage =  driver.findElement(By.xpath("//div[@class='body_text']")).getText();
        Assert.isTrue(errorMessage.startsWith("It appears"),"Registration failed!");
    }

    //....................LOG IN WITH INVALID PASSWORD............................
    @Then("Enter EmailAddress {string}")
    public void enter_emailaddress(String emailadress) throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='regSignIn.email']")).sendKeys(emailadress);
        sleep(3000);
    }

    @Then("Enter invalid Password {string}")
    public void enter_invalid_password(String invalidpassword) throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='regSignIn.password']")).sendKeys(invalidpassword);
        sleep(3000);
    }
    @Then("Click Sign In Button")
    public void click_signin_button() throws InterruptedException {
        driver.findElement(By.xpath("//button[contains(@class,'coreRegPrimaryButton')]")).click();
        sleep(3000);
    }
    @Then("Check for Sign in error message")
    public void check_for_signin_error_message() throws InterruptedException {
        List<WebElement> errorsList = driver.findElement(By.xpath("//div[@id='regErrors']")).findElement(By.tagName("ul")).findElements(By.tagName("li"));
        Assert.isTrue(errorsList.size() > 0, "");
        sleep(3000);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
