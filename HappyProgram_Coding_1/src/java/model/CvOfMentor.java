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
    private int cvId;
    private int mentorId;

    public CvOfMentor() {
    }

    public CvOfMentor(int cvId, int mentorId) {
        this.cvId = cvId;
        this.mentorId = mentorId;
    }

    public int getCvId() {
        return cvId;
    }

    public void setCvId(int cvId) {
        this.cvId = cvId;
    }

    public int getMentorId() {
        return mentorId;
    }

    public void setMentorId(int mentorId) {
        this.mentorId = mentorId;
    }

    @Override
    public String toString() {
        return "CvOfMentor{" + "cvId=" + cvId + ", mentorId=" + mentorId + '}';
    }
    
    
}
