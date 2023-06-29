/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.common;

import controller.common.RoleChecker;
import dao.*;
import dao.SkillDAO;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import model.ListRequest;
import model.*;

/**
 *
 * @author havie
 */
@WebServlet(name = "LoadSkillSuggestServlet", urlPatterns = {"/suggest"})
public class LoadSkillSuggestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //khoi tao session 
        HttpSession session = request.getSession();

        try {
            SkillDAO sd = new SkillDAO();
            List<Skill> ls = sd.getAllskill();
            request.setAttribute("ls", ls);
            MentorDAO m = new MentorDAO();
            ArrayList<ListMentor> mentorList = m.getMentorSuggestBySkill("1");
            session.setAttribute("mentorList", mentorList);

        } catch (Exception e) {
            log("Error at SkillServlet: " + e.toString());
        } finally {
            RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            SkillDAO sd = new SkillDAO();
            List<Skill> ls = sd.getAllskill();
            request.setAttribute("ls", ls);

            String skillId = request.getParameter("skill");
            HttpSession session = request.getSession();
            MentorDAO m = new MentorDAO();
            ArrayList<ListMentor> mentorList = m.getMentorSuggestBySkill(skillId);
            session.setAttribute("mentorList", mentorList);

        } catch (Exception e) {
            log("Error at SkillServlet: " + e.toString());
        } finally {
            RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
            dispatcher.forward(request, response);
        }
    }

}
