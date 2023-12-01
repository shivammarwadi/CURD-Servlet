package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.mobileDao;
import com.model.mobile;

@WebServlet("/mobileInsert")
public class mobileInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String storage=request.getParameter("storage");
		String model=request.getParameter("model");
		
		int id1=Integer.parseInt(id);
		int stog=Integer.parseInt(storage);
		
		mobile m=new mobile(id1,name,stog,model);
		
		int i;
		try {
			i = mobileDao.addMobile(m);
			
			if(i>0)
			{
				out.print("<h2>Mobile Add Sucessfully<h2>");
				RequestDispatcher rd = request.getRequestDispatcher("index.html");
				rd.include(request, response);

			}
		} catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}

		
	}

}
