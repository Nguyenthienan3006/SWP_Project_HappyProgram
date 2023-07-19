package dao;

import java.util.ArrayList;
import model.*;

public class CommentDAO extends MyDAO {

    public ArrayList<Comment> getComment(int mentorID) {
        xSql = "select C.mentorID, C.comment_Content, R.Rated_point\n"
                + "from comment C, Rate R\n"
                + "where C.mentorID = R.mentorID and C.menteeID = R.menteeID and C.mentorID = ?";
        String comment;
        int rateStar;
        ArrayList<Comment> ListComment = new ArrayList<>();
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, mentorID);
            rs = ps.executeQuery();
            while (rs.next()) {
                comment = rs.getString("comment_Content");
                rateStar = rs.getInt("Rated_point");
                //add comment từ database vào list
                Comment list = new Comment(comment, rateStar);
                ListComment.add(list);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListComment;
    }

    public static void main(String[] args) {
        CommentDAO c = new CommentDAO();
        c.getComment(3);
    }
}
