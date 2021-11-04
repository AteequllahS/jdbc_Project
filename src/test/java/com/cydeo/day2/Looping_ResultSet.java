package com.cydeo.day2;

import java.sql.*;

public class Looping_ResultSet {

    public static void main(String[] args) {

        String url = "jdbc:oracle:thin:@3.93.163.26:1521:XE";
        String password = "hr";
        String username = "hr";

        try {
            Connection conn = DriverManager.getConnection(url, username, password);

            //can work without parameters too, but it will only go forward (cannot come backward)
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery("SELECT * FROM REGIONS");

            //next() method is moving the cursor to the next line and returning true/false according to whether we have
            //next line or not

            //while loop :
            // as long as rs.next() is true, it loops
            while( rs.next()){
                System.out.println(rs.getString(1)+" | "+rs.getString(2) );
            }

            //if we directly loop it again, it wont work because our cursor is at the end and nothing is after that.
            // so we need to move our cursor to before first row
            System.out.println("second loop :");
            rs.beforeFirst();
            while( rs.next()){

                System.out.println(rs.getString(1)+" | "+rs.getString(2) );
            }

            //getRwo() method
            //getting row count : move cursor to the last row and get the row number using
            rs.last();
            System.out.println("ROW COUNT IS : "+rs.getRow());


            //closing all
            rs.close();
            stmt.close();
            conn.close();


        } catch (SQLException e) {
            System.out.println("CONNECTION FAILED");
        }
    }
}
