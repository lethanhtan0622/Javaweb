<%-- 
    Document   : Product
    Created on : Dec 5, 2016, 3:10:06 PM
    Author     : SinoMax
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.product"%>
<%@page import="dao.ProductDAO" %>
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
    </head>
    <body>
        <%
            ProductDAO productDAO = new ProductDAO();
            String maloai ="";
            if(request.getParameter("loaisp")!= null){
                maloai = request.getParameter("loaisp");
            }
            Cart cart = (Cart) session.getAttribute("cart");
            if(cart == null){
                cart = new Cart();
                session.setAttribute("cart",cart);
            }      
        %>
        <jsp:include page="header.jsp"></jsp:include>
        <jsp:include page="banner.jsp"></jsp:include>
        <div class="login">
         <div class="wrap">
     	    <div class="rsidebar span_1_of_left">
                <section  class="sky-form">
                    <h4>Occasion</h4>
                        <div class="row row1 scroll-pane">
                                <div class="col col-4">
                                        <label class="checkbox"><input type="checkbox" name="checkbox" checked=""><i></i>Athletic (20)</label>
                                </div>
                                <div class="col col-4">
                                        <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Athletic Shoes (48)</label>
                                        <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Casual (45)</label>
                                        <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Casual (45)</label>
                                        <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Other (1)</label>
                            </div>
                         </div>
                    <h4>Category</h4>
                    <div class="row row1 scroll-pane">
                            <div class="col col-4">
                                    <label class="checkbox"><input type="checkbox" name="checkbox" checked=""><i></i>Flats (70)</label>
                            </div>
                            <div class="col col-4">
                                    <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Athletic Shoes (48)</label>
                                    <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Athletic Shoes (48)</label>
                                    <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Heels (38)</label>
                                    <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Other (1)</label>
                        </div>
                    </div>
            </section>
		        
            </div>
		<div class="cont span_2_of_3">
		  <div class="mens-toolbar">
              <div class="sort">
               	<div class="sort-by">
		            <label>Sort By</label>
		            <select>
		                            <option value="">
		                    Popularity               </option>
		                            <option value="">
		                    Price : High to Low               </option>
		                            <option value="">
		                    Price : Low to High               </option>
		            </select>
		            <a href=""><img src="images/arrow2.gif" alt="" class="v-middle"></a>
               </div>
    		</div>
	          <div class="pager">   
	           <div class="limiter visible-desktop">
	            <label>Show</label>
	            <select>
	                            <option value="" selected="selected">
	                    9                </option>
	                            <option value="">
	                    15                </option>
	                            <option value="">
	                    30                </option>
	                        </select> per page        
	             </div>
	       		<ul class="dc_pagination dc_paginationA dc_paginationA06">
				    <li><a href="#" class="previous">Pages</a></li>
				    <li><a href="#">1</a></li>
				    <li><a href="#">2</a></li>
			  	</ul>
		   		<div class="clear"></div>
	    	</div>
     	    <div class="clear"></div>
	       </div>
                    <div class="box1">
                    <%
                        for(product p : productDAO.getListSanphamByLoaisp(Long.parseLong(maloai))){
                    %>
                   <div class="col_1_of_single1 span_1_of_single1">
                               <a href="Single.jsp?Product=<%=p.getMasp()%>">
                     <div class="view1 view-fifth1">
                          <div class="top_box">
                                <h3 class="m_1"><%=p.getTensp()%></h3>
                                <div class="grid_img">
                                                       <div class="css3"><img src="images/<%=p.getHinhanh()%>" alt=""/></div>
                                          <div class="mask1">
                                            <div class="info">Xem nhanh</div>
                                          </div>
                                </div>
                               <div class="price"><fmt:formatNumber type="number" value="<%=p.getGia()%>"/> VNĐ</div>
                           </div>
                     </div>
                     <span class="rating">
                        <input type="radio" class="rating-input" id="rating-input-1-5" name="rating-input-1">
                        <label for="rating-input-1-5" class="rating-star1"></label>
                        <input type="radio" class="rating-input" id="rating-input-1-4" name="rating-input-1">
                        <label for="rating-input-1-4" class="rating-star1"></label>
                        <input type="radio" class="rating-input" id="rating-input-1-3" name="rating-input-1">
                        <label for="rating-input-1-3" class="rating-star1"></label>
                        <input type="radio" class="rating-input" id="rating-input-1-2" name="rating-input-1">
                        <label for="rating-input-1-2" class="rating-star"></label>
                        <input type="radio" class="rating-input" id="rating-input-1-1" name="rating-input-1">
                        <label for="rating-input-1-1" class="rating-star"></label>&nbsp;
                        
                    </span>
                     <ul class="list2">
                      <li>
                            <img src="images/plus.png" alt=""/>
                            <ul class="icon1 sub-icon1 profile_img">
                              <li><a class="active-icon c1" href="CartServlet?command=plus&masp=<%=p.getMasp()%>">Mua ngay</a>
                                    <ul class="sub-icon1 list">                                            
                                        <li><p><%=p.getMota()%><a href=""></a></p></li>
                                    </ul>
                              </li>
                             </ul>
                       </li>
                 </ul>
                            <div class="clear"></div>
                        </a></div>
                           <% 
                                }
                            %>
                        <div class="clear"></div>   	  
                  </div>			  
			  
			  
			  </div>
			  <div class="clear"></div>
			</div>
		   </div>
        <jsp:include page="footer.jsp"></jsp:include>
      
    </body>
</html>
