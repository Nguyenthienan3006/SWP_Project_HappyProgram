/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import model.ListRequest;

/**
 *
 * @author An Nguyen
 */
public class ListRequestMentorDAO extends MyDAO {

    public List<ListRequest> listRequestMentor(int mentorId) {
        List<ListRequest> list = new ArrayList<>();
        xSql = " SELECT u.full_name AS MenteeName,\n"
                + "       s.Skill_Name AS SkillName,\n"
                + "       r.Title_of_request AS Title_of_request,\n"
                + "       r.Desciption_of_request AS Desciption_of_request,\n"
                + "       r.created_date AS created_date,\n"
                + "       r.finish_date AS finish_date,\n"
                + "       r.Date_hour AS Date_hour,\n"
                + "       r.Request_hour AS Request_hour,\n"
                + "       rs.Name AS Status\n"
                + "FROM User u\n"
                + "JOIN Request r ON u.u_id = r.menteeID\n"
                + "Join SkillOfRequest sor on sor.request_Id = r.requestId\n"
                + "JOIN Skills s ON sor.skill_id = s.skill_id\n"
                + "JOIN RequestStatus rs ON rs.status_id = r.RequestStatus\n"
                + "WHERE r.mentorId = ?;";
        try {
            String MenteeName, SkillName, Title_of_request, Desciption_of_request, created_date, finish_date, Status;
            Time Date_hour;
            float Request_hour;
            ps = con.prepareStatement(xSql);
            ps.setInt(1, mentorId);
            rs = ps.executeQuery();
            while (rs.next()) {
                MenteeName = rs.getString("MenteeName");
                SkillName = rs.getString("SkillName");
                Title_of_request = rs.getString("Title_of_request");
                Desciption_of_request = rs.getString("Desciption_of_request");
                created_date = rs.getString("created_date");
                finish_date = rs.getString("finish_date");
                Status = rs.getString("Status");
                Date_hour = rs.getTime("Date_hour");
                Request_hour = rs.getFloat("Request_hour");

                ListRequest r = new ListRequest(MenteeName, SkillName, created_date, finish_date, Date_hour, Title_of_request, Desciption_of_request, Request_hour, Status);
                list.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public int countRequestStatus(int mentorID, String requestStatus) {
        xSql = "SELECT COUNT(*) as count FROM Request WHERE mentorID = ? AND RequestStatus = (SELECT status_Id FROM RequestStatus WHERE Name = ?)";
        int count = 0;
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, mentorID);
            ps.setString(2, requestStatus);
            rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt("count");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

}
