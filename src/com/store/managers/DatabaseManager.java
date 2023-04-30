package com.store.managers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class DatabaseManager {

    public static Connection getConnection() throws Exception {
        Connection conn;

        Class.forName("oracle.jdbc.OracleDriver");

        conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "stock", "stock");
        return conn;
    }
    
    public static void closeConnection(Connection conn){
        try {
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public static void closeStatment(PreparedStatement stmt){
        try {
            stmt.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public static void closeResultSet(ResultSet rs){
        try {
            rs.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}