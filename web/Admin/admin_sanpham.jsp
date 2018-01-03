<%-- 
    Document   : admin_sanpham
    Created on : Jan 13, 2017, 1:29:52 PM
    Author     : SinoMax
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.product"%>
<%@page import="dao.SanphamDAO"%>
<%@page import="java.util.ArrayList"%>
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
        
        <% 
             
            SanphamDAO lsp = new SanphamDAO();
            ArrayList<product> l = lsp.getListSanpham();
            %>
        <jsp:include page="admin_header.jsp"></jsp:include>
        <div id="content">
          <div id="content-header">
            <div id="breadcrumb"> <a href="${root}/Admin/admin_index.jsp" title="Về trang chủ" class="tip-bottom">
                  <i class="icon-home"></i> Trang chủ
              </a> 
                  <a href="${root}/Admin/admin_sanpham.jsp" class="current">Quản lý sản phẩm</a> </div>
            <h1>Quản lý sản phẩm</h1>
          </div>
          <div class="container-fluid">
            <hr>
            <a href="${root}/Admin/insert_sanpham.jsp"><i class="icon icon-plus"></i><span>Thêm mới</span></a>
            <div class="row-fluid">
              <div class="span12">
                <div class="widget-box">
                  <div class="widget-title"> <span class="icon"> <i class="icon-align-left"></i> </span>
                    <h5>Danh sách loại sản phẩm</h5>
                  </div>
                  <div class="widget-content nopadding">
                    <table class="table table-bordered table-striped">
                      <thead>
                        <tr>
                          <th>Mã sản phẩm</th>
                          <th>Mã loại</th>
                          <th>Tên loại</th>
                          <th>Hình ảnh</th>
                          <th>Giá (VND)</th>
                          <th>Mô tả</th>
                          <th>Số lượng</th>
                          <th>Tùy chọn</th>
                        </tr>
                      </thead>
                      <tbody> 
                          <% for (product p : l){
                           %>
                        <tr class="odd gradeX">
                          <td><%=p.getMasp()%></td>
                          <td><%=p.getMaloai()%></td>
                          <td><%=p.getTensp()%></td>
                          <td><%=p.getHinhanh()%></td>
                          <td><fmt:formatNumber type="number" value="<%=p.getGia()%>"/></td>
                          <td><%=p.getMota()%></td>
                          <td><%=p.getSoluong()%></td>
                          <td>
                              <a href="${root}/Admin/update_sanpham.jsp?command=update&masp=<%=p.getMasp()%>">
                                  <i class="icon icon-wrench"></i>
                              </a> | 
                              <a href="${root}/Admin/delete_sanpham.jsp?command=delete&masp=<%=p.getMasp()%>">
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
