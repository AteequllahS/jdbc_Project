package com.cydeo.day1;

import java.sql.*;

public class Test_SQL_Connection {

    public static void main(String[] args) {

        // connection string or url for Library App  Library2 Environment

        String url = "jdbc:mysql://54.157.236.232:3306/library2";
        String username = "library2_client";
        String password = "6s2LQQTjBcGFfDhY";

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("CONNECTION TO LIBRARY APP WAS SUCCESSFUL");

            //create statement Object from Connection so we can eventually run query
            Statement stmt = conn.createStatement();

            //using this statement object to run query
            ResultSet rs = stmt.executeQuery("");


        } catch (SQLException e) {
           // e.printStackTrace();
            System.out.println("ERROR WHILE CONNECTING HAPPENED : "+e.getMessage());
        }
    }
}
