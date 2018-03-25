package TestsSignUpPage1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by macbook on 3/11/18.
 */
public class TestingElemets {


    @Test
    public void testingElements(){


        //System.setProperty("webdriver.gecko.driver", "/Users/macbook/Documents/Selenium/Browser Drivers/Firefox GecoDeriver/geckodriver");
        //WebDriver driver = new FirefoxDriver();
        //driver.get("https://accounts.google.com/SignUp");


        String firstString = "bnrik";
        String secondString = "anrik";

        char[] firstChar = firstString.toCharArray();
        char[] secondChar = secondString.toCharArray();

        int[] answer = new int[firstChar.length];

        for(int i = 0; i < firstChar.length; i++ ){

            int firstOne = (int) firstChar[i];
            int secondOne = (int) secondChar[i];

            int rotated = Math.abs(secondOne - firstOne);
            //System.out.println(secondChar[i] + " rotated " + rotated + " times");
            answer[i] = rotated;
        }

        System.out.println(Arrays.toString(answer));




//        driver.findElement(By.id("GmailAddress")).click();
//        driver.findElement(By.id("GmailAddress")).clear();

     //   driver.findElement(By.name("BirthDay")).clear();
       // driver.findElement(By.name("BirthDay")).sendKeys("2");

//        driver.findElement(By.id("LastName")).sendKeys(Keys.ENTER);
//        driver.findElement(By.id("LastName")).sendKeys(Keys.TAB);


//
//        String text = driver.findElement(By.cssSelector("span#errormsg_0_GmailAddress.errormsg")).getText();
//        System.out.println(text);




//
//        driver.findElement(By.id("LastName")).click();
//        driver.findElement(By.id("LastName")).sendKeys(Keys.TAB);






        //Assert.assertTrue(driver.findElement(By.id("errormsg_0_LastName")).getText().contains("You can't leave this empty."));






    }
}

