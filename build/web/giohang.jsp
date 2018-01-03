<%-- 
    Document   : giohang
    Created on : Jan 5, 2017, 2:14:51 PM
    Author     : SinoMax
--%>
<%@page import="model.Users"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>
<%@page import="model.Item"%>
<%@page import="model.Cart"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/form.css" rel="stylesheet" type="text/css" media="all" />
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
        <script type="text/javascript" src="js/jquery.min.js"></script>
        <script src="js/jquery.easydropdown.js"></script>
        <script type="text/javascript">
                $(document).ready(function() {
                    $(".dropdown img.flag").addClass("flagvisibility");

                    $(".dropdown dt a").click(function() {
                        $(".dropdown dd ul").toggle();
                    });

                    $(".dropdown dd ul li a").click(function() {
                        var text = $(this).html();
                        $(".dropdown dt a span").html(text);
                        $(".dropdown dd ul").hide();
                        $("#result").html("Selected value is: " + getSelectedValue("sample"));
                    });

                    function getSelectedValue(id) {
                        return $("#" + id).find("dt a span.value").html();
                    }

                    $(document).bind('click', function(e) {
                        var $clicked = $(e.target);
                        if (! $clicked.parents().hasClass("dropdown"))
                            $(".dropdown dd ul").hide();
                    });


                    $("#flagSwitcher").click(function() {
                        $(".dropdown img.flag").toggleClass("flagvisibility");
                    });
                });
             </script>
        <!-- start menu -->     
        <link href="css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
        <script type="text/javascript" src="js/megamenu.js"></script>
        <script>$(document).ready(function(){$(".megamenu").megamenu();});</script>
        <!-- end menu -->
        <script type="text/javascript" src="js/jquery.jscrollpane.min.js"></script>
        <script type="text/javascript" id="sourcecode">
                $(function()
                {
                        $('.scroll-pane').jScrollPane();
                });
        </script>
        <!-- top scrolling -->
        <script type="text/javascript" src="js/move-top.js"></script>
        <script type="text/javascript" src="js/easing.js"></script>
       <script type="text/javascript">
                    jQuery(document).ready(function($) {
                            $(".scroll").click(function(event){		
                                    event.preventDefault();
                                    $('html,body').animate({scrollTop:$(this.hash).offset().top},1200);
                            });
                    });
        </script>
        <style>
        table {
            border-collapse: collapse;
            width: 80%;
            margin-left: 10%;
        }

        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        tr:hover {background-color: #f5f5f5}
</style>
    </head>
    <body>
        <%Users users = (Users) session.getAttribute("khachhang");             
            if (users == null) {                 
                response.sendRedirect("/WebApplication1/Login.jsp");             
            }         
        %>
        <jsp:include page="header.jsp"></jsp:include>
        <jsp:include page="banner.jsp"></jsp:include>
        
        <%
            Cart cart = (Cart) session.getAttribute("cart");
            if(cart == null){
                cart = new Cart();
                session.setAttribute("cart",cart);
            }
        %>
        <table>
            <tr>
                <th>Hình sản phẩm</th>
                <th>Tên sản phẩm</th>
                <th>Số lượng</th>
                <th>Giá bán</th>
            </tr>
            <%for (Map.Entry<Long, Item> list : cart.getCartItems().entrySet()) {%>
            <tr>
                <td>
                    <img style="max-width:30%" src="images/<%=list.getValue().getProduct().getHinhanh()%>" alt="">
                </td>
                <td>
                     <%=list.getValue().getProduct().getTensp()%>
                </td>
                <td>
                    <%=list.getValue().getQuantity()%>
                </td>
                <td>
                    <fmt:formatNumber type="number" value="<%=list.getValue().getProduct().getGia()%>"/> VND
                </td>
                <td><a href="CartServlet?command=remove&masp=<%=list.getValue().getProduct().getMasp()%>"><image width="20px" src="images/not-available.png"/></a></td>
                <div class="clearfix"></div> 
            </tr>
                       
                <%}%> 
            <tr>
                <th></th>
                <th></th>
                <th>Tổng tiền:</th>
                <th><fmt:formatNumber type="number" value="<%=cart.total()%>"/> VND</th>
                <th></th>
            </tr> 
            <tr>
                
            </tr>
        </table>
        <div class="clear"></div>
        
        <hr/>
        <div class="login" style="height: 408px; align-items: center">
              <div class="wrap">
                <div class="col_1_of_login span_1_of_login">
                  <div class="login-title">            
                     <div class="comments-area">
                         <form action="CheckOutServlet" method="POST"> 
                            <div>
                                <label>Địa chỉ:</label>
                                <span>*</span>
                                <input type="text" value="" name="diachi"required="required">
                            </div>
                              <div>
                                 <p>                                           
                                    <input type="submit" value="Đặt hàng"> 
                                </p>
                             </div>
                        </form>
                    </div>
                </div>
                </div>
                <div class="clear"></div>
            </div>
        </div>
    <div class="clear"></div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
    
</html>
