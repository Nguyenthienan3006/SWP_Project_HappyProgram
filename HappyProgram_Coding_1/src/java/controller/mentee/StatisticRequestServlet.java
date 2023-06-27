/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.mentee;

import controller.common.RoleChecker;
import dao.ListRequestDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import model.StatisticRequestMentee;
import model.User;

/**
 *
 * @author An Nguyen
 */
public class StatisticRequestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //khoi tao session va lay nguoi dung hien tai
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        //check role
        if (!RoleChecker.isMentee(user)) {
            RoleChecker.redirectToHome(session, response);
        } else {
            ListRequestDAO m = new ListRequestDAO();
            ArrayList<StatisticRequestMentee> ListStatistic = m.StatisticRequest(user.getUid());
            session.setAttribute("ListStatistic", ListStatistic);
            request.getRequestDispatcher("StatisticRequestMentee.jsp").forward(request, response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        // Lấy session
        HttpSession session = request.getSession();

        // Xóa thông báo từ session
        session.removeAttribute("message");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
