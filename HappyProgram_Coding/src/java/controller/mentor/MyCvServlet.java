/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.mentor;

import controller.common.RoleChecker;
import dao.CommentDAO;
import dao.CvOfMentorDAO;
import dao.SkillDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Session;
import model.Comment;
import model.CvOfMentor;
import model.ListMentor;
import model.Rate;
import model.User;

/**
 *
 * @author dongx
 */
@WebServlet(name = "MyCvServlet", urlPatterns = {"/mycv"})
public class MyCvServlet extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {

            //khoi tao session
            HttpSession session = request.getSession();
            User u = (User) session.getAttribute("user");
            //lay thong tin nguoi dung can update
            CommentDAO c2 = new CommentDAO();
            CvOfMentorDAO c = new CvOfMentorDAO();
            SkillDAO sd = new SkillDAO();
            //Get mentorID
            int Uid = u.getUid();
            //Cv information
            ListMentor lm = c.GetCvOfMentor(Uid);
            CvOfMentor mentorCV = c.getMentorInfoReq(Uid);
            List<String> skillMentor = sd.getSkillByMentorId(Uid);
            //Get comment
            ArrayList<Comment> commentList = c2.getComment(Uid);
            //Get average rateStar
            double rateStar = c2.getAVGStar(Uid);
            //Set attribute
            session.setAttribute("commentList", commentList);
            session.setAttribute("rs", rateStar);
            session.setAttribute("mentorCV", mentorCV);
            request.setAttribute("skillMentor", skillMentor);
            request.setAttribute("cv", lm);
            request.getRequestDispatcher("teachers-singel.jsp").forward(request, response);

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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(MyCvServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(MyCvServlet.class.getName()).log(Level.SEVERE, null, ex);
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