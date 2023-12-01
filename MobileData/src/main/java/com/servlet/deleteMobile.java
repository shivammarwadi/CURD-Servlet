package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.Dao.mobileDao;
import com.model.mobile;

@WebServlet("/deleteMobile")
public class deleteMobile extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
      
		String id=request.getParameter("id");	
		int id1=Integer.parseInt(id);
		mobile mb=new mobile(id1);
		
		try 
		{
			 int i=mobileDao.DeleteMobile(mb);
			 
			 if(i>0)
			 {
				pw.println("<h1>Data Deleted</h1>");
				RequestDispatcher rd = request.getRequestDispatcher("/showMobile");
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
		
	}

}
