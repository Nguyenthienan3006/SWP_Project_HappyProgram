/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import dao.ListRequestDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
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
public class RequestDetailAdmin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        ListRequestDAO d = new ListRequestDAO();
        //gọi ra dữ liệu của phiên người dùng hiện tại
        User u = (User) session.getAttribute("user");

        int menteeRole = 3;
        if (u == null || u.getRole() != menteeRole) {
            // Đặt thông báo vào session
            session.setAttribute("message", "Bạn Không có quyền truy cập!");
            request.getRequestDispatcher("home.jsp").forward(request, response);
        } else {
            int requestID = Integer.parseInt(request.getParameter("requestid"));
            ArrayList<ListRequest> listreqdetail = d.RequestDetail(requestID);
            session.setAttribute("listreqdetail", listreqdetail);
            request.getRequestDispatcher("requestDetailAdmin.jsp").forward(request, response);
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
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
