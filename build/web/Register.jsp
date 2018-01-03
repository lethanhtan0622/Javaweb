<%-- 
    Document   : Register
    Created on : Dec 5, 2016, 3:34:52 PM
    Author     : SinoMax
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
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
     <script type="text/javascript">
        function validLogin(){
        if (document.form.matkhau.value !== document.form.nhaplaimatkhau.value){
            alert ( "Hai mật khẩu không trùng khớp vui lòng kiểm tra lại." );       
        return true;
        }
    }
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
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"  type="text/javascript"></script>         
<script type="text/javascript">               
    $(document).ready(function () {                    
        var x_timer;                    
        $("#email").keyup(function (e) {                         
            clearTimeout(x_timer);                         
            var user_name = $(this).val();                         
            x_timer = setTimeout(function () {                             
                check_username_ajax(user_name);                         
            }, 1000);                         });                    
        function check_username_ajax(username) {                         
            $("#user-result").html('<img src="img/ajax-loader.gif" />');                         
            $.post('CheckEmailServlet', {'email': username}, function (data) {                             
                $("#user-result").html(data);                          
            });                    
        }                
    });         
</script> 
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
        <div class="register_account">
            <div class="wrap">
                <h4 class="title">Tạo tài khoản</h4>
                <div class="">
                  <form name="form" action="UserServlet" method="POST" onsubmit="return validLogin();" >

                        <div>
                            <input type="text" required="yes" name="hoten" placeholder="Họ tên"style="width: 350px" ></div>
                        <div>
                           <input type="email" required="yes" name="email" id="email" placeholder="Email"style="width: 350px">
                           <span id="user-result"> </span>
                        </div>
                         <div>
                             <input type="password" required="yes" name="matkhau" placeholder="Mật khẩu" style="width: 350px">
                         </div>
                         <div>
                             <input type="password" required="yes" placeholder="Nhập lại mật khẩu" name="nhaplaimatkhau"style="width: 350px" >
                         </div>
                         <div>
                             <input type="text" maxlength="11" name="sdt" placeholder="Số điện thoại"style="width: 350px" >
                         </div>
                         <div>
                             <input type="text" name="diachi" placeholder="Địa chỉ"style="width: 350px" >
                         </div>

                        <div>                           
                            <p>
                                <input type="hidden" value="Signup" name="command"/>
                                <button class="grey" type="submit">Đăng ký</button>
                            </p>                        
                        </div>

                        <div class="clear"></div>
                                                <div>
                            <p class="terms">By clicking 'Create Account' you agree to the <a href="#">Terms &amp; Conditions</a>.</p>
                        </div>
                    </form>
            </div>
    	  </div> 
        </div>
<!--       <script type="text/javascript">
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
        <a href="#" id="toTop" style="display: block;"><span id="toTopHover" style="opacity: 1;"></span></a>-->
                <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
