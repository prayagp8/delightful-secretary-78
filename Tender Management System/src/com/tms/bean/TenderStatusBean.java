package com.tms.bean;

public class TenderStatusBean {

	private int tendorId;
	private int bidderId;
	private String status;
	private int vendorId;
	
	
	
	
	
	@Override
	public String toString() {
		return "TenderStatusBean [tendorId=" + tendorId + ", bidderId=" + bidderId + ", status=" + status
				+ ", vendorId=" + vendorId + "]";
	}


	public TenderStatusBean(int tendorId, int bidderId, String status, int vendorId) {
		super();
		this.tendorId = tendorId;
		this.bidderId = bidderId;
		this.status = status;
		this.vendorId = vendorId;
	}


	public TenderStatusBean() {
		// TODO Auto-generated constructor stub
	}


	public int getTendorId() {
		return tendorId;
	}


	public void setTendorId(int tendorId) {
		this.tendorId = tendorId;
	}


	public int getBidderId() {
		return bidderId;
	}


	public void setBidderId(int bidderId) {
		this.bidderId = bidderId;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public int getVendorId() {
		return vendorId;
	}


	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}
	
	
	
	
	
	
}
