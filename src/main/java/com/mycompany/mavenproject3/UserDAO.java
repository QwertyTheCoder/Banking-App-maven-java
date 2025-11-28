/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3;
import java.sql.*;
/**
 *
 * @author HP
 */

public class UserDAO {
    
    public static boolean RegisterUser(String username, String password){
        String sql = "insert into users(username, password, balance) values (?, ?, 0.00)";
        
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.executeUpdate();
            
            System.out.println("User Registered:" + username);
            return true;
        
        } catch (SQLException e) {
            if (e.getErrorCode() == 1062) {
                System.out.println("Username already exists");
            }
            else{
                System.out.println("Registration failed");
            }
        } return false;
            
    }
    
    public static boolean LoginUser(String username, String password){
        String sql = "Select * from users where username = ? and password = ?";
        try (Connection Conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = Conn.prepareStatement(sql)) {
            
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            
            if  (rs.next()) {
                System.out.println("Login successful");
                return true;
                
            }
            else {
                System.out.println("Login Failed");
                return false;
               
            }
        } catch (SQLException e) {
            System.out.println("Login Failed");
        } return false;
    }
    
    public static double getbalance(String username) {
        String sql = "Select balance from users where username = ?";
        try (Connection Conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = Conn.prepareStatement(sql)) {
            
            pstmt.setString(1, username);
//            pstmt.setString(2, password);
            
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                return rs.getDouble("balance");
                
            }
        } catch (SQLException e) {
            System.out.println("error");
        }
        return -1;
        
    }
    public static boolean updateBalance(String username, double newBalance){
        String sql = "update users set balance = ? where username = ?";
        try (Connection Conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = Conn.prepareStatement(sql)){
            
            pstmt.setDouble(1, newBalance);
            pstmt.setString(2, username);
//            pstmt.setString(3, password);
            
            pstmt.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            System.out.println("New Balance failed");
        } return false;
    }
    
    public static boolean deposit(String username,  double amount) {
        if (amount <= 0){
            System.out.println("Amount should be postive");
            return false;
        }
        double currentBalance = getbalance(username);
        double newBalance = currentBalance + amount;
        
        if (updateBalance(username, newBalance)) {
          //  recordTransaction(username, "DEPOSIT", amount, "Deposit");
//          recordTransaction(username, "DEPOSIT", amount);
            System.out.println("Deposited" + amount);
            return true;
        }
        return false;
    }
    
    public static boolean withdraw(String username, double amount) {
        if (amount <= 0) {
            return false;
        }
        double currentBalance = getbalance(username);
        if (currentBalance < amount) {
            return false;
        }
        
        double newBalance = currentBalance - amount;
        
        if (updateBalance(username, newBalance)) {
//            recordTransaction(username, "Withdraw")
            System.out.println("WIthdrawn: " + amount);
            return true;
        }
        return false;
        
    }
    
    public static boolean transfer(String from, String to, double amount){
        if (from.equals(to) || amount<=0) {
            return false;
        }
        
        double newBalancefrom = getbalance(from) - amount;
        double newBalanceto = getbalance(to) + amount;
        if (getbalance(from) == -1 || newBalancefrom < 0) {
            return false;
        }
        if (updateBalance(from, newBalancefrom) && updateBalance(to, newBalanceto)) {
            System.out.println("Transfered");
            return true;
        }
        
        return false;
    }
    
//    public static boolean recordTransaction(String username, String type, double amounnt) {
//        String sql1 = "Insert into transactins(username, type, amount) values(?, ?, ?);";
//        try (Connection Conn = DatabaseConnection.getConnection();
//                PreparedStatement pstmt = PreparedStatement(sql1)) {
//            pstmt.setString(1, username);
//            pstmt.setString(2, type);
//            pstmt.setString(3, amount);
//            
//            pstmt.executeUpdate();
//            
//        
//    }
}
