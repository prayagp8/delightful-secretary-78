package com.tms.dao;

import java.util.List;

import com.tms.bean.TenderBean;
import com.tms.bean.TenderStatusBean;
import com.tms.exceptions.TenderException;
import com.tms.exceptions.VendorException;

public interface Tenderdao {

	public String createTender(TenderBean tender);


	public List<TenderBean> getAllTenderDetails()throws TenderException;


	public String getTenderStatus(int tenderId);

	public String assignTender(int tenderId,int vendorId,int bidderId);

	public List<TenderStatusBean> getAllAssignedTenders();
}
