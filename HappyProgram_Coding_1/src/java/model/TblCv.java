package model;

public class TblCv {
    private int cvId;
    private String contact; 
    private String professional_summary; 
    private String education; 
    private String workExp; 
    private String achievements;
    private boolean cvStatus;

    public TblCv() {
    }

    public TblCv(int cvId, String contact, String professional_summary, String education, String workExp, String achievements, boolean cvStatus) {
        this.cvId = cvId;
        this.contact = contact;
        this.professional_summary = professional_summary;
        this.education = education;
        this.workExp = workExp;
        this.achievements = achievements;
        this.cvStatus = cvStatus;
    }

    public int getCvId() {
        return cvId;
    }

    public void setCvId(int cvId) {
        this.cvId = cvId;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getProfessional_summary() {
        return professional_summary;
    }

    public void setProfessional_summary(String professional_summary) {
        this.professional_summary = professional_summary;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getWorkExp() {
        return workExp;
    }

    public void setWorkExp(String workExp) {
        this.workExp = workExp;
    }

    public String getAchievements() {
        return achievements;
    }

    public void setAchievements(String achievements) {
        this.achievements = achievements;
    }

    public boolean isCvStatus() {
        return cvStatus;
    }

    public void setCvStatus(boolean cvStatus) {
        this.cvStatus = cvStatus;
    }

    @Override
    public String toString() {
        return "TblCv{" + "cvId=" + cvId + ", contact=" + contact + ", professional_summary=" + professional_summary + ", education=" + education + ", workExp=" + workExp + ", achievements=" + achievements + ", cvStatus=" + cvStatus + '}';
    }
    
    
}
