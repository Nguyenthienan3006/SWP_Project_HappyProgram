package model;

import jakarta.servlet.http.Cookie;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class User {

    private int uid;
    private String username;
    private String password;
    private String fullname;
    private boolean gender;
    private Date dob;
    private String email;
    private String address;
    private String phoneNumber;
    private int role;
    private String img;
    private boolean userStatus;
    private int avgRate;
    private LocalDate creareTime;
    

    public User() {
    }

    public User(int uid, String username, String password, String fullname, boolean gender, Date dob, String email, String address, String phoneNumber, int role, boolean userStatus, int avgRate, String img) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.gender = gender;
        this.dob = dob;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.img = img;
        this.userStatus = userStatus;
        this.avgRate = avgRate;
    }

    public User(String username, String password, String fullname, boolean gender, Date dob, String email, String address, String phoneNumber, int role, String img) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.gender = gender;
        this.dob = dob;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.img = img;
    }
    
    

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

     
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public boolean isUserStatus() {
        return userStatus;
    }

    public void setUserStatus(boolean userStatus) {
        this.userStatus = userStatus;
    }
    public int getAvgRate() {
        return avgRate;
    }

    public void setAvgRate(int avgRate) {
        this.avgRate = avgRate;
    }

    public LocalDate getCreareTime() {
        return creareTime;
    }

    public void setCreareTime(LocalDate creareTime) {
        this.creareTime = creareTime;
    }

    @Override
    public String toString() {
        return "User{" + "uid=" + uid + ", username=" + username + ", password=" + password + ", fullname=" + fullname + ", dob=" + dob + ", email=" + email + ", address=" + address + ", phoneNumber=" + phoneNumber + ", role=" + role + ", userStatus=" + userStatus  + ", avgRate=" + avgRate + ", creareTime=" + creareTime + '}';
    }
}
