package Pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Created by macbook on 3/4/18.
 * Page selectors and main methods
 */
 public class SignUpPage {

    WebDriver driver;



    //Constructor
    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }


    // = = = = = = W_E_B  E_L_E_M_E_N_T_S = = = = = =

    @FindBy(how = How.CLASS_NAME, using = "devices-icon")
    WebElement waitUntil;

    @FindBy(how = How.ID, using = "FirstName")
    public static WebElement firstName;

    @FindBy(how = How.ID, using = "LastName")
    public static WebElement lastName;

    @FindBy(how = How.ID, using = "GmailAddress")
    public static WebElement email;

    @FindBy(how = How.ID, using = "Passwd")
    public static WebElement pass;

    @FindBy(how = How.ID, using = "PasswdAgain")
    public static WebElement confirmPass;

    @FindBy(how = How.ID, using = "BirthDay")
    public static WebElement birthDay;

    @FindBy(how = How.ID, using = ":0")
    public static WebElement birthMonth;

    @FindBy(how = How.ID, using = ":0")
    WebElement monthMarch;

    @FindBy(how = How.ID, using = "BirthYear")
    public static WebElement birthYear;

    @FindBy(how = How.ID, using = "Gender")
    public static WebElement gender;

    @FindBy(how = How.ID, using = ":e")
    WebElement gndrFemale;

    @FindBy(how = How.ID, using = ":f")
    WebElement gndrMale;

    @FindBy(how = How.CLASS_NAME, using = "i18n-phone-flag")
    WebElement phoneCode;

    @FindBy(how = How.ID, using = ":7q")
    WebElement phoneCodeUSA;

    @FindBy(how = How.ID, using = ":7r")
    WebElement phoneCodeAfgnst;

    @FindBy(how = How.ID, using = "RecoveryPhoneNumber")
    WebElement phoneNumb;

    @FindBy(how = How.ID, using = "RecoveryEmailAddress")
    WebElement recovEmai;

    @FindBy(how = How.ID, using = ":i")
    WebElement locationCountry;

    @FindBy(how = How.ID, using = ":j")
    WebElement locationUSA;

    @FindBy(how = How.ID, using = ":q")
    WebElement locationAndorra;

    @FindBy(how = How.ID, using = "submitbutton")
    WebElement submitButton;

    @FindBy(how = How.CSS, using = "a[href^='https://support.google.com/accounts/answer/1733224?hl']")
    WebElement learnMore;

    @FindBy(how = How.ID, using = "lang-chooser")
    WebElement chooseLang;

    @FindBy(how = How.CLASS_NAME, using = "logo.logo-w")
    WebElement googleLogo;

    @FindBy(how = How.CSS, using = "#a[href^='https://accounts.google.com/TOS?loc=US&hl']")
    WebElement privacyTerms;

    @FindBy(how = How.ID, using = "footer-help")
    WebElement help;



    //ERRORS MESSAGES

    @FindBy(how = How.ID, using = "errormsg_0_FirstName")
    public static WebElement isFirstNameEmpty;

    @FindBy(how = How.ID, using = "errormsg_0_LastName")
    public static WebElement isLastNameEmpty;

    @FindBy(how = How.CSS, using = "span#errormsg_0_GmailAddress.errormsg")
    public static WebElement unameErrorMsg;

    @FindBy(how = How.CSS, using = "span#errormsg_0_Passwd.errormsg")
    public static WebElement isPassEmpty;


    @FindBy(how = How.CSS, using = "span#errormsg_0_PasswdAgain.errormsg")
    public static WebElement isPassAgainEmpty;

    @FindBy(how = How.CSS, using = "span#errormsg_0_BirthYear.errormsg")
    public static WebElement isBYearEmpty;

    @FindBy(how = How.CSS, using = "span#errormsg_0_BirthDay.errormsg")
    public static WebElement isBDayEmpty;

    @FindBy(how = How.CSS, using = "span#errormsg_0_BirthMonth.errormsg")
    public static WebElement isBMonthEmpty;


    @FindBy(how = How.CSS, using = "span#errormsg_0_Gender.errormsg")
    public static WebElement isGenderEmpty;


    // = = = = = = E_N_D   W_E_B  E_L_E_M_E_N_T_S = = = = = =






    // = = = = = = M_E_T_H_O_D_S = = = = = = = = = = = =




    //Waiting until
//    public void waitUntilVisible(){
//        wait.until(visibilityOfElementLocated(By.className("devices-icon")));
//    }




    // Creating new account
    public void createAccount(String name, String surname, String elMail, String password,
                              String bDay, String bYear,
                              String telNumb, String elMailRecov) {

        firstName.sendKeys(name);
        lastName.sendKeys(surname);
        email.sendKeys(elMail);
        pass.sendKeys(password);
        confirmPass.sendKeys(password);

        //b-day
        birthDay.click();
        birthDay.sendKeys(bDay);

        //Selecting month in two clicks
        birthMonth.click();
        monthMarch.click();

        birthYear.sendKeys(bYear);


        //Selecting gender in two clicks
        gender.click();
        gndrMale.click();

        //Selecting phone code in two clicks
        phoneCode.click();
        phoneCodeUSA.click();

        phoneNumb.sendKeys(telNumb);
        recovEmai.sendKeys(elMailRecov);

        //Selecting country location in two clicks
        locationCountry.click();
        locationUSA.click();

        //submitButton.click();
    }




    //Clicking "Learn more" button
    public void learnMore() {
        learnMore.click();
    }



    //Enter name
    public void enterName(String name) {
        lastName.click();
        lastName.sendKeys(name);
    }




    public void validUname (String username, String expectedErrorText){
        email.click();
        email.clear();
        email.sendKeys(username);
        firstName.click();
        firstName.sendKeys(Keys.ENTER);

        WebElement myDynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOf(unameErrorMsg));

        String actualErrorText = unameErrorMsg.getText();

        boolean compareErrorText = actualErrorText.equals(expectedErrorText);
        if(!compareErrorText){
            System.out.println("= = = = = = = Testing value: /" + username + "/ = = = = = = = = = = = =  ");
            System.out.println("EXPECTED: " + expectedErrorText);

            System.out.println("ACTUAL:   " + actualErrorText);
            System.out.println("= = = = = = = = = = = = = = = = = = =  = = = = = = = = = = = =  = = = = = ");
    }
        Assert.assertTrue(actualErrorText.contains(expectedErrorText));
    }




/*    Check if error message (text) is visible if required field was not filled
     testingField - this field we leave empty to test error message
     checkError - this is error message element
     enterValue = here we enter some value to be sure, that this field is not empty so error message for this field
     will not be apears and effect to our test*/

    public void isErrorVisible (WebElement testingField, WebElement checkError, WebElement enterValue){
        testingField.clear();

        enterValue.sendKeys("123");
        enterValue.sendKeys(Keys.ENTER);

        Assert.assertTrue(checkError.getText().contains("You can't leave this empty."));
    }

    //Special method for Birthday data, Gender
    public void isErrVisibReq (WebElement checkError, WebElement enterValue1, WebElement enterValue2){

        enterValue1.sendKeys("1");
        enterValue1.sendKeys(Keys.ENTER);

        enterValue2.sendKeys("1");
        enterValue2.sendKeys(Keys.ENTER);

        Assert.assertTrue(checkError.getText().contains("You can't leave this empty."));
    }






    //Clicking Google logo
    public void logoClick() {
        googleLogo.click();
    }



    //Clicking "Help"
    public void helpClick() {
        help.click();
    }



    //Clicking "Privacy & Terms"
    public void privacyAndTerms() {
        privacyTerms.click();
    }



    //Changing page language
    public void changeLanguage(String language){

        //Scrolling down
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0, 750);");


        Select selectLanguage = new Select(chooseLang);
        chooseLang.click();
        selectLanguage.selectByValue(language);
    }
    // = = = = = = E_N_D    M_E_T_H_O_D_S = = = = = = = = = = = =
}
