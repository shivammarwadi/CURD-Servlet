package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.connection.connect;

import com.model.mobile;

public class mobileDao 
{
		public static int addMobile(mobile m) throws ClassNotFoundException, SQLException
		{
			Connection con=connect.getConnection();
			String sql="insert into mobileData values(?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, m.getId());
			ps.setString(2, m.getName());
			ps.setInt(3, m.getStorage());
			ps.setString(4, m.getModel());
			return ps.executeUpdate();
		}
		
		public static List<mobile> showMob(mobile m) throws ClassNotFoundException, SQLException
		{
			List<mobile> ls=new ArrayList<mobile>();
			Connection con=connect.getConnection();
			String sql="select * from mobileData";
			PreparedStatement ps=con.prepareStatement(sql);
			
			ResultSet rs=ps.executeQuery();

			while(rs.next())
			{
				mobile mb=new mobile();
				mb.setId(rs.getInt(1));
				mb.setName(rs.getString(2));
				mb.setStorage(rs.getInt(3));
				mb.setModel(rs.getString(4));
				
				ls.add(mb);
			}
			return ls;
			
		}
		
		public static int DeleteMobile(mobile m) throws ClassNotFoundException, SQLException
		{
			Connection con=connect.getConnection();
			String sql="delete from mobileData where id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, m.getId());
			
			return ps.executeUpdate();
		}
		
		
		public static mobile getElementById(int id) throws SQLException, ClassNotFoundException {
			Connection con = connect.getConnection();
			String sql = "select * from mobileData where id=?";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			
			mobile emp = new mobile();
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				 emp.setId(rs.getInt(1));
				 emp.setName(rs.getString(2)); 
				 emp.setStorage(rs.getInt(3));
				 emp.setModel(rs.getString(4)); 
			}
			return emp;
		}
		
		public static int updateMobile(mobile m) throws ClassNotFoundException, SQLException
		{
			Connection con=connect.getConnection();
			String sql="update mobileData set name=?,storage=?,model=? where id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, m.getName());
			ps.setInt(2, m.getStorage());
			ps.setString(3, m.getModel());
			ps.setInt(4, m.getId());
			return ps.executeUpdate();
		}
}
