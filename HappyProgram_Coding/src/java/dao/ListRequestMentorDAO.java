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
        xSql = "Select R.RequestID, R.menteeID as 'MenteeID', U.full_name as 'MenteeName', "
                + "R.Title_of_request as 'TitleOfRequest',R2.Name as 'RequestStatus'\n"
                + "from request as R, User as U, requeststatus as R2\n"
                + "where R.menteeID = U.u_id and R.RequestStatus = R2.status_Id and R.mentorID = ?\n"
                + "order by R.RequestID";
        try {
            String MenteeName, Title_of_request, Desciption_of_request, created_date, finish_date, Status;
            Time Date_hour;
            float Request_hour;
            int RequestID;
            ps = con.prepareStatement(xSql);
            ps.setInt(1, mentorId);
            rs = ps.executeQuery();
            while (rs.next()) {
                int requestID = rs.getInt("requestID");
                int menteeID = rs.getInt("MenteeID");
                String menteeName = rs.getString("MenteeName");
                String TitleOfRequest = rs.getString("TitleOfRequest");
                String RequestStatus = rs.getString("RequestStatus");

                //add mentor từ database vào list
                ListRequest listallreqMentor = new ListRequest(requestID, menteeName, menteeID, RequestStatus, TitleOfRequest);
                list.add(listallreqMentor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<ListRequest> listRequestDetailMentor(int mentorId, int requestId) {
        List<ListRequest> list = new ArrayList<>();
        xSql = " SELECT r.requestID AS RequestID,\n"
                + " u.full_name AS MenteeName,\n"
                + "s.Skill_Name AS SkillName,\n"
                + "r.Title_of_request AS Title_of_request,\n"
                + "r.Desciption_of_request AS Desciption_of_request,\n"
                + "r.created_date AS created_date,\n"
                + "r.finish_date AS finish_date,\n"
                + "r.Date_hour AS Date_hour,\n"
                + "r.Request_hour AS Request_hour,\n"
                + "rs.Name AS Status\n"
                + "FROM User u\n"
                + "JOIN Request r ON u.u_id = r.menteeID\n"
                + "Join SkillOfRequest sor on sor.request_Id = r.requestId\n"
                + "JOIN Skills s ON sor.skill_id = s.skill_id\n"
                + "JOIN RequestStatus rs ON rs.status_id = r.RequestStatus\n"
                + "WHERE r.mentorId = ? and r.requestID = ?;";
        try {

            ps = con.prepareStatement(xSql);
            ps.setInt(1, mentorId);
            ps.setInt(2, requestId);
            rs = ps.executeQuery();
            while (rs.next()) {
                int requestID = rs.getInt("requestID");;
                String menteeName = rs.getString("MenteeName");
                String Skill_Name = rs.getString("SkillName");
                String TitleOfRequest = rs.getString("Title_of_request");
                String DesciptionOfRequest = rs.getString("Desciption_of_request");
                String created_date = rs.getString("created_date");
                String finish_date = rs.getString("finish_date");
                Time Date_hour = rs.getTime("Date_hour");
                float Request_hour = rs.getFloat("Request_hour");
                String Status = rs.getString("Status");
                //add mentor từ database vào list
                ListRequest listallreqMentor = new ListRequest (requestID, menteeName,  Skill_Name,  created_date, 
                         finish_date,  Date_hour,  TitleOfRequest, 
                         DesciptionOfRequest,  Request_hour,  Status);
                list.add(listallreqMentor);
                
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
    public static void main(String[] args) {
        ListRequestMentorDAO d = new ListRequestMentorDAO();
        d.listRequestDetailMentor(3, 2);
    }
    
}
