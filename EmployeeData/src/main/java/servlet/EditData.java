package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.EmployeeDao;
import com.Model.Employee;

/**
 * Servlet implementation class EditData
 */
//@WebServlet("/EditData")
public class EditData extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int id=Integer.parseInt(request.getParameter("id"));
		Employee emp=null;
		try {
			emp=EmployeeDao.getElementById(id);
		} catch (SQLException e) {
				e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		out.print("<h2> STUDENT UPDATE FORM <h2> <br>");
		out.print("<form action='UpdateData' method='get'>");
		
		out.print("<input type='text' name='id' value='"+emp.getId()+"' readonly >");
		out.print("<br><br>");
		out.print("<input type='text' name='uname' value='"+emp.getName()+"'>");
		out.print("<br><br>");
		out.print("<input type='text' name='lname' value='"+emp.getLastname()+"'>");
		out.print("<br><br>");
		out.print("<input type='text' name='add' value='"+emp.getAddress()+"'>");
		out.print("<br><br>");
		out.print("<input type='text' name='city' value='"+emp.getCity()+"'>");
		out.print("<br><br>");
		
		out.print("<input type='submit' value='UPDATE'>");
		
		out.print("</form>");
		
	}

}
