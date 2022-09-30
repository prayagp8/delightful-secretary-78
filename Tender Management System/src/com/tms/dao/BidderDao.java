package com.tms.dao;

import java.util.List;

import com.tms.bean.BidderBean;
import com.tms.exceptions.BidderException;

public interface BidderDao {

	public String acceptBid(int bid,int tenderId,int vendorId);

//	public String rejectBid(String applicationId);

	public String bidTender(BidderBean bidder) ;

	public List<BidderBean> getAllBidsOfaTender(int tenderId);

	public List<BidderBean> getAllBidsOfaVendor(int vendorId);

}
