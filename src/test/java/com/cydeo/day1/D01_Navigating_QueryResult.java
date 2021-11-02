package com.cydeo.day1;

import java.sql.*;

public class D01_Navigating_QueryResult {

    public static void main(String[] args) {

        String url = "jdbc:oracle:thin:@3.93.163.26:1521:XE";
        String username = "hr";
        String password = "hr";
        try {
            Connection connect = DriverManager.getConnection(url, username, password);

            Statement stmt = connect.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM REGIONS");

            rs.next(); // GO to next row
            System.out.println("RESION ID on first row is : "+rs.getString(1) );
            System.out.println("RESION ID on first row is : "+rs.getString("REGION_ID") );
            System.out.println("RESION NAME on first row is : "+rs.getString(2) );
            System.out.println("RESION NAME on first row is : "+rs.getString("REGION_NAME") );

            System.out.println("=========================================");

            rs.next(); // GO to next row
            System.out.println("RESION NAME on second row is : "+rs.getString("REGION_NAME") );


            System.out.println("=========================================");

            rs.next(); // GO to next row
            System.out.println("RESION NAME on third row is : "+rs.getString("REGION_NAME") );

            System.out.println("=========================================");

            rs.next(); // GO to next row
            System.out.println("RESION NAME on third row is : "+rs.getString("REGION_NAME") );

            System.out.println("=========================================");

            //rs.next(); // GO to next row
            //System.out.println("RESION NAME AFTER LAST ROW row is : "+rs.getString("REGION_NAME") );
            //THROWS EXCEPTION AS THERE IS NO MORE ROW

            //Or we can print next() as boolean result
            System.out.println("Do we have more row data? = " + rs.next());

            //Go to previous row
            rs.previous(); // WE cant go to previous row if we set the forward next() method.


        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error Has Occurred " + e.getMessage());
        }
    }
}
