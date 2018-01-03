<%-- 
    Document   : insert_loaisp
    Created on : Jan 11, 2017, 11:40:40 PM
    Author     : SinoMax
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.loaisp"%>
<%@page import="dao.loaispDAO"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="css/bootstrap.min.css" />
        <link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
        <link rel="stylesheet" href="css/fullcalendar.css" />
        <link rel="stylesheet" href="css/matrix-style.css" />
        <link rel="stylesheet" href="css/matrix-media.css" />
        <link href="font-awesome/css/font-awesome.css" rel="stylesheet" />
        <link rel="stylesheet" href="css/jquery.gritter.css" />
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>
    </head>
    <body>
        <% 
            loaispDAO lsp = new loaispDAO();
            loaisp l = new loaisp();
            String maloai = "";
            if(request.getParameter("maloai")!= null){
                maloai = request.getParameter("maloai");
                l = lsp.get1loaisp(Long.parseLong(maloai));
            }
            %>
        <jsp:include page="admin_header.jsp"></jsp:include>
        <div id="content">
            <div id="content-header">
              <div id="breadcrumb"> <a href="${root}/Admin/admin_index.jsp" title="Về trang chủ" class="tip-bottom">
                      <i class="icon-home"></i> Trang chủ
                  </a> 
                  <a href="${root}/Admin/admin_loaisp.jsp" class="tip-bottom">Quản lý loại sản phẩm</a> 
              <a href="#" class="current">Xóa loại sản phẩm</a> </div>
              <h1>XÁC NHẬN XÓA</h1>
            </div>
            <div class="container-fluid">
              <hr>
              <div class="row-fluid">
                  
                  <div class="widget-box">
                    <div class="widget-title"> <span class="icon"> <i class="icon-align-justify"></i> </span>
                      <h5>Thông tin loại sản phẩm</h5>
                    </div>
                    <div class="widget-content nopadding">
                      <form class="form-horizontal">
                          <div class="control-group">
                          <label class="control-label">Mã loại :</label>
                          <div class="controls">
                              <label><%=l.getmaloai()%></label>
                          </div>
                        </div>
                        <div class="control-group">
                          <label class="control-label">Tên loại :</label>
                          <div class="controls">
                              <label><%=l.gettenloai()%></label>
                          </div>
                        </div>
                        <div class="control-group">
                          <label class="control-label">Hình ảnh :</label>
                          <div class="controls">
                              <label><%=l.gethinhanh()%></label>
                          </div>
                        </div>                        
                          
                        <div class="control-group">
                            
                          <label class="control-label">Mô tả :</label>
                            <div class="controls">
                                <label><%=l.getMota()%></label>
                            </div>
                            
                        </div>      
                        <div class="form-actions">
                            <a  href="/WebApplication1/ManagerLoaispServlet?command=delete&maloai=<%=l.getmaloai()%>">
                                <i class="icon icon-trash"></i> Xác nhận
                            </a>
                        </div>
                      </form>
                    
                  </div>
                </div>
                  
            </div>
            </div>
        </div>
        <script src="js/jquery.min.js"></script> 
        <script src="js/jquery.ui.custom.js"></script> 
        <script src="js/bootstrap.min.js"></script> 
        <script src="js/bootstrap-colorpicker.js"></script> 
        <script src="js/bootstrap-datepicker.js"></script> 
        <script src="js/jquery.toggle.buttons.js"></script> 
        <script src="js/masked.js"></script> 
        <script src="js/jquery.uniform.js"></script> 
        <script src="js/select2.min.js"></script> 
        <script src="js/matrix.js"></script> 
        <script src="js/matrix.form_common.js"></script> 
        <script src="js/wysihtml5-0.3.0.js"></script> 
        <script src="js/jquery.peity.min.js"></script> 
        <script src="js/bootstrap-wysihtml5.js"></script> 
        <script>
                $('.textarea_editor').wysihtml5();
        </script>
    </body>
</html>
