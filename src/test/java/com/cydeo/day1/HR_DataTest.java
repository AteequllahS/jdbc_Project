package com.cydeo.day1;

import com.cydeo.utility.ConfigReader;
import com.cydeo.utility.DB_Util;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HR_DataTest {

    //connection creation need to be only performed once
    // so @ BeforeAll method is good place to put to

    @BeforeAll
    public static void init(){
        String url = ConfigReader.read("hr.database.url");
        String username = ConfigReader.read("hr.database.username");
        String password = ConfigReader.read("hr.database.password");

        DB_Util.createConnection(url, username, password);
    }



    @Test
    public void testRegion(){

        //read the first row of REGIONS table and verify REGION_NAME is Europe

        DB_Util.runQuery("SELECT * FROM REGIONS");
        String firstRegion = DB_Util.getCellValue(1, "REGION_NAME");

        assertEquals( "Europe", firstRegion);

    }


    //WRITE a test to verify the max salary holder name is Steven King
    @Test
    public void testEmployee(){

        String query = "SELECT FIRST_NAME  || ' ' || LAST_NAME FROM EMPLOYEES WHERE SALARY = (SELECT MAX(SALARY) FROM EMPLOYEES)";
        DB_Util.runQuery(query);

        System.out.println("DB_Util.getFirstRowFirstColumn() = " + DB_Util.getFirstRowFirstColumn()); // Steven King
        String expectedResult = "Steven King";
        String actualResult = DB_Util.getFirstRowFirstColumn();
        assertEquals(expectedResult, actualResult);

    }


    //closing creation need to be only performed once
    //so @afterAll method is good place to put it
    @AfterAll
    public static void tierDown(){
        DB_Util.destroy();
    }
}
