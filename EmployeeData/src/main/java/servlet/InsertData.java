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

/**
 * Servlet implementation class InsertData
 */
//@WebServlet("/InsertData")
public class InsertData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id=request.getParameter("id");
 		String name=request.getParameter("uname");
		String lastname=request.getParameter("lname");
		String Address=request.getParameter("add");
		String City=request.getParameter("city");
		
		int id1=Integer.parseInt(id);
	    Employee emp=new Employee(id1,name,lastname,Address,City);
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
	    try 
		{ 
			 int i=EmployeeDao.addEmployee(emp);
			 
			 if(i>0)
			 {
				pw.println("Data Inserted");
//				RequestDispatcher rd = request.getRequestDispatcher("/insert.html");
//				rd.include(request, response);

			 }
			 else
			 {
				 pw.println("Data not Inserted");
			 }
			 
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
		
		response.getWriter();
	}

}
