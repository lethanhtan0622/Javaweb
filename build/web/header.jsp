<%-- 
    Document   : header
    Created on : Dec 5, 2016, 2:40:49 PM
    Author     : SinoMax
--%>

<%@page import="java.util.Map"%>
<%@page import="model.Item"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.loaisp"%>
<%@page import="dao.loaispDAO"%>
<%@page import="model.Users"%> 
<%@page import="dao.UsersDAO"%> 
<%@page import="model.Cart"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bạn thích phượt?</title>
    </head>
    <body>
        <% loaispDAO LoaiSPdao = new loaispDAO();
        %>
        <%             Users users = new Users();             
        if (session.getAttribute("khachhang") != null)                  
            users = (Users) session.getAttribute("khachhang");
        %>
        <%
            Cart cart = (Cart) session.getAttribute("cart");
            if(cart == null){
                cart = new Cart();
                session.setAttribute("cart",cart);
            }
        %>
        <div class="header-top">
	 <div class="wrap"> 
		<div class="logo">
			<a href="index.jsp"><img src="images/logo1.png" alt=""/></a>
	    </div>
             <div class="cssmenu" style="float: right">
                       <%
                          if(session.getAttribute("khachhang") == null) {
                        %>
                    <ul>
                        <li><a href="Login.jsp">Đăng nhập</a></li> 
                        <li><a href="Register.jsp">Đăng ký</a></li> 
                        <li><a href="giohang.jsp">Giỏ hàng</a></li>                         
                        <li><span> <%=cart.countItem()%></span> </li>
                    </ul>
                        <%
                            }else{
                        %>
                    <ul>
                        <li><a href="#"><%=users.getHoten()%> </a></li>
                        <li><a href="Logout.jsp">Đăng xuất</a></li> 
                        <li><a href="giohang.jsp">Giỏ hàng</a></li>                         
                        <li><span> <%=cart.countItem()%></span> </li>
                    </ul>
                        <%
                            }
                        %>
                             
                        
            </div>

                <div class="clear"></div>
 	</div>
   </div>
   <div class="header-bottom">
   	<div class="wrap">
   		<!-- start header menu -->
            <ul class="megamenu skyblue">
                <li><a class="color10" href="index.jsp">Trang chủ</a></li>
                    <% for (loaisp l: LoaiSPdao.getListLoaiSP()){
                    %>
                        <li class="active grid">
                            <a class="color12" href="Product.jsp?loaisp=<%=l.getmaloai()%>"><%=l.gettenloai()%></a>
                                <div class="megapanel">
                                    <div class="row">
                                            <div class="col5">
                                                <div class="h_nav">
                                                    <h4><%=l.gettenloai()%></h4>
                                                        <ul>
                                                                <li><a href="Product.jsp?loaisp=<%=l.getmaloai()%>"><%=l.getMota()%></a></li>									
                                                        </ul>	
                                                </div>							
                                            </div>
                                            <div class="col1">
						 <div class="h_nav">
						   <img src="images/<%=l.gethinhanh()%>" alt=""/>
						 </div>
                                            </div>            
                                    </div>
                                </div>
                        </li>
                    <% 
                        }
                    %>
               </ul>
               <div class="clear"></div>
     	</div>
       </div>
    </body>
</html>
