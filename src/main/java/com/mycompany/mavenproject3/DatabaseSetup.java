/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

/**
 *
 * @author HP
 */
public class DatabaseSetup {
    public static void initializeDatabase() {
        System.out.println("🔧 Initializing database...");
        createUsersTable();
        createTransactionsTable();
        System.out.println("✅ Database ready!");
    }
    
    private static void createUsersTable() {
        String sql = """
            CREATE TABLE IF NOT EXISTS users (
                id INT PRIMARY KEY AUTO_INCREMENT,
                username VARCHAR(50) UNIQUE NOT NULL,
                password VARCHAR(255) NOT NULL,
                balance DECIMAL(10, 2) DEFAULT 0.00,
                created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
            )
        """;
        executeSQL(sql, "Users table");
    }
    
    private static void createTransactionsTable() {
        String sql = """
            CREATE TABLE IF NOT EXISTS transactions (
                id INT PRIMARY KEY AUTO_INCREMENT,
                user_id INT NOT NULL,
                type VARCHAR(20) NOT NULL,
                amount DECIMAL(10, 2) NOT NULL,
                timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
            )
        """;
        executeSQL(sql, "Transactions table");
    }
    
    private static void executeSQL(String sql, String description) {
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("✅ " + description + " created");
        } catch (SQLException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        initializeDatabase();
    }
}
