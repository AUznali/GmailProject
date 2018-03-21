package Helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by AnriUznali on 3/4/18.
 *
 * This is "BrowserFactory", that will run one of the drivers (Firefox, Chrome...)
 * depending of the browser name, that will be passed as the parameter "browserName".
 */
public class BrowserFactory {

    static WebDriver driver;

    public static WebDriver startBrowser(String browserName) {

       // DesiredCapabilities capabilities = new DesiredCapabilities();

        // Strategy can be: normal (by default), eager (wait for "interactive") or none (don't wait)
       // capabilities.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "normal");



        //FIREFOX
        if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "/Users/macbook/JAVA_files/GitHub/GmailProject/webdrivers/geckodriver");
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

        //CHROME
        else if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "/Users/macbook/JAVA_files/GitHub/GmailProject/webdrivers/chromedriver");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        return driver;
    }
}
