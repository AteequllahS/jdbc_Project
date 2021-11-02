package com.cydeo.day1;

import java.sql.*;

public class D01_Navigating_ResultSet {

    public static void main(String[] args) {

        String url = "jdbc:oracle:thin:@3.93.163.26:1521:XE";
        String username = "hr";
        String password = "hr";
        try {
            Connection connect = DriverManager.getConnection(url, username, password);

            Statement stmt = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            // Resultset use cursor or pointer to navigate through the rows by default the pointer is at a location known as BeforeFirst location
            // meaning right before first row
            // in order to move to the first row, we need to call next() method
            // everytime you call next() method, it will jump next row
            // you can use getString(column name) method to get the cell value
            ResultSet rs = stmt.executeQuery("SELECT * FROM REGIONS");

/*
            ResultSet Methods to navigate rows
             *  next()
             * previous()
             * first()
             * last()
             * beforeFirst()
             * afterLast()
             * absolute(8)
*/
            rs.first();
            System.out.println("rs.first() : "+ rs.getString("REGION_ID") + " "+ rs.getString("REGION_NAME") );

            rs.last();
            System.out.println("rs.last()  : "+ rs.getString("REGION_ID") + " "+ rs.getString("REGION_NAME") );

            rs.previous();
            System.out.println("rs.previous() : "+ rs.getString("REGION_ID") + " "+ rs.getString("REGION_NAME") );

            rs.absolute(2);
            System.out.println("rs.absolute(2) : "+ rs.getString("REGION_ID") + " "+ rs.getString("REGION_NAME") );

            rs.beforeFirst();
            rs.next();// as there is nothing before first, we go to next step in this scenario.
            System.out.println("rs.afterLast() :"+rs.getString("REGION_ID") + " "+ rs.getString("REGION_NAME") );

            rs.afterLast();
            rs.previous(); // as there is nothing after last in this example, so go one step up
            System.out.println(rs.getString("REGION_ID") + " "+ rs.getString("REGION_NAME") );


        } catch (SQLException e) {
            System.out.println("Error Has Occurred " + e.getMessage());
        }

    }
}
