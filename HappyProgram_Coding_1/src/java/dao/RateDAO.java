package dao;

import model.*;


public class RateDAO extends MyDAO {

    public double getAvgRateByUserID(int uid) {
        xSql = "SELECT ROUND(AVG(Rated_point), 1) AS avg_rate\n"
                + "FROM Rate\n"
                + "WHERE mentorID = ?";
        double rate = 0;
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, uid);
            rs = ps.executeQuery();
            if (rs.next()) {
                rate = rs.getDouble("avg_rate");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rate;
    }
}


