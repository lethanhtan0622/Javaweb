/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.ProductDAO;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import model.Cart;
import model.Item;
import model.product;

/**
 *
 * @author SinoMax
 */
import javax.servlet.http.HttpSession; 
import model.Cart; 
public class CartServlet extends HttpServlet {
    private final ProductDAO productDAO = new ProductDAO(); 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String command = request.getParameter("command");
        String masp = request.getParameter("masp");
        Cart cart = (Cart) session.getAttribute("cart");
        String url = ""; 
        try{
            Long maSP = Long.parseLong(masp);
            product Product = productDAO.getProduct(maSP);
            switch(command){
                case "plus":
                    if(cart.getCartItems().containsKey(maSP)){
                        cart.plusToCart(maSP, new Item(Product, cart.getCartItems().get(maSP).getQuantity()));
                        
                    }else{
                        cart.plusToCart(maSP, new Item(Product, 1));
                    }
                    url = "/index.jsp";
                    break;
                case "remove":
                    cart.removeToCart(maSP);
                    url ="/giohang.jsp";
                    break;
            }
        }catch(NumberFormatException | SQLException e){
            url = "/index.jsp";
        }
        session.setAttribute("cart", cart);
        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);         
        rd.forward(request, response);
    }
    
}
