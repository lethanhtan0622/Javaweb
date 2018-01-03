<%-- 
    Document   : Login
    Created on : Dec 5, 2016, 3:49:06 PM
    Author     : SinoMax
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
<script type="text/javascript" src="js/jquery.min.js"></script>
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
        <jsp:include page="header.jsp"></jsp:include>
        <div class="login">
          <div class="wrap">

            <div class="col_1_of_login span_1_of_login">
              <div class="login-title">
            <h4 class="title">Registered Customers</h4>
                     <div class="comments-area">
                            <form  action="UserServlet" method="POST">                            
                                <%if(session.getAttribute("ErorrLogin")!= null){%>                                                       
                                    <p style="color:red"><%=session.getAttribute("ErorrLogin")%>
                                    </p>                                                            
                                <%}%> 
                                    <p>
                                            <label>Email</label>
                                            <span>*</span>
                                            <input type="text" value="" name="email">
                                    </p>
                                    <p>
                                            <label>Mật khẩu</label>
                                            <span>*</span>
                                            <input type="password" value="" name="matkhau">
                                    </p>
                                     <p id="login-form-remember">
                                            <label><a href="#">Quên mật khẩu? </a></label>
                                     </p>
                                     <div>
                                     <p>
                                            <input type="hidden" value="Signin" name="command">
                                            <input type="submit" value="Đăng nhập"> 
                                    </p>
                                  </div>
                            </form>
                    </div>
          </div>
            </div>
            <div class="clear"></div>
			</div>
		</div>
        <jsp:include page="footer.jsp"></jsp:include>
        <script type="text/javascript">
			$(document).ready(function() {
			
				var defaults = {
		  			containerID: 'toTop', // fading element id
					containerHoverID: 'toTopHover', // fading element hover id
					scrollSpeed: 1200,
					easingType: 'linear' 
		 		};
				
				
				$().UItoTop({ easingType: 'easeOutQuart' });
				
			});
        </script>
        <a href="#" id="toTop" style="display: block;"><span id="toTopHover" style="opacity: 1;"></span></a>
    </body>
</html>
