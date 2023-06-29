package controller.common;

import dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import model.User;

/**
 *
 * @author asus
 */
public class UpdateProfile extends HttpServlet {
    UserDAO dao = new UserDAO();
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateProfile</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateProfile at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("user");
        //lay thong tin nguoi dung can update
        int userID = u.getUid();
        String fullName = request.getParameter("inputUsername");
        String address = request.getParameter("inputLocation");
        String email = request.getParameter("inputEmailAddress");
        String phoneNumber = request.getParameter("inputPhone");
        String dobb = request.getParameter("inputBirthday") ;
        String g = request.getParameter("gender");
        String tmp_img = request.getParameter("img");
        String current_img = request.getParameter("current_img");
        String img = "";
        if(tmp_img == null || tmp_img.length() == 0)
            img = current_img;
        else
            img = "images/userImg/" + tmp_img;
        String gender = "0";

        //doi ngay sinh tu String sang date
        Date dob = Date.valueOf(dobb);
        //doi gender tu string sang int
        if (g.equalsIgnoreCase("1")) {
            gender = "1";
        } else if (g.equalsIgnoreCase("2")) {
            gender = "0";
        }
        
        dao.updateProfile(fullName, dob, email, phoneNumber, address, gender,img, userID);
        
        // Chuyển hướng đến trang profile sau khi cập nhật thành công
        UserDAO ud = new UserDAO();
        User user = ud.Signin(u.getUsername(), u.getPassword());
        session.setAttribute("user", user);
        session.setAttribute("message", "Update Success!");
        request.getRequestDispatcher("profile.jsp").forward(request, response); 
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
