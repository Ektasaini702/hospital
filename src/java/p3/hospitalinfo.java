package p3;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet(name = "hospitalinfo", urlPatterns = {"/hospitalinfo"})

public class hospitalinfo extends HttpServlet {
protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
           String t= request.getParameter("Info");
           String p= request.getParameter("Patient_id");
           String n= request.getParameter("Num");
           String s= request.getParameter("Date");
         
           DatabaseConnection d= new DatabaseConnection();
           RequestDispatcher r;
           PreparedStatement p1;

           try{
           Connection c=d.getConnection();
           p1= c.prepareStatement("insert into hospitalinfo values(?,?,?,?)");
           p1.setString(1,t);
           p1.setString(2,p);
           p1.setString(3,n);
           p1.setString(4,s);
          
           p1.execute();
           
           r= request.getRequestDispatcher("SuccessPage.html");
           r.forward(request,response);
           
        }  catch(Exception e)
           {System.out.println(e);
           }
        }
   }
}
