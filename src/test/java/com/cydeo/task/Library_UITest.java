package com.cydeo.task;

import com.cydeo.utility.BrowserUtil;
import com.cydeo.utility.DB_Util;
import com.cydeo.utility.Driver;
import org.junit.jupiter.api.*;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class Library_UITest {

    LibLoginPage loginPage = new LibLoginPage();;
    public String actualResult;
    public String expectedResult;


    @BeforeAll
    public static void connect() {

        String url = "jdbc:mysql://54.157.236.232:3306/library2";
        String username = "library2_client";
        String password = "6s2LQQTjBcGFfDhY";
        DB_Util.createConnection(url, username, password);

    }

    @BeforeEach
    public void loginToLibrary(){
        loginPage.goTo();
        BrowserUtil.waitFor(3);
        loginPage.login("librarian47@library", "Sdet2022*");
        BrowserUtil.waitFor(3);

    }

    @Test
    public void userCountTest() {

        DB_Util.runQuery("SELECT COUNT(*) FROM users ORDER BY 1 DESC");
        actualResult = DB_Util.getFirstRowFirstColumn();

        expectedResult = loginPage.userCount.getText();
        assertEquals(expectedResult, actualResult);

    }

    @Test
    public void bookCountTest() {

        DB_Util.runQuery("SELECT COUNT(*) FROM books ORDER BY 1 DESC");
        actualResult = DB_Util.getFirstRowFirstColumn();
        expectedResult = loginPage.bookCount.getText();
        assertEquals(expectedResult, actualResult);

    }

    @Test
    public void borrowedBookCountTest() {

        DB_Util.runQuery("SELECT COUNT(IS_RETURNED) FROM book_borrow WHERE is_returned = 0");
        actualResult = DB_Util.getFirstRowFirstColumn();
        expectedResult = loginPage.borrowedBookCount.getText();

        assertEquals(expectedResult, actualResult);

    }

    @AfterEach
    public void closeBrowser(){
        BrowserUtil.waitFor(2);
        Driver.closeBrowser();
    }

    @AfterAll
    public static void closeConnection() {
        DB_Util.destroy();
    }
}
