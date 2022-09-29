package com.tms.UseCase;

import java.util.List;

import com.tms.bean.VendorBean;
import com.tms.dao.VendorDao;
import com.tms.dao.VendorDaoImpl;
import com.tms.exceptions.VendorException;

public class getAllVendorsUseCase {
	public static void main(String[] args) {
		
		
		VendorDao dao = new VendorDaoImpl();
		
		try {
			List<VendorBean> Vlist=dao.getAllVendorDetails();
			
			Vlist.forEach(s->{
				
				System.out.println("vendor id: "+ s.getId());
				System.out.println("vendor name: "+ s.getFname());
				System.out.println("vendor password: "+ s.getPass());
				System.out.println("vendor email: "+ s.getEmail());
				System.out.println("vendor company: "+s.getCompany());
				System.out.println("vendor pancard: "+s.getPancard());
				System.out.println("vendor address: "+s.getAddress());
				
				
				System.out.println("******************************************");
			});
			
			
			
			
			
		} catch (VendorException e) {
			
			System.out.println(e.getMessage());
		}
		

	}
}
