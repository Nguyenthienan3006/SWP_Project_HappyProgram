/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.mentee;

import dao.RequestDAO;
import dao.SkillDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Skill;

/**
 *
 * @author An Nguyen
 */
public class CreateRequest extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CreateRequest</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreateRequest at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        try {
            SkillDAO s = new SkillDAO();
            List<Skill> skillsList = s.getAllskill();
            HttpSession session = request.getSession();
            session.setAttribute("skillsList", skillsList);
        } catch (Exception e) {
            log("Error at SkillServlet: " + e.toString());
        } finally {
            request.getRequestDispatcher("create_request.jsp").forward(request, response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String Title_of_request = request.getParameter("Title_of_request");
        String createdDate = request.getParameter("createdDate");
        String finishDate = request.getParameter("finishDate");
        String Date_hour = request.getParameter("Date_hour");
        int Request_hour = Integer.parseInt(request.getParameter("Request_hour"));
        String Desciption_of_request = request.getParameter("Desciption_of_request");

        RequestDAO d = new RequestDAO();
        d.createRequest(2, 3, 1, createdDate, finishDate, Date_hour, Request_hour, Title_of_request, Desciption_of_request);
        // request.getRequestDispatcher("home.jsp").forward(request, response);
        response.sendRedirect("home.jsp");
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
