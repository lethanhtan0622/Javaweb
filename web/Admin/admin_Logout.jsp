<%-- 
    Document   : admin_Logout
    Created on : Dec 2, 2017, 10:53:10 PM
    Author     : THANH TAN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>đăng xuất</title>
    </head>
    <body>
         <%
            if(session!=null){
                session.removeAttribute("khachhang");
                response.sendRedirect("admin_login.jsp" );
            }
            
        %>
    </body>
</html>
