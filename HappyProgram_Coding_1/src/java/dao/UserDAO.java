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

                x = new User(xUid, xUser, xPass, xName, xGender, xDob, xEmail, xAddress, xPhone, xRole, xUserStatus, xAvgRate, xImage);
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
        boolean xGender, xUserStatus;
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
                xImage = rs.getString("image"); //Image

                x = new User(xUid, xUser, xPass, xName, xGender, xDob, xEmail, xAddress, xPhone, xRole, xUserStatus, xAvgRate, xImage);
                list.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void add(String user, String pass, String fullname, boolean gender, Date dob, String email, String phonenumber, String address, int role) {
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

    public int changePassword(String user_name, String newPassword) {
        int succes = 0;
        String sql = "update swp391.user set password = '" + newPassword + "' where username like '" + user_name + "'";
        try {
            ps = con.prepareStatement(sql);
            succes = ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return succes;
    }

    public List<User> getMentorBy1Skill(String skill_id) {
        List<User> list = new ArrayList<>();
        xSql = " SELECT u.*\n"
                + "  FROM user u\n"
                + "  JOIN cvofmentor cvom ON u.u_Id = cvom.mentor_Id\n"
                + "  JOIN skillofcv socv ON cvom.cv_Id = socv.cv_Id\n"
                + "  WHERE socv.skill_Id = ?";
        String xUser, xPass, xName, xEmail, xAddress, xPhone, xImage;
        int xUid, xRole, xAvgRate;
        Date xDob;
        boolean xGender, xUserStatus;
        User x = null;
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, skill_id);
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
                xImage = rs.getString("image"); //Image
                x = new User(xUid, xUser, xPass, xName, xGender, xDob, xEmail, xAddress, xPhone, xRole, xUserStatus, xAvgRate, xImage);
                list.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<User> getMentorBy2Skill(String skill_id1, String skill_id2) {
        List<User> list = new ArrayList<>();
        xSql = "SELECT a.u_Id, a.username, a.password,a.full_name, a.date_of_birth, a.email, a.phonenumber, a.address, a.role,\n"
                + "	   a.user_status, a.avg_rate, a.create_time, a.gender, a.image\n"
                + "FROM\n"
                + "  (SELECT u.*\n"
                + "  FROM user u\n"
                + "  JOIN cvofmentor cvom ON u.u_Id = cvom.mentor_Id\n"
                + "  JOIN skillofcv socv ON cvom.cv_Id = socv.cv_Id\n"
                + "  WHERE socv.skill_Id = ?) AS a\n"
                + "JOIN\n"
                + "  (SELECT u.* \n"
                + "  FROM user u\n"
                + "  JOIN cvofmentor cvom ON u.u_Id = cvom.mentor_Id\n"
                + "  JOIN skillofcv socv ON cvom.cv_Id = socv.cv_Id\n"
                + "  WHERE socv.skill_Id = ?) AS b\n"
                + "ON a.u_Id = b.u_id;";
        String xUser, xPass, xName, xEmail, xAddress, xPhone, xImage;
        int xUid, xRole, xAvgRate;
        Date xDob;
        boolean xGender, xUserStatus;
        User x = null;
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, skill_id1);
            ps.setString(2, skill_id2);
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
                xImage = rs.getString("image"); //Image

                x = new User(xUid, xUser, xPass, xName, xGender, xDob, xEmail, xAddress, xPhone, xRole, xUserStatus, xAvgRate, xImage);
                list.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<User> getMentorBy3Skill(String skill_id1, String skill_id2, String skill_id3) {
        List<User> list = new ArrayList<>();
        xSql = "SELECT a.u_Id, a.username, a.password, a.full_name, a.date_of_birth, a.email, a.phonenumber, a.address, a.role,\n"
                + "       a.user_status, a.avg_rate, a.create_time, a.gender, a.image\n"
                + "FROM\n"
                + "  (SELECT u.u_Id, u.username, u.password, u.full_name, u.date_of_birth, u.email, u.phonenumber, u.address, u.role,\n"
                + "          u.user_status, u.avg_rate, u.create_time, u.gender, u.image\n"
                + "   FROM user u\n"
                + "   JOIN cvofmentor cvom ON u.u_Id = cvom.mentor_Id\n"
                + "   JOIN skillofcv socv ON cvom.cv_Id = socv.cv_Id\n"
                + "   WHERE socv.skill_Id = ?) AS a\n"
                + "JOIN\n"
                + "  (SELECT u.u_Id, u.username, u.password, u.full_name, u.date_of_birth, u.email, u.phonenumber, u.address, u.role,\n"
                + "          u.user_status, u.avg_rate, u.create_time, u.gender, u.image\n"
                + "   FROM user u\n"
                + "   JOIN cvofmentor cvom ON u.u_Id = cvom.mentor_Id\n"
                + "   JOIN skillofcv socv ON cvom.cv_Id = socv.cv_Id\n"
                + "   WHERE socv.skill_Id = ?) AS b\n"
                + "ON a.u_Id = b.u_Id\n"
                + "JOIN\n"
                + "  (SELECT u.u_Id, u.username, u.password, u.full_name, u.date_of_birth, u.email, u.phonenumber, u.address, u.role,\n"
                + "          u.user_status, u.avg_rate, u.create_time, u.gender, u.image\n"
                + "   FROM user u\n"
                + "   JOIN cvofmentor cvom ON u.u_Id = cvom.mentor_Id\n"
                + "   JOIN skillofcv socv ON cvom.cv_Id = socv.cv_Id\n"
                + "   WHERE socv.skill_Id = ?) AS c\n"
                + "ON a.u_Id = c.u_Id;";
        String xUser, xPass, xName, xEmail, xAddress, xPhone, xImage;
        int xUid, xRole, xAvgRate;
        Date xDob;
        boolean xGender, xUserStatus;
        User x = null;
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, skill_id1);
            ps.setString(2, skill_id2);
            ps.setString(3, skill_id3);
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
                xImage = rs.getString("image"); //Image
                x = new User(xUid, xUser, xPass, xName, xGender, xDob, xEmail, xAddress, xPhone, xRole, xUserStatus, xAvgRate, xImage);
                list.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public static void main(String[] args) {
        UserDAO ud = new UserDAO();
        List<User> lu = ud.getMentorBy1Skill("1");
        System.out.println(lu);
    }

}
