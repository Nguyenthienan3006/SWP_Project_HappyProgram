/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.mentee;

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
@WebServlet(name = "LoadMentorServlet", urlPatterns = {"/loadmentor"})
public class LoadMentorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        //khởi tạo sesion
        HttpSession session = request.getSession();
        //gọi ra dữ liệu của phiên người dùng hiện tại
        User u = (User) session.getAttribute("user");

        int menteeRole = 1;
        if (u == null || u.getRole() != menteeRole) {
            // Đặt thông báo vào session
            session.setAttribute("message", "Bạn Không có quyền truy cập!");
            request.getRequestDispatcher("home.jsp").forward(request, response);
        } else {
            String[] skillSelected;
            skillSelected = request.getParameterValues("skills");

            UserDAO ud = new UserDAO();
            List<User> lu = new ArrayList<>();

            SkillDAO sd = new SkillDAO();
            List<Skill> lss = new ArrayList<>();

            switch (skillSelected.length) {
                case 1:
                    lu = ud.getMentorBy1Skill(skillSelected[0]);
                    lss.add(sd.getSkillById(skillSelected[0]));
                    break;
                case 2:
                    lu = ud.getMentorBy2Skill(skillSelected[0], skillSelected[1]);
                    lss.add(sd.getSkillById(skillSelected[0]));
                    lss.add(sd.getSkillById(skillSelected[1]));
                    break;
                case 3:
                    lu = ud.getMentorBy3Skill(skillSelected[0], skillSelected[1], skillSelected[2]);
                    lss.add(sd.getSkillById(skillSelected[0]));
                    lss.add(sd.getSkillById(skillSelected[1]));
                    lss.add(sd.getSkillById(skillSelected[2]));
                    break;
                default:
                    break;
            }

            request.setAttribute("lss", lss);
            request.setAttribute("lu", lu);
            //request.getRequestDispatcher("create_request.jsp").forward(request, response);
            RequestDispatcher dispatcher = request.getRequestDispatcher("loadskill");
            dispatcher.forward(request, response);
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
