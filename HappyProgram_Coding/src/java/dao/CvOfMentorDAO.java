package dao;

import static DB.DBConnect.getJDBCConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.*;

public class CvOfMentorDAO extends MyDAO {

    private static final String GET_CV_MENTOR = "SELECT \n"
            + "ROW_NUMBER() OVER (ORDER BY U.u_Id) ,\n"
            + "U.u_Id AS ID,\n"
            + "U.full_name AS Fullname,\n"
            + "U.image AS Image,\n"
            + "U.username AS Accountname,\n"
            + "CD.achievements AS  Achievements,\n"
            + "CD.professional_summary AS Profession,\n"
            + "CD.contact,\n"
            + "CD.education,\n"
            + "CD.work_experience,\n"
            + "COUNT(CM.mentor_Id) AS NumberOfAcceptedRequest,\n"
            + "ROUND(AVG(R.Rated_point),2) AS RateStar\n"
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
            + "U.u_Id , U.full_name , U.username , CD.professional_summary, CD.achievements, CD.contact, CD.education, CD.work_experience\n"
            + "ORDER BY\n"
            + "U.u_Id;";

    private static final String getCV = "SELECT\n"
            + "    q1.mentorID,\n"
            + "    q1.TotalRequests,\n"
            + "    (q2.NumberOfOpenReq) AS NumberOfAccReq,\n"
            + "    q1.CompleteRequests,\n"
            + "	Round((q1.CompleteRequests / IFNULL(q1.TotalRequests, 0))*100,2) AS CompletePercentage\n"
            + "FROM\n"
            + "    (SELECT\n"
            + "        mentorID,\n"
            + "        COUNT(CASE WHEN RequestStatus IN (1,2,4,5) THEN 1 END) AS TotalRequests,\n"
            + "         COUNT(CASE WHEN RequestStatus IN (4, 5) THEN 1 END) AS CompleteRequests\n"
            + "    FROM\n"
            + "        request\n"
            + "    WHERE\n"
            + "        RequestStatus IN (1, 2, 3, 4, 5) \n"
            + "    GROUP BY\n"
            + "        mentorID) q1\n"
            + "JOIN\n"
            + "    (SELECT\n"
            + "        mentorID,\n"
            + "         COUNT(CASE WHEN RequestStatus IN (2) THEN 1 END) AS NumberOfOpenReq\n"
            + "    FROM\n"
            + "        request\n"
            + "    WHERE\n"
            + "        RequestStatus IN (1, 2, 3, 4, 5)\n"
            + "    GROUP BY\n"
            + "        mentorID) q2\n"
            + "ON q1.mentorID = q2.mentorID and q1.mentorID = ?;";

    public ListMentor GetCvOfMentor(int Uid) throws SQLException {
        ListMentor ls = null;

        if (con != null) {
            ps = con.prepareStatement(GET_CV_MENTOR);
            ps.setInt(1, Uid);
            rs = ps.executeQuery();
            if (rs.next()) {
                String Image = rs.getString("image");
                int ID = rs.getInt("ID");
                String Fullname = rs.getString("Fullname");
                String Accountname = rs.getString("Accountname");
                String Achievements = rs.getString("Achievements");
                String Profession = rs.getString("Profession");
                int NumberOfAcceptedRequest = rs.getInt("NumberOfAcceptedRequest");
                float RateStar = rs.getFloat("RateStar");
                
                String contact = rs.getString("contact");
                String education = rs.getString("education");
                String workExperience = rs.getString("work_experience");
                
                ls = new ListMentor(ID, Fullname, Accountname, Achievements, Profession, 
                        NumberOfAcceptedRequest, RateStar, Image, contact, education, workExperience);
            }
        }
        return ls;
    }

    public CvOfMentor getMentorInfoReq(int mentorID) throws SQLException {
        CvOfMentor cv = null;

        if (con != null) {
            ps = con.prepareStatement(getCV);
            ps.setInt(1, mentorID);
            rs = ps.executeQuery();
            if (rs.next()) {
                int ID = rs.getInt("mentorID");
                int totalReq = rs.getInt("TotalRequests");
                int acceptReq = rs.getInt("NumberOfAccReq");
                int completeReq = rs.getInt("CompleteRequests");
                double completePer = rs.getDouble("CompletePercentage");

                //add mentor từ database vào list
                cv = new CvOfMentor(ID, totalReq, acceptReq, completeReq, completePer);

            }
        }
        return cv;
    }
}

class t1 {

    public static void main(String[] args) throws SQLException {

        CvOfMentorDAO d = new CvOfMentorDAO();

    }
}
