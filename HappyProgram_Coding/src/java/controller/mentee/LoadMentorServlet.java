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
@WebServlet(name = "LoadMentorServlet", urlPatterns = {"/loadmentor"})
public class LoadMentorServlet extends HttpServlet {

    String[] skillSelected;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        //khoi tao session va lay nguoi dung hien tai
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        //check role
        if (!RoleChecker.isMentee(user)) {
            RoleChecker.redirectToHome(session, response);
        } else {
            try {
                SkillDAO sd = new SkillDAO();
                List<Skill> ls = sd.getAllskill();
                request.setAttribute("ls", ls);

                skillSelected = request.getParameterValues("skills");

                UserDAO ud = new UserDAO();
                List<User> lu = new ArrayList<>();

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

            } catch (Exception e) {
                log("Error at SkillServlet: " + e.toString());
            } finally {
                RequestDispatcher dispatcher = request.getRequestDispatcher("create_request.jsp");
                dispatcher.forward(request, response);
            }

            //request.getRequestDispatcher("create_request.jsp").forward(request, response);
            /*  RequestDispatcher dispatcher = request.getRequestDispatcher("loadskill");
            dispatcher.forward(request, response);*/
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
        User u = (User) session.getAttribute("user");
        int menteeID = u.getUid();

        int mentorID = Integer.parseInt(request.getParameter("mentor"));

        String Title_of_request = request.getParameter("Title_of_request");
        String createdDate = request.getParameter("createdDate");
        String finishDate = request.getParameter("finishDate");
        String Date_hour = "2023-08-25 06:00:00";
        int Request_hour = Integer.parseInt(request.getParameter("Request_hour"));
        String Desciption_of_request = request.getParameter("Desciption_of_request");

        RequestDAO d = new RequestDAO();
        d.createRequest(menteeID, mentorID, 1, createdDate, finishDate, Date_hour, Request_hour, Title_of_request, Desciption_of_request);

        for (int i = 0; i < skillSelected.length; i++) {
            d.createRequestskill(skillSelected[i]);
        }
        ListRequestDAO m = new ListRequestDAO();
        ArrayList<ListRequest> ListRequest = m.listRequestMentee(u.getUid());
        session.setAttribute("ListRequest", ListRequest);
        session.setAttribute("message", "Create Successfull!");
        request.getRequestDispatcher("suggest").forward(request, response);
    }

}
