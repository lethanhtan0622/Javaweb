/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UsersDAO; 
import java.io.IOException; 
import javax.servlet.RequestDispatcher; 
import javax.servlet.ServletException; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
import javax.servlet.http.HttpSession; 
import model.Users; 
import tool.MD5;

/**
 *
 * @author SinoMax
 */
public class AdminServlet extends HttpServlet {

    UsersDAO usersDAO = new UsersDAO();     
    @Override    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)             
            throws ServletException, IOException {     
    }     
    @Override     
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String command = request.getParameter("command");         
        String url = "";         
        Users users = new Users();         
        HttpSession session = request.getSession();                            
        users = usersDAO.login(request.getParameter("email"),  
                MD5.encryption(request.getParameter("matkhau")));
        if (users != null) { 
            session.setAttribute("khachhang", users);
                             
                url = "/Admin/admin_login.jsp";
                 if(users.getMakh() == 1){                   
                url = "/Admin/admin_index.jsp";
             }else{
                url = "/index.jsp";
            }   
        }else{ 
            session.setAttribute("ErorrLogin", "Email hoặc mật khẩu không đúng!");
            url = "/Admin/admin_login.jsp"; 
        }       
        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);         
        rd.forward(request, response);     
    } 

}
