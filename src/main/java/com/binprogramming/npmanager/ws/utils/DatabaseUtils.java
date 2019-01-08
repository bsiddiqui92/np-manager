package com.binprogramming.npmanager.ws.utils;


import org.apache.tomcat.jdbc.pool.DataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtils {

    /*
     * Utility class that provides two different (1. single DriverManager connection, 2. a connection pool)
     * non container managed ways to connect to a database.
     */

    private static final String driverClassName = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/npm";
    private static final String username = "npm";
    private static final String password = "secretpwd";
    private static final int maxActive = 100;
    private static final int maxIdle = 10;
    private static final int minIdle = 4;
    private static final int maxWait = 5000;
    private static final String query = "SELECT 1";

    public static Connection getSingleDatabaseConnection() {

        Connection conn = null;

        try {

            Class.forName(driverClassName);
            conn = DriverManager.getConnection(url, username, password);

        } catch(ClassNotFoundException cnfe) {
            System.err.println("Error loading driver: " + cnfe);
        } catch(SQLException sqle) {
            System.err.println("Error connecting: " + sqle);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;

    }


    public static Connection getPooledDatabaseConnection() {

        // The class BasicDataSource lives in package org.apache.commons.dbcp2 in commons-dbcp2-2.1.jar
//        BasicDataSource bds = new BasicDataSource();
        DataSource ds = new DataSource();

        ds.setDriverClassName(driverClassName);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        ds.setInitialSize(10);
        ds.setMaxActive(maxActive);
//       bds.setMaxTotal(Integer.parseInt(maxActive));
        ds.setMaxIdle(maxIdle);
        ds.setMinIdle(minIdle);
        ds.setMaxWait(maxWait);
        ds.setTestWhileIdle(true);
        ds.setValidationQuery(query);

        Connection conn = null;

        try {

            conn = ds.getConnection();

        } catch (SQLException sqle) {
            System.err.println("Error connecting: " + sqle);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;

    }



}