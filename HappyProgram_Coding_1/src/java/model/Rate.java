package model;

public class Rate {
    private int menteeId;
    private int mentorId;
    private int ratePoint;

    public Rate() {
    }

    public Rate(int menteeId, int mentorId, int ratePoint) {
        this.menteeId = menteeId;
        this.mentorId = mentorId;
        this.ratePoint = ratePoint;
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

    public int getRatePoint() {
        return ratePoint;
    }

    public void setRatePoint(int ratePoint) {
        this.ratePoint = ratePoint;
    }

    @Override
    public String toString() {
        return "Rate{" + "menteeId=" + menteeId + ", mentorId=" + mentorId + ", ratePoint=" + ratePoint + '}';
    }
    
    
    
    

}
