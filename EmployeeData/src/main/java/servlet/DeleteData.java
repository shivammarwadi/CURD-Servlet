package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.EmployeeDao;
import com.Model.Employee;
import com.connection.connect;

/**
 * Servlet implementation class DeleteData
 */
//@WebServlet("/DeleteData")
public class DeleteData extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
 		
		int id1=Integer.parseInt(id);
		Employee demp=new Employee(id1);
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		try 
		{
			 int i=EmployeeDao.deleteEmployee(demp);
			 
			 if(i>0)
			 {
				pw.println("<h1>Data Deleted</h1>");
				RequestDispatcher rd = request.getRequestDispatcher("/ShowData");
				rd.include(request, response);

			 }
			 else
			 {
				 pw.println("Data not Deleted");
			 }
			 
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
		response.getWriter();
	}

}
