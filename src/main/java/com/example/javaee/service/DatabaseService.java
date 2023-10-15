package com.example.javaee.service;

import java.sql.*;

public class DatabaseService {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/javaee?autoReconnect=true&useSSL=false";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "5858";
    private static final String createTableSQL = "CREATE TABLE IF NOT EXISTS TeamList ( id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255))";

    public static Connection getConnection() {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            statement = connection.prepareStatement(createTableSQL);
            statement.executeUpdate();
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
