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

import com.Dao.mobileDao;
import com.model.mobile;

@WebServlet("/showMobile")
public class showMobile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		mobile mb = new mobile();

		try {

			List<mobile> list = mobileDao.showMob(mb);

			Iterator<mobile> itr = list.iterator();

			pw.print("<table border=1>");
			pw.print("<tr>");
			pw.print("<td>IMEI No</td>");
			pw.print("<td>Mobile Name</td>");
			pw.print("<td>Mobile Storage</td>");
			pw.print("<td>Mobile Model</td>");
			pw.print("<td>Action</td>");
			pw.print("</tr>");

			while (itr.hasNext()) {
				pw.print("<tr>");
				mobile ee = itr.next();

				pw.print("<td>" + ee.getId() + "</td>");
				pw.print("<td>" + ee.getName() + "</td>");
				pw.print("<td>" + ee.getStorage() + "</td>");
				pw.print("<td>" + ee.getModel() + "</td>");
		
				  pw.print("<td>");
				  pw.print("<a href='deleteMobile?id="+ee.getId()+"'>"+"DELETE"+"</a>");
				 pw.print("</td>"); pw.print("<td>");
				 pw.print("<a href='EditMobile?id="+ee.getId()+"'>"+"EDIT"+"</a>");
				 pw.print("</td>");
				
				pw.print("</tr>");
			}
			pw.print("</table>");
			pw.print("<br><br><br>");
			pw.print("<a href='index.html'>" + "Back" + "</a>");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
