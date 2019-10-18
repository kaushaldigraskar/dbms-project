package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import a.b.Data;
import java.sql.*;

public final class shwodetails_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');

    
    try {
        String s="";
        String name=request.getParameter("name");
        Data ob=new Data();
        if(name.equals("all")||name.equals("All")){
            String sql="select * from dbms";
         
           ResultSet rs = ob.getData(sql);
           while(rs.next()){
             s="Name: "+rs.getString("name")+",\nAddress: "+rs.getString("address")+",\nDesignation: "+rs.getString("designation")+",\nBranch: "+rs.getString("branch")+",\nMobile :"+rs.getString("mobile")+",\nQualification: "+rs.getString("qualification")+",\nBlood group: "+rs.getString("blood_group")+",\nPassout college: "+rs.getString("passout_college");
             out.print(s);
           }
        }
        String sql="select * from dbms where name='"+name+"'";
        System.out.println(sql);
        ResultSet rs = ob.getData(sql);
        if(rs.next()){
            s="Address: "+rs.getString("address")+",\nDesignation: "+rs.getString("designation")+",\nBranch: "+rs.getString("branch")+",\nMobile :"+rs.getString("mobile")+",\nQualification: "+rs.getString("qualification")+",\nBlood group: "+rs.getString("blood_group")+",\nPassout college: "+rs.getString("passout_college");
        }
        out.print(s);
        
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
