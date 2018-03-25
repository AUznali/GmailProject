package TestsSignUpPage;

import Helper.BrowserFactory;
import Pages.SignUpPage;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;


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
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        //Checking that correct page is opened. If not, open one more time.
        if(!(driver.getCurrentUrl().contains(testUrl))){
            driver.get(testUrl);
            driver.manage().window().maximize();
        }

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

    @Test
    @Parameters({"capitalUname", "stringDotExist"})
    private void capitalUname (String capitalUname, String stringDotExist){
        sign_up_page.validUname(capitalUname, stringDotExist);
    }

    @Test
    @Parameters({"digitsUname", "stringExist"})
    private void digitsUname (String digitsUname, String stringExist){
        sign_up_page.validUname(digitsUname, stringExist);
    }

    @Test
    @Parameters({"wSpacesUname", "stringNameTaken"})
    private void wSpacesUname (String wSpacesUname, String stringNameTaken){
        sign_up_page.validUname(wSpacesUname, stringNameTaken);
    }


    //NEGATIVE//
    @Test
    @Parameters({"plusUname", "stringCorrectChars"})
    private void plusUname (String plusUname, String stringCorrectChars){
        sign_up_page.validUname(plusUname, stringCorrectChars);
    }

    @Test
    @Parameters({"dashUname", "stringCorrectChars"})
    private void dashUname (String dashUname, String stringCorrectChars){
        sign_up_page.validUname(dashUname, stringCorrectChars);
    }

    @Test
    @Parameters({"underscoreUname", "stringCorrectChars"})
    private void underscoreUname (String underscoreUname, String stringCorrectChars){
        sign_up_page.validUname(underscoreUname, stringCorrectChars);
    }

    @Test
    @Parameters({"specCharsUname", "stringCorrectChars"})
    private void specCharsUname (String specCharsUname, String stringCorrectChars){
        sign_up_page.validUname(specCharsUname, stringCorrectChars);
    }

    @Test
    @Parameters({"firstDotUname", "stringFirstChar"})
    private void firstDotUname (String firstDotUname, String stringFirstChar){
        sign_up_page.validUname(firstDotUname, stringFirstChar);
    }

    @Test
    @Parameters({"lastDotUname", "stringLastChar"})
    private void lastDotUname (String lastDotUname, String stringLastChar){
        sign_up_page.validUname(lastDotUname, stringLastChar);
    }

    @Test
    @Parameters({"dotsUname", "stringTwoDots"})
    private void dotsUname (String dotsUname, String stringTwoDots){
        sign_up_page.validUname(dotsUname, stringTwoDots);
    }

    @Test
    @Parameters({"unicodeUname", "stringCorrectChars"})
    private void unicodeUname (String unicodeUname, String stringCorrectChars){
        sign_up_page.validUname(unicodeUname, stringCorrectChars);
    }

    @Test
    @Parameters({"twoWordsUname", "stringCorrectChars"})
    private void twoWordsUname (String twoWordsUname, String stringCorrectChars){
        sign_up_page.validUname(twoWordsUname, stringCorrectChars);
    }





   @AfterClass
    public void closeDriver(){
        driver.quit();
    }

}
