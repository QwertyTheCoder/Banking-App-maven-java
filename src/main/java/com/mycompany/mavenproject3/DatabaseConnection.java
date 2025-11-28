/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author HP
 */
public class DatabaseConnection {
    // Database credentials - CHANGE THESE!
    private static final String DB_URL = "jdbc:mysql://localhost:3306/javaproject";
    private static final String USER = "root";
    private static final String PASSWORD = ""; // Change if you set a password

    /**
     * Get database connection
     */
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            return conn;
        } catch (ClassNotFoundException e) {
            System.out.println("❌ MySQL Driver not found: " + e.getMessage());
            return null;
        } catch (SQLException e) {
            System.out.println("❌ Connection failed: " + e.getMessage());
            System.out.println("   Make sure MySQL is running!");
            return null;
        }
    }

    /**
     * Test connection
     */
    public static boolean testConnection() {
        try (Connection conn = getConnection()) {
            if (conn != null && !conn.isClosed()) {
                System.out.println("✅ Database connected successfully!");
                return true;
            }
        } catch (SQLException e) {
            System.out.println("❌ Test failed: " + e.getMessage());
        }
        return false;
    }

    public static void main(String[] args) {
        testConnection();
    }
}
