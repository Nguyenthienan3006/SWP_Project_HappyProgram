/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class CvOfMentor {
    private int mentorID;
    private int totalReq;
    private int acceptReq;
    private int completeReq;
    private double completePer;

    public CvOfMentor() {
    }

    public CvOfMentor(int mentorID, int totalReq, int acceptReq, int completeReq, double completePer) {
        this.mentorID = mentorID;
        this.totalReq = totalReq;
        this.acceptReq = acceptReq;
        this.completeReq = completeReq;
        this.completePer = completePer;
    }

    public int getMentorID() {
        return mentorID;
    }

    public void setMentorID(int mentorID) {
        this.mentorID = mentorID;
    }

    public int getTotalReq() {
        return totalReq;
    }

    public void setTotalReq(int totalReq) {
        this.totalReq = totalReq;
    }

    public int getAcceptReq() {
        return acceptReq;
    }

    public void setAcceptReq(int acceptReq) {
        this.acceptReq = acceptReq;
    }

    public int getCompleteReq() {
        return completeReq;
    }

    public void setCompleteReq(int completeReq) {
        this.completeReq = completeReq;
    }

    public double getCompletePer() {
        return completePer;
    }

    public void setCompletePer(double completePer) {
        this.completePer = completePer;
    }

    
    
    @Override
    public String toString() {
        return "CvOfMentor{" + "mentorID=" + mentorID + ", totalReq=" + totalReq + ", acceptReq=" + acceptReq + ", completeReq=" + completeReq + ", completePer=" + completePer + '}';
    }
}
