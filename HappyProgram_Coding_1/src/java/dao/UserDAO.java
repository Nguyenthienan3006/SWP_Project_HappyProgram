package dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.*;

public class UserDAO extends MyDAO {

    public User Signin(String user, String pass) {
        xSql = "select * from User where username = ? and password = ?";
        String xUser, xPass, xName, xEmail, xAddress, xPhone, xImage;
        int xUid, xRole, xAvgRate;
        Date xDob;
        boolean xGender, xUserStatus;
        User x = null;
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                xUser = rs.getString("username");
                xPass = rs.getString("password");
                xName = rs.getString("full_name");
                xGender = rs.getBoolean("gender");
                xEmail = rs.getString("email");
                xAddress = rs.getString("address");
                xPhone = rs.getString("phonenumber");
                xUid = rs.getInt("u_Id");
                xRole = rs.getInt("role");
                xImage = rs.getString("image"); //Image
                xAvgRate = rs.getInt("avg_rate");
                xDob = rs.getDate("date_of_birth");
                xUserStatus = rs.getBoolean("user_status");
                

                x = new User(xUid, xUser, xPass, xName, xGender, xDob, xEmail, xAddress, xPhone, xRole, xUserStatus,  xAvgRate, xImage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return x;
    }

    public List<User> getAllUser() {
        List<User> list = new ArrayList<>();
        xSql = "select * from user";
        String xUser, xPass, xName, xEmail, xAddress, xPhone, xImage;
        int xUid, xRole, xAvgRate;
        Date xDob;
        boolean xGender, xUserStatus, xMentorStatus;
        User x = null;
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                xUser = rs.getString("username");
                xPass = rs.getString("password");
                xName = rs.getString("full_name");
                xEmail = rs.getString("email");
                xAddress = rs.getString("address");
                xPhone = rs.getString("phonenumber");
                xUid = rs.getInt("u_Id");
                xRole = rs.getInt("role");
                xAvgRate = rs.getInt("avg_rate");
                xDob = rs.getDate("date_of_birth");
                xGender = rs.getBoolean("gender");
                xUserStatus = rs.getBoolean("user_status");
                xMentorStatus = rs.getBoolean("mentor_status");
                xImage = rs.getString("image"); //Image

                x = new User(xUid, xName, xPass, xName, xGender, xDob, xEmail, xAddress, xPhone, xRole, xUserStatus, xAvgRate, xImage);
                list.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void add(String user, String pass, String fullname,boolean gender,Date dob, String email, String phonenumber, String address, int role) {
        xSql = "INSERT INTO `User` (username, password, full_name, gender, date_of_birth, email, phonenumber, address, role) VALUES   (?,?, ?, ?, ?, ?, ?, ?, ?)";

        java.sql.Date xDob = (java.sql.Date) dob;

        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.setString(3, fullname);
            ps.setBoolean(4, gender);
            ps.setDate(5, xDob);
            ps.setString(6, email);
            ps.setString(7, phonenumber);
            ps.setString(8, address);
            ps.setInt(9, role);

            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        UserDAO ud = new UserDAO();
        System.out.println(ud.Signin("neque", "1119"));
    }
    
     public String getPasswordByUser_name(String user_name) {
        String password = null;
        String sql = "select password from swp391.user where username like '" + user_name + "'";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                password = rs.getString(1);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return password;
    }
    
    public int changePassword(String user_name, String newPassword){
        int succes = 0;
        String sql = "update swp391.user set password = '" +  newPassword + "' where username like '" + user_name + "'";
        try {
            ps = con.prepareStatement(sql);
            succes = ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return succes;
    }

}
