package com.tms.UseCase;

import java.util.Scanner;

import com.tms.bean.VendorBean;
import com.tms.dao.VendorDao;
import com.tms.dao.VendorDaoImpl;
import com.tms.utility.IDUtil;

public class createVendorUseCase {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Enter vendor first name: ");
		
		String fname = sc.next();
		
		System.out.println("Enter vendor last name: ");
		String lname = sc.next();
		
		
		System.out.println("Enter vendor mobile no: ");
		String tmob = sc.next();
		
		System.out.println("create password : ");
		String tpass = sc.next();
		
		System.out.println("Enter ventor email: ");
		String temail = sc.next();
		
		System.out.println("Enter vendor company: ");
		String tcompany= sc.next();
		
		System.out.println("Enter vendor pancard: ");
		String tpan_card = sc.next();
		
		System.out.println("Enter vendor address: ");
		String tloc = sc.next();
		
		IDUtil ids = new IDUtil();
	
		int tid = Integer.parseInt(ids.generateVendorId());
		
		
		
		
		VendorBean vendorObj = new VendorBean( tid ,tpass, fname, lname, tmob, temail, tcompany, tloc, tpan_card);
		VendorDao dao = new VendorDaoImpl();
		String result = dao.createVendor(vendorObj);
		
		
		
		
		System.out.println(TEXT_RED+ result+ TEXT_RESET);
		
		
	}
	
	
	public static final String TEXT_RESET = "\u001B[0m";
	public static final String TEXT_BLACK = "\u001B[30m";
	public static final String TEXT_RED = "\u001B[31m";
}
