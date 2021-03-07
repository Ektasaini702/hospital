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
import javax.servlet.http.HttpSession;

@WebServlet(name = "showinfo", urlPatterns = {"/showinfo"})

public class showinfo extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
           HttpSession s= request.getSession();
            String t=request.getParameter("Patient_id");
            DatabaseConnection c= new DatabaseConnection();
            Connection c1= c.getConnection();
            PreparedStatement p1= c1.prepareStatement("select * from hospitalinfo where Patient_id=?");
            p1.setString(1,t);
            
            ResultSet rs= p1.executeQuery();
            
            while(rs.next())

         {  out.println("<body style=\"background-color:lightblue;\" >\n" +"");
                        
            out.println("<style>\n"+".borders{\n" +""
                    + "border: 2px solid black;\n" +" }\n" + " label {\n"+"width: 200px;\n" +
"            display: inline-block;\n"+" }\n"+"</style>");
                out.println("<div style=\"padding:100px; padding-left: 100px; padding-right: 100px;\" align=\"center\" class=\"borders\">\n" +"");
                out.println(" <h1 style=\"background-color:DodgerBlue;\" align=\"center\"> New Information about Patients</h1>\n" +"");
                out.println("<table border=2>");
                out.println("<tr><td>"+ rs.getString(1)+"<td>"+rs.getString(2)+"<td>"+rs.getString(3)+"<td>"+rs.getString(4));
                out.println("</body>");
            }
           
        }  catch(Exception e)
           {System.out.println(e);
           }
        }
   }
