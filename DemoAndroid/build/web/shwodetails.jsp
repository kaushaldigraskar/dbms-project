<%@page import="a.b.Data,java.sql.*"%>
<%
    
    try {
        String s="";
        String name=request.getParameter("name");
        Data ob=new Data();
        if(name.equals("all")||name.equals("All")){
            String sql="select * from dbms";
         
           ResultSet rs = ob.getData(sql);
           while(rs.next()){
             s="Name: "+rs.getString("name")+",\nAddress: "+rs.getString("address")+",\nDesignation: "+rs.getString("designation")+",\nBranch: "+rs.getString("branch")+",\nMobile :"+rs.getString("mobile")+",\nQualification: "+rs.getString("qualification")+",\nBlood group: "+rs.getString("blood_group")+",\nPassout college: "+rs.getString("passout_college")+",\n";
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
    

%>