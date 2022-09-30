package com.tms.bean;



public class BidderBean {

	private int bidId;
	private int vendorId;
	private int tenderId;
	private int bidAmount;			
	private String bidStatus ;
	
	public BidderBean() {
		// TODO Auto-generated constructor stub
	}
	
	public int getBidId() {
		return bidId;
	}

	public void setBidId(int bidId) {
		this.bidId = bidId;
	}

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public int getTenderId() {
		return tenderId;
	}

	public void setTenderId(int tenderId) {
		this.tenderId = tenderId;
	}

	public int getBidAmount() {
		return bidAmount;
	}

	public void setBidAmount(int bidAmount) {
		this.bidAmount = bidAmount;
	}


	public String getBidStatus() {
		return bidStatus;
	}

	public void setBidStatus(String bidStatus) {
		this.bidStatus = bidStatus;
	}

	public BidderBean(int bidId, int vendorId, int tenderId, int bidAmount, String bidStatus) {
		super();
		this.bidId = bidId;
		this.vendorId = vendorId;
		this.tenderId = tenderId;
		this.bidAmount = bidAmount;
	
		this.bidStatus = bidStatus;
	}

	@Override
	public String toString() {
		return "BidderBean [bidId=" + bidId + ", vendorId=" + vendorId + ", tenderId=" + tenderId + ", bidAmount="
				+ bidAmount + ", bidStatus=" + bidStatus + "]";
	}
	
	
	
	
	
	

	
	
	
	
	
	
	
	
}
