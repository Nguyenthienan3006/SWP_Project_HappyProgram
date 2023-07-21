package dao;

import model.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CvDAO extends MyDAO {

    public List<Integer> listMentorIdHaveCv() {
        List<Integer> listId = new ArrayList<>();
        xSql = "SELECT mentor_id FROM CvOfMentor";
        try ( PreparedStatement ps = con.prepareStatement(xSql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int mentorId = rs.getInt("mentor_id");
                listId.add(mentorId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle or log the exception here based on the actual environment.
        }
        return listId;
    }

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
    
    
     public void updateCvDetail(Cv cv) {
        xSql = "UPDATE CvDetail SET professional_summary = ?, education = ?, work_experience = ?, achievements = ? WHERE cv_id = ?";
        try (PreparedStatement ps = con.prepareStatement(xSql)) {
            ps.setString(1, cv.getProfessionalSummary());
            ps.setString(2, cv.getEducation());
            ps.setString(3, cv.getWorkExperience());
            ps.setString(4, cv.getAchievements());
            ps.setInt(5, cv.getCvId()); // Truyền cvId để xác định CV cần cập nhật
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý hoặc thông báo lỗi tại đây (tuỳ vào môi trường thực tế)
        }
    }

    public void deleteSkillsOfCv(int cvId) {
        xSql = "DELETE FROM SkillOfCv WHERE cv_id = ?";
        try (PreparedStatement ps = con.prepareStatement(xSql)) {
            ps.setInt(1, cvId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý hoặc thông báo lỗi tại đây (tuỳ vào môi trường thực tế)
        }
    }

    public void insertOrUpdateSkillsOfCv(int cvId, List<Integer> skills) {
        xSql = "INSERT INTO SkillOfCv (cv_id, skill_id) VALUES (?, ?) ON DUPLICATE KEY UPDATE cv_id = ?";
        try (PreparedStatement ps = con.prepareStatement(xSql)) {
            for (int skillId : skills) {
                ps.setInt(1, cvId);
                ps.setInt(2, skillId);
                ps.setInt(3, cvId);
                ps.addBatch();
            }
            ps.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý hoặc thông báo lỗi tại đây (tuỳ vào môi trường thực tế)
        }
    }

    public void updateCv(int mentorId, Cv cv, List<Integer> skills) {
        try {
            // Bước 1: Lấy cvId từ bảng CvOfMentor dựa trên mentorId
            int cvId = getCvIdByMentorId(mentorId);

            // Bước 2: Cập nhật thông tin chi tiết của CV trong bảng CvDetail
            if (cvId != -1) {
                cv.setCvId(cvId); // Đảm bảo cvId cho Cv đúng
                updateCvDetail(cv);
            }

            // Bước 3: Xóa tất cả các kỹ năng của CV khỏi bảng SkillOfCv
            if (cvId != -1) {
                deleteSkillsOfCv(cvId);
            }

            // Bước 4: Cập nhật lại thông tin về kỹ năng của CV trong bảng SkillOfCv
            if (cvId != -1) {
                insertOrUpdateSkillsOfCv(cvId, skills);
            }

        } catch (Exception e) {
            e.printStackTrace();
            // Xử lý hoặc thông báo lỗi tại đây (tuỳ vào môi trường thực tế)
        }
    }

    private int getCvIdByMentorId(int mentorId) {
        int cvId = -1;
        xSql = "SELECT cv_id FROM CvOfMentor WHERE mentor_id = ?";
        try (PreparedStatement ps = con.prepareStatement(xSql)) {
            ps.setInt(1, mentorId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cvId = rs.getInt("cv_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý hoặc thông báo lỗi tại đây (tuỳ vào môi trường thực tế)
        }
        return cvId;
    }
}
