package com.cydeo.day1;

import java.sql.*;

public class TestConnection {

/*
     *  host : 3.93.163.26
     *  port : 1521
     *  SID  : XE
     *  user : hr
     *  pass : hr
     *
     *  jdbc url AKA connection String
     *  syntax :
     *  jdbc : vendorName : driverType @YourHost:PORT:SID
     *
     *  jdbc:oracle:thin:@3.93.163.26:1521:XE
*/

    public static void main(String[] args) {


        String url = "jdbc:oracle:thin:@3.93.163.26:1521:XE";
        String username = "hr";
        String password = "hr";
        try {
            Connection connect = DriverManager.getConnection(url, username, password);
            System.out.println("CONNECTION WAS SUCCESSFUL.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("CONNECTION HAS FAILED " + e.getMessage());
        }


    }
}
