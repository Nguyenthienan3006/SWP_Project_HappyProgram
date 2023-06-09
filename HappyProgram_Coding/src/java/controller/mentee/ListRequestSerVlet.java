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
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import model.ListRequest;
import model.User;

/**
 *
 * @author An Nguyen
 */
@WebServlet(name = "ListRequestSerVlet", urlPatterns = {"/listrequest"})
public class ListRequestSerVlet extends HttpServlet {

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
            ArrayList<ListRequest> ListRequest = m.listRequestMentee(user.getUid());
            session.setAttribute("ListRequest", ListRequest);
            request.getRequestDispatcher("ListRequest.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy session
        HttpSession session = request.getSession();

        // Xóa thông báo từ session
        session.removeAttribute("message");

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
