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

                    Skill skill = new Skill(skillId, skillName, img);
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

    public int UpdateSkillAdmin(int skillID, int status, String newName) {
        int mess = 0;
        // Chuỗi truy vấn SELECT để lấy danh sách mentor
        String query = "UPDATE Skills\n"
                + "SET Skill_Name = ?,\n"
                + "    skill_Status = ?\n"
                + "WHERE skill_Id = ?;";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, newName);
            ps.setInt(2, status);
            ps.setInt(3, skillID);
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
        String xMySql = "INSERT INTO swp391.skills(  Skill_Name,skill_Status,SKill_Image) value (?,?,?);;";
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

                    Skill skill = new Skill(skillId, skillName, img);
                    list.add(skill);
                }
            }
        } else {
            System.err.println("adadadadad");
        }

        return list;
    }
}

class t2 {

    public static void main(String[] args) throws SQLException {

        SkillDAO d = new SkillDAO();
        for (Skill s : d.getAllskill()) {
            System.out.println(s);
        }

    }
}
