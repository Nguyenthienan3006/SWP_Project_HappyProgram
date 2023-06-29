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
    private int requestID;
    private String Title;
    private int mentorID;
    private int NumOfAllRequest;
    private float TotalHour;
    private int TotalMentor;
    
    public StatisticRequestMentee() {
    }

    public StatisticRequestMentee(int requestID, String Title, int mentorID, int NumOfAllRequest, float TotalHour, int TotalMentor) {
        this.requestID = requestID;
        this.Title = Title;
        this.mentorID = mentorID;
        this.NumOfAllRequest = NumOfAllRequest;
        this.TotalHour = TotalHour;
        this.TotalMentor = TotalMentor;
    }

    public int getRequestID() {
        return requestID;
    }

    public void setRequestID(int requestID) {
        this.requestID = requestID;
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
