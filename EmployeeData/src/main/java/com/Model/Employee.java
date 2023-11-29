package com.Model;

public class Employee 
{
	public Employee(int id) {
		super();
		this.id = id;
	}

	private int id;
	private String name;
	private String lastname;
	private String Address;
	private String city;
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", lastname=" + lastname + ", Address=" + Address + ", city="
				+ city + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int id, String name, String lastname, String address, String city) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		Address = address;
		this.city = city;
	}

}
	

