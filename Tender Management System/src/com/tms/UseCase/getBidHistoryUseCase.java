package com.tms.UseCase;

import java.util.List;
import java.util.Scanner;

import com.tms.bean.BidderBean;
import com.tms.bean.VendorBean;
import com.tms.dao.BidderDao;
import com.tms.dao.BidderDaoImpl;

public class getBidHistoryUseCase {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your vendor ID: ");
		
		int vid = sc.nextInt();
		
		BidderDao dao = new BidderDaoImpl();
		
		
	    List<BidderBean> BList  = dao.getAllBidsOfaVendor(vid);
	    
	    BList.forEach(s->{
	    	
	    	System.out.println("Biding id: "+s.getBidId());
	    	System.out.println("Vender id: "+s.getVendorId());
	    	System.out.println("Tender id: "+s.getTenderId());
	    	System.out.println("Status: "+s.getBidStatus());
	    	System.out.println("Amount: "+s.getBidAmount());
	    	
	    	System.out.println("**********************************");
	    });
		
		
		
	}
}
