/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CT_HoaDonDAO;
import dao.HoaDonDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.CT_HoaDon;
import model.Cart;
import model.HoaDon;
import model.Item;
import model.Users;
import tool.Sendmail;

/**
 *
 * @author SinoMax
 */
public class CheckOutServlet extends HttpServlet {
     private final HoaDonDAO billDAO = new HoaDonDAO();
     private final CT_HoaDonDAO billDetailDAO = new CT_HoaDonDAO();     
     @Override     
     protected void doGet(HttpServletRequest request, HttpServletResponse response)             
             throws ServletException, IOException {     
         
     }
     
    @Override     
    protected void doPost(HttpServletRequest request, HttpServletResponse response)             
    throws ServletException, IOException { 
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String address = request.getParameter("diachi");         
        HttpSession session = request.getSession();         
        Cart cart = (Cart) session.getAttribute("cart");         
        Users users = (Users) session.getAttribute("khachhang");
        String url = "";
        try {             
        long ID = new Date().getTime();             
        HoaDon bill = new HoaDon();             
        bill.setMaddh(ID);             
        bill.setDiachi(address);                        
        bill.setMakh(users.getMakh());             
        bill.setNgaydat(new Timestamp(new Date().getTime()));             
        bill.setTongtien(cart.total());             
        billDAO.insertBill(bill);             
        for (Map.Entry<Long, Item> list : cart.getCartItems().entrySet()) {                 
            billDetailDAO.insertBillDetail(new CT_HoaDon(0,ID,                    
                    list.getValue().getProduct().getMasp(),                         
                    list.getValue().getProduct().getGia(),                         
                    list.getValue().getQuantity()));             
        } 
     //  Sendmail sm = new Sendmail();             
      // Sendmail.sendMail(users.getEmail(), "PhuotShop.com", "Xin chao,  "+users.getEmail()+"\nTotal: "+cart.total()); 
//        
        cart = new Cart();             
        session.setAttribute("cart", cart);
        url = "/index.jsp";
        } catch (SQLException e) { 
            url="/giohang.jsp";
        }         
        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);         
        rd.forward(request, response);     
    }
}
