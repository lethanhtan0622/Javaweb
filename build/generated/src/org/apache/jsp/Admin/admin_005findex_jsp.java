package org.apache.jsp.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Users;

public final class admin_005findex_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <meta charset=\"UTF-8\" />\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap-responsive.min.css\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/fullcalendar.css\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/matrix-style.css\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/matrix-media.css\" />\n");
      out.write("        <link href=\"font-awesome/css/font-awesome.css\" rel=\"stylesheet\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/jquery.gritter.css\" />\n");
      out.write("        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>\n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
Users users = (Users) session.getAttribute("khachhang");             
            if ( users==null&& users.getMakh() != 1) {                 
                response.sendRedirect("/Admin/admin_login.jsp");             
            }         
        
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "admin_header.jsp", out, false);
      out.write("\n");
      out.write("        <div id=\"content\">\n");
      out.write("        <!--breadcrumbs-->\n");
      out.write("          <div id=\"content-header\">\n");
      out.write("            <div id=\"breadcrumb\"> <a href=\"admin_index.jsp\" title=\"Go to Home\" class=\"tip-bottom\"><i class=\"icon-home\"></i> Home</a></div>\n");
      out.write("          </div>\n");
      out.write("        <!--End-breadcrumbs-->\n");
      out.write("\n");
      out.write("        <!--Action boxes-->\n");
      out.write("          <div class=\"container-fluid\">\n");
      out.write("            <div class=\"quick-actions_homepage\">\n");
      out.write("              <ul class=\"quick-actions\">\n");
      out.write("                <li class=\"bg_lb\"> <a href=\"index.html\"> <i class=\"icon-dashboard\"></i> <span class=\"label label-important\">20</span> My Dashboard </a> </li>\n");
      out.write("                <li class=\"bg_lg span3\"> <a href=\"charts.html\"> <i class=\"icon-signal\"></i> Charts</a> </li>\n");
      out.write("                <li class=\"bg_ly\"> <a href=\"widgets.html\"> <i class=\"icon-inbox\"></i><span class=\"label label-success\">101</span> Widgets </a> </li>\n");
      out.write("                <li class=\"bg_lo\"> <a href=\"tables.html\"> <i class=\"icon-th\"></i> Tables</a> </li>\n");
      out.write("                <li class=\"bg_ls\"> <a href=\"grid.html\"> <i class=\"icon-fullscreen\"></i> Full width</a> </li>\n");
      out.write("                <li class=\"bg_lo span3\"> <a href=\"form-common.html\"> <i class=\"icon-th-list\"></i> Forms</a> </li>\n");
      out.write("                <li class=\"bg_ls\"> <a href=\"buttons.html\"> <i class=\"icon-tint\"></i> Buttons</a> </li>\n");
      out.write("                <li class=\"bg_lb\"> <a href=\"interface.html\"> <i class=\"icon-pencil\"></i>Elements</a> </li>\n");
      out.write("                <li class=\"bg_lg\"> <a href=\"calendar.html\"> <i class=\"icon-calendar\"></i> Calendar</a> </li>\n");
      out.write("                <li class=\"bg_lr\"> <a href=\"error404.html\"> <i class=\"icon-info-sign\"></i> Error</a> </li>\n");
      out.write("\n");
      out.write("              </ul>\n");
      out.write("            </div>\n");
      out.write("        <!--End-Action boxes-->\n");
      out.write("        <!--Chart-box-->    \n");
      out.write("            <div class=\"row-fluid\">\n");
      out.write("              <div class=\"widget-box\">\n");
      out.write("                <div class=\"widget-title bg_lg\"><span class=\"icon\"><i class=\"icon-signal\"></i></span>\n");
      out.write("                  <h5>Site Analytics</h5>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"widget-content\" >\n");
      out.write("                  <div class=\"row-fluid\">\n");
      out.write("                    <div class=\"span9\">\n");
      out.write("                      <div class=\"chart\"></div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"span3\">\n");
      out.write("                      <ul class=\"site-stats\">\n");
      out.write("                        <li class=\"bg_lh\"><i class=\"icon-user\"></i> <strong>2540</strong> <small>Total Users</small></li>\n");
      out.write("                        <li class=\"bg_lh\"><i class=\"icon-plus\"></i> <strong>120</strong> <small>New Users </small></li>\n");
      out.write("                        <li class=\"bg_lh\"><i class=\"icon-shopping-cart\"></i> <strong>656</strong> <small>Total Shop</small></li>\n");
      out.write("                        <li class=\"bg_lh\"><i class=\"icon-tag\"></i> <strong>9540</strong> <small>Total Orders</small></li>\n");
      out.write("                        <li class=\"bg_lh\"><i class=\"icon-repeat\"></i> <strong>10</strong> <small>Pending Orders</small></li>\n");
      out.write("                        <li class=\"bg_lh\"><i class=\"icon-globe\"></i> <strong>8540</strong> <small>Online Orders</small></li>\n");
      out.write("                      </ul>\n");
      out.write("                    </div>\n");
      out.write("                  </div>\n");
      out.write("                </div>\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("        <!--End-Chart-box--> \n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "admin_footer.jsp", out, false);
      out.write("\n");
      out.write("        \n");
      out.write("        <script src=\"js/excanvas.min.js\"></script> \n");
      out.write("        <script src=\"js/jquery.min.js\"></script> \n");
      out.write("        <script src=\"js/jquery.ui.custom.js\"></script> \n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script> \n");
      out.write("        <script src=\"js/jquery.flot.min.js\"></script> \n");
      out.write("        <script src=\"js/jquery.flot.resize.min.js\"></script> \n");
      out.write("        <script src=\"js/jquery.peity.min.js\"></script> \n");
      out.write("        <script src=\"js/fullcalendar.min.js\"></script> \n");
      out.write("        <script src=\"js/matrix.js\"></script> \n");
      out.write("        <script src=\"js/matrix.dashboard.js\"></script>        \n");
      out.write("        <script src=\"js/matrix.interface.js\"></script> \n");
      out.write("        <script src=\"js/matrix.chat.js\"></script> \n");
      out.write("        <script src=\"js/jquery.validate.js\"></script> \n");
      out.write("        <script src=\"js/matrix.form_validation.js\"></script> \n");
      out.write("        <script src=\"js/jquery.wizard.js\"></script> \n");
      out.write("        <script src=\"js/jquery.uniform.js\"></script> \n");
      out.write("        <script src=\"js/select2.min.js\"></script> \n");
      out.write("        <script src=\"js/matrix.popover.js\"></script> \n");
      out.write("        <script src=\"js/jquery.dataTables.min.js\"></script> \n");
      out.write("        <script src=\"js/matrix.tables.js\"></script> \n");
      out.write("        \n");
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
