package model;

public class Rate {
    private int menteeId;
    private int mentorId;
    private double ratePoint;

    public Rate() {
    }

    public Rate(double ratePoint) {
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

    public double getRatePoint() {
        return ratePoint;
    }

    public void setRatePoint(double ratePoint) {
        this.ratePoint = ratePoint;
    }


    @Override
    public String toString() {
        return "Rate{" + "menteeId=" + menteeId + ", mentorId=" + mentorId + ", ratePoint=" + ratePoint + '}';
    }
    
    
    
    

}
