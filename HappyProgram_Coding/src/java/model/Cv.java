package model;

import java.util.List;

public class Cv {
    private int cvId;
    private String contactInfo;
    private String professionalSummary;
    private String education;
    private String workExperience;
    private String achievements;
    private String cvStatus;
    private List<Integer> skills;

    public Cv(String contactInfo, String professionalSummary, String education, String workExperience, String achievements, String cvStatus, List<Integer> skills) {
        this.cvId = 0; // Giá trị tạm thời, sẽ được cập nhật sau khi thêm vào CSDL
        this.contactInfo = contactInfo;
        this.professionalSummary = professionalSummary;
        this.education = education;
        this.workExperience = workExperience;
        this.achievements = achievements;
        this.cvStatus = cvStatus;
        this.skills = skills;
    }

    public Cv(String professionalSummary, String education, String workExperience, String achievements) {
        this.professionalSummary = professionalSummary;
        this.education = education;
        this.workExperience = workExperience;
        this.achievements = achievements;
    }
    
    

    public int getCvId() {
        return cvId;
    }

    public void setCvId(int cvId) {
        this.cvId = cvId;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getProfessionalSummary() {
        return professionalSummary;
    }

    public void setProfessionalSummary(String expertiseSummary) {
        this.professionalSummary = expertiseSummary;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(String workExperience) {
        this.workExperience = workExperience;
    }

    public String getAchievements() {
        return achievements;
    }

    public void setAchievements(String achievements) {
        this.achievements = achievements;
    }

    public String getCvStatus() {
        return cvStatus;
    }

    public void setCvStatus(String cvStatus) {
        this.cvStatus = cvStatus;
    }

    public List<Integer> getSkills() {
        return skills;
    }

    public void setSkills(List<Integer> skills) {
        this.skills = skills;
    }
}
