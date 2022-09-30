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
		String status = "Registration Failed!!";




		try (Connection con = DButil.provideConnection()){

			PreparedStatement pst = con.prepareStatement("select * from vendor where vemail=?");

			pst.setString(1, vendor.getEmail());
			ResultSet rs = pst.executeQuery();

			if(rs.next()){

				status = "Registration Declined! \n Email Id already Registered";
			}
			else{

				try(Connection conn = DButil.provideConnection()) {

					PreparedStatement ps = conn.prepareStatement("insert into vendor values(?,?,?,?,?,?,?,?,?)");

					ps.setInt(1,vendor.getId());
					ps.setString(2, vendor.getPass());
					ps.setString(3, vendor.getFname());
					ps.setString(4, vendor.getLname());

					ps.setString(5, vendor.getMob());
					ps.setString(6, vendor.getEmail());
					ps.setString(7, vendor.getPancard());
					ps.setString(8, vendor.getCompany());
					ps.setString(9, vendor.getAddress());

					int k = ps.executeUpdate();

					if(k>0) //update successful
						status = "Registration Successful. \n Your Vendor id: "+vendor.getId()+" \n Thanks For Registration";
				}

				catch(SQLException e){
					e.printStackTrace();
					status = "Error: "+e.getMessage();
				}

			}
		}
		catch(SQLException e){
			e.printStackTrace();
			status = "Error: "+ e.getErrorCode()+" : "+e.getMessage();
		}

		return status;

	}
	
	
	

	@Override
	public List<VendorBean> getAllVendorDetails() throws VendorException {

		List<VendorBean> vendors= new ArrayList<>();


		try(Connection conn= DButil.provideConnection()) {

			PreparedStatement ps= conn.prepareStatement("select * from vendor");



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
