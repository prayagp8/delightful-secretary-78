package com.tms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tms.bean.BidderBean;
import com.tms.utility.DButil;
import com.tms.utility.IDUtil;

public class BidderDaoImpl implements BidderDao {


	@Override
	public String bidTender(BidderBean bidder){
		String status = "Tender Bidding Failed!";



		try(Connection conn = DButil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("insert into bidder values(?,?,?,?,?)");

			ps.setInt(1,bidder.getBidId());

			ps.setInt(2, bidder.getVendorId());

			ps.setInt(3,bidder.getTenderId());

			ps.setInt(4,bidder.getBidAmount());


			ps.setString(5,bidder.getBidStatus());


			int x = ps.executeUpdate();

			if(x>0)
				status = "You have successfully Bid for the tender! your Bidding ID is: "+ bidder.getBidId();


		} catch (SQLException e) {

			status = e.getMessage();
		}




		return status;
	}







	@Override
	public List<BidderBean> getAllBidsOfaTender(int tenderId) {

		List<BidderBean> bidderList = new ArrayList<BidderBean>();



		PreparedStatement ps = null;
		ResultSet rs = null;

		try(Connection con = DButil.provideConnection()) {

			ps = con.prepareStatement("select * from bidder where tid=?");

			ps.setInt(1, tenderId);

			rs = ps.executeQuery();

			while(rs.next()){
				BidderBean bidder = new BidderBean();

				bidder.setBidAmount(rs.getInt("bidamount"));
				bidder.setBidId(rs.getInt("bidId"));
				bidder.setBidStatus(rs.getString("status"));
				bidder.setTenderId(rs.getInt("tid"));
				bidder.setVendorId(rs.getInt("vid"));

				bidderList.add(bidder);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}




		return bidderList;
	}







	@Override
	public String acceptBid(int bid, int tenderId, int vendorId) {

		String status = "Bid Acceptance Failed";

		Connection con = DButil.provideConnection();

		PreparedStatement ps = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {

			ps = con.prepareStatement("select * from tenderstatus where tid=?");
			ps.setInt(1, tenderId);
			rs = ps.executeQuery();
			if(rs.next()){

				status = "Project Already Assigned";
			}
			else{

				pst = con.prepareStatement("update bidder set status = ? where bid=? and status=?");

				pst.setString(1, "Accepted");
				pst.setInt(2, bid);
				pst.setString(3, "Pending");

				int x = pst.executeUpdate();
				if(x>0){
					status = "Bid Has Been Accepted Successfully!";
					Tenderdao dao = new TenderdaoImpl();
					status = dao.assignTender(tenderId, vendorId, bid);
				}
			}
		} catch (SQLException e) {

			status = status + "Error: "+e.getMessage();
			e.printStackTrace();
		}

		return status;
	}



	@Override
	public List<BidderBean> getAllBidsOfaVendor(int vendorId) {
		List<BidderBean> bidderList = new ArrayList<BidderBean>();


		
		PreparedStatement ps = null;
		ResultSet rs = null;

		try(Connection con = DButil.provideConnection()) {

			ps = con.prepareStatement("select * from bidder where vid=?");

			ps.setInt(1, vendorId);

			rs = ps.executeQuery();

			while(rs.next()){
				BidderBean bidder = new BidderBean();

				bidder.setBidAmount(rs.getInt("bidamount"));
				bidder.setBidId(rs.getInt("bid"));
				bidder.setBidStatus(rs.getString("status"));
				bidder.setTenderId(rs.getInt("tid"));
				bidder.setVendorId(rs.getInt("vid"));

				bidderList.add(bidder);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
	



		return bidderList;
	}
















}




