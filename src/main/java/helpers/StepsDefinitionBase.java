package helpers;

import org.openqa.selenium.WebDriver;

public class StepsDefinitionBase {
    public WebDriver driver;

    public StepsDefinitionBase() {
        this.driver = ChromeDriverHelper.getConfiguredWebDriver();
    }
}
