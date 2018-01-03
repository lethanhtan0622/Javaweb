<%-- 
    Document   : admin_loaisp
    Created on : Jan 12, 2017, 5:46:44 PM
    Author     : SinoMax
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.UsersDAO"%> 
<%@page import="model.HoaDon"%> 
<%@page import="java.util.ArrayList"%> 
<%@page import="dao.HoaDonDAO"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8" />
        
        <c:set var="root" value="${pageContext.request.contextPath}"/> 
         
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="${root}/css/bootstrap.min.css" />
        <link rel="stylesheet" href="${root}/css/bootstrap-responsive.min.css" />
        <link rel="stylesheet" href="${root}/css/uniform.css" />
        <link rel="stylesheet" href="${root}/css/select2.css" />
        <link rel="stylesheet" href="${root}/css/matrix-style.css" />
        <link rel="stylesheet" href="${root}/css/matrix-media.css" />
        <link href="${root}/font-awesome/css/font-awesome.css" rel="stylesheet" />
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>
    </head>
    <body>
        <%   HoaDonDAO billDAO = new HoaDonDAO();            
             ArrayList<HoaDon> b = billDAO.getListBill();            
             UsersDAO usersDAO = new UsersDAO(); 
        %> 
        <jsp:include page="admin_header.jsp"></jsp:include>
        <div id="content">
          <div id="content-header">
            <div id="breadcrumb"> <a href="${root}/Admin/admin_index.jsp" title="Về trang chủ" class="tip-bottom">
                  <i class="icon-home"></i> Trang chủ</a> 
                  <a href="#" class="current">Quản lý hóa đơn</a> </div>
            <h1>Quản lý hóa đơn</h1>
          </div>
          <div class="container-fluid">
            <hr>
            
            <div class="row-fluid">
              <div class="span12">
                <div class="widget-box">
                  <div class="widget-title"> <span class="icon"> <i class="icon-align-left"></i> </span>
                    <h5>Danh sách hóa đơn</h5>
                  </div>
                  <div class="widget-content nopadding">
                    <table class="table table-bordered table-striped">
                      <thead>
                        <tr>
                          <th>STT</th>
                          <th>Mã hóa đơn</th>
                          <th>Khách hàng</th>
                          <th>Nơi nhận</th>
                          <th>Ngày đặt</th>
                          <th>Tổng tiền (VND)</th>
                          <th>Tùy chọn</th>
                        </tr>
                      </thead>
                      <tbody>
                          <%
                              int count =0;
                              for(HoaDon ll:b){
                                  count++;
                          %>
                        <tr class="odd gradeX">
                          <td><%=count%></td>
                          <td><%=ll.getMaddh()%></td>
                          <td><%=usersDAO.getUser(ll.getMakh()).getEmail()%></td>
                          <td><%=ll.getDiachi()%></td>
                          <td><%=ll.getNgaydat()%></td>
                          <td><fmt:formatNumber type="number" value="<%=ll.getTongtien()%>"/></td>
                          <td>
                              <a href="detail_hoadon.jsp?maddh=<%=ll.getMaddh()%>">
                                  <i class="icon icon-desktop"></i>
                              </a> | 
                              <a href="${root}/Admin/detail_hoadon.jsp?command=delete&maddh=<%=ll.getMaddh()%>">
                                  <i class="icon icon-trash"></i></a>
                          </td>
                        </tr>
                        <%}%>
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <script src="${root}/js/jquery.min.js"></script> 
        <script src="${root}/js/jquery.ui.custom.js"></script> 
        <script src="${root}/js/bootstrap.min.js"></script> 
        <script src="${root}/js/jquery.uniform.js"></script> 
        <script src="${root}/js/select2.min.js"></script> 
        <script src="${root}/js/jquery.dataTables.min.js"></script> 
        <script src="${root}/js/matrix.js"></script> 
        <script src="${root}/js/matrix.tables.js"></script>
    </body>
</html>
