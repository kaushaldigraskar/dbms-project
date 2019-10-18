package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import a.b.Data;

public final class newjsp_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
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

    
    try {
        String name=request.getParameter("name");
        String address=request.getParameter("address");
        String designation=request.getParameter("designation");
        String branch=request.getParameter("branch");
        String mobile=request.getParameter("mobile");
        String date = request.getParameter("date");
        String qualification = request.getParameter("qualification");
        String blood_group = request.getParameter("blood_group");
        String passout_college=request.getParameter("passout_college");
        System.out.println(mobile+date+qualification+blood_group+passout_college);
        Data ob=new Data();
        String sql="insert into dbms values('"+name+"','"+address+"','"+designation+"','"+branch+"','"+mobile+"','"+date+"','"+qualification+"','"+blood_group+"','"+passout_college+"')";
        ob.executeSql(sql);
        out.print("Record Savedn in jsp");
        out.print(sql);
        
        
    } catch (Exception e) {
        out.print(e);
    }
    


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
