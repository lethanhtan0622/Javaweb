package controller;
import dao.SanphamDAO; 
import java.io.IOException;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.loaispDAO;
import model.product;

public class ManagerSanphamServlet extends HttpServlet {
    
    SanphamDAO categoryDAO = new SanphamDAO();
    loaispDAO lspDAO = new loaispDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String command = request.getParameter("command");
        String maloai = request.getParameter("masp");
        String url = "";
        try {
            switch (command) {
                case "delete":
                    categoryDAO.delete(Long.parseLong(maloai));
                    url = "/Admin/admin_sanpham.jsp";
                    break;
            }
        } catch (NumberFormatException e) {
        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
        rd.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String command = request.getParameter("command");
        Long maloai = Long.parseLong(request.getParameter("maloai"));
        String tenloai = request.getParameter("tensp");
        String hinhanh = request.getParameter("hinhanh");
        Double gia = Double.parseDouble(request.getParameter("gia"));
        String mota = request.getParameter("mota");
        int soluong = Integer.parseInt(request.getParameter("soluong")) ;
        String url = "", error = "";
        
        if (tenloai.equals("")) {
            error = "Vui lòng nhập tên danh mục!";
            request.setAttribute("error", error);
        }
        try {
            if (error.length() == 0) {
                switch (command) {
                    case "insert":
                        
                        categoryDAO.insert(new product(new Date().getTime()%1000, maloai, tenloai, hinhanh, gia, mota, soluong));
                        url = "/Admin/admin_sanpham.jsp";
                        break;
                    case "update":
                        categoryDAO.update(new product(Long.parseLong(request.getParameter("masp")), maloai, tenloai,hinhanh, gia, mota, soluong));
                        url = "/Admin/admin_sanpham.jsp";
                        break;
                }
            } else {
                url = "/Admin/admin_sanpham.jsp";
            }
        } catch (Exception e) {
        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
        rd.forward(request, response);
    }
}
