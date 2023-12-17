package com.example.broadwayroulette;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                String url = "jdbc:mysql://localhost:3306/broadwayshow1";
                String username = "root";
                String password = "password";
                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
