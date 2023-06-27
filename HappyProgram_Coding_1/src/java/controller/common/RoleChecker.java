package controller.common;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import model.User;

public class RoleChecker extends HttpServlet {

    //cac ham check role
    public static boolean isMentee(User user) {
        int menteeRole = 1;
        return user != null && user.getRole() == menteeRole;
    }

    public static boolean isMentor(User user) {
        int mentorRole = 2;
        return user != null && user.getRole() == mentorRole;
    }

    public static boolean isAdmin(User user) {
        int adminRole = 3;
        return user != null && user.getRole() == adminRole;
    }

    public static void redirectToHome(HttpSession session, HttpServletResponse response)
            throws ServletException, IOException {
        //day ve trang home va thong bao
        session.setAttribute("message", "Bạn không có quyền truy cập!");
        response.sendRedirect("home.jsp");
    }
}
