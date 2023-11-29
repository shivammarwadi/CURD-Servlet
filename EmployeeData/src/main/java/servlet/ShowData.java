package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.EmployeeDao;
import com.Model.Employee;



//@WebServlet("/ShowData")
public class ShowData extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		EmployeeDao dao=new EmployeeDao();
		try {
				List<Employee> list=dao.showData();
				
				Iterator<Employee> itr=list.iterator();
				
				pw.print("<table border=1>");
				pw.print("<tr>");
				  pw.print("<td>ID</td>");
				  pw.print("<td>Last Name</td>");
				  pw.print("<td>First Name</td>");
				  pw.print("<td>Address</td>");
				  pw.print("<td>City</td>");
				  pw.print("<td>Action</td>");
				pw.print("</tr>");
				while(itr.hasNext())
				{
					pw.print("<tr>");
					Employee ee=itr.next();
					pw.print("<td>"+ee.getId()+"</td>");
					pw.print("<td>"+ee.getName()+"</td>");
					pw.print("<td>"+ee.getLastname()+"</td>");
					pw.print("<td>"+ee.getAddress()+"</td>");
					pw.print("<td>"+ee.getCity()+"</td>");
					pw.print("<td>");
					pw.print("<a href='DeleteData?id="+ee.getId()+"'>"+"DELETE"+"</a>");
					pw.print("</td>");
					pw.print("<td>");
					pw.print("<a href='EditData?id="+ee.getId()+"'>"+"EDIT"+"</a>");
					pw.print("</td>");
					pw.print("</tr>");
				}
				pw.print("</table>");
				pw.print("<br><br><br>");
				pw.print("<a href='home.html'>"+"Back"+"</a>");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		response.getWriter();
	}

}
