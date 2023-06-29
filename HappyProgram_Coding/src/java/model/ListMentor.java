/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author An Nguyen
 */
public class ListMentor {
    private int STT;
    private int ID;
    private String Fullname;
    private String Accountname;
    private String Profession;
    private int NumberOfAcceptedRequest;
    private String PercentageCompleted;
    private float RateStar;
    private String Action;
    private String Achievements;
    private String img;

    public ListMentor() {
    }
    
    public ListMentor(int ID, String Fullname, String Accountname, String Achievements,String Profession ,int NumberOfAcceptedRequest, float RateStar, String img) {
        this.ID = ID;
        this.Fullname = Fullname;
        this.Accountname = Accountname;
        this.Profession = Profession;
        this.Achievements = Achievements;
        this.NumberOfAcceptedRequest = NumberOfAcceptedRequest;
        this.RateStar = RateStar;
        this.img = img;
    }

    public ListMentor(int STT, int ID, String Fullname, String Accountname, String Profession, int NumberOfAcceptedRequest, String PercentageCompleted, float RateStar, String Action, String img) {
        this.STT = STT;
        this.ID = ID;
        this.Fullname = Fullname;
        this.Accountname = Accountname;
        this.Profession = Profession;
        this.NumberOfAcceptedRequest = NumberOfAcceptedRequest;
        this.PercentageCompleted = PercentageCompleted;
        this.RateStar = RateStar;
        this.Action = Action;
        this.img = img;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    

    public int getSTT() {
        return STT;
    }

    public void setSTT(int STT) {
        this.STT = STT;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String Fullname) {
        this.Fullname = Fullname;
    }

    public String getAccountname() {
        return Accountname;
    }

    public void setAccountname(String Accountname) {
        this.Accountname = Accountname;
    }

    public String getProfession() {
        return Profession;
    }

    public void setProfession(String Profession) {
        this.Profession = Profession;
    }

    public String getAchievements() {
        return Achievements;
    }

    public void setAchievements(String Achievements) {
        this.Achievements = Achievements;
    }
    
    public int getNumberOfAcceptedRequest() {
        return NumberOfAcceptedRequest;
    }

    public void setNumberOfAcceptedRequest(int NumberOfAcceptedRequest) {
        this.NumberOfAcceptedRequest = NumberOfAcceptedRequest;
    }

    public String getPercentageCompleted() {
        return PercentageCompleted;
    }

    public void setPercentageCompleted(String PercentageCompleted) {
        this.PercentageCompleted = PercentageCompleted;
    }

    public float getRateStar() {
        return RateStar;
    }

    public void setRateStar(float RateStar) {
        this.RateStar = RateStar;
    }

    public String getAction() {
        return Action;
    }

    public void setAction(String Action) {
        this.Action = Action;
    }

}
