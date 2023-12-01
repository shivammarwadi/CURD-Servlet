package com.model;

import java.util.List;

public class Doctor 
{
	private int id;
	private String Name;
	private int Experience;
	@Override
	public String toString() {
		return "Doctor [id=" + id + ", Name=" + Name + ", Experience=" + Experience + "]";
	}
	public Doctor(int id) {
		super();
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getExperience() {
		return Experience;
	}
	public void setExperience(int experience) {
		Experience = experience;
	}
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Doctor(int id, String name, int experience) {
		super();
		this.id = id;
		Name = name;
		Experience = experience;
	}
	public List<Doctor> showDoctor() {
		// TODO Auto-generated method stub
		return null;
	}
}
