/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a.b;

import java.sql.*;

public class Data {

    Connection con;
    Statement stmt;
    ResultSet rs;
    public ResultSet s;
    public Data(){
    try{
        
     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  // load the driver
     // line below needs to be modified to include the database name, user, and password (if any)
       String connectionUrl = "jdbc:sqlserver://DESKTOP-CRFB4HG\\SQLEXPRESS:1433;databaseName=myDB;user=sa;password=12345678";

     con = DriverManager.getConnection(connectionUrl);
 
     System.out.println("Connected to database !");
 
   }
   catch(SQLException sqle) {
      System.out.println("Sql Exception :"+sqle.getMessage());
   }
   catch(ClassNotFoundException e) {
    System.out.println("Class Not Found Exception :" + e.getMessage());
   }

  //  public Data() throws Exception {
    //    String url = "jdbc:sqlserver:1433//DESKTOP-CRFB4HG\\Kaushal Digraskar;databaseName=myDB;integratedSecurity=true";
      //  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        //con = DriverManager.getConnection(url);
    }

    //insert,delete and update
    public void executeSql(String sql) throws Exception {
       stmt = con.createStatement();
        stmt.executeUpdate(sql);
    }

    //select
    public ResultSet getData(String sql) throws Exception {
       stmt = con.createStatement();
       rs = stmt.executeQuery(sql);
        return rs;
        
    }

    public void disconnect() throws Exception {
       con.close();
    }
}
