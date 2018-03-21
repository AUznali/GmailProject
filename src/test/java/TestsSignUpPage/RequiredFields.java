package TestsSignUpPage;


import Helper.BrowserFactory;
import Pages.SignUpPage;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static Pages.SignUpPage.*;

/**
 * Created by macbook on 3/12/18.
 *
 *
 * Checking error messages for required field when it is empty
 */
public class RequiredFields {


    WebDriver driver;
    SignUpPage sign_up_page;
    Properties properties = new Properties();
    String browser;
    String testUrl;
    String language;



    @BeforeSuite
    public void setup() throws IOException {
        //Connecting properties config file
        FileInputStream file = new FileInputStream("config.properties");
        properties.load(file);

        //Pulling values from the properties config file
        browser = properties.getProperty("Browser");
        testUrl = properties.getProperty("TestUrl");
        language = properties.getProperty("Language");
    }

    @BeforeTest
    public void beforeClass(){
        //WebDriver initialization
        driver = BrowserFactory.startBrowser("Chrome");

        //PageFactory elements initialization
        sign_up_page = PageFactory.initElements(driver, SignUpPage.class);
    }


    @BeforeTest
    public void openDriver(){
        driver.get(testUrl);
        driver.manage().window().maximize();
        sign_up_page.changeLanguage(language);
    }





//= = = = = = = = = T_E_S_T_S = = = = = = = = =

    // Checking error message, when required field is empty
    @Test(groups = {"ErrorMessages"})
    public void firstNameEmpty(){
        sign_up_page.isErrorVisible(firstName, isFirstNameEmpty, lastName);
    }

    @Test(groups = {"ErrorMessages"})
    public void lastNameEmpty(){
        sign_up_page.isErrorVisible(lastName, isLastNameEmpty, firstName);
    }

    @Test(groups = {"ErrorMessages"})
    public void eMailEmpty(){
        sign_up_page.isErrorVisible(email, isEMailEmpty, firstName);
    }

    @Test(groups = {"ErrorMessages"})
    public void passEmpty(){
        sign_up_page.isErrorVisible(pass, isPassEmpty, firstName);
    }

    @Test(groups = {"ErrorMessages"})
    public void passAgainEmpty(){
        sign_up_page.isErrorVisible(confirmPass, isPassAgainEmpty, firstName);
    }

    @Test(groups = {"ErrorMessages"})
    public void birthYearEmpty(){
        sign_up_page.isErrorVisible(birthYear, isBYearEmpty, birthDay);
    }

    @Test(groups = {"ErrorMessages"})
    public void birthDayEmpty(){
        sign_up_page.isErrorVisible(birthDay, isBDayEmpty, birthYear);
    }

    @Test(groups = {"ErrorMessages"})
    public void birthMonthEmpty(){
        sign_up_page.isErrVisibReq(isBMonthEmpty, birthDay, birthYear);
    }

    @Test(groups = {"ErrorMessages"})
    public void genderEmpty(){
        sign_up_page.isErrVisibReq(isGenderEmpty, birthDay, birthYear);
    }




    @AfterTest
    public void closeDriver(){
       driver.quit();
    }
}
