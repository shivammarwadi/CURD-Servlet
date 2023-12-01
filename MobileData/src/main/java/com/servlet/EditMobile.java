package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.mobileDao;
import com.model.mobile;

@WebServlet("/EditMobile")
public class EditMobile extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int id=Integer.parseInt(request.getParameter("id"));
		mobile mob=null;
		try {
			mob=mobileDao.getElementById(id);
		} catch (SQLException e) {
				e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		out.print("<h2>Mobile UPDATE FORM <h2> <br>");
		out.print("<form action='UpdateMobile' method='get'>");
		
		out.print("<input type='text' name='id' value='"+mob.getId()+"' readonly >");
		out.print("<br><br>");
		out.print("<input type='text' name='name' value='"+mob.getName()+"'>");
		out.print("<br><br>");
		out.print("<input type='text' name='storage' value='"+mob.getStorage()+"'>");
		out.print("<br><br>");
		out.print("<input type='text' name='model' value='"+mob.getModel()+"'>");
		out.print("<br><br>");
		
		out.print("<input type='submit' value='UPDATE'><br>");
		out.print("<a href='index.html'>" + "Back" + "</a>");
		out.print("</form>");
		
	}

}
