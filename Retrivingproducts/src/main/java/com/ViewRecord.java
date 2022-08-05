package com;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewRecord")
public class ViewRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		  int x=Integer.parseInt(request.getParameter("retrive"));
		out.print("<table border=1>");
			out.println("<tr><th>Productid</th><th>ProductName</th><th>ProductPrice</th></tr>");
			
		try {
			
			Connection con=DBConnection.getMyConnection();
	       
			String str="select * from products where productid="+x;
			Statement  ps=con.createStatement();
			ResultSet ans =ps.executeQuery(str);
						  
			while(ans.next()) {
				out.println("<tr>");
				out.print("<td>"+ans.getInt("productid")+"</td>");
				out.print("<td>"+ans.getString("productname")+"</td>");
				out.print("<td>"+ans.getInt("productprice")+"</td>");
				out.println("</tr>");
			}
					
		}
			
		catch(Exception e) {
			e.printStackTrace();
		}
		out.println("</table>");
		
	}

	

}