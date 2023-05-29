package model;

public class Comment {
    private int commentId;
    private int menteeId;
    private int mentorId;
    private String commentContent;

    public Comment() {
    }

    public Comment(int commentId, int menteeId, int mentorId, String commentContent) {
        this.commentId = commentId;
        this.menteeId = menteeId;
        this.mentorId = mentorId;
        this.commentContent = commentContent;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
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

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    @Override
    public String toString() {
        return "Comment{" + "commentId=" + commentId + ", menteeId=" + menteeId + ", mentorId=" + mentorId + ", commentContent=" + commentContent + '}';
    }
    
    
}
