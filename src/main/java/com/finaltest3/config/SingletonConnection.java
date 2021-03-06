package com.finaltest3.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {
    private static Connection connection;
    private SingletonConnection(){

    }
    public static final String URL = "jdbc:mysql://localhost:3306/quanlisanpham";
    public static final String USER = "root";
    public static final String PASSWORD = "123456";

    public static Connection getConnect() {
        if (connection == null)  {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("Connect successes");
                e.printStackTrace();
            }
        }
        return connection;
    }
}
