package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.*;

public class SkillDAO extends MyDAO {

    private static final String GET_ALL_SKILL = "SELECT * FROM swp391.skills where skill_Status =1  ;";
    private static final String GET_ALL_SKILL_ADMIN = "SELECT * FROM swp391.skills  ;";

    public List<Skill> getAllskill() throws SQLException {
        List<Skill> list = new ArrayList<>();

        if (con != null) {
            ps = con.prepareStatement(GET_ALL_SKILL);
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    int skillId = rs.getInt("skill_Id");
                    String skillName = rs.getString("skill_Name");
                    String img = rs.getString("skill_Image");
                    int skillStatus = rs.getInt("skill_status");

                    Skill skill = new Skill(skillId, skillName, img, skillStatus);
                    list.add(skill);
                }
            }
        } else {
            System.err.println("adadadadad");
        }

        return list;
    }

    public Skill getSkillById(String skill_id) {
        xSql = "select * from Skills where skill_Id = ?";
        String xSkill_Name, xSkill_Image;
        int xSkill_Id;

        Skill x = null;
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, skill_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                xSkill_Id = rs.getInt("skill_Id");
                xSkill_Name = rs.getString("Skill_Name");
                xSkill_Image = rs.getString("SKill_Image");

                x = new Skill(xSkill_Id, xSkill_Name, xSkill_Image);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return x;
    }

    public int UpdateSkillStatus(int skillID) {
        int mess = 0;
        // Chuỗi truy vấn SELECT để lấy danh sách mentor
        String query = "UPDATE Skills\n"
                + "SET skill_Status = CASE\n"
                + "    WHEN skill_Status = 1 THEN 0\n"
                + "    WHEN skill_Status = 0 THEN 1\n"
                + "END\n"
                + "WHERE skill_Id = ?";
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, skillID);
            // Đóng kết nối và giải phóng tài nguyên

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            mess = 1;
        }
        return mess;
    }

    public int UpdateSkillAdmin(int skillID, int status, String img, String newName) {
        int mess = 0;
        // Chuỗi truy vấn SELECT để lấy danh sách mentor
        String query = "UPDATE Skills\n"
                + "SET Skill_Name = ?,\n"
                + "    skill_Status = ?,\n"
                + "    SKill_Image = ?\n"
                + "WHERE skill_Id = ?;";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, newName);
            ps.setInt(2, status);
            ps.setString(3, img);
            ps.setInt(4, skillID);

            // Đóng kết nối và giải phóng tài nguyên
            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            mess = 1;
        }
        return mess;
    }

    public int CreateSkill(String skillName, int skill_Status, String img) {
        int check = 0;
        String xMySql = "INSERT INTO swp391.skills(Skill_Name,skill_Status,SKill_Image) value (?,?,?);;";
        try {
            PreparedStatement st = getJDBCConnection().prepareStatement(xMySql);
            // st.setInt(1,skillId);
            st.setString(1, skillName);
            st.setInt(2, skill_Status);
            st.setString(3, img);
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            check = 1;
        }
        return check;
    }

    public List<Skill> getAllskillAdmin() throws SQLException {
        List<Skill> list = new ArrayList<>();

        if (con != null) {
            ps = con.prepareStatement(GET_ALL_SKILL_ADMIN);
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    int skillId = rs.getInt("skill_Id");
                    String skillName = rs.getString("skill_Name");
                    String img = rs.getString("skill_Image");
                    int skillStatus = rs.getInt("skill_status");

                    Skill skill = new Skill(skillId, skillName, img, skillStatus);
                    list.add(skill);
                }
            }
        } else {
            System.err.println("adadadadad");
        }

        return list;
    }

    public List<String> getSkillByMentorId(int mentor_id) {

        List<String> list = new ArrayList<>();

        xSql = "select s.Skill_Name from skills s\n"
                + "join skillofcv socv on s.Skill_Id = socv.Skill_id\n"
                + "join cvdetail cv on socv.cv_Id = cv.cv_id\n"
                + "join cvofmentor cvom on cvom.cv_id = cv.cv_id\n"
                + "join user u on u.u_Id = cvom.mentor_Id\n"
                + "where cvom.mentor_Id = ?";
        String xSkill_Name;

        Skill x = null;
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, mentor_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                xSkill_Name = rs.getString("Skill_Name");

                String str = xSkill_Name;
                list.add(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}

class t2 {

    public static void main(String[] args) throws SQLException {

        SkillDAO d = new SkillDAO();
        d.getSkillByMentorId(3);

    }
}
