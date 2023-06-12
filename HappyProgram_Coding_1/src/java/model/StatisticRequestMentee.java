/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author An Nguyen
 */
public class StatisticRequestMentee {
    private String Title;
    private int mentorID;
    private String SkillName;
    private int NumOfAllRequest;
    private float TotalHour;
    private int TotalMentor;

    public StatisticRequestMentee() {
    }

    public StatisticRequestMentee(String Title, int mentorID, String SkillName, int NumOfAllRequest, float TotalHour, int TotalMentor) {
        this.Title = Title;
        this.mentorID = mentorID;
        this.SkillName = SkillName;
        this.NumOfAllRequest = NumOfAllRequest;
        this.TotalHour = TotalHour;
        this.TotalMentor = TotalMentor;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public int getMentorID() {
        return mentorID;
    }

    public void setMentorID(int mentorID) {
        this.mentorID = mentorID;
    }

    public String getSkillName() {
        return SkillName;
    }

    public void setSkillName(String SkillName) {
        this.SkillName = SkillName;
    }

    public int getNumOfAllRequest() {
        return NumOfAllRequest;
    }

    public void setNumOfAllRequest(int NumOfAllRequest) {
        this.NumOfAllRequest = NumOfAllRequest;
    }

    public float getTotalHour() {
        return TotalHour;
    }

    public void setTotalHour(float TotalHour) {
        this.TotalHour = TotalHour;
    }

    public int getTotalMentor() {
        return TotalMentor;
    }

    public void setTotalMentor(int TotalMentor) {
        this.TotalMentor = TotalMentor;
    }


}
