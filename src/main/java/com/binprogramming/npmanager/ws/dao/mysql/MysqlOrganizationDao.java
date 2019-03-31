package com.binprogramming.npmanager.ws.dao.mysql;

import com.binprogramming.npmanager.ws.dao.Organization;
import com.binprogramming.npmanager.ws.shared.dto.OrganizationDTO;

import java.sql.*;
import java.util.List;

public class MysqlOrganizationDao implements Organization {
    
    Connection conn;
    
    MysqlOrganizationDao (Connection conn) { this.conn = conn; }

    MysqlOrganizationDao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public OrganizationDTO getOrganization(String field, String value){
        
        OrganizationDTO returnValue = new OrganizationDTO();
        
        try {
            // Query data from user table
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM organization WHERE " + field + "  = ?");
            stmt.setString(1, value);

            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                returnValue.setId( rs.getInt("id") );
                returnValue.setName( rs.getString("name") );
                returnValue.setPrimaryEmail( rs.getString("primary_email") );
                returnValue.setPrimaryPhone( rs.getString("primary_phone") );
                returnValue.setMission( rs.getString("mission") );
            }
        } catch (SQLException exception) {
            System.out.println("Error establisghing db connection " + exception);
        }
        
        return (OrganizationDTO) returnValue;
    }

    @Override
    public OrganizationDTO saveOrganization(OrganizationDTO organization) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
