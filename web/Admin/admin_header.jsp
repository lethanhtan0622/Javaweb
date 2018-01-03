<%-- 
    Document   : admin_header
    Created on : Jan 11, 2017, 10:07:26 AM
    Author     : SinoMax
--%>
<%@page import="model.Users"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <c:set var="root" value="${pageContext.request.contextPath}"/> 
        <link rel="stylesheet" href="${root}/css/bootstrap.min.css" />
        <link rel="stylesheet" href="${root}/css/bootstrap-responsive.min.css" />
        <link rel="stylesheet" href="${root}/css/fullcalendar.css" />
        <link rel="stylesheet" href="${root}/css/matrix-style.css" />
        <link rel="stylesheet" href="${root}/css/matrix-media.css" />
        <link href="${root}/font-awesome/css/font-awesome.css" rel="stylesheet" />
        <link rel="stylesheet" href="${root}/css/jquery.gritter.css" />
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>
    </head>
    <body>
        <%Users users = (Users) session.getAttribute("khachhang");                     
        %>
        <!--Header-part-->
        <div id="header">
          <h1><a href="${root}/Admin/admin_index.jsp">PhuotShop Admin</a></h1>
        </div>
        <!--close-Header-part--> 


        <!--top-Header-menu-->
        <div id="user-nav" class="navbar navbar-inverse">
          <ul class="nav">
            <li  class="dropdown" id="profile-messages" >
                <a title="" href="#" data-toggle="dropdown" data-target="#profile-messages" class="dropdown-toggle">
                    <i class="icon icon-user"></i>  
                    <span class="text"><%=users.getHoten()%></span><b class="caret"></b>
                </a>
              <ul class="dropdown-menu">
                <li><a href="#"><i class="icon-user"></i> My Profile</a></li>
                <li class="divider"></li>
                <li><a href="#"><i class="icon-check"></i> My Tasks</a></li>
                <li class="divider"></li>
                <li><a href="Admin/admin_Logout.jsp"><i class="icon-key"></i> Log Out</a></li>
              </ul>
            </li>
            
            <li class=""><a title="" href="#"><i class="icon icon-cog"></i> <span class="text">Settings</span></a></li>
            <li class=""><a title="" href=" admin_Logout.jsp"><i class="icon icon-share-alt"></i> <span class="text">Đăng xuất</span></a></li>
          </ul>
        </div>
        <!--close-top-Header-menu-->

        <!--sidebar-menu-->
        <div id="sidebar"><a href="#" class="visible-phone"><i class="icon icon-home"></i> PhuotShop.com</a>
          <ul>
            <li><a href="${root}/Admin/admin_index.jsp"><i class="icon icon-home"></i> <span>Trang chủ</span></a> </li>
            <li><a href="${root}/Admin/admin_sanpham.jsp"><i class="icon icon-th"></i> <span>Quản lý sản phẩm</span></a></li>
            <li><a href="${root}/Admin/admin_loaisp.jsp"><i class="icon icon-align-left"></i> <span>Quản lý loại sản phẩm</span></a></li>
            <li><a href="${root}/Admin/admin_bill.jsp"><i class="icon icon-tint"></i> <span>Quản lý hóa đơn</span></a></li>
          </ul>
        </div>
        <!--sidebar-menu-->
        
        <script src="${root}/js/excanvas.min.js"></script> 
        <script src="${root}/js/jquery.min.js"></script> 
        <script src="${root}/js/jquery.ui.custom.js"></script> 
        <script src="${root}/js/bootstrap.min.js"></script> 
        <script src="${root}/js/jquery.flot.min.js"></script> 
        <script src="${root}/js/jquery.flot.resize.min.js"></script> 
        <script src="j${root}/s/jquery.peity.min.js"></script> 
        <script src="${root}/js/fullcalendar.min.js"></script> 
        <script src="${root}/js/matrix.js"></script> 
        <script src="${root}/js/matrix.dashboard.js"></script> 
        <script src="${root}/js/jquery.gritter.min.js"></script> 
        <script src="${root}/js/matrix.interface.js"></script> 
        <script src="${root}/js/matrix.chat.js"></script> 
        <script src="${root}/js/jquery.validate.js"></script> 
        <script src="${root}/vjs/matrix.form_validation.js"></script> 
        <script src="${root}/js/jquery.wizard.js"></script> 
        <script src="${root}/js/jquery.uniform.js"></script> 
        <script src="${root}/js/select2.min.js"></script> 
        <script src="${root}/js/matrix.popover.js"></script> 
        <script src="${root}/js/jquery.dataTables.min.js"></script> 
        <script src="${root}/js/matrix.tables.js"></script> 

    </body>
</html>
