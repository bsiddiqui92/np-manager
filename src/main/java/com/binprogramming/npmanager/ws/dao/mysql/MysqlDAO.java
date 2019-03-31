package com.binprogramming.npmanager.ws.dao.mysql;

import com.binprogramming.npmanager.ws.dao.*;

import java.sql.Connection;

public class MysqlDAO implements DAO {

    /**
     * Connection conn connection object for mysql.
     */
    private Connection conn;

    private MySqlUserDAO userDAO = null;
    private MysqlVolunteerDAO volunteerDAO = null;
    private MysqlOrganizationDao organizationDao = null;

    public MysqlDAO() {
        ConnectionFactory ConnFacotry = new ConnectionFactory();
        MysqlConnection MysqlConn = ConnFacotry.getConnectionFactory(1);
        this.conn = MysqlConn.getConnection();
    }

    /**
     * Return instance of MysqlUserDao.
     * @return MysqlUserDAO
     */
    public User user() {
        if (this.userDAO == null)
            this.userDAO = new MySqlUserDAO(this.conn);
        return this.userDAO;
    }

    /**
     * Return instance of MysqlVolunteerDAO.
     * @return MysqlVolunteerDAO
     */
    public Volunteer volunteer() {
        if (this.volunteerDAO == null)
            this.volunteerDAO = new MysqlVolunteerDAO();
        return this.volunteerDAO;
    }

    /**
     * Return instance of MysqlOrganizationDAO.
     * @return MysqlOrganizationDAO
     */
    public Organization organization() {
        if (this.organizationDao == null)
            this.organizationDao = new MysqlOrganizationDao(this.conn);
        return this.organizationDao;
    }

    
}
