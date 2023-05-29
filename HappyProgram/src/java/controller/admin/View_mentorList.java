/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import dao.MentorDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ListMentor;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 *
 * @author An Nguyen
 */
@WebServlet(name = "View_mentorList", urlPatterns = {"/View_mentorList"})
public class View_mentorList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        HttpSession session = request.getSession();
        MentorDAO m = new MentorDAO();
        ArrayList<ListMentor> mentorList = m.displayMentorList();
        session.setAttribute("mentorList", mentorList);
        request.getRequestDispatcher("teachers.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        HttpSession session = request.getSession();
        MentorDAO me = new MentorDAO();

        ArrayList<ListMentor> mentorList = me.displayMentorList();
        String search = request.getParameter("name");

        if (search != null && !search.isEmpty()) {
            ArrayList<ListMentor> searchList = new ArrayList();
            for (ListMentor m : mentorList) {
                if (m.getFullname().toLowerCase().contains(search.toLowerCase())) {
                    searchList.add(m);
                }
            }
            session.setAttribute("mentorList", searchList);
        } else {
            session.setAttribute("mentorList", mentorList);
        }

        request.getRequestDispatcher("teachers.jsp").forward(request, response);
    }
}
