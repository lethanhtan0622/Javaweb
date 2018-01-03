<%-- 
    Document   : insert_loaisp
    Created on : Jan 11, 2017, 11:40:40 PM
    Author     : SinoMax
--%>

<<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.UsersDAO"%> 
<%@page import="model.HoaDon"%> 
<%@page import="java.util.ArrayList"%> 
<%@page import="dao.HoaDonDAO"%> 
<%@page import="dao.CT_HoaDonDAO"%> 
<%@page import="model.CT_HoaDon"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <c:set var="root" value="${pageContext.request.contextPath}"/> 
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
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
        <%   HoaDonDAO billDAO = new HoaDonDAO();
            HoaDon hd = new HoaDon();
            CT_HoaDonDAO ct = new CT_HoaDonDAO();
            ArrayList<CT_HoaDon> cc = ct.getListHoadon();
            String maddh = "";
            if(request.getParameter("maddh")!= null){
                maddh = request.getParameter("maddh");
                cc = ct.getListHoadon(Long.parseLong(maddh));
            }  
            if(request.getParameter("maddh")!= null){
                maddh = request.getParameter("maddh");
                hd= billDAO.getHoaDon(Long.parseLong(maddh));
            }
             UsersDAO usersDAO = new UsersDAO(); 
        %> 
        <jsp:include page="admin_header.jsp"></jsp:include>
        <div id="content">
            <div id="content-header">
              <div id="breadcrumb"> <a href="${root}/Admin/admin_index.jsp" title="Về trang chủ" class="tip-bottom">
                      <i class="icon-home"></i> Trang chủ
                  </a> 
                  <a href="${root}/Admin/admin_loaisp.jsp" class="tip-bottom">Quản lý hóa đơn</a> 
              <a href="#" class="current">Xác nhận hóa đơn</a> </div>
              <h1>XÁC NHẬN HÓA ĐƠN</h1>
            </div>
            <div class="container-fluid">
              <hr>
              <div class="row-fluid">
                  
                  <div class="widget-box">
                    <div class="widget-title"> <span class="icon"> <i class="icon-align-justify"></i> </span>
                      <h5>Thông tin hóa đơn</h5>
                    </div>
                    <div class="widget-content nopadding">
                      <form class="form-horizontal">
                          <div class="control-group">
                          <label class="control-label">Mã đơn đặt hàng :</label>
                          <div class="controls">
                              <label><%=hd.getMaddh()%></label>
                          </div>
                        </div>
                        <div class="control-group">
                          <label class="control-label">Người đặt :</label>
                          <div class="controls">
                              <label><%=usersDAO.getUser(hd.getMakh()).getEmail()%></label>
                          </div>
                        </div>
                        <div class="control-group">
                          <label class="control-label">Nơi nhận :</label>
                          <div class="controls">
                              <label><%=hd.getDiachi()%></label>
                          </div>
                        </div>                          
                        <div class="control-group">
                          <label class="control-label">Ngày đặt :</label>
                            <div class="controls">
                                <label><%=hd.getNgaydat()%></label>
                            </div>
                        </div> 
                        <div class="control-group">
                          <label class="control-label">Tổng tiền :</label>
                            <div class="controls">
                                <label><%=hd.getTongtien()%></label>
                            </div>
                        </div>
                         <table class="table table-bordered table-striped">
                      <thead>
                        <tr>
                          <th>STT</th>
                          <th>Mã sản phẩm</th>
                          <th>Giá bán (VND)</th>
                          <th>Số lượng</th>
                        </tr>
                      </thead>
                      <tbody>
                          <%
                              int count =0;
                              for(CT_HoaDon v:cc){
                                  count++;
                          %>
                        <tr class="odd gradeX">
                          <td><%=count%></td>
                          <td><%=v.getMasp()%></td>                          
                          <td><fmt:formatNumber type="number" value="<%=v.getGia()%>"/></td>
                          <td><%=v.getQuantity()%></td>
                        </tr>
                        <%}%>
                      </tbody>
                    </table>   
                        <div class="form-actions">
                            <a  href="${root}/Admin/admin_bill.jsp">
                                <i class="icon icon-check"></i> Xác nhận
                            </a> &nbsp; &nbsp; 
                            <a href="/WebApplication1/DeleteHoadonServlet?command=delete&maddh=<%=hd.getMaddh()%>">
                                <i class="icon icon-trash"></i> Xóa hóa đơn này
                            </a>
                        </div>
                      </form>
                    
                  </div>
                </div>
                  
            </div>
            </div>
        </div>
        <script src="${root}/js/jquery.min.js"></script> 
        <script src="${root}/js/jquery.ui.custom.js"></script> 
        <script src="${root}/js/bootstrap.min.js"></script> 
        <script src="${root}/js/bootstrap-colorpicker.js"></script> 
        <script src="${root}/js/bootstrap-datepicker.js"></script> 
        <script src="${root}/js/jquery.toggle.buttons.js"></script> 
        <script src="${root}/js/masked.js"></script> 
        <script src="${root}/js/jquery.uniform.js"></script> 
        <script src="${root}/js/select2.min.js"></script> 
        <script src="${root}/js/matrix.js"></script> 
        <script src="${root}/js/matrix.form_common.js"></script> 
        <script src="${root}/js/wysihtml5-0.3.0.js"></script> 
        <script src="${root}/js/jquery.peity.min.js"></script> 
        <script src="${root}/js/bootstrap-wysihtml5.js"></script> 
    </body>
</html>
