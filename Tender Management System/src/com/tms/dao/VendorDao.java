package com.tms.dao;

import java.util.List;


import com.tms.bean.VendorBean;
import com.tms.exceptions.VendorException;

public interface  VendorDao {

	public String createVendor(VendorBean vendor);
	
	public List<VendorBean> getAllVendorDetails()throws VendorException;
}
