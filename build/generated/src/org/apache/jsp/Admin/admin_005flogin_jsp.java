package org.apache.jsp.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class admin_005flogin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">        \n");
      out.write("        <title>phuotshop Admin</title><meta charset=\"UTF-8\" />\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap-responsive.min.css\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/matrix-login.css\" />\n");
      out.write("        <link href=\"font-awesome/css/font-awesome.css\" rel=\"stylesheet\" />\n");
      out.write("        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"loginbox\">            \n");
      out.write("            <form id=\"loginform\" class=\"form-vertical\" action=\"/WebApplication1/AdminServlet\" method=\"post\">\n");
      out.write("                <div class=\"control-group normal_text\"> <h3><img src=\"img/logo.png\" alt=\"Logo\" /></h3></div>\n");
      out.write("                <div class=\"control-group\">\n");
      out.write("                    <div class=\"controls\">\n");
      out.write("                        <div class=\"main_input_box\">\n");
      out.write("                            <span class=\"add-on bg_lg\"><i class=\"icon-user\"> </i></span><input name=\"email\" type=\"text\" placeholder=\"Email\" />\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"control-group\">\n");
      out.write("                    <div class=\"controls\">\n");
      out.write("                        <div class=\"main_input_box\">\n");
      out.write("                            <span class=\"add-on bg_ly\"><i class=\"icon-lock\"></i></span><input name=\"matkhau\" type=\"password\" placeholder=\"Mậṭ khẩu\" />\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-actions\">\n");
      out.write("                    <input style=\"margin-left: 40%; border-radius: 5%\" class=\"btn btn-success\" type=\"submit\" value=\"Đăng nhập\"/>\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("            <form id=\"recoverform\" action=\"#\" class=\"form-vertical\">\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t\n");
      out.write("                    <div class=\"controls\">\n");
      out.write("                        <div class=\"main_input_box\">\n");
      out.write("                            <span class=\"add-on bg_lo\"><i class=\"icon-envelope\"></i></span><input type=\"text\" placeholder=\"E-mail address\" />\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("               \n");
      out.write("                <div class=\"form-actions\">\n");
      out.write("                    <span class=\"pull-left\"><a href=\"#\" class=\"flip-link btn btn-success\" id=\"to-login\">&laquo; Back to login</a></span>\n");
      out.write("                    <span class=\"pull-right\"><a class=\"btn btn-info\"/>Reecover</a></span>\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <script src=\"js/jquery.min.js\"></script>  \n");
      out.write("        <script src=\"js/matrix.login.js\"></script> \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
