package controller.mentor;

import controller.common.RoleChecker;
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

        //khoi tao session va lay nguoi dung hien tai
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        //check role
        if (!RoleChecker.isMentor(user)) {
            RoleChecker.redirectToHome(session, response);
        } else {
            int uid = user.getUid();
            RateDAO rd = new RateDAO();
            double avgRate = rd.getAvgRateByUserID(uid);

            ListRequestMentorDAO rqd = new ListRequestMentorDAO();
            int open, processing, finish, Reject;

            open = rqd.countRequestStatus(uid, "Open");
            processing = rqd.countRequestStatus(uid, "processing");
            finish = rqd.countRequestStatus(uid, "finish");
            Reject = rqd.countRequestStatus(uid, "Reject");

            request.setAttribute("rate", avgRate);
            request.setAttribute("total", open + processing + finish + Reject);
            request.setAttribute("open", open);
            request.setAttribute("processing", processing);
            request.setAttribute("finish", finish);
            request.setAttribute("rejected", Reject);
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
