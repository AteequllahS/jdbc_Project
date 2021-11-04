package com.cydeo.day2;

import com.cydeo.utility.ConfigReader;
import com.cydeo.utility.DB_Util;

import java.util.List;
import java.util.Map;

public class PracticeUtility {

    public static void main(String[] args) {

        // create connection
        String url = ConfigReader.read("hr.database.url");
        String username = ConfigReader.read("hr.database.username");
        String password = ConfigReader.read("hr.database.password");

        DB_Util.createConnection(url, username, password);

        //run Query
        DB_Util.runQuery("SELECT * FROM COUNTRIES");

        //print out the result of the query
        //DB_Util.displayAllData();

        //print out all column names
        System.out.println("DB_Util.getAllColumnNamesAsList() = " + DB_Util.getAllColumnNamesAsList());

        //print out 2row data ast list
        System.out.println("DB_Util.getRowDataAsList(2) = " + DB_Util.getRowDataAsList(2));

        //print out 1st column data as list
        System.out.println("DB_Util.getColumnDataAsList(1) = " + DB_Util.getColumnDataAsList(1));

        //print out COUNTRY_NAME column data ast list
        System.out.println("DB_Util.getColumnDataAsList(\"COUNTRY_NAME\") = " + DB_Util.getColumnDataAsList("COUNTRY_NAME"));

        //print out row count
        System.out.println("DB_Util.getRowCount() = " + DB_Util.getRowCount());

        //print out column count
        System.out.println("DB_Util.getColumnCount() = " + DB_Util.getColumnCount());

        //print out the value of row number 4 column number 1
        System.out.println("DB_Util.getCellValue(4, 1) = " + DB_Util.getCellValue(4, 1));

        //print out the value of the row number 10 and COUNTRY_ID column
        System.out.println("DB_Util.getCellValue(10, \"COUNTRY_ID\") = " + DB_Util.getCellValue(10, "COUNTRY_ID"));

        //print out the first row first cell value
        System.out.println("DB_Util.getFirstRowFirstColumn() = " + DB_Util.getFirstRowFirstColumn());

        //print out 3rd row as Map
        System.out.println("DB_Util.getRowMap(3) = " + DB_Util.getRowMap(3));

        //print out all row a List of Map
        System.out.println("DB_Util.getAllRowAsListOfMap() = " + DB_Util.getAllRowAsListOfMap());

        //PRINT above list of Map item by item
        List<Map<String, String>> allRowMaps = DB_Util.getAllRowAsListOfMap();

        allRowMaps.forEach(each -> System.out.println(each));

        //Close the connection
        DB_Util.destroy();
    }
}
