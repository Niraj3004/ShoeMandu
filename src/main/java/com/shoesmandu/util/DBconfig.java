package com.shoesmandu.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * DBconfig is a utility class responsible for
 * establishing a connection with the MySQL database.
 * 
 * It provides a reusable method to get database
 * connection throughout the application.
 * 
 * Database used: MySQL (shoesmandu)
 */
public class DBconfig {

    // DATABASE CONFIGURATION
    private static final String URL = "jdbc:mysql://localhost:3306/shoesmandu";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    /**
     * Creates and returns a database connection.
     * 
     * This method loads the MySQL JDBC driver
     * and connects to the database using
     * DriverManager.
     * 
     * @return Connection object if successful,
     *         otherwise null
     */
    public static Connection getConnection() {

        Connection conn = null;

        try {
            // LOAD MYSQL DRIVER
            Class.forName("com.mysql.cj.jdbc.Driver");

            // ESTABLISH CONNECTION
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Connected to DB");

        } catch (Exception e) {

            System.out.println("DB Connection Failed");
            e.printStackTrace();
        }

        return conn;
    }
}