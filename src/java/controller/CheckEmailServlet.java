/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UsersDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SinoMax
 */
public class CheckEmailServlet extends HttpServlet {

    UsersDAO usersDAO = new UsersDAO();     
     @Override     
     protected void doGet(HttpServletRequest request, HttpServletResponse response)             
             throws ServletException, IOException {     
     }     
     @Override 
     protected void doPost(HttpServletRequest request, HttpServletResponse response)             
             throws ServletException, IOException {         
         if (usersDAO.checkEmail(request.getParameter("email"))) {             
             response.getWriter().write("<img width=\"20px\" src=\"images/not-available.png\" />");         
         } else {             
             response.getWriter().write("<img width=\"20px\" src=\"images/available.png\" />");         
         }     
     } 

}
