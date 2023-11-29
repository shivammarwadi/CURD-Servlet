package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.EmployeeDao;
import com.Model.Employee;



//@WebServlet("/UpdateData")
public class UpdateData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		 * String idd = request.getParameter("id");
		 * 
		 * int id1 = Integer.parseInt(idd); Employee demp = new Employee(id1);
		 * response.setContentType("text/html"); PrintWriter pw = response.getWriter();
		 * EmployeeDao dao = new EmployeeDao();
		 * 
		 * try { Connection con = connect.getDBConnection();
		 * 
		 * List<Employee> list = dao.getElementById(id1);
		 * 
		 * Iterator<Employee> itr = list.iterator();
		 * 
		 * pw.print("<table border=1>"); pw.print("<tr>"); pw.print("<td>ID</td>");
		 * pw.print("<td>First Name</td>"); pw.print("<td>Last Name</td>");
		 * pw.print("<td>Address</td>"); pw.print("<td>City</td>"); pw.print("</tr>");
		 * while (itr.hasNext()) { pw.print("<tr>"); Employee ee = itr.next(); if
		 * (ee.getId() == id1) { pw.print("<td>" + ee.getId() + "</td>");
		 * pw.print("<td>" + ee.getName() + "</td>"); pw.print("<td>" + ee.getLastname()
		 * + "</td>"); pw.print("<td>" + ee.getAddress() + "</td>"); pw.print("<td>" +
		 * ee.getCity() + "</td>"); pw.print("</tr>"); } else { pw.print("Error"); }
		 * 
		 * } pw.print("</table>");
		 * 
		 * 
		 * } catch (ClassNotFoundException e) { e.printStackTrace(); } catch
		 * (SQLException e) { e.printStackTrace(); }
		 */
		response.setContentType("text/html"); 
		PrintWriter pw = response.getWriter();
		
		String id=request.getParameter("id");
 		String name=request.getParameter("uname");
		String lastname=request.getParameter("lname");
		String Address=request.getParameter("add");
		String City=request.getParameter("city");
		
		int id1=Integer.parseInt(id);
	    Employee emp=new Employee(id1,name,lastname,Address,City);
	    try 
		{ 
			 int i=EmployeeDao.UpdateEmployee(emp);
			 
			 if(i>0)
			 {
				pw.println("Data Updated");
			 }
			 else
			 {
				 pw.println("Data not Updated");
			 }
			 RequestDispatcher rd=request.getRequestDispatcher("/ShowData");
			 rd.forward(request, response);
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
}
}