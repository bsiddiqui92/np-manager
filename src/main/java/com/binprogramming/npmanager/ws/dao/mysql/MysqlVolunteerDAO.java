package com.binprogramming.npmanager.ws.dao.mysql;

import com.binprogramming.npmanager.ws.dao.VolunteerDAO;
import com.binprogramming.npmanager.ws.model.Volunteer;
import com.binprogramming.npmanager.ws.shared.dto.VolunteerDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * MySqlVolunteerDao DAO for volunteer related data.
 * @author Bilal Siddiqui
 */
public class MysqlVolunteerDAO implements VolunteerDAO {

    Connection conn;

    MysqlVolunteerDAO (Connection conn) {
        this.conn = conn;
    }

    public List<Volunteer> getVolunteers(String field, String value) {

        List<Volunteer> volunteersList = new ArrayList<Volunteer>();

        try {
            // Query data from user table
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM volunteer WHERE " + field + "  = ?");
            stmt.setString(1, value);

            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                Volunteer volunteer = new Volunteer();

                volunteer.setOrganizationId(rs.getInt(Volunteer.ORGANIZATION_ID));
                volunteer.setEmail(rs.getString(Volunteer.EMAIL));
                volunteer.setFirstName(rs.getString(Volunteer.FIRST_NAME));
                volunteer.setLastName(rs.getString(Volunteer.LAST_NAME));
                volunteer.setZip(rs.getString(Volunteer.ZIP));

                volunteersList.add(volunteer);
            }
        } catch (SQLException exception) {
            System.out.println("Error establisghing db connection " + exception);
        }

        return volunteersList;
    }

    public Boolean createVolunteers(VolunteerDTO volunteerDTO) {
        return true;
    }


}
