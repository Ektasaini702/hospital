package p3;

import java.sql.*;

public class DatabaseConnection {
    Connection con= null;
    PreparedStatement p=null; 

public DatabaseConnection()
{
   try{ 
       
       Class.forName("com.mysql.jdbc.Driver");
       con= DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","");
      
    }catch(Exception e){}
}
//factory method 
//design pattern 
public Connection getConnection()
{
    return con;
}
}
