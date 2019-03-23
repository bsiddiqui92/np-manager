package com.binprogramming.npmanager.ws.dao;

import com.binprogramming.npmanager.ws.dao.mysql.MysqlConnection;

public class ConnectionFactory {

    public static final int MYSQL = 1;

    public static MysqlConnection getConnectionFactory(int whichFactory) {
        switch (whichFactory) {
            case MYSQL : return new MysqlConnection();
            default: return null;
        }
    }
}
