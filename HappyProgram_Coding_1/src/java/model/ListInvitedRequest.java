/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author An Nguyen
 */
public class ListInvitedRequest {
    private int menteeID;
    private String MenteeFullName;
    private String Title;
    private String Description;
    private String SkillName;
    private String DeadlineDate;
    private String DeadlineHour;
    private float  RequestHour;

    public ListInvitedRequest() {
    }

    public ListInvitedRequest(int menteeID, String MenteeFullName, String Title, String Description, String SkillName, String DeadlineDate, String DeadlineHour, float RequestHour) {
        this.menteeID = menteeID;
        this.MenteeFullName = MenteeFullName;
        this.Title = Title;
        this.Description = Description;
        this.SkillName = SkillName;
        this.DeadlineDate = DeadlineDate;
        this.DeadlineHour = DeadlineHour;
        this.RequestHour = RequestHour;
    }

    public int getMenteeID() {
        return menteeID;
    }

    public void setMenteeID(int menteeID) {
        this.menteeID = menteeID;
    }

    public String getMenteeFullName() {
        return MenteeFullName;
    }

    public void setMenteeFullName(String MenteeFullName) {
        this.MenteeFullName = MenteeFullName;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getSkillName() {
        return SkillName;
    }

    public void setSkillName(String SkillName) {
        this.SkillName = SkillName;
    }

    public String getDeadlineDate() {
        return DeadlineDate;
    }

    public void setDeadlineDate(String DeadlineDate) {
        this.DeadlineDate = DeadlineDate;
    }

    public String getDeadlineHour() {
        return DeadlineHour;
    }

    public void setDeadlineHour(String DeadlineHour) {
        this.DeadlineHour = DeadlineHour;
    }

    public float getRequestHour() {
        return RequestHour;
    }

    public void setRequestHour(float RequestHour) {
        this.RequestHour = RequestHour;
    }
    
    
}
