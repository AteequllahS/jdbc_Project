package com.cydeo.task;

import com.cydeo.utility.ConfigReader;
import com.cydeo.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.sql.*;

public class LibLoginPage {

    // declaring at class level so all methods can access
    private static Connection con ;
    private static Statement stm ;
    private static ResultSet rs ;
    private static ResultSetMetaData rsmd ;

    @FindBy(id="inputEmail")
    public WebElement usernameBox ;

    @FindBy(id="inputPassword")
    public WebElement passwordBox ;

    @FindBy(xpath="//button[.='Sign in']")
    public WebElement loginButton ;

    @FindBy(id="user_count")
    public WebElement userCount ;

    @FindBy(id="book_count")
    public WebElement bookCount ;

    @FindBy(id="borrowed_books")
    public WebElement borrowedBookCount ;


    public LibLoginPage(){
        PageFactory.initElements(com.cydeo.utility.Driver.getDriver(), this );
    }

    public void goTo(){
        Driver.getDriver().get("http://library2.cybertekschool.com/login.html");
        //Driver.getDriver().get(ConfigReader.read( "library2.ui.url" ) );
    }

    public void login(String username, String password){

        usernameBox.sendKeys(username);
        passwordBox.sendKeys(password);
        loginButton.click();

    }


    public static void createConnection(String url , String username, String password){


        try {
            con = DriverManager.getConnection(url, username, password) ;
            System.out.println("CONNECTION SUCCESSFUL");
        } catch (Exception e) {
            System.out.println("CONNECTION HAS FAILED " + e.getMessage() );
        }

    }
    public static void createConnection(){

        String url      = ConfigReader.read("library2.database.url") ;
        String username = ConfigReader.read("library2.database.username") ;
        String password = ConfigReader.read("library2.database.password") ;
        createConnection(url, username, password);
        System.out.println("CONNECTION WAS SUCCESSFUL");

    }

}
