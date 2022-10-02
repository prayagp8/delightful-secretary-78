package com.tms.UseCase;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserActivity {

	public static void selectUser() {


		Scanner sc = new Scanner(System.in);

		System.out.println();
		System.out
		.println(TEXT_BRIGHT_RED+"  Choose an options - \n  " + "  1. Admin Login\n  " + "  2.Vendor Login\n  "+TEXT_RESET);

		System.out.println();
		System.out.println(TEXT_BRIGHT_GREEN+"Enter any number from above: "+TEXT_RESET);

		int choice = 0;

		try {
			choice = sc.nextInt();
		} catch (InputMismatchException e) {

			System.out.println("Invalid input!");

			System.out.println();
			System.out.println("Try again...");

			UserActivity.selectUser();
		}


		switch (choice) {
		case 1:
			System.out.println(TEXT_BRIGHT_RED+"Enter admin username"+TEXT_RESET);
			String username=sc.next();
			System.out.println(TEXT_BRIGHT_GREEN+"Enter admin password"+TEXT_RESET);
			String password=sc.next();
			if(username.equals("root") && password.equals("root")) {
				System.out.println(TEXT_BRIGHT_BG_YELLOW+"Admin login successful"+TEXT_RESET);
				
				UserActivity.admin();
				
			}else {
				System.out.println("Username or password are wrong try again");
				UserActivity.selectUser();
			}

			break;
		case 2:
			
			validateVendorUseCase.main(null);
			break;
		default:
			System.out.println("Invalid choice!");
			System.out.println();

			System.out.println("Try again...");
			UserActivity.selectUser();
		}
	}
	
	
	public static void admin() {
		Scanner sc=new Scanner(System.in);
		
		System.out.println(TEXT_BRIGHT_BG_YELLOW
				+"          1. Register new Vendor\r\n"
				+ "         2. View all the vendors..\r\n"
				+ "         3. Create new tenders.\r\n"
				+ "         4. View All the Tenders.\r\n"
				+ "         5. View All the Bids of a tender.\r\n"
				+ "         6. Assign tender to a vendor\r\n"
				+ "         7. Go Back"+TEXT_RESET);
		
		System.out.println();
		System.out.println("Enter any number from above which you want to operate");
		
		int c=0;
		
		try {
			c=sc.nextInt();
		}catch(InputMismatchException e) {
			System.out.println("Invalid input!");
			System.out.println(TEXT_BRIGHT_RED+"Try again...."+TEXT_RESET);
			UserActivity.admin();
		}
		
		switch(c) {
		case 1:
			createVendorUseCase.main(null);
			break;
		case 2:
			getAllVendorsUseCase.main(null);
			break;
		case 3:
			createTenderUseCase.main(null);
			break;
		case 4:
			getAllTendersUseCase.main(null);
			break;
		case 5:
			getAllBidderUseCase.main(null);
			break;
		case 6:
			acceptBidUseCase.main(null);
			break;
		case 7:
			UserActivity.selectUser();
		}
		
		UserActivity.admin();
			
	
		}
	
	
	public static void Vendor() {
		Scanner sc=new Scanner(System.in);
		System.out.println(TEXT_BRIGHT_BG_GREEN+"	1. View all the current Tenders.\r\n"
				+ "	2. Place a Bid against a Tender.\r\n"
				+ "	3. View status of a Bid(Whether Selected or Not)\r\n"
				+ "	4. View his own Bid History.\r\n"
				+ " 	5. Go back"+TEXT_RESET);
		
		System.out.println();
		System.out.println("Enter any number from above which you want to operate");
		int c=0;
		
		try {
			c=sc.nextInt();
		}catch(InputMismatchException e) {
			System.out.println("Invalid input!");
			System.out.println("Try again....");
			UserActivity.Vendor();
		}
		
		switch(c) {
		case 1:
			getAllTendersUseCase.main(null);
			break;
		case 2:
			createBidUseCase.main(null);
			break;
		case 3:
			setTenderStatusUseCase.main(null);
			break;
		case 4:
			getBidHistoryUseCase.main(null);
			break;
			
		case 5:
			UserActivity.selectUser();;
			break;
		}
		
		UserActivity.Vendor();
		
	}
	
	
	
	
	
	  public static final String TEXT_RESET  = "\u001B[0m";

	  public static final String TEXT_BRIGHT_BG_GREEN  = "\u001B[102m";
	  public static final String TEXT_BRIGHT_BG_YELLOW = "\u001B[103m";
	  public static final String TEXT_BRIGHT_BG_BLUE   = "\u001B[104m";
	  public static final String TEXT_BRIGHT_BLACK  = "\u001B[90m";
	  public static final String TEXT_BRIGHT_RED    = "\u001B[91m";
	  public static final String TEXT_BRIGHT_GREEN  = "\u001B[92m";
	  public static final String TEXT_BRIGHT_BG_PURPLE = "\u001B[105m";

}
