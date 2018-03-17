package TestsSignUpPage;


import Helper.BrowserFactory;
import Pages.SignUpPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;





/**
 * Created by macbook on 3/6/18.
 */
public class NewUserPositive {

    WebDriver driver;
    SignUpPage sign_up_page;
    Properties properties = new Properties();
    String browser;
    String testUrl;



    @BeforeClass
    public void setup() throws IOException {
        //Connecting properties config file
        FileInputStream file = new FileInputStream("config.properties");
        properties.load(file);

        //Pulling values from the properties config file
        browser = properties.getProperty("Browser");
        testUrl = properties.getProperty("TestUrl");
    }

    @BeforeSuite
    public void beforeClass(){

        //WebDriver initialization
        driver = BrowserFactory.startBrowser("Firefox");
        driver.get("https://accounts.google.com/SignUp");


        //PageFactory elements initialization
        sign_up_page = PageFactory.initElements(driver, SignUpPage.class);

        //driver.manage().window().maximize(); //doesn't work with old firefox version

        //Waiting until element is visible (page is loaded);
       // sign_up_page.waitUntilVisible();

    }











   //@Test
    @Parameters({"namePosit", "surnamePosit", "elMailPosit", "passwordPosit", "bDayPosit",
            "bYearPosit", "telNumbPosit", "elMailRecovPosit"})
    public void newUserSignUp(String namePosit, String surnamePosit, String elMailPosit, String passwordPosit,
                              String bDayPosit, String bYearPosit, String telNumbPosit, String elMailRecovPosit) {

        sign_up_page.createAccount(namePosit, surnamePosit,
                elMailPosit, passwordPosit, bDayPosit,
                bYearPosit, telNumbPosit, elMailRecovPosit);
    }




String language = "Dansk";

  // @Test
    public void test (String language) {

        sign_up_page.changeLanguage(language);
    }

    @AfterClass (alwaysRun = true)
    public void closeDriver(){
       // driver.close();
        //driver.quit();
        System.out.println("= = = = = = = = = = " + "Closing Driver");
    }

}
