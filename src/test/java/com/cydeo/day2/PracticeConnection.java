package com.cydeo.day2;

import java.sql.*;

public class PracticeConnection {

    public static void main(String[] args) throws SQLException {

        String url = "jdbc:oracle:thin:@3.93.163.26:1521:XE";
        String username = "hr";
        String password = "hr";

        //this time we declared the exception in the method signature
        Connection conn = DriverManager.getConnection(url, username, password);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM REGIONS");

        //using navigate through the ResultSet object to get the cell value
        rs.next();
        //moves the cursor from beforeFirst() location to first row.
        System.out.println("rs.getString(\"REGION_ID\") = " + rs.getString("REGION_ID"));
        System.out.println("rs.getString(\"REGION_NAME\") = " + rs.getString("REGION_NAME"));

        rs.next();
        //moves the cursor from beforeFirst() location to first row.
        System.out.println("rs.getString(\"REGION_ID\") = " + rs.getString("REGION_ID"));
        System.out.println("rs.getString(\"REGION_NAME\") = " + rs.getString("REGION_NAME"));

        rs.next();
        //moves the cursor from beforeFirst() location to first row.
        System.out.println("rs.getString(\"REGION_ID\") = " + rs.getString("REGION_ID"));
        System.out.println("rs.getString(\"REGION_NAME\") = " + rs.getString("REGION_NAME"));

        rs.next();
        //moves the cursor from beforeFirst() location to first row.
        System.out.println("rs.getString(\"REGION_ID\") = " + rs.getString("REGION_ID"));
        System.out.println("rs.getString(\"REGION_NAME\") = " + rs.getString("REGION_NAME"));

        //we dont have 5th row in REGIONS
        //rs.next();
        System.out.println("Do we have more row :"+ rs.next()); // we can print it for boolean result
        //moves the cursor from beforeFirst() location to first row.
        System.out.println("rs.getString(\"REGION_ID\") = " + rs.getString("REGION_ID"));
        System.out.println("rs.getString(\"REGION_NAME\") = " + rs.getString("REGION_NAME"));

        //closing all
        rs.close();
        stmt.close();
        conn.close();


    }
}
