package dao;

import model.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class CvDAO extends MyDAO {

    public int insertCvDetail(Cv cv) {
        int cvId = -1;
        xSql = "INSERT INTO CvDetail (professional_summary, education, work_experience, achievements) VALUES (?, ?, ?, ?)";
        try ( PreparedStatement ps = con.prepareStatement(xSql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, cv.getProfessionalSummary());
            ps.setString(2, cv.getEducation());
            ps.setString(3, cv.getWorkExperience());
            ps.setString(4, cv.getAchievements());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                cvId = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý hoặc thông báo lỗi tại đây (tuỳ vào môi trường thực tế)
        }
        return cvId;
    }

    public void insertCvOfMentor(int mentorId) {
        xSql = "INSERT INTO CvOfMentor (mentor_id, cv_id) VALUES (?, (select max(cv_id) from cvdetail))";
        try ( PreparedStatement ps = con.prepareStatement(xSql)) {
            ps.setInt(1, mentorId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý hoặc thông báo lỗi tại đây (tuỳ vào môi trường thực tế)
        }
    }

    public void insertSkillsOfCv(int cvId, List<Integer> skills) {
        xSql = "INSERT INTO SkillOfCv (cv_id, skill_id) VALUES (?, ?)";
        try ( PreparedStatement ps = con.prepareStatement(xSql)) {
            for (int skillId : skills) {
                ps.setInt(1, cvId);
                ps.setInt(2, skillId);
                ps.addBatch();
            }
            ps.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý hoặc thông báo lỗi tại đây (tuỳ vào môi trường thực tế)
        }
    }

    public void createCv(int mentorId, Cv cv, List<Integer> skills) {
        try {
            // Bước 1: Insert vào bảng CvDetail
            int cvId = insertCvDetail(cv);

            // Bước 2: Insert vào bảng CvOfMentor
            if (cvId != -1) {
                insertCvOfMentor(mentorId);
            }

            // Bước 3: Insert vào bảng SkillOfCv
            if (cvId != -1) {
                insertSkillsOfCv(cvId, skills);
            }

        } catch (Exception e) {
            e.printStackTrace();
            // Xử lý hoặc thông báo lỗi tại đây (tuỳ vào môi trường thực tế)
        }
    }
}
