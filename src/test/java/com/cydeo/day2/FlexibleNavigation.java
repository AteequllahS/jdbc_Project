package com.cydeo.day2;

import java.sql.*;

public class FlexibleNavigation {

    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@3.93.163.26:1521:XE";
        String password = "hr";
        String username = "hr";

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEES");
/*
             navigations methods for moving cursors:

             * next()        --move to next row and return true false according to if we have valid row
             * previous()    -move to previous row and return true false according to if we have valid row
             * first()       - move to first row from anywhere
             * last()        - move to last row from anywhere
             * beforeFirst() - move to before first location from anywhere
             * afterLast()   - move to after last location from anywhere
             * absolute(rowNumber)   - move to any row by using row number
*/
            rs.first();
            System.out.println("first row = " + rs.getString("EMPLOYEE_ID"));

            rs.last();
            System.out.println("last row= " + rs.getString("EMPLOYEE_ID"));

            rs.previous();
            System.out.println("previous row = " + rs.getString("EMPLOYEE_ID"));

            //moves the cursor to the row 100
            rs.absolute(100);
            System.out.println("absolute(at row 100 )  = " + rs.getString("EMPLOYEE_ID"));

            while( rs.next()){
                System.out.println(rs.getString(1)+" | "+rs.getString(2) );
            }

            System.out.println("second loop :");
            rs.beforeFirst();
            while( rs.next()){

                System.out.println(rs.getString(1)+" | "+rs.getString(2) );
            }

            //getRwo() method
            //getting row count : move cursor to the last row and get the row number using
            rs.last();
            System.out.println("ROW COUNT IS : "+rs.getRow());

            rs.beforeFirst();
            rs.first();

            //closing all
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("CONNECTION FAILED");
        }



    }
}
