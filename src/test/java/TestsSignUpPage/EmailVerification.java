package TestsSignUpPage;

import Helper.BrowserFactory;
import Pages.SignUpPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static Pages.SignUpPage.*;
import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by macbook on 3/23/18.
 */
public class EmailVerification {

    WebDriver driver;
    SignUpPage sign_up_page;
    Properties properties = new Properties();
    String browser;
    String testUrl;
    String language;



    @BeforeClass
    public void setup() throws IOException {
        //Connecting properties config file
        FileInputStream file = new FileInputStream("config.properties");
        properties.load(file);

        //Pulling values from the properties config file
        browser = properties.getProperty("Browser");
        testUrl = properties.getProperty("TestUrl");
        language = properties.getProperty("Language");



        //WebDriver initialization
        driver = BrowserFactory.startBrowser("Firefox");

        //PageFactory elements initialization
        sign_up_page = PageFactory.initElements(driver, SignUpPage.class);


        //Opening test link in browser and changing language
        driver.get(testUrl);
        driver.manage().window().maximize();
        sign_up_page.changeLanguage(language);
    }








//= = = = = = = = = T_E_S_T_S = = = = = = = = =


    //POSITIVE//
    @Test
    @Parameters({"correctUname", "stringExist"})
    private void correctUname(String correctUname, String stringExist){
        sign_up_page.validUname(correctUname, stringExist);
    }


    @Test
    @Parameters({"dotUname", "stringDotExist"})
    private void dotUname (String dotUname, String stringDotExist){
        sign_up_page.validUname(dotUname, stringDotExist);
    }




   @AfterClass
    public void closeDriver(){
        driver.quit();
    }


}
