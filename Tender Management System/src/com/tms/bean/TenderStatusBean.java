package com.tms.bean;

public class TenderStatusBean {

	private String tendorId;
	private String bidderId;
	private String status;
	private String vendorId;
	
	
	
	
	
	@Override
	public String toString() {
		return "TenderStatusBean [tendorId=" + tendorId + ", bidderId=" + bidderId + ", status=" + status
				+ ", vendorId=" + vendorId + "]";
	}


	public TenderStatusBean(String tendorId, String bidderId, String status, String vendorId) {
		super();
		this.tendorId = tendorId;
		this.bidderId = bidderId;
		this.status = status;
		this.vendorId = vendorId;
	}


	public TenderStatusBean() {
		// TODO Auto-generated constructor stub
	}


	public String getTendorId() {
		return tendorId;
	}


	public void setTendorId(String tendorId) {
		this.tendorId = tendorId;
	}


	public String getBidderId() {
		return bidderId;
	}


	public void setBidderId(String bidderId) {
		this.bidderId = bidderId;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getVendorId() {
		return vendorId;
	}


	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}
	
	
	
	
	
	
}
