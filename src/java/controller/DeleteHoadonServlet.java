/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.HoaDonDAO;
import dao.CT_HoaDonDAO;
/**
 *
 * @author SinoMax
 */
public class DeleteHoadonServlet extends HttpServlet {
HoaDonDAO hdDAO = new HoaDonDAO();
CT_HoaDonDAO ctDAO = new CT_HoaDonDAO();
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String command = request.getParameter("command");
        String maloai = request.getParameter("maddh");
        String url = "";
        try {
            switch (command) {
                case "delete":
                    ctDAO.delete(Long.parseLong(maloai));
                    hdDAO.delete(Long.parseLong(maloai));
                    url = "/Admin/admin_bill.jsp";
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
    }
}
