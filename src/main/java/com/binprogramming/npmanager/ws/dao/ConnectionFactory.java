package com.binprogramming.npmanager.ws.dao;

import com.binprogramming.npmanager.ws.dao.mysql.MysqlConnection;

/**
 * Connection factory will return instantiated instance of specified connection class.
 * @author Bilal Siddiqui <bos19992@gmail.com>
 */
public class ConnectionFactory {

    public static final int MYSQL = 1;

    public static MysqlConnection getConnectionFactory(int whichFactory) {
        switch (whichFactory) {
            case MYSQL : return new MysqlConnection();
            default: return null;
        }
    }
}
