package controller.common;

import dao.*;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.util.List;
import model.*;

public class SignupServlet extends HttpServlet {

    String user, pass, cfpass, xRole, fullname, xGender, xDob, address, email, phone;
    Date dob;
    EmailSender e = new EmailSender();
    int count = 0;
    int num = 2;

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
        } else if (!(phone.startsWith("0") && phone.length() == 10)) {
            request.setAttribute("mess", "Phone must start with 0 and include 10 number");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
        }

        UserDAO ud = new UserDAO();
        List<User> lu = ud.getAllUser();
        for (User u : lu) {
            if (u.getUsername().equals(user)) {
                request.setAttribute("mess", "Username already exist!");
                request.getRequestDispatcher("signup.jsp").forward(request, response);
            }
            if (u.getEmail().equals(email)) {
                request.setAttribute("mess", "Email already exist!");
                request.getRequestDispatcher("signup.jsp").forward(request, response);
            }
        }
        e.sendOTP(email);

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        SignupServlet.OtpForm(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String otp = request.getParameter("otp");
        if (!((e.getOtp()).equals(otp))) {
            request.setAttribute("mess", "Wrong OTP!");
            count++;
            if (count == 3) {
                session.setAttribute("message", "Sign up Fail!");
                request.getRequestDispatcher("home.jsp").forward(request, response);
            }
            String messOTP = "Wrong! you have " + num + " more time!";
            num--;
            session.setAttribute("messageOTP", messOTP);
            SignupServlet.OtpForm(request, response);
        } else {

            Date dob = Date.valueOf(xDob);
            int role = Integer.parseInt(xRole);
            boolean gender;

            if (xGender.equals("male")) {
                gender = true;
            } else {
                gender = false;
            }

            UserDAO ud = new UserDAO();

            ud.add(user, pass, fullname, gender, dob, email, phone, address, role);
            session.setAttribute("message", "Sign up Success!");
            request.getRequestDispatcher("home.jsp").forward(request, response);
        }

    }

    public static void OtpForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>OTP Confirmation</title>");
        out.println("<link rel=\"stylesheet\" href=\"css/style.css\"/></link>");
        out.println("<style>");
        out.println(".otp-body {");
        out.println("    background-color: #f2f2f2;");
        out.println("    font-family: Arial, sans-serif;");
        out.println("}");
        out.println(".otp-container {");
        out.println("    max-width: 400px;");
        out.println("    margin: 0 auto;");
        out.println("    padding: 20px;");
        out.println("    background-color: #fff;");
        out.println("    border-radius: 5px;");
        out.println("    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);");
        out.println("}");
        out.println(".otp-h1 {");
        out.println("    text-align: center;");
        out.println("    color: #333;");
        out.println("}");
        out.println(".otp-note {");
        out.println("    text-align: center;");
        out.println("    font-size: 14px;");
        out.println("    color: #666;");
        out.println("}");
        out.println(".otp-form {");
        out.println("    margin-top: 20px;");
        out.println("}");
        out.println(".otp-label {");
        out.println("    display: block;");
        out.println("    margin-bottom: 5px;");
        out.println("    color: #333;");
        out.println("}");
        out.println(".otp-input {");
        out.println("    width: 100%;");
        out.println("    padding: 10px;");
        out.println("    margin-bottom: 10px;");
        out.println("    border: 1px solid #ccc;");
        out.println("    border-radius: 4px;");
        out.println("}");
        out.println(".otp-input[type=\"submit\"] {");
        out.println("    background-color: #4CAF50;");
        out.println("    color: #fff;");
        out.println("    cursor: pointer;");
        out.println("}");
        out.println(".otp-input[type=\"submit\"]:hover {");
        out.println("    background-color: #45a049;");
        out.println("}");
        out.println("</style>");
        out.println("</head>");
        out.println("<body class=\"otp-body\">");
        out.println("<div class=\"otp-container\">");
        out.println("<h1 class=\"otp-h1\">Confirm OTP</h1>");
        out.println("<p class=\"otp-note\">Bạn có tối đa 3 lần nhập mã OTP</p>");
        out.println("<form class=\"otp-form\" action=\"signup\" method=\"post\">");
        out.println("<label class=\"otp-label\" for=\"otp\">Enter OTP:</label>");
        out.println("<input name=\"otp\" class=\"otp-input\" type=\"text\" id=\"otp-input\" required>");
        out.println("<input class=\"otp-input\" type=\"submit\" value=\"Enter\">");
        out.println("<br><a href=\"suggest\">Back to home</a>");
        out.println("<form>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }

}
