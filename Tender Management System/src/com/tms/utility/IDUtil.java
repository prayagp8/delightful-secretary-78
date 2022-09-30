package com.tms.utility;

import java.util.Date;
import java.text.SimpleDateFormat;

public class IDUtil {
	public static String generateTenderId(){
		String tid = null;
		
		SimpleDateFormat sdf=new SimpleDateFormat("MMddhhmmss");
		tid=sdf.format(new Date());
		
		return tid;
	}
	
	
	public static String generateVendorId(){
		String vid = null;
		
		SimpleDateFormat sdf=new SimpleDateFormat("MMddhhmmss");
		vid=sdf.format(new Date());
		
		
		return vid;
	}
	
	public static String generateApplicationId(){
		return generateBidderId();
	}
	
	public static String generateBidderId(){
		String bidderId = null;
		
		SimpleDateFormat sdf=new SimpleDateFormat("MMddmmss");
		bidderId =sdf.format(new Date());
//		bidderId = "B"+bidderId;
		
		return bidderId;
	}
}