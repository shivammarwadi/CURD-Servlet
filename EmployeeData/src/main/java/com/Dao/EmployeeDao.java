package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.Model.Employee;
import com.connection.connect;


public class EmployeeDao 
{
	public static int addEmployee(Employee emp) throws ClassNotFoundException, SQLException 
	{
		Connection con = connect.getDBConnection();
		PreparedStatement ps = con.prepareStatement("insert into persons value(?,?,?,?,?)");
		ps.setInt(1, emp.getId());
		ps.setString(2, emp.getName());
		ps.setString(3, emp.getLastname());
		ps.setString(4, emp.getAddress());
		ps.setString(5, emp.getCity());
		return ps.executeUpdate();
	}

	public static int deleteEmployee(Employee emp) throws ClassNotFoundException, SQLException 
	{
		Connection con = connect.getDBConnection();
		PreparedStatement ps = con.prepareStatement("delete from persons where id=?");
		ps.setInt(1, emp.getId());
		
		return ps.executeUpdate();
	}

	public  List<Employee> showData() throws ClassNotFoundException, SQLException
	{
		List<Employee> ls=new ArrayList<Employee>();
		Connection con = connect.getDBConnection();
		PreparedStatement ps = con.prepareStatement("select * from persons");
		ResultSet rs=ps.executeQuery();
		
		while(rs.next())
		{
			Employee emp=new Employee();
			emp.setId(rs.getInt(1));
			emp.setLastname(rs.getString(2));
			emp.setName(rs.getString(3));
			emp.setAddress(rs.getString(4));
			emp.setCity(rs.getString(5));
			ls.add(emp);
		}
		return ls;
	
	}
	
	/*
	 * public List<Employee> getElementById(int id) throws ClassNotFoundException,
	 * SQLException { List<Employee> ls=new ArrayList<Employee>(); Connection con =
	 * connect.getDBConnection(); PreparedStatement ps =
	 * con.prepareStatement("select * from persons"); ResultSet
	 * rs=ps.executeQuery();
	 * 
	 * while(rs.next()) { Employee emp=new Employee(); emp.setId(rs.getInt(1));
	 * emp.setLastname(rs.getString(2)); emp.setName(rs.getString(3));
	 * emp.setAddress(rs.getString(4)); emp.setCity(rs.getString(5)); ls.add(emp); }
	 * return ls;
	 * 
	 * }
	 */
	public static Employee getElementById(int id) throws SQLException, ClassNotFoundException {
		Connection con = connect.getDBConnection();
		String sql = "select * from persons where id=?";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		Employee emp = new Employee();
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			emp.setId(rs.getInt(1));
			 emp.setLastname(rs.getString(2)); 
			 emp.setName(rs.getString(3));
			 emp.setAddress(rs.getString(4)); 
			 emp.setCity(rs.getString(5));
		}
		return emp;

	}
	

	public static int UpdateEmployee(Employee emp) throws ClassNotFoundException, SQLException 
	{
		Connection con = connect.getDBConnection();
		PreparedStatement ps = con.prepareStatement("update persons set Firstname=?,LastName=?,Address=?,City=? where id=?");
		ps.setString(1, emp.getName());
		ps.setString(2, emp.getLastname());
		ps.setString(3, emp.getAddress());
		ps.setString(4, emp.getCity());
		ps.setInt(5, emp.getId());
		return ps.executeUpdate();
	}


}
