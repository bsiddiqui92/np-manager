/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.binprogramming.npmanager.ws.dao.mysql;

import com.binprogramming.npmanager.ws.dao.User;
import com.binprogramming.npmanager.ws.shared.dto.UserDTO;

import java.sql.*;

/**
 * MysqlUserDAO DAO for user related data.
 * @author Bilal Siddiqui
 */
public class MySqlUserDAO implements User {

    Connection conn;

    MySqlUserDAO (Connection conn) { this.conn = conn; }

    /**
     * Retrieve user data by username.
     * @param  field
     * @param value
     * @return UserDTO
     */
    public UserDTO getUser(String field, String value) {

        UserDTO returnValue = new UserDTO();

        try {
            // Query data from user table
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM user WHERE " + field + "  = ?");
            stmt.setString(1, value);

            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                returnValue.setId( rs.getInt("id") );
                returnValue.setFirstName( rs.getString("first_name") );
                returnValue.setLastName( rs.getString("last_name") );
                returnValue.setEmail( rs.getString("email") );
                returnValue.setPhone( rs.getString("phone") );
                returnValue.setAddress( rs.getString("address") );
                returnValue.setState( rs.getString("state") );
                returnValue.setCity( rs.getString("city") );
                returnValue.setZip( rs.getString("zip") );
            }

         } catch (SQLException exception) {
            System.out.println("Error establisghing db connection " + exception);
        }

        return returnValue;
    }

    @Override
    public UserDTO getAllUsers() {
        return null;
    }

    @Override
    public UserDTO saveUser(UserDTO user) {
        return null;
    }
}
