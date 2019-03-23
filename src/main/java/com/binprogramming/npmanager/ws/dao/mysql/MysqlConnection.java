package com.binprogramming.npmanager.ws.dao.mysql;

import com.binprogramming.npmanager.ws.dao.DBConnection;
import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnection implements DBConnection {

    public static final String URL = "jdbc:mysql://localhost:3306/npmanager";
    public static final String USER = "root";
    public static final String PASS = "root";

    /**
     * Get a connection to database
     * @return Connection object
     */
    public Connection getConnection()
    {
        try {
            DriverManager.registerDriver(new Driver());
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }
}
