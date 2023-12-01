package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.connection.connect;
import com.model.Doctor;

public class DoctorDao 
{
	
		public static int addDoctor(Doctor d) throws ClassNotFoundException, SQLException
		{
			Connection con=connect.getConnection();
			String sql="insert into doctor values(?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, d.getId());
			ps.setString(2, d.getName());
			ps.setInt(3,d.getExperience());
			
			return ps.executeUpdate();
		}	
		

		public List<Doctor> showDoctor() throws ClassNotFoundException, SQLException
		{
			List<Doctor> ls=new ArrayList<Doctor>();
			Connection con=connect.getConnection();
			String sql="select * from doctor";
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				Doctor d=new Doctor();
				d.setId(rs.getInt(1));
				d.setName(rs.getString(2));
				d.setExperience(rs.getInt(3));
				ls.add(d);
			}
			
			return ls;
		}
		
		public static int deleteDoctor(Doctor d) throws ClassNotFoundException, SQLException
		{
			Connection con=connect.getConnection();
			String sql="delete from doctor where id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1,d.getId());
			
			return ps.executeUpdate();
		}
		
		public static Doctor getElementById(int id) throws SQLException, ClassNotFoundException {
			Connection con = connect.getConnection();
			String sql = "select * from doctor where id=?";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id); 
            Doctor doc = new Doctor();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				doc.setId(rs.getInt(1));
				 doc.setName(rs.getString(2)); 
				 doc.setExperience(rs.getInt(3));
			}
			return doc;

		}

		public static int UpdateDoctor(Doctor doc) throws ClassNotFoundException, SQLException 
		{
			Connection con = connect.getConnection();
			PreparedStatement ps = con.prepareStatement("update doctor set Name=?,doct_experience=? where id=?");
			ps.setString(1,doc.getName());
			ps.setInt(2, doc.getExperience());
		
			ps.setInt(3, doc.getId());
			return ps.executeUpdate();
		}

}
