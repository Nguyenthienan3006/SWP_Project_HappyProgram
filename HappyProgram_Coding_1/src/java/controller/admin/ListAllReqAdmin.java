/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import dao.ListRequestDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import model.ListRequest;
import model.User;

/**
 *
 * @author An Nguyen
 */
public class ListAllReqAdmin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        ListRequestDAO d = new ListRequestDAO();
        //gọi ra dữ liệu của phiên người dùng hiện tại
        User u = (User) session.getAttribute("user");

        int menteeRole = 3;
        if (u == null || u.getRole() != menteeRole) {
            // Đặt thông báo vào session
            session.setAttribute("message", "Bạn Không có quyền truy cập!");
            request.getRequestDispatcher("home.jsp").forward(request, response);
        } else {
            ArrayList<ListRequest> listreq = d.ListAllRequestAdmin();
            session.setAttribute("listreq", listreq);
            request.getRequestDispatcher("listAllReqAdmin.jsp").forward(request, response);
        }
        //ListAllRequestAdmin()
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        ListRequestDAO d = new ListRequestDAO();
        //gọi ra dữ liệu của phiên người dùng hiện tại
        User u = (User) session.getAttribute("user");

        int menteeRole = 3;
        if (u == null || u.getRole() != menteeRole) {
            // Đặt thông báo vào session
            session.setAttribute("message", "Bạn Không có quyền truy cập!");
            request.getRequestDispatcher("home.jsp").forward(request, response);
        } else {
            String searchText = request.getParameter("searchText");
            String status = request.getParameter("status");
            String startDate = request.getParameter("startDate");
            String endDate = request.getParameter("endDate");

            // Gọi phương thức để tìm kiếm và lọc danh sách yêu cầu
            ArrayList<ListRequest> filteredRequests = searchRequests(searchText, status, startDate, endDate);

            // Lưu danh sách yêu cầu đã lọc trong attribute của request
            session.setAttribute("listreq", filteredRequests);

            // Forward request và response đến trang JSP hiển thị danh sách yêu cầu
            request.getRequestDispatcher("listAllReqAdmin.jsp").forward(request, response);
        }

    }

    public ArrayList<ListRequest> searchRequests(String searchText, String status, String startDate, String endDate) {
        // Tạo danh sách yêu cầu đã lọc
        ArrayList<ListRequest> filteredRequests = new ArrayList<>();

        // Thực hiện logic tìm kiếm và lọc yêu cầu dựa trên các tham số
        ListRequestDAO d = new ListRequestDAO();
        ArrayList<ListRequest> listreq = d.RequestDetailForFilter();

        // Duyệt qua tất cả các yêu cầu và áp dụng các điều kiện lọc
        for (ListRequest list : listreq) {
            // Kiểm tra điều kiện tìm kiếm tên theo từ khóa
            if (searchText != null && !searchText.isEmpty()) {
                if (!(list.getMenteeName().toLowerCase()).contains(searchText)) {
                    continue; // Bỏ qua yêu cầu không khớp với từ khóa tìm kiếm
                }
            }

            // Kiểm tra điều kiện lọc theo trạng thái
            if (status != null && !status.isEmpty()) {
                if (!list.getRequestStatus().equalsIgnoreCase(status)) {
                    continue; // Bỏ qua yêu cầu không khớp với trạng thái lựa chọn
                }
            }

            // Kiểm tra điều kiện lọc theo ngày bắt đầu và ngày kết thúc
            if (startDate != null && !startDate.isEmpty() && endDate != null && !endDate.isEmpty()) {
                // Chuyển đổi startDate và endDate từ chuỗi sang đối tượng Date để so sánh
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    Date start = sdf.parse(startDate);
                    Date end = sdf.parse(endDate);
                    Date requestDate = sdf.parse(list.getCreated_date());

                    if (requestDate.before(start) || requestDate.after(end)) {
                        continue; // Bỏ qua yêu cầu không nằm trong khoảng ngày lựa chọn
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            // Nếu yêu cầu vượt qua tất cả các điều kiện lọc, thêm vào danh sách yêu cầu đã lọc
            filteredRequests.add(list);
        }

        // Trả về danh sách yêu cầu đã lọc
        return filteredRequests;
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
