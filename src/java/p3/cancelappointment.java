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

@WebServlet(name = "cancelappointment", urlPatterns = {"/cancelappointment"})
public class cancelappointment extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           String u= request.getParameter("Patient_id");
                     
          DatabaseConnection d= new DatabaseConnection();
           RequestDispatcher r;
           PreparedStatement p1;

           try{
           Connection c=d.getConnection();
           p1= c.prepareStatement("delete from appointment where Patient_id=?");
           p1.setString(1,u);
                     
           p1.execute();
           r= request.getRequestDispatcher("SuccessPage.html");
           r.forward(request,response);
           
        }  catch(Exception e)
           {System.out.println(e);}
               }
   }
}
