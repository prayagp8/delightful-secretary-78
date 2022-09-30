package com.tms.UseCase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.tms.bean.VendorBean;
import com.tms.exceptions.VendorException;
import com.tms.utility.DButil;

public class validateVendorUseCase {

	public static void main(String[] args) {


		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Username: ");
		String email = sc.next();


		System.out.println("Enter Password");
		String pass = sc.next();






		try(Connection conn= DButil.provideConnection()) {

			PreparedStatement ps= conn.prepareStatement("select * from vendor where vemail=? and vpass=?");

			ps.setString(1, email);
			ps.setString(2, pass);



			ResultSet rs= ps.executeQuery();

			if(rs.next()) {

				if(rs.getString("vemail").equalsIgnoreCase(email)&& rs.getString("vpass").equalsIgnoreCase(pass)) {

					System.out.println("Welcome "+rs.getString("vfirst_name"));
					UserActivity.Vendor();
				}


			}else {

				System.out.println("Username or password are wrong try again");
				UserActivity.selectUser();

			}




		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
