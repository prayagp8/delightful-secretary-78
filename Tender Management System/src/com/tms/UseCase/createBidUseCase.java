package com.tms.UseCase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.tms.bean.BidderBean;
import com.tms.dao.BidderDao;
import com.tms.dao.BidderDaoImpl;
import com.tms.exceptions.BidderException;
import com.tms.exceptions.VendorException;
import com.tms.utility.DButil;
import com.tms.utility.IDUtil;

public class createBidUseCase {

	public static void main(String[] args) {





		try(Connection conn = DButil.provideConnection()) {


			System.out.println("Enter your vendor ID: ");


			Scanner sc = new Scanner(System.in);
			int vid = sc.nextInt();



			System.out.println("Enter the tendor ID: ");
			int tid = sc.nextInt();

			System.out.println("Enter the bid amount: ");
			int bidamount = sc.nextInt();


			int bid= Integer.parseInt(IDUtil.generateBidderId());
			
			PreparedStatement ps = conn.prepareStatement("select * from bidder where vid=? and tid=?");
			ps.setInt(1, vid);
			ps.setInt(2, tid);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				if(vid==rs.getInt("vid")&& tid ==rs.getInt("tid")) {
					System.out.println("only one bid allowed");
				}
				
			}else {
				
				BidderBean bidObject = new BidderBean(bid, vid, tid, bidamount,"pending");
				BidderDao dao = new BidderDaoImpl();

				
				String status = dao.bidTender(bidObject);
				System.out.println(status);
			}


			

		} catch (SQLException e) {

			System.out.println(e.getMessage());


		}catch(InputMismatchException f) {
			System.out.println("invalid input");
		}











	}
}
