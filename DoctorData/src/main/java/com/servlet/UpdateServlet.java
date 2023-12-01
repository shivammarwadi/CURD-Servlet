package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.DoctorDao;
import com.model.Doctor;



@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); 
		PrintWriter pw = response.getWriter();
		
		String id=request.getParameter("id");
 		String name=request.getParameter("docname");
		String experi=request.getParameter("exp");
		
		
		int id1=Integer.parseInt(id);
		int exp1=Integer.parseInt(experi);
	    Doctor doct=new Doctor(id1,name,exp1);
	    try 
		{ 
			 int i=DoctorDao.UpdateDoctor(doct);
			 
			 if(i>0)
			 {
				pw.println("Data Updated");
				RequestDispatcher rd=request.getRequestDispatcher("/ShowServlet");
				rd.forward(request, response);
			 }
			 else
			 {
				 pw.println("Data not Updated");
			 }
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
