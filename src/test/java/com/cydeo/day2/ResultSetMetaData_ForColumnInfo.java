package com.cydeo.day2;

import java.sql.*;

public class ResultSetMetaData_ForColumnInfo {

    public static void main(String[] args) {

        String url = "jdbc:oracle:thin:@3.93.163.26:1521:XE";
        String username = "hr";
        String password = "hr";

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEES");

            //ResultSetMetaData is a class that can provide information about column e.g. column name, column count,
            //column tpe etc.
            ResultSetMetaData rsmd = rs.getMetaData();

            // if we want to get the column count
            int columnCount = rsmd.getColumnCount();

            // or if we want to get the column name
            String firstColName = rsmd.getColumnName(1);

            System.out.println("columnCount = " + columnCount);
            System.out.println("firstColName = " + firstColName);

            // TO TAKE ALL COLUMNS NAME USING LOOP
            for (int colIndex = 1; colIndex <= columnCount; colIndex++) {
                System.out.println("rsmd.getColumnName("+colIndex+") : "+rsmd.getColumnName(colIndex));
            }


        } catch (SQLException e) {
            System.out.println("connection failed : "+ e.getMessage());
        }

    }
}
