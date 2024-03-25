package ru.dmitry.Util;

import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class Connect {
    private static final String URL = "jdbc:mysql://localhost:3306/my_db?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";


    public static Connection getConnection() {
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException | ClassNotFoundException c) {
            c.printStackTrace();
        }

        return connection;
    }
}
