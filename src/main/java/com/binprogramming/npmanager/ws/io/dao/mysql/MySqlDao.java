package com.binprogramming.npmanager.ws.io.dao.mysql;

import com.binprogramming.npmanager.ws.utils.DatabaseUtils;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class MySqlDao implements Serializable{

    private static final Logger log = LoggerFactory.getLogger(MySqlDao.class);

    public static final String DATA_SOURCE_NAME = "npm";

    private DataSource ds = new DataSource();

    public Connection conn;

    public MySqlDao() {
        this.conn = null;
    }


    public Connection getDatabaseConnection(String dataSourceName) {

        try {
            if (this.conn != null && !this.conn.isClosed())
                return this.conn;
        } catch (SQLException e) {
            log.error("Exception occurred", e);
        }

        try {

            Context ctx = new InitialContext();

            ds = (DataSource) ctx.lookup("java:comp/env/jdbc/"
                    + dataSourceName);

            if (ds == null) {
                throw new Exception("DataSource is null");
            }
            conn = ds.getConnection();
            if (conn == null) {
                throw new Exception("Connection is null");
            }

            return conn;

        } catch (Exception e) {
            log.error("Exception occurred: " + e.getMessage());
            // The following line of code will be called if we are using a DAO class outside of a container, for example from the command line.
            conn = DatabaseUtils.getPooledDatabaseConnection();
        }
        return conn;
    }

    public Connection getBasicDatabaseConnection(String dataSourceName) {

        try {
            if (this.conn != null && !this.conn.isClosed())
                return this.conn;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {

            // Context ctx = new InitialContext();
            // DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/" +
            // dataSourceName);

            String driverClassName = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/" + dataSourceName;
            String username = "npm";
            String password = "sectretpwd";
            int maxTotal = 20;
            int maxIdle = 10;
            int minIdel = 4;

            ds.setDriverClassName(driverClassName);
            ds.setUrl(url);
            ds.setUsername(username);
            ds.setPassword(password);
            ds.setMaxActive(maxTotal);
            ds.setMaxIdle(maxIdle);
            ds.setMinIdle(minIdel);
            ds.setTestWhileIdle(true);
            ds.setValidationQuery("SELECT 1");

            conn = ds.getConnection();
            if (conn == null) {
                throw new Exception("Connection is null");
            }

            return conn;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }


//	public int getSequence() throws Exception {
//
//		int sequence = 0;
//		Statement stmt;
//		try {
//			String query = "select @@identity";
//			stmt = conn.createStatement();
//			ResultSet rs = stmt.executeQuery(query);
//			rs.next();
//			sequence = rs.getInt(1);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return sequence;
//	}


    public int getSequence() throws Exception {

        int sequence = 0;
        Statement stmt;

        try {

            String query = "SELECT LAST_INSERT_ID() as id";
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            sequence = Integer.parseInt(rs.getString("id"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sequence;
    }


    public void releaseRsStatementConnection(ResultSet rs, Statement stmt) {

        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            this.releaseDatabaseConnection();
        } catch (SQLException e) {
            log.error("SQLException occurred", e);
        }
    }


    public void releaseDatabaseConnection() throws SQLException {

        if (this.conn != null && !this.conn.isClosed()) {
            this.conn.close();
        }
        this.conn = null;
    }

}
