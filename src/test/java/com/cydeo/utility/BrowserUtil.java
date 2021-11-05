package com.cydeo.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class BrowserUtil {

    public static void waitFor(int seconds){

        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static boolean checkVisibilityOfElement(By locator, int timeToWait){

        boolean result = false;
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),timeToWait);
        try {
            wait.until( ExpectedConditions.visibilityOfElementLocated(locator) );
            result=true;
        }catch (TimeoutException e){
            e.printStackTrace();
            System.out.println("WE DID NOT SEE THE MESSAGE ELEMENT.");
        }
        return result;
    }


    //a method to get all texts
    public static List<String> getAllText(List<WebElement> listOfWebElement){

        List<String> allTextLst = new ArrayList<>();

        for (WebElement eachElement : listOfWebElement) {
            allTextLst.add(  eachElement.getText() );

        }
        return allTextLst;
    }
}
