package model;

import java.util.Date;

public class Request {
    private int menteeId;
    private int mentorId;
    private int skillId;
    private int requestStatus;
    private Date createdDate;
    private Date finishDate;

    public Request() {
    }

    public Request(int menteeId, int mentorId, int skillId, int requestStatus, Date createdDate, Date finishDate) {
        this.menteeId = menteeId;
        this.mentorId = mentorId;
        this.skillId = skillId;
        this.requestStatus = requestStatus;
        this.createdDate = createdDate;
        this.finishDate = finishDate;
    }

    public int getMenteeId() {
        return menteeId;
    }

    public void setMenteeId(int menteeId) {
        this.menteeId = menteeId;
    }

    public int getMentorId() {
        return mentorId;
    }

    public void setMentorId(int mentorId) {
        this.mentorId = mentorId;
    }

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public int getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(int requestStatus) {
        this.requestStatus = requestStatus;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    @Override
    public String toString() {
        return "Request{" + "menteeId=" + menteeId + ", mentorId=" + mentorId + ", skillId=" + skillId + ", requestStatus=" + requestStatus + ", createdDate=" + createdDate + ", finishDate=" + finishDate + '}';
    }
    
    
    
}
