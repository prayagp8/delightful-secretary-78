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

		if(BList.size()==0) {
			System.out.println("No bidding history available !");
		}else {



			BList.forEach(s->{
				System.out.println(TEXT_RED+"**********************************"+TEXT_RESET);
				System.out.println("Biding id: "+s.getBidId());
				System.out.println("Vender id: "+s.getVendorId());
				System.out.println("Tender id: "+s.getTenderId());
				System.out.println("Status: "+s.getBidStatus());
				System.out.println("Amount: "+s.getBidAmount());

				System.out.println(TEXT_RED+"**********************************"+TEXT_RESET);
			});
		}





	}
	public static final String TEXT_RESET = "\u001B[0m";

	public static final String TEXT_RED = "\u001B[31m";


}
