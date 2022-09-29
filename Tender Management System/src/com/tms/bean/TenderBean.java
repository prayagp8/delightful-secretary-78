package com.tms.bean;

public class TenderBean {

	private int id;
	private String name;
	private String type;
	private String cost;
	private String desc;
	private String deadline;
	private String location;
	
	
	public TenderBean() {
		// TODO Auto-generated constructor stub
	}


	public TenderBean(int id, String name, String type, String cost, String desc, String deadline, String location) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.cost = cost;
		this.desc = desc;
		this.deadline = deadline;
		this.location = location;
	}
	

	public TenderBean( String name, String type, String cost, String desc, String deadline, String location) {
		super();
		
		this.name = name;
		this.type = type;
		this.cost = cost;
		this.desc = desc;
		this.deadline = deadline;
		this.location = location;
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


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getCost() {
		return cost;
	}


	public void setCost(String cost) {
		this.cost = cost;
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}


	public String getDeadline() {
		return deadline;
	}


	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	@Override
	public String toString() {
		return "TenderBean [id=" + id + ", name=" + name + ", type=" + type + ", cost=" + cost + ", desc=" + desc
				+ ", deadline=" + deadline + ", location=" + location + "]";
	}
	
	
	
	
	
	
	
	
}
