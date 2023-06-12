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

        RateDAO rd = new RateDAO();
        double avgRate = rd.getAvgRateByUserID(uid);

        ListRequestMentorDAO rqd = new ListRequestMentorDAO();
        int open, processing, finish, rejected;

        open = rqd.countRequestStatus(uid, "open");
        processing = rqd.countRequestStatus(uid, "processing");
        finish = rqd.countRequestStatus(uid, "finish");
        rejected = rqd.countRequestStatus(uid, "rejected");

        
        request.setAttribute("rate", avgRate);
        request.setAttribute("total", open + processing + finish + rejected);
        request.setAttribute("uncheck", open);
        request.setAttribute("processing", processing);
        request.setAttribute("accepted", finish);
        request.setAttribute("rejected", rejected);
        request.getRequestDispatcher("static-request-mentor.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

    }

}
