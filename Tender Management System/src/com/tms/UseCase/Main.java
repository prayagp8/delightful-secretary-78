package com.tms.UseCase;



public class Main {

	public static void main(String[] args) {

		
		System.out.println("------------------------------------");
		System.out.println(TEXT_BRIGHT_BG_RED+ "     Tender Management System     "+ TEXT_RESET);
		System.out.println("------------------------------------");
		
		UserActivity.selectUser();;
		
		

	}
	
	public static final String TEXT_RESET = "\u001B[0m";
	public static final String TEXT_BLACK = "\u001B[30m";
	public static final String TEXT_RED = "\u001B[31m";
	 public static final String TEXT_BRIGHT_BG_RED    = "\u001B[101m";
}
