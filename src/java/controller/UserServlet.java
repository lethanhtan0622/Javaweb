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
public class UserServlet extends HttpServlet {

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
        switch (command) {             
            case "Signup":            
                if(null != request.getParameter("nhaplaimatkhau") && request.getParameter("matkhau").equals(request.getParameter("nhaplaimatkhau")))
                {
                    users.setMakh(new java.util.Date().getTime());
                    users.setHoten(request.getParameter("hoten"));
                    users.setEmail(request.getParameter("email"));
                    users.setMatkhau(MD5.encryption(request.getParameter("matkhau")));
                    users.setDiachi(request.getParameter("diachi"));
                    users.setSdt(request.getParameter("sdt"));
                    usersDAO.insertUser(users);
                    url = "/Login.jsp";
                }else{
                    url = "/Register.jsp";
                }                
                break;
            case "Signin":                            
                users = usersDAO.login(request.getParameter("email"),  
                        MD5.encryption(request.getParameter("matkhau")));
                if (users != null) { 
                     session.setAttribute("khachhang", users);                     
                     url = "/index.jsp";                 
                }else{ 
                    session.setAttribute("ErorrLogin", "Email hoặc mật khẩu không đúng!");
                    url = "/Login.jsp"; 
                }
                break;
            case "Signout":
                session.setAttribute("khachhang", null);
                url = "/index.jsp";
                break;
        }         
        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);         
        rd.forward(request, response);     
    } 

}
