package com.binprogramming.npmanager.ws.dao;

import com.binprogramming.npmanager.ws.dao.mysql.MysqlDAO;

public class DAOFactory {

    public static final int MYSQL_DAO = 1;

    public static DAO getDAOFactory(int whichFactory) {
        switch (whichFactory) {
            case MYSQL_DAO : return new MysqlDAO();
            default: return null;
        }
    }
}
