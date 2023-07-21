/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.mentor;

import controller.common.RoleChecker;
import dao.*;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.*;
import model.*;

/**
 *
 * @author An Nguyen
 */
@WebServlet(name = "UpdateCvServlet", urlPatterns = {"/updatecv"})
public class UpdateCvServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            SkillDAO sd = new SkillDAO();
            List<Skill> ls = sd.getAllskill();
            request.setAttribute("ls", ls);

        } catch (Exception e) {
            log("Error at SkillServlet: " + e.toString());
        } finally {
            RequestDispatcher dispatcher = request.getRequestDispatcher("updatecv.jsp");
            dispatcher.forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        // Lấy session
        HttpSession session = request.getSession();

        // Xóa thông báo từ session
        session.removeAttribute("message");

        User u = (User) session.getAttribute("user");
        int mentorID = u.getUid();
        String pro = request.getParameter("pro");
        String edu = request.getParameter("edu");
        String exp = request.getParameter("exp");
        String achi = request.getParameter("achi");
        String[] skillSelected;
        skillSelected = request.getParameterValues("skills");

        List<Integer> skillsList = new ArrayList<>();
        if (skillSelected != null) {
            for (String skillIdStr : skillSelected) {
                int skillId = Integer.parseInt(skillIdStr);
                skillsList.add(skillId);
            }
        }

        Cv cv = new Cv(pro, edu, exp, achi);

        CvDAO cd = new CvDAO();
        cd.updateCv(mentorID, cv, skillsList);

        request.getRequestDispatcher("mycv").forward(request, response);
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
