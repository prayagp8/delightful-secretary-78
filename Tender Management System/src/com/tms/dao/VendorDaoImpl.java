package com.tms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.tms.bean.VendorBean;
import com.tms.exceptions.VendorException;
import com.tms.utility.DButil;

public class VendorDaoImpl implements VendorDao {

	@Override
	public String createVendor(VendorBean vendor) {
		String mesg = "Vendor registration failed!";



		try(Connection conn = DButil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("\r\n"
					+ "insert into vender(vpass,vfirst_name,vlast_name,vmob,vemail,vpan_card,company,address) values(\r\n"
					+ "?,?,?,?,?,?,?,?);");

			ps.setString(1, vendor.getPass());
			ps.setString(2, vendor.getFname());
			ps.setString(3, vendor.getLname());
			ps.setString(4, vendor.getMob());
			ps.setString(5, vendor.getEmail());
			ps.setString(6, vendor.getPancard());
			ps.setString(8, vendor.getCompany());
			ps.setString(7, vendor.getAddress());
			int x= ps.executeUpdate();


			if(x > 0)
				mesg = "vendor Registered Sucessfully !";

		} catch (SQLException e) {
			mesg = e.getMessage();
		}


		return mesg;

	}

	@Override
	public List<VendorBean> getAllVendorDetails() throws VendorException {

		List<VendorBean> vendors= new ArrayList<>();


		try(Connection conn= DButil.provideConnection()) {

			PreparedStatement ps= conn.prepareStatement("select * from vender");



			ResultSet rs= ps.executeQuery();

			while(rs.next()) {


				int id= rs.getInt("vid");
				String pass= rs.getString("vpass");
				String fname= rs.getString("vfirst_name");
				String lname= rs.getString("vlast_name");
				String mob= rs.getString("vmob");
				String email= rs.getString("vemail");
				String pan= rs.getString("vpan_card");
				String comp= rs.getString("company");
				String address= rs.getString("address");

				VendorBean vendorObj = new VendorBean(id,pass, fname, lname, mob, email, comp, address, pan);	

				vendors.add(vendorObj);



			}





		} catch (SQLException e) {
			throw new VendorException(e.getMessage());
		}


		if(vendors.size() == 0)
			throw new VendorException("No vendors found..");




		return vendors;
	}

}
