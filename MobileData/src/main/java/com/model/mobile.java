package com.model;

public class mobile 
{
	
	private int id;
	private String name;
	private int storage;
	private String model;
	public mobile(int id, String name, int storage, String model) {
		super();
		this.id = id;
		this.name = name;
		this.storage = storage;
		this.model = model;
	}
	public mobile(int id) {
		super();
		this.id = id;
	}
	@Override
	public String toString() {
		return "mobile [id=" + id + ", name=" + name + ", storage=" + storage + ", model=" + model + "]";
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
	public int getStorage() {
		return storage;
	}
	public void setStorage(int storage) {
		this.storage = storage;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public mobile() {
		super();
		// TODO Auto-generated constructor stub
	}

}
