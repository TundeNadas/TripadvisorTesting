package helpers;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class ChromeDriverHelper {
    private static WebDriver chromeWebDriver;

    public static WebDriver getConfiguredWebDriver()  {
        if(chromeWebDriver == null){
            configureChromeWebDriver();
        }

        return chromeWebDriver;
    }

    private static void configureChromeWebDriver() {
        try {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/driver/chromedriver.exe");

            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("load-extension=C:\\Users\\nadas\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Extensions\\cfhdojbkjhnklbpkdaibdccddilifddb\\3.17_0");
            chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            chromeWebDriver = new ChromeDriver(chromeOptions);
            chromeWebDriver.manage().window().maximize();
            Thread.sleep(5000);
            String MainWindowHandle=chromeWebDriver.getWindowHandle();
            for(String winHandle : chromeWebDriver.getWindowHandles()){
                chromeWebDriver.switchTo().window(winHandle);
            }
            chromeWebDriver.close();

            chromeWebDriver.switchTo().window(MainWindowHandle);
        }
        catch(Exception e){
        }
    }
}
