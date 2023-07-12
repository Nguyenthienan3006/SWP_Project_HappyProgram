/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.mentee;

import controller.common.RoleChecker;
import dao.ListRequestDAO;
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
import java.util.ArrayList;
import java.util.List;
import model.*;

/**
 *
 * @author An Nguyen
 */
@WebServlet(name = "UpdateSkillStatusServlet", urlPatterns = {"/updateskillstatus"})
public class UpdateSkillStatusServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        //khoi tao session va lay nguoi dung hien tai
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        //check role
        if (!RoleChecker.isAdmin(user)) {
            RoleChecker.redirectToHome(session, response);
        } else {
            try {
                int skillId = Integer.parseInt(request.getParameter("id"));
                SkillDAO sd = new SkillDAO();
                sd.UpdateSkillStatus(skillId);
                
                List<Skill> skillsList = sd.getAllskillAdmin();
                session.setAttribute("skillsList", skillsList);
            } catch (Exception e) {
                log("Error at SkillServlet: " + e.toString());
            } finally {
                RequestDispatcher dispatcher = request.getRequestDispatcher("courses.jsp");
                dispatcher.forward(request, response);
            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        // Lấy session
        HttpSession session = request.getSession();
        // Xóa thông báo từ session
        session.removeAttribute("message");
        //gọi ra dữ liệu của phiên người dùng hiện tại

    }

}
