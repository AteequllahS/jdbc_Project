package com.cydeo.day2;

import java.sql.*;

public class LoopingBackward {

    public static void main(String[] args) throws SQLException {

        String url = "jdbc:oracle:thin:@3.93.163.26:1521:XE";
        String username = "hr";
        String password = "hr";

        Connection conn = DriverManager.getConnection(url, username, password);
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);


        //run this query - SELECT*FROM EMPLOYEES WHERE EMPLOYEE_ID <120
        //PRINT OUT THE EMPLOYEE_ID column from last row till first row
        ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID <120");

        rs.afterLast(); // move cursor to the afterLast position

        while(rs.previous()){

            System.out.println( rs.getString(1) +" | "+ rs.getString(2)  );
        }

        //AFTER we are done with Connection, Statement, ResultSet, we need to CLOSE them
        // just like Scanner, FileInputStream and so son
        // the order of CLOSING is exactly opposite to the creation
        rs.close();
        stmt.close();
        conn.close();


    }
}
