package com.tms.bean;

public class VendorBean {

	private int id;
	private String pass;
	private String name;
	private String mob;
	private String email;
	private String company;
	private String address;
	private String pancard;
	
	
	
	public VendorBean() {
		// TODO Auto-generated constructor stub
	}



	public VendorBean(int id, String pass, String name, String mob, String email, String company, String address,
			String pancard) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.mob = mob;
		this.email = email;
		this.company = company;
		this.address = address;
		this.pancard = pancard;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getPass() {
		return pass;
	}



	public void setPass(String pass) {
		this.pass = pass;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getMob() {
		return mob;
	}



	public void setMob(String mob) {
		this.mob = mob;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getCompany() {
		return company;
	}



	public void setCompany(String company) {
		this.company = company;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getPancard() {
		return pancard;
	}



	public void setPancard(String pancard) {
		this.pancard = pancard;
	}



	@Override
	public String toString() {
		return "VendorBean [id=" + id + ", pass=" + pass + ", name=" + name + ", mob=" + mob + ", email=" + email
				+ ", company=" + company + ", address=" + address + ", pancard=" + pancard + "]";
	}
	
	
	
	
	
}
