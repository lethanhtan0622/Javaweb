<%-- 
    Document   : newproduct
    Created on : Dec 22, 2016, 12:54:50 PM
    Author     : SinoMax
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="model.product"%>
<%@page import="dao.SanphamDAO" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        
    </head>
<body>


 <div class="content-bottom">
    <div class="box1">     
    <%
        SanphamDAO sanphamDAO =new SanphamDAO();
        %>
        <%
            for(product pro: sanphamDAO.getListSanpham()){
            %>
            
        <div class="col_1_of_3 span_1_of_3">
            <a href="Single.jsp?Product=<%=pro.getMasp()%>">
            <div class="view view-fifth">
              <div class="top_box">
                  <h3 class="m_1"><%=pro.getTensp()%></h3>
                    
                <div class="grid_img">
                       <div class="css3"><img src="images/<%=pro.getHinhanh()%>" alt="<%=pro.getTensp()%>"/></div>
                      <div class="mask">
                        <div class="info">Xem nhanh</div>
                      </div>
                </div>
                       <div class="price"><fmt:formatNumber type="number" value="<%=pro.getGia()%>" /> VNĐ</div>
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
                (<%=pro.getSoluong()%>)
            </span>
             <ul class="list">
              <li>
                    <img src="images/plus.png" alt=""/>
                    <ul class="icon1 sub-icon1 profile_img">
                      <li><a class="active-icon c1" href="CartServlet?command=plus&masp=<%=pro.getMasp()%>">Mua ngay</a>
                            <ul class="sub-icon1 list">
                                    <li><p><%=pro.getMota().substring(0,80)%>...</p></li>
                            </ul>
                      </li>
                     </ul>
               </li>
            </ul>
            
            <div class="clear"></div>
        </div>   
        <%
            }
        %>
    <div class="clear"></div>

    </div>
 </div>
                          
                                  
   </body>
</html>
