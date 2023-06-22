/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.mentee;

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
 * @author An Nguyen
 */
@WebServlet(name = "LoadSkillServlet", urlPatterns = {"/loadskill"})
public class LoadSkillServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
            try {
                SkillDAO sd = new SkillDAO();
                List<Skill> ls = sd.getAllskill();
                request.setAttribute("ls", ls);
                List<Skill> lss = (List<Skill>) request.getAttribute("lss");
                List<User> lu = (List<User>) request.getAttribute("lu");
                request.setAttribute("lss", lss);
                request.setAttribute("lu", lu);

            } catch (Exception e) {
                log("Error at SkillServlet: " + e.toString());
            } finally {
                RequestDispatcher dispatcher = request.getRequestDispatcher("create_request.jsp");
                dispatcher.forward(request, response);
            }
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
