/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.binprogramming.npmanager.ws.io.dao.mysql;

import com.binprogramming.npmanager.ws.io.dao.UserDao;
import com.binprogramming.npmanager.ws.shared.dto.UserDTO;

import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Bilal Siddiqui
 */
public class MySqlUserDao extends MySqlDao implements UserDao {
    
    public UserDTO getUserByName(String userName) {

        UserDTO user = null;

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            this.conn = this.getDatabaseConnection(DATA_SOURCE_NAME);

            String query = "SELECT * FROM users WHERE userName = ?";

            stmt = this.conn.prepareStatement(query);
            stmt.setString(1, userName);
            rs = stmt.executeQuery();

            if (rs != null && rs.next()) {
                user = new UserDTO();
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("userName"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setEmail(rs.getString("email"));
                user.setSalt(rs.getString("salt"));
                user.setEncryptedPassword(rs.getString("encryptedPassword"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            releaseRsStatementConnection(rs, stmt);
        }

        return user;
    }
    
    public UserDTO[] getAllUsers() {

        UserDTO user = null;
        ArrayList<UserDTO> al = new ArrayList<>();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            this.conn = this.getDatabaseConnection(DATA_SOURCE_NAME);

            String query = "SELECT * FROM users";

            stmt = this.conn.prepareStatement(query);
            rs = stmt.executeQuery();


            while (rs.next())
                     {
                        user = new UserDTO();
                        user.setId(rs.getInt("id"));
                        user.setUserName(rs.getString("userName"));
                        user.setFirstName(rs.getString("firstName"));
                        user.setLastName(rs.getString("lastName"));
                        user.setEmail(rs.getString("email"));
                        user.setSalt(rs.getString("salt"));
                        user.setEncryptedPassword(rs.getString("encryptedPassword"));
                        al.add(user);
                    }

                } catch(Exception e){
                    e.printStackTrace();
                } finally{
                    releaseRsStatementConnection(rs, stmt);
                }

        return  al.toArray(new UserDTO[0]);
    }
    
    public UserDTO createUser(UserDTO user) {
        // Record data in db
        PreparedStatement stmt = null;
        try {


            this.conn = this.getDatabaseConnection("npm");

            String query = "INSERT INTO users (" +
                    "userName," +
                    "firstName," +
                    "lastName," +
                    "email," +
                    "salt," +
                    "encryptedPassword," +
                    "userId" +
                    ") VALUES (?,?,?,?,?,?,?)";

            stmt = this.conn.prepareStatement(query);

            int j = 0;

            stmt.setString(++j, user.getUserName());
            stmt.setString(++j, user.getFirstName());
            stmt.setString(++j, user.getLastName());
            stmt.setString(++j, user.getEmail());
            stmt.setString(++j, user.getSalt());
            stmt.setString(++j, user.getEncryptedPassword());
            stmt.setString(++j, user.getUserId());

            stmt.execute();

            int id = this.getSequence();
            user.setId(id);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.releaseRsStatementConnection(null, stmt);
        }

        return new UserDTO();
    }
    
}
