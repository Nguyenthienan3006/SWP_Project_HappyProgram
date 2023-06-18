package model;

public class Skill {
    private int skillId;
    private String skillName;
    private String img;

    public Skill() {
    }

    public Skill(int skillId, String skillName, String img) {
        this.skillId = skillId;
        this.skillName = skillName;
        this.img = img;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
    
    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    @Override
    public String toString() {
        return "Skill{" + "skillId=" + skillId + ", skillName=" + skillName + '}';
    }
    
    
    
}
