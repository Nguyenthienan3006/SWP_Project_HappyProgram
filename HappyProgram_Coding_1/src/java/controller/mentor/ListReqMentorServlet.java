package controller.mentor;

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
        //khởi tạo sesion
        HttpSession session = request.getSession();
        //gọi ra dữ liệu của phiên người dùng hiện tại
        User u = (User) session.getAttribute("user");
        
        int mentorRole = 2;
        if (u == null || u.getRole() != mentorRole) {
            request.getRequestDispatcher("home.jsp").forward(request, response);
        } else {
            //Xử lý khi đối tượng là null
            ListRequestMentorDAO lrd = new ListRequestMentorDAO();
            List<ListRequest> lr = lrd.listRequestMentor(u.getUid());
            request.setAttribute("lr", lr);
            request.getRequestDispatcher("list-request-mentor.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

    }

}
