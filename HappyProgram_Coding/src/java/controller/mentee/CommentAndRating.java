/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.mentee;

import controller.common.RoleChecker;
import dao.ListRequestDAO;
import dao.RequestDAO;
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
 * @author admin
 */
public class CommentAndRating extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CommentAndRating</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CommentAndRating at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
            request.setAttribute("mess", "close success full!");
            request.getRequestDispatcher("CommentAndRating.jsp").forward(request, response);
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
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        // Lấy giá trị được truyền từ JSP
        String mentorID = request.getParameter("mentorID");
        String menteeID = request.getParameter("menteeID");
        String comment = request.getParameter("comment");
        String rating = request.getParameter("rating");

        // Ép kiểu các thông số ID sang kiểu int (nếu có giá trị)
        int mentorIDInt = 0;
        int menteeIDInt = 0;
        int ratingInt = 0;

        if (mentorID != null && !mentorID.isEmpty()) {
            mentorIDInt = Integer.parseInt(mentorID);
        }

        if (menteeID != null && !menteeID.isEmpty()) {
            menteeIDInt = Integer.parseInt(menteeID);
        }
        if (rating != null && !rating.isEmpty()) {
            ratingInt = Integer.parseInt(rating);
        }

        // Xử lý các giá trị         
        RequestDAO d = new RequestDAO();
        int check = d.CommentMentee(menteeIDInt, mentorIDInt, comment);
        if (check == 0) {
            session.setAttribute("message", "close request successfully!");
            request.getRequestDispatcher("suggest").forward(request, response);
        } else {
            session.setAttribute("message", "close request fail!");
            request.getRequestDispatcher("suggest").forward(request, response);

        }
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
