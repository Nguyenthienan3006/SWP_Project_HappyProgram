/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import DB.DBConnect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.CheckExistCv;

/**
 *
 * @author admin
 */
public class CheckExistCvDAO extends DBConnect {

    public ArrayList<CheckExistCv> checkExistCv() {
        ArrayList<CheckExistCv> list = new ArrayList<>();
        String xSql = "select c.mentor_Id as mentorID\n"
                + "from cvofmentor as c";
        try {
            int mentorID;
            PreparedStatement st = getJDBCConnection().prepareStatement(xSql);
            ResultSet resultSet = st.executeQuery();

            resultSet = st.executeQuery();
            while (resultSet.next()) {
                mentorID = resultSet.getInt("mentorID");

                //add mentorID từ database vào list
              CheckExistCv c = new CheckExistCv(mentorID);
                list.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
