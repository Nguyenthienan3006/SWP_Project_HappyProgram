package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.*;

public class CvOfMentorDAO extends MyDAO {

    private static final String GET_CV_MENTOR = "SELECT \n"
            + "ROW_NUMBER() OVER (ORDER BY U.u_Id) ,\n"
            + "U.u_Id AS ID,\n"
            + "U.full_name AS Fullname,\n"
            + "U.username AS Accountname,\n"
            + "CD.achievements AS  Achievements,\n"
            + "CD.professional_summary AS Profession,\n"
            + "COUNT(CM.mentor_Id) AS NumberOfAcceptedRequest,\n"
            + "\n"
            + "ROUND(AVG(R.Rated_point),2) AS RateStar\n"
            + "\n"
            + "FROM\n"
            + "`User` U\n"
            + "INNER JOIN\n"
            + "CvOfMentor CM ON U.u_Id = CM.mentor_Id\n"
            + "INNER JOIN\n"
            + "CvDetail CD ON CM.cv_Id = CD.cv_Id\n"
            + "LEFT JOIN\n"
            + "Rate R ON U.u_Id = R.mentorID\n"
            + "WHERE\n"
            + "U.`role` = (SELECT role_Id FROM `Role` WHERE role_name = 'Mentor') and U.u_Id = ?\n"
            + "GROUP BY\n"
            + "U.u_Id , U.full_name , U.username , CD.professional_summary,CD.achievements\n"
            + "ORDER BY\n"
            + "U.u_Id;";

    public ListMentor GetCvOfMentor(int Uid) throws SQLException {
        ListMentor ls = null;

        if (con != null) {
            ps = con.prepareStatement(GET_CV_MENTOR);
            ps.setInt(1, Uid);
            rs = ps.executeQuery();
            if (rs.next()) {
                int ID = rs.getInt("ID");
                String Fullname = rs.getString("Fullname");
                String Accountname = rs.getString("Accountname");
                String Achievements = rs.getString("Achievements");
                String Profession = rs.getString("Profession");
                int NumberOfAcceptedRequest = rs.getInt("NumberOfAcceptedRequest");
                float RateStar = rs.getFloat("RateStar");
                ls = new ListMentor(ID, Fullname, Accountname, Achievements, Profession, NumberOfAcceptedRequest, RateStar);
            }
        }

        return ls;
    }

}

class t1 {

    public static void main(String[] args) throws SQLException {

        CvOfMentorDAO d = new CvOfMentorDAO();

        System.out.println(d.GetCvOfMentor(3));

    }
}
