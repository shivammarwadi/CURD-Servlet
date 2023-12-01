package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.DoctorDao;

import com.model.Doctor;


@WebServlet("/ShowServlet")
public class ShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		DoctorDao dao=new DoctorDao();
		try {
				List<Doctor> list=dao.showDoctor();
				
				Iterator<Doctor> itr=list.iterator();
				
				pw.print("<table border=1>");
				pw.print("<tr>");
				  pw.print("<td>ID</td>");
				  pw.print("<td>Doctor Name</td>");
				  pw.print("<td>Experience</td>");
				  pw.print("<td>Action</td>");
				pw.print("</tr>");
				while(itr.hasNext())
				{
					pw.print("<tr>");
					Doctor ee=itr.next();
					pw.print("<td>"+ee.getId()+"</td>");
					pw.print("<td>"+ee.getName()+"</td>");
					pw.print("<td>"+ee.getExperience()+"</td>");
					pw.print("<td>");
					pw.print("<a href='DeleteServlet?id="+ee.getId()+"'>"+"DELETE"+"</a>");
					pw.print("</td>");
					pw.print("<td>");
					pw.print("<a href='EditServlet?id="+ee.getId()+"'>"+"EDIT"+"</a>");
					pw.print("</td>");
					pw.print("</tr>");
				}
				pw.print("</table>");
				pw.print("<br><br><br>");
				pw.print("<a href='index.html'>"+"Back"+"</a>");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		response.getWriter();
	}


}
