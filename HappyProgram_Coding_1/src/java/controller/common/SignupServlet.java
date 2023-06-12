package controller.common;

import dao.*;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.List;
import model.*;

public class SignupServlet extends HttpServlet {

    String user, pass, cfpass, xRole, fullname,xGender, xDob, address, email, phone;
    Date dob;
    EmailSender e = new EmailSender();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        user = request.getParameter("user");
        pass = request.getParameter("pass");
        cfpass = request.getParameter("cfpass");
        xRole = request.getParameter("role");
        fullname = request.getParameter("fullname");
        xGender = request.getParameter("gender");
        xDob = request.getParameter("dob");
        email = request.getParameter("email");
        phone = request.getParameter("phone");
        address = request.getParameter("address");

        if (!pass.equals(cfpass)) {
            request.setAttribute("mess", "Password not match!");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
        }

        UserDAO ud = new UserDAO();
        List<User> lu = ud.getAllUser();
        for (User u : lu) {
            if (u.getUsername().equals(user)) {
                request.setAttribute("mess", "Username already exist!");
                request.getRequestDispatcher("signup.jsp").forward(request, response);
            }
        }
        e.sendOTP(email);

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>OTP Confirmation</title>");
        out.println("<link rel=\"stylesheet\" href=\"css/style.css\"/></link>");
        out.println("</head>");
        out.println("<body class=\"otp-body\">");
        out.println("<div class=\"otp-container\">");
        out.println("<h1 class=\"otp-h1\">Confirm OTP</h1>");
        out.println("<form class=\"otp-form\" action=\"signup\" method=\"post\">");
        out.println("<label class=\"otp-label\" for=\"otp\">Enter OTP:</label>");
        out.println("<input name=\"otp\" class=\"otp-input\" type=\"text\" id=\"otp-input\" required>");
        out.println("<input class=\"otp-input\" type=\"submit\" value=\"Enter\">");
        out.println("<br><a href=\"home.jsp\">Back to home</a>");
        out.println("<form>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String otp = request.getParameter("otp");

        if (!((e.getOtp()).equals(otp))) {
            request.setAttribute("mess", "Sign up FAIL! Wrong OTP!");
            request.getRequestDispatcher("home.jsp").forward(request, response);
        } else {

            Date dob = Date.valueOf(xDob);
            int role = Integer.parseInt(xRole);
            boolean gender;
            if(xGender.equals("male")){
                gender = true;
            }else{
                gender = false;
            }

            UserDAO ud = new UserDAO();

            ud.add(user, pass, fullname, gender, dob, email, phone, address, role);
            request.setAttribute("mess", "Sign up Success!");
            request.getRequestDispatcher("home.jsp").forward(request, response);
        }

    }

}
