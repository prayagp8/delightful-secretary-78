package com.tms.UseCase;

import java.util.Scanner;

import com.tms.dao.Tenderdao;
import com.tms.dao.TenderdaoImpl;

public class setTenderStatusUseCase {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Tender No. to check status: ");
		int tid = sc.nextInt();
		
		
		Tenderdao dao = new TenderdaoImpl();
		
		
		
		 String  status  =  dao.getTenderStatus(tid);
		
		System.out.println(status);
		
	}
	
	
	
	
}
