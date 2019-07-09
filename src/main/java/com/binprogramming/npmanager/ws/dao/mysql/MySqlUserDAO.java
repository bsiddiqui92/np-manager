package com.binprogramming.npmanager.ws.dao.mysql;

import com.binprogramming.npmanager.ws.dao.UserDAO;
import com.binprogramming.npmanager.ws.model.User;
import com.binprogramming.npmanager.ws.shared.dto.UserDTO;

import java.sql.*;

/**
 * MysqlUserDAO DAO for user related data.
 * @author Bilal Siddiqui
 */
public class MySqlUserDAO implements UserDAO {

    Connection conn;

    MySqlUserDAO (Connection conn) { this.conn = conn; }

    /**
     * Retrieve user data by username.
     * @param  field
     * @return UserDTO
     */
    public UserDTO getUser(String field, String value) {

        User user = new User();
        UserDTO returnValue = new UserDTO();

        try {
            // Query data from user table
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM user WHERE " + field + "  = ?");
            stmt.setString(1, value);

            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                user.setId( rs.getInt("id") );
                user.setFirstName( rs.getString("first_name") );
                user.setLastName( rs.getString("last_name") );
                user.setEmail( rs.getString("email") );
                user.setPhone( rs.getString("phone") );
                user.setAddress( rs.getString("address") );
                user.setState( rs.getString("state") );
                user.setCity( rs.getString("city") );
                user.setZip( rs.getString("zip") );
            }

            returnValue.setUser(user);
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
