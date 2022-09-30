package com.tms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tms.bean.TenderBean;
import com.tms.bean.TenderStatusBean;
import com.tms.bean.VendorBean;
import com.tms.exceptions.TenderException;
import com.tms.exceptions.VendorException;
import com.tms.utility.DButil;

public class TenderdaoImpl implements Tenderdao {

	@Override
	public String createTender(TenderBean tender) {
		String mesg = "Tender not created!";



		try(Connection conn = DButil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("insert into tender(tname,ttype,tcost,tdesc,tdeadline,tloc) values(?,?,?,?,?,?)");

			ps.setString(1, tender.getName());
			ps.setString(2, tender.getType());
			ps.setString(3, tender.getCost());
			ps.setString(4, tender.getDesc());
			ps.setString(5, tender.getDeadline());
			ps.setString(6, tender.getLocation());

			int x= ps.executeUpdate();

			ps= conn.prepareStatement("select * from tender where tname=?");
			ps.setString(1, tender.getName());


			ResultSet rs= ps.executeQuery();

			int id=0;
			while(rs.next()) {


				id= rs.getInt("tid");

			}

			if(x > 0)
				mesg = "Tendor Registered Sucessfully ! Your tender id: " + id; 



		} catch (SQLException e) {
			mesg = e.getMessage();
		}


		return mesg;


	}






	@Override
	public List<TenderBean> getAllTenderDetails() throws TenderException {
		List<TenderBean> tenders= new ArrayList<>();


		try(Connection conn= DButil.provideConnection()) {

			PreparedStatement ps= conn.prepareStatement("select * from tender");



			ResultSet rs= ps.executeQuery();

			while(rs.next()) {


				int id= rs.getInt("tid");
				String name= rs.getString("tname");
				String type= rs.getString("ttype");
				String cost= rs.getString("tcost");
				String desc= rs.getString("tdesc");
				String deadline= rs.getString("tdeadline");
				String loc= rs.getString("tloc");


				TenderBean tenderObj = new TenderBean(id,name, type, cost, desc, deadline, loc) ;

				tenders.add(tenderObj);



			}





		} catch (SQLException e) {
			throw new TenderException(e.getMessage());
		}


		if(tenders.size() == 0)
			throw new TenderException("No tenders found..");




		return tenders;
	}






	@Override
	public String getTenderStatus(int tenderId) {
		String status = "Not Assigned";


		PreparedStatement ps = null;

		ResultSet rs = null;

		try (Connection con = DButil.provideConnection()){
			ps = con.prepareStatement("select * from tenderstatus where tid=?");

			ps.setInt(1, tenderId);

			rs = ps.executeQuery();

			if(rs.next()){
				//Tender Has been Assigned 

				status = "Assigned";
			}

		} catch (SQLException e) {
			status = "Error: "+e.getMessage();
			e.printStackTrace();
		}

		return status;
	}




	@Override
	public String assignTender(int tenderId, int vendorId,int bidderId) {
		String status = "Tender Assigning failed";

		Connection con = DButil.provideConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement("select * from tenderstatus where tid=?");
			ps.setInt(1, tenderId);

			rs = ps.executeQuery();

			if(rs.next()){

				status = "Tender is Already Assigned to Vendor: "+rs.getInt("vid");
			}
			else{

				ps = con.prepareStatement("insert into tenderstatus values(?,?,?,?)");
				ps.setInt(1,tenderId);
				ps.setInt(2, bidderId);
			
				ps.setInt(3, vendorId);
				ps.setString(4, "Assigned");

				int k = ps.executeUpdate();
				if(k>0){
					status = "Tender: "+tenderId+" has been Assigned to vendor: "+vendorId;
				}

			}
		} catch (SQLException e) {
			status = status + e.getMessage();
			e.printStackTrace();
		}


		return status;
	}




	@Override
	public List<TenderStatusBean> getAllAssignedTenders() {
		List<TenderStatusBean> statusList = new ArrayList<TenderStatusBean>();



		PreparedStatement ps  = null;

		ResultSet rs = null;

		try(Connection con = DButil.provideConnection()) {

			ps = con.prepareStatement("select * from tenderstatus");

			rs = ps.executeQuery();

			while(rs.next()){

				TenderStatusBean status = new TenderStatusBean(rs.getInt("tid"),rs.getInt("bid"),rs.getString("status"),rs.getInt("vid"));

				statusList.add(status);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}



		return statusList;
	}

}
