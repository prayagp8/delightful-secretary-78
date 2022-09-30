package com.tms.UseCase;

import java.util.Scanner;

import com.tms.dao.Tenderdao;
import com.tms.dao.TenderdaoImpl;

public class assignedTenderUseCase {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Enter your vendor ID: ");
		int vid = sc.nextInt();



		System.out.println("Enter the tendor ID: ");
		int tid = sc.nextInt();
		
		System.out.println("Enter the bider ID: ");
		int bid = sc.nextInt();
		
		Tenderdao dao = new TenderdaoImpl();
		
		String status = dao.assignTender(tid, vid, bid);
		
		System.out.println(status);
		
		
		






	}
}
