/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.sql.Time;


/**
 *
 * @author An Nguyen
 */
public class ListRequest {

    private int requestID;
    private String mentorName;
    private int mentorID;
    private String menteeName;
    private int menteeID;
    private String Skill_Name;
    private String created_date;
    private String finish_date;
    private String RequestStatus;
    private Time Date_hour;
    private String Title_of_request;
    private String Desciption_of_request;
    private float Request_hour;
    private String Status;

    public ListRequest( String menteeName, String Skill_Name, String created_date, String finish_date, Time Date_hour, String Title_of_request, String Desciption_of_request, float Request_hour, String Status) {
        this.menteeName = menteeName;
        this.Skill_Name = Skill_Name;
        this.created_date = created_date;
        this.finish_date = finish_date;
        this.Date_hour = Date_hour;
        this.Title_of_request = Title_of_request;
        this.Desciption_of_request = Desciption_of_request;
        this.Request_hour = Request_hour;
        this.Status = Status;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    
    

    public ListRequest() {
    }

    public ListRequest(int requestID, String mentorName, int mentorID, String menteeName, int menteeID, String Skill_Name, String created_date, String finish_date, String RequestStatus, 
            Time Date_hour, String Title_of_request, String Desciption_of_request, float Request_hour) {
        this.requestID = requestID;
        this.mentorName = mentorName;
        this.mentorID = mentorID;
        this.menteeName = menteeName;
        this.menteeID = menteeID;
        this.Skill_Name = Skill_Name;
        this.created_date = created_date;
        this.finish_date = finish_date;
        this.RequestStatus = RequestStatus;
        this.Date_hour = Date_hour;
        this.Title_of_request = Title_of_request;
        this.Desciption_of_request = Desciption_of_request;
        this.Request_hour = Request_hour;
    }

    public String getMentorName() {
        return mentorName;
    }

    public void setMentorName(String mentorName) {
        this.mentorName = mentorName;
    }

    public int getMentorID() {
        return mentorID;
    }

    public void setMentorID(int mentorID) {
        this.mentorID = mentorID;
    }

    public String getMenteeName() {
        return menteeName;
    }

    public void setMenteeName(String menteeName) {
        this.menteeName = menteeName;
    }

    public int getMenteeID() {
        return menteeID;
    }

    public void setMenteeID(int menteeID) {
        this.menteeID = menteeID;
    }

    public String getSkill_Name() {
        return Skill_Name;
    }

    public void setSkill_Name(String Skill_Name) {
        this.Skill_Name = Skill_Name;
    }

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    public String getFinish_date() {
        return finish_date;
    }

    public void setFinish_date(String finish_date) {
        this.finish_date = finish_date;
    }

    public String getRequestStatus() {
        return RequestStatus;
    }

    public void setRequestStatus(String RequestStatus) {
        this.RequestStatus = RequestStatus;
    }

    public Time getDate_hour() {
        return Date_hour;
    }

    public void setDate_hour(Time Date_hour) {
        this.Date_hour = Date_hour;
    }

    public String getTitle_of_request() {
        return Title_of_request;
    }

    public void setTitle_of_request(String Title_of_request) {
        this.Title_of_request = Title_of_request;
    }

    public String getDesciption_of_request() {
        return Desciption_of_request;
    }

    public void setDesciption_of_request(String Desciption_of_request) {
        this.Desciption_of_request = Desciption_of_request;
    }

    public float getRequest_hour() {
        return Request_hour;
    }

    public void setRequest_hour(float Request_hour) {
        this.Request_hour = Request_hour;
    }

    public int getRequestID() {
        return requestID;
    }

    public void setRequestID(int requestID) {
        this.requestID = requestID;
    }

   
}
