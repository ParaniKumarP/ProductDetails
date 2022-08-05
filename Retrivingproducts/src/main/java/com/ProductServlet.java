package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ProductServlet")

public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productid=Integer.parseInt(request.getParameter("txtproductid"));
		String productname=request.getParameter("txtproductname");
		int productprice=Integer.parseInt(request.getParameter("txtproductprice"));
		PrintWriter out=response.getWriter();
		
		try {
			
				Connection con=DBConnection.getMyConnection();
		
				String str="Insert into products(productid,productname,productprice) values(?,?,?)";
				
				PreparedStatement  ps=con.prepareStatement(str);
				ps.setInt(1,productid );
				ps.setString(2, productname);
				ps.setInt(3, productprice);
				int ans =ps.executeUpdate();
				
				if(ans>0)
					out.println("Record inserted");
				else
					out.println("Record not inserted");
				con.close();	
	}
		catch(Exception e) {
			e.printStackTrace();
		}

}
}
