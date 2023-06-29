package model;

public class SkillOfCv {
    private int cvId;
    private int skill;

    public SkillOfCv() {
    }

    public SkillOfCv(int cvId, int skill) {
        this.cvId = cvId;
        this.skill = skill;
    }

    public int getCvId() {
        return cvId;
    }

    public void setCvId(int cvId) {
        this.cvId = cvId;
    }

    public int getSkill() {
        return skill;
    }

    public void setSkill(int skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return "SkillOfCv{" + "cvId=" + cvId + ", skill=" + skill + '}';
    }
    
    
            
       
    
}
