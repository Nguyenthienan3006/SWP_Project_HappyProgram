package controller.mentor;

import controller.common.RoleChecker;
import dao.*;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.*;

@WebServlet(name = "ListReqMentorServlet", urlPatterns = {"/listreqmentor"})

public class ListReqMentorServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //khoi tao session va lay nguoi dung hien tai
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        //check role
        if (!RoleChecker.isMentor(user)) {
            RoleChecker.redirectToHome(session, response);
        } else {
            //Xử lý khi đối tượng là null
            ListRequestMentorDAO lrd = new ListRequestMentorDAO();
            List<ListRequest> lr = lrd.listRequestMentor(user.getUid());
            request.setAttribute("lr", lr);
            request.getRequestDispatcher("list-request-mentor.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        // Lấy session
        HttpSession session = request.getSession();

        // Xóa thông báo từ session
        session.removeAttribute("message");
    }

}
