package controller.common;

import dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class ChangePasswordServlet extends HttpServlet {
    UserDAO dao = new UserDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String currentPassword = req.getParameter("currentPassword");
        String newPassword = req.getParameter("newPassword");
        String confirmPassword = req.getParameter("confirmPassword");
        String oldPassword = dao.getPasswordByUser_name(userName);
        if(currentPassword.equals(oldPassword)){
            if(confirmPassword.equals(newPassword)){
                 int succes = dao.changePassword(userName, newPassword);
            if(succes == 0){
                req.setAttribute("mess", "Change password fail");
                req.getRequestDispatcher("changepass.jsp").forward(req, res);
            }
            else{
                req.setAttribute( "mess", "Change password success");
                req.getRequestDispatcher("changepass.jsp").forward(req, res);
            }
        }
            else{
                req.setAttribute("mess", "New password must be same as confirm password");
                req.getRequestDispatcher("changepass.jsp").forward(req, res);
            }
    }
            else{
                req.setAttribute("mess", "Current password is incorrect");
                req.getRequestDispatcher("changepass.jsp").forward(req, res);
                        
                    }
    }    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute( "mess", "" );
        req.getRequestDispatcher("changepass.jsp").forward(req, resp);
    }
}

    
 