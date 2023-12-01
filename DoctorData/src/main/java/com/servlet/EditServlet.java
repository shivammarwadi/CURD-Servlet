package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.DoctorDao;

import com.model.Doctor;


/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EditServlet() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int id=Integer.parseInt(request.getParameter("id"));
		Doctor doc=null;
		try {
			doc=DoctorDao.getElementById(id);
		} catch (SQLException e) {
				e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		out.print("<h2> STUDENT UPDATE FORM <h2> <br>");
		out.print("<form action='UpdateServlet' method='get'>");
		
		out.print("<input type='text' name='id' value='"+doc.getId()+"' readonly >");
		out.print("<br><br>");
		out.print("<input type='text' name='docname' value='"+doc.getName()+"'>");
		out.print("<br><br>");
		out.print("<input type='text' name='exp' value='"+doc.getExperience()+"'>");
		out.print("<br><br>");
		
		
		out.print("<input type='submit' value='UPDATE'>");
		
		out.print("</form>");
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
