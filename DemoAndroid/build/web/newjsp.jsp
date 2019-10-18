

<%@page import="a.b.Data"%>
<%
    
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
    

%>