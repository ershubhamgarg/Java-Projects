package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Shubham Garg on 25-01-2017.
 */
public class ConnectionConfiguration {
    public static Connection getConnection() {
        Connection connection = null;

        try {
            System.out.println("Connecting........");

Class.forName("com.mysql.jdbc.Driver");
connection = DriverManager.getConnection("jdbc:mysql://localhost/mydatabase","root","12345");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
