package controller;
import dao.loaispDAO;
import java.io.IOException;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.loaisp;
import model.product;
import dao.SanphamDAO;

public class ManagerLoaispServlet extends HttpServlet {
    loaispDAO categoryDAO = new loaispDAO();
    SanphamDAO sp = new SanphamDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String command = request.getParameter("command");
        String maloai = request.getParameter("maloai");
        product p = new product();
        String url = "";
        try {
            switch (command) {
                case "delete":
                    categoryDAO.delete(Long.parseLong(maloai));
                    sp.deletelist(new product(p.getMasp(),Long.parseLong(maloai), p.getTensp(), p.getHinhanh(), p.getGia(), p.getMota(), p.getSoluong()));
                    url = "/Admin/admin_loaisp.jsp";
                    break;
            }
        } catch (Exception e) {
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
        String tenloai = request.getParameter("tenloai");
        String hinhanh = request.getParameter("hinhanh");
        String mota = request.getParameter("mota");
        String url = "", error = "";
        if (tenloai.equals("")) {
            error = "Vui lòng nhập tên danh mục!";
            request.setAttribute("error", error);
        }
        try {
            if (error.length() == 0) {
                switch (command) {
                    case "insert":
                        categoryDAO.insert(new loaisp(new Date().getTime()%1000, tenloai,hinhanh,mota));
                        url = "/Admin/admin_loaisp.jsp";
                        break;
                    case "update":
                        categoryDAO.update(new loaisp(Long.parseLong(request.getParameter("maloai")),tenloai,hinhanh,mota));
                        url = "/Admin/admin_loaisp.jsp";
                        break;
                }
            } else {
                url = "/Admin/admin_loaisp.jsp";
            }
        } catch (Exception e) {
        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
        rd.forward(request, response);
    }
}
