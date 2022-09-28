package com.tms.bean;



public class BidderBean {

	private String bidId;
	private String vendorId;
	private String tenderId;
	private int bidAmount;
	private String bidDeadline;
	private String bidStatus ;
	
	
	
	
	
	public BidderBean(String bidId, String vendorId, String tenderId, int bidAmount, String bidDeadline,
			String bidStatus) {
		super();
		this.bidId = bidId;
		this.vendorId = vendorId;
		this.tenderId = tenderId;
		this.bidAmount = bidAmount;
		this.bidDeadline = bidDeadline;
		this.bidStatus = bidStatus;
	}

	public BidderBean() {
		// TODO Auto-generated constructor stub
	}

	public String getBidId() {
		return bidId;
	}

	public void setBidId(String bidId) {
		this.bidId = bidId;
	}

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public String getTenderId() {
		return tenderId;
	}

	public void setTenderId(String tenderId) {
		this.tenderId = tenderId;
	}

	public int getBidAmount() {
		return bidAmount;
	}

	public void setBidAmount(int bidAmount) {
		this.bidAmount = bidAmount;
	}

	public String getBidDeadline() {
		return bidDeadline;
	}

	public void setBidDeadline(String bidDeadline) {
		this.bidDeadline = bidDeadline;
	}

	public String getBidStatus() {
		return bidStatus;
	}

	public void setBidStatus(String bidStatus) {
		this.bidStatus = bidStatus;
	}

	@Override
	public String toString() {
		return "BidderBean [bidId=" + bidId + ", vendorId=" + vendorId + ", tenderId=" + tenderId + ", bidAmount="
				+ bidAmount + ", bidDeadline=" + bidDeadline + ", bidStatus=" + bidStatus + "]";
	}


	
	
	
	
	
	
	
	
}
