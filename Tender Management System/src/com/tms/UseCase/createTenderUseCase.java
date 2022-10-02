package com.tms.UseCase;

import java.util.Scanner;

import com.tms.bean.TenderBean;
import com.tms.dao.Tenderdao;
import com.tms.dao.TenderdaoImpl;

public class createTenderUseCase {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter tender name: ");
		
		String tname = sc.next();
		
		System.out.println("Enter tender type: ");
		String ttype = sc.next();
		
		
		System.out.println("Enter tender cost: ");
		String tcost = sc.next();
		
		System.out.println("Enter tender description: ");
		String tdesc = sc.next();
		
		System.out.println("Enter tender deadline in 'yyyy-mm-dd': ");
		String tdeadline = sc.next();
		
		System.out.println("Enter tender location: ");
		String tloc = sc.next();
		
		TenderBean tenderObj = new TenderBean(tname, ttype, tcost, tdesc, tdeadline, tloc);
		Tenderdao dao= new TenderdaoImpl(); 
		
		String result = dao.createTender(tenderObj);
		
		System.out.println(TEXT_PURPLE+ result + TEXT_RESET);
		
	}
	
	
	public static final String TEXT_RESET = "\u001B[0m";
	public static final String TEXT_BLACK = "\u001B[30m";
	public static final String TEXT_PURPLE = "\u001B[35m";
}
