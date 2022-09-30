package com.tms.UseCase;

import java.util.Scanner;

import com.tms.dao.BidderDao;
import com.tms.dao.BidderDaoImpl;


public class acceptBidUseCase {

	public static void main(String[] args) {


		Scanner sc = new Scanner(System.in);


		System.out.println("Enter your vendor ID: ");
		int vid = sc.nextInt();



		System.out.println("Enter the tendor ID: ");
		int tid = sc.nextInt();

		System.out.println("Enter the bider ID: ");
		int bid = sc.nextInt();

		BidderDao dao = new BidderDaoImpl();

		String status = dao.acceptBid(bid, tid, vid);

		System.out.println(status);
	}
}
