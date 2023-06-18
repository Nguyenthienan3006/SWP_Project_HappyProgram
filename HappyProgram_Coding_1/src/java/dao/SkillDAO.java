package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.*;

public class SkillDAO extends MyDAO {

    private static final String GET_ALL_SKILL = "SELECT * FROM swp391.skills  ;";

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

}

class t2 {

    public static void main(String[] args) throws SQLException {

        SkillDAO d = new SkillDAO();
        for (Skill s : d.getAllskill()) {
            System.out.println(s);
        }

    }
}


