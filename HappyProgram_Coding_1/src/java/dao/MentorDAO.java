/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.ListMentor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import DB.DBConnect;
import java.sql.Date;

public class MentorDAO {
    
     public ArrayList<ListMentor> displayMentorList() {
        //list chứa danh sách mentor
        ArrayList<ListMentor> mentorList = new ArrayList<>();
        try {
            // Kết nối đến cơ sở dữ liệu

            DBConnect db = new DBConnect();
            Connection con = db.getJDBCConnection();
            // Tạo đối tượng Statement để thực thi câu truy vấn
            Statement statement = con.createStatement();

            // Chuỗi truy vấn SELECT để lấy danh sách mentor
            String query = "SELECT \n"
                    + "     ROW_NUMBER() OVER (ORDER BY U.u_Id) AS STT,\n"
                    + "     U.u_Id AS ID,\n"
                    + "     U.full_name AS Fullname,\n"
                    + "     U.image AS Image,\n"
                    + "     U.username AS Accountname,\n"
                    + "     CD.professional_summary AS Profession,\n"
                    + "     COUNT(CM.mentor_Id) AS NumberOfAcceptedRequest,\n"
                    + "     CONCAT(ROUND((COUNT(CM.mentor_Id) / COUNT(CD.cv_Id)) * 100, 0), '%') AS PercentageCompleted,\n"
                    + "	 ROUND(AVG(R.Rated_point),0) AS RateStar,\n"
                    + "     'Link_or_button' AS Action\n"
                    + " FROM\n"
                    + "     `User` U\n"
                    + "         INNER JOIN\n"
                    + "     CvOfMentor CM ON U.u_Id = CM.mentor_Id\n"
                    + "         INNER JOIN\n"
                    + "     CvDetail CD ON CM.cv_Id = CD.cv_Id\n"
                    + "              LEFT JOIN\n"
                    + "     Rate R ON U.u_Id = R.mentorID\n"
                    + " WHERE\n"
                    + "     U.`role` = (SELECT role_Id FROM `Role` WHERE role_name = 'Mentor')\n"
                    + " GROUP BY\n"
                    + "     U.u_Id , U.full_name , U.username , CD.professional_summary\n"
                    + " ORDER BY\n"
                    + "     U.u_Id;";

            // Thực thi câu truy vấn SELECT
            ResultSet resultSet = statement.executeQuery(query);

            // Duyệt qua kết quả truy vấn và hiển thị thông tin mentor
            while (resultSet.next()) {
                String Image = resultSet.getString("image");
                int STT = resultSet.getInt("STT");
                int ID = resultSet.getInt("ID");
                String Fullname = resultSet.getString("Fullname");
                String Accountname = resultSet.getString("Accountname");
                String Profession = resultSet.getString("Profession");
                int NumberOfAcceptedRequest = resultSet.getInt("NumberOfAcceptedRequest");
                String PercentageCompleted = resultSet.getString("PercentageCompleted");
                float RateStar = resultSet.getFloat("RateStar");
                String Action = resultSet.getString("Action");

                //add mentor từ database vào list
                ListMentor user = new ListMentor(STT, ID, Fullname, Accountname, Profession, NumberOfAcceptedRequest, PercentageCompleted, RateStar, Action, Image);
                mentorList.add(user);

            }

            // Đóng kết nối và giải phóng tài nguyên
            resultSet.close();
            statement.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return mentorList;
    } 
}
