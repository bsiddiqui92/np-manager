package com.binprogramming.npmanager.ws.dao;

import java.sql.Connection;


public interface DBConnection {

    String URL = null;
    String USER = null;
    String PASS = null;

    /**
     * Get a connection to   database
     * @return Connection object
     */
    Connection getConnection();
}
