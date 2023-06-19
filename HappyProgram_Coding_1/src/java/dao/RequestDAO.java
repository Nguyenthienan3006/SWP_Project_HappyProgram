package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import model.*;

public class RequestDAO extends MyDAO {

    public int UpdateRequest_Mentor(int requestID) {
        int mess = 0;
        // Chuỗi truy vấn SELECT để lấy danh sách mentor
        String query = "UPDATE Request\n"
                + "SET RequestStatus = 2\n"
                + "WHERE RequestID = ?;";
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, requestID);
            // Đóng kết nối và giải phóng tài nguyên

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            mess = 1;
        }
        return mess;
    }

    public int RejectRequest_Mentor(int requestID) {
        int mess = 0;
        // Chuỗi truy vấn SELECT để lấy danh sách mentor
        String query = "UPDATE Request\n"
                + "SET RequestStatus = 3\n"
                + "WHERE RequestID = ?;";
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, requestID);
            // Đóng kết nối và giải phóng tài nguyên

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            mess = 1;
        }
        return mess;
    }

    public boolean createRequest(int menteeId, int mentorId, int requestStatus, String createdDate, String finishDate, String Date_hour, float Request_hour, String Title_of_request, String Desciption_of_request) {
        // Lấy thời gian hiện tại
        LocalDateTime currentTime = LocalDateTime.now();
        // Cộng thêm 12 giờ
        LocalDateTime newTime = currentTime.plusHours(12);
        // Định dạng lại chuỗi thời gian
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String currentFormatted = currentTime.format(formatter);
        String newFormatted = newTime.format(formatter);
        LocalDateTime currentDateTime = LocalDateTime.parse(currentFormatted, formatter);
        LocalDateTime newDateTime = LocalDateTime.parse(newFormatted, formatter);
        // In ra kết quả
        System.out.println("Thời gian hiện tại: " + currentDateTime);
        System.out.println("Thời gian sau khi cộng 12 giờ: " + newDateTime);
        // Chuyển đổi LocalDateTime thành Timestamp
        Timestamp timestamp = Timestamp.valueOf(newDateTime);
        //******************************************************

        try {
            String sql = "INSERT INTO Request (menteeID, mentorID, RequestStatus, created_date, finish_date, Date_hour, "
                    + "Request_hour, Title_of_request, Desciption_of_request) \n"
                    + "VALUES\n"
                    + "(?, ?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement ps = con.prepareStatement(sql);


                ps.setInt(1, menteeId);
                ps.setInt(2, mentorId);
                //   ps.setInt(2, Integer.parseInt(sessionUser_id));
                //  ps.setInt(3, skillId);
                ps.setInt(3, requestStatus);
                ps.setString(4, createdDate);
                ps.setString(5, finishDate);
                ps.setString(6, Date_hour);
                ps.setFloat(7, Request_hour);
                ps.setString(8, Title_of_request);

                ps.setString(9, Desciption_of_request);

                ps.executeUpdate();
                ps.close();

                //  ps.setTimestamp(5, timestamp);
                System.out.print("thanh cong ");
            return true;

        } catch (SQLException e) {
            System.out.println("Error in BlogDAO.createBlog()");
            return false;
        }
    }

    public static void main(String[] args) {
        RequestDAO r = new RequestDAO();
        r.createRequest(2, 3, 1, "2023-01-01", "2023-01-10", "2023-01-10 06:00:00", 2, "Hoc lap trinh",
                "Lap trinh co ban cho ngươi moi");
    }
    
}


    
    

