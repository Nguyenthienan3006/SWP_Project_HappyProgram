/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import DB.DBConnect;
import static DB.DBConnect.getJDBCConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import model.ListInvitedRequest;
import model.ListRequest;
import model.StatisticRequestMentee;

/**
 *
 * @author An Nguyen
 */
public class ListRequestDAO extends DBConnect {

    public ArrayList<ListRequest> ListRequest(int u_Id) {
        //list chứa danh sách request by mentee
        ArrayList<ListRequest> ListRequest = new ArrayList<>();
        // Chuỗi truy vấn SELECT để lấy danh sách mentor
        String query = "with R as (\n"
                + "select U.full_name as 'MentorName', R.RequestStatus, R.created_date, R.finish_date, R.menteeID, R.mentorID, S.Skill_Name, DATE_FORMAT(R.Date_hour, '%H:%i:%s') AS Deadline_hour, R.Title_of_request, R.Desciption_of_request, R.Request_hour\n"
                + "from request as R, user as U, skills as S\n"
                + "where R.mentorID = U.u_id and S.skill_Id = R.Skill_Id and U.role = 2\n"
                + ")\n"
                + "select R.MentorName, R.mentorID, U.full_name as 'MenteeName', R.menteeID, R.Skill_Name, R.created_date, R.finish_date, E.Name as 'RequestStatus', R.Deadline_hour,  R.Title_of_request, R.Desciption_of_request, R.Request_hour\n"
                + "from R, user as U, requeststatus as E\n"
                + "where R.menteeID = U.u_Id and R.RequestStatus = E.status_Id and U.u_Id = ?";
        try {
            PreparedStatement st = getJDBCConnection().prepareStatement(query);
            st.setInt(1, u_Id);
            ResultSet resultSet = st.executeQuery();
            // Duyệt qua kết quả truy vấn và hiển thị thông tin request
            while (resultSet.next()) {
                String mentorName = resultSet.getString("MentorName");
                int mentorID = resultSet.getInt("mentorID");
                String menteeName = resultSet.getString("MenteeName");
                int menteeID = resultSet.getInt("menteeID");
                String Skill_Name = resultSet.getString("Skill_Name");
                String created_date = resultSet.getString("created_date");
                String finish_date = resultSet.getString("finish_date");
                String RequestStatus = resultSet.getString("RequestStatus");
                Time Deadline_hour = resultSet.getTime("Deadline_hour");
                String Title_of_request = resultSet.getString("Title_of_request");
                String Desciption_of_request = resultSet.getString("Desciption_of_request");
                float Request_hour = resultSet.getFloat("Request_hour");

                //add mentor từ database vào list
                ListRequest list = new ListRequest(mentorName, mentorID, menteeName, menteeID, Skill_Name, created_date,
                        finish_date, RequestStatus, Deadline_hour, Title_of_request, Desciption_of_request, Request_hour);
                ListRequest.add(list);

            }

            // Đóng kết nối và giải phóng tài nguyên
            resultSet.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ListRequest;
    }

    public ArrayList<StatisticRequestMentee> StatisticRequest(int menteeID) {
        //list chứa danh sách Statistic Request
        ArrayList<StatisticRequestMentee> ListStatistic = new ArrayList<>();
        try {

            // Chuỗi truy vấn SELECT để lấy danh sách mentor
            String query = "select R.Title_of_request, R.mentorID, S.Skill_Name, count(R.mentorID) as 'NumberOfAllRequests', sum(R.Request_hour) as 'TotalHoursOfAllRequest', count(R.mentorID) as 'NumberOfMentors'\n"
                    + "from Request as R, Skills as S\n"
                    + "where R.skill_Id = S.skill_Id and R.menteeID = ?\n"
                    + "group by R.Title_of_request, R.mentorID, S.Skill_Name;";

            PreparedStatement st = getJDBCConnection().prepareStatement(query);
            st.setInt(1, menteeID);
            ResultSet resultSet = st.executeQuery();

            // Duyệt qua kết quả truy vấn và hiển thị thông tin mentor
            while (resultSet.next()) {
                String Title_of_request = resultSet.getString("Title_of_request");
                int mentorID = resultSet.getInt("mentorID");
                String SkillName = resultSet.getString("Skill_Name");
                int Number_Of_All_Request = resultSet.getInt("NumberOfAllRequests");
                float Total_hours_of_all_request = resultSet.getFloat("TotalHoursOfAllRequest");
                int Number_Of_Mentors = resultSet.getInt("NumberOfMentors");
                //add mentor từ database vào list
                StatisticRequestMentee list = new StatisticRequestMentee(Title_of_request, mentorID, SkillName, Number_Of_All_Request, Total_hours_of_all_request, Number_Of_Mentors);
                ListStatistic.add(list);

            }

            // Đóng kết nối và giải phóng tài nguyên
            resultSet.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ListStatistic;
    }

    public ArrayList<ListInvitedRequest> InvitedRequest() {
        //list chứa danh sách invited Request
        ArrayList<ListInvitedRequest> ListInvited = new ArrayList<>();
        try {
            // Kết nối đến cơ sở dữ liệu

            DBConnect db = new DBConnect();
            Connection con = db.getJDBCConnection();
            // Tạo đối tượng Statement để thực thi câu truy vấn
            Statement statement = con.createStatement();

            // Chuỗi truy vấn SELECT để lấy danh sách mentor
            String query = "select R.menteeID, U.full_name, R.Title_of_request, R.Desciption_of_request, S.Skill_Name, R.finish_date as 'Dealine_date', DATE_FORMAT(R.Date_hour, '%H:%i:%s') AS Deadline_hour, R.Request_hour\n"
                    + "from Request as R, Skills as S, User as U\n"
                    + "where R.skill_Id = S.skill_Id and R.menteeID = U.u_Id";

            // Thực thi câu truy vấn SELECT
            ResultSet resultSet = statement.executeQuery(query);

            // Duyệt qua kết quả truy vấn và hiển thị thông tin mentor
            while (resultSet.next()) {
                int menteeID = resultSet.getInt("menteeID");
                String full_name = resultSet.getString("full_name");
                String Title_of_request = resultSet.getString("Title_of_request");
                String Desciption_of_request = resultSet.getString("Desciption_of_request");
                String Skill_Name = resultSet.getString("Skill_Name");
                String Dealine_date = resultSet.getString("Dealine_date");
                String Deadline_hour = resultSet.getString("Deadline_hour");
                float Number_Of_Mentors = resultSet.getFloat("Request_hour");

                //add mentor từ database vào list
                ListInvitedRequest list = new ListInvitedRequest(menteeID, full_name, Title_of_request, Desciption_of_request,
                        Skill_Name, Dealine_date, Deadline_hour, Number_Of_Mentors);
                ListInvited.add(list);

            }

            // Đóng kết nối và giải phóng tài nguyên
            resultSet.close();
            statement.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ListInvited;
    }

    public static void main(String[] args) {
        ListRequestDAO d = new ListRequestDAO();
        ArrayList<ListRequest> ListInvited = d.ListRequest(15);
        if (ListInvited.size() == 0) {
            System.out.println("error");
        } else {
            System.out.println("oke");
        }
    }
}