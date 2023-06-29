package model;

import java.sql.Timestamp;
import java.util.Date;

public class Request {

    private int menteeId;
    private int mentorId;
    private int skillId;
    private int requestStatus;
    private Timestamp createdDate;
    private Timestamp finishDate;
    private Timestamp Date_hour;
    private int Request_hour;
    private String Title_of_request;
    private String Desciption_of_request;

    public Request() {
    }

    public Request(int menteeId, int mentorId, int skillId, int requestStatus, Timestamp createdDate, Timestamp finishDate, Timestamp Date_hour, String Title_of_request, String Desciption_of_request) {
        this.menteeId = menteeId;
        this.mentorId = mentorId;
        this.skillId = skillId;
        this.requestStatus = requestStatus;
        this.createdDate = createdDate;
        this.finishDate = finishDate;
        this.Date_hour = Date_hour;
        this.Request_hour = Request_hour;
        this.Title_of_request = Title_of_request;
        this.Desciption_of_request = Desciption_of_request;
    }

    public void setDate_hour(Timestamp Date_hour) {
        this.Date_hour = Date_hour;
    }

    public void setRequest_hour(int Request_hour) {
        this.Request_hour = Request_hour;
    }

    public void setTitle_of_request(String Title_of_request) {
        this.Title_of_request = Title_of_request;
    }

    public void setDesciption_of_request(String Desciption_of_request) {
        this.Desciption_of_request = Desciption_of_request;
    }

    public Date getDate_hour() {
        return Date_hour;
    }

    public int getRequest_hour() {
        return Request_hour;
    }

    public String getTitle_of_request() {
        return Title_of_request;
    }

    public String getDesciption_of_request() {
        return Desciption_of_request;
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

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Timestamp finishDate) {
        this.finishDate = finishDate;
    }

    @Override
    public String toString() {
        return "Request{" + "menteeId=" + menteeId + ", mentorId=" + mentorId + ", skillId=" + skillId + ", requestStatus=" + requestStatus + ", createdDate=" + createdDate + ", finishDate=" + finishDate + ", Date_hour=" + Date_hour + ", Request_hour=" + Request_hour + ", Title_of_request=" + Title_of_request + ", Desciption_of_request=" + Desciption_of_request + '}';
    }

}
