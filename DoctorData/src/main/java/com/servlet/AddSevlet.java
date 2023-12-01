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


@WebServlet("/AddSevlet")
public class AddSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String id=request.getParameter("doc_id");
		String Name=request.getParameter("doc_name");
		String Experi=request.getParameter("doc_exp");
		
		int id1=Integer.parseInt(id);
		int exp1=Integer.parseInt(Experi);
		
		Doctor d=new Doctor(id1,Name,exp1);
		
		try
		{
			int i=DoctorDao.addDoctor(d);
			
			if(i>0)
			{
				out.print("<h3>Doctor Add Successfully</h3>");
				RequestDispatcher rd = request.getRequestDispatcher("/index.html");
				rd.include(request, response);

			}
			else
			{
				out.print("Doctor Add Failed");
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		response.getWriter();
	}

}
