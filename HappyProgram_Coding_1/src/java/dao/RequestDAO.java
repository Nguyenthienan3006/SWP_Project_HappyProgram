package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public static void main(String[] args) {
        RequestDAO r = new RequestDAO();
        r.UpdateRequest_Mentor(3);
    }
}

