<%-- 
    Document   : DatHang
    Created on : Jan 6, 2017, 12:00:08 PM
    Author     : SinoMax
--%>

<%@page import="model.Users"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
    </head>
    <body>
        <%Users users = (Users) session.getAttribute("khachhang");             
            if (users == null) {                 
                response.sendRedirect("/WebApplication2/Login.jsp");             
            }         
        %> 
        <jsp:include page="header.jsp"></jsp:include> 
    <div class="login" style="height: 408px; align-items: center">
          <div class="wrap">
            <div class="col_1_of_login span_1_of_login">
              <div class="login-title">            
                 <div class="comments-area">
                     <form action="CheckOutServlet" method="POST"> 
                        <div>
                            <label>Địa chỉ:</label>
                            <span>*</span>
                            <input type="text" value="" name="diachi">
                        </div>
                          <div>
                             <p>                                           
                                <input type="submit" value="Checkout"> 
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
