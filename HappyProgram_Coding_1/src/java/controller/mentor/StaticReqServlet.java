package controller.mentor;

import dao.*;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.*;

public class StaticReqServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("user");
        int uid = u.getUid();
        int mentorRole = 2;
        if (u == null || u.getRole() != mentorRole) {
            // Đặt thông báo vào session
            session.setAttribute("message", "Bạn Không có quyền truy cập!");
            request.getRequestDispatcher("home.jsp").forward(request, response);

        } else {

            RateDAO rd = new RateDAO();
            double avgRate = rd.getAvgRateByUserID(uid);

            ListRequestMentorDAO rqd = new ListRequestMentorDAO();
            int open, processing, finish, rejected;

            open = rqd.countRequestStatus(uid, "Open");
            processing = rqd.countRequestStatus(uid, "processing");
            finish = rqd.countRequestStatus(uid, "finish");
            rejected = rqd.countRequestStatus(uid, "rejected");

            request.setAttribute("rate", avgRate);
            request.setAttribute("total", open + processing + finish + rejected);
            request.setAttribute("open", open);
            request.setAttribute("processing", processing);
            request.setAttribute("finish", finish);
            request.setAttribute("rejected", rejected);
            request.getRequestDispatcher("static-request-mentor.jsp").forward(request, response);
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
