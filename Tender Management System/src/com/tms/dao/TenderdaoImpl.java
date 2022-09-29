package com.tms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.tms.bean.TenderBean;
import com.tms.utility.DButil;

public class TenderdaoImpl implements Tenderdao {

	@Override
	public String createTender(TenderBean tender) {
		String mesg = "tender created successfully!";



		try(Connection conn = DButil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("insert into tender(tname,ttype,tcost,tdesc,tdeadline,tloc) values(?,?,?,?,?,?)");

			ps.setString(1, tender.getName());
			ps.setString(2, tender.getType());
			ps.setString(3, tender.getCost());
			ps.setString(4, tender.getDesc());
			ps.setString(5, tender.getDeadline());
			ps.setString(6, tender.getLocation());

			int x= ps.executeUpdate();


			if(x > 0)
				mesg = "Student Registered Sucessfully !";

		} catch (SQLException e) {
			mesg = e.getMessage();
//			System.out.println("lala juju");
		}


		return mesg;


	}

}
