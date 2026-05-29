package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    static Connection con;

    public static Connection createDBConnection() {

        try {

            String url = "jdbc:mysql://localhost:3306/studentdb";
            String username = "root";
            String password = "meettyagi9027751326";

            con = DriverManager.getConnection(url, username, password);

            System.out.println("Connection Successful");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }
}