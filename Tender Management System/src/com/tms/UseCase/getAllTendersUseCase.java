package com.tms.UseCase;

import java.util.List;

import com.tms.bean.TenderBean;
import com.tms.bean.VendorBean;
import com.tms.dao.Tenderdao;
import com.tms.dao.TenderdaoImpl;

import com.tms.exceptions.TenderException;


public class getAllTendersUseCase {
	public static void main(String[] args) {


		Tenderdao dao =new TenderdaoImpl();

		try {
			List<TenderBean> Tlist=dao.getAllTenderDetails();

			Tlist.forEach(s->{
				System.out.println(TEXT_BRIGHT_BG_YELLOW+"******************************************"+TEXT_RESET);
				System.out.println("Tender id: "+ s.getId());
				System.out.println("Tender name: "+ s.getName());
				System.out.println("Tender type: "+ s.getType());
				System.out.println("Tender amount: "+ s.getCost());
				System.out.println("Tender description: "+s.getDesc());
				System.out.println("Tender deadline: "+s.getDeadline());
				System.out.println("Tender location: "+s.getLocation());


				System.out.println(TEXT_BRIGHT_BG_YELLOW+"******************************************"+TEXT_RESET);
			});





		} catch (TenderException e) {
			System.out.println(e.getMessage());
		}

	}
	public static final String TEXT_RESET = "\u001B[0m";


	public static final String TEXT_BRIGHT_BG_YELLOW = "\u001B[103m";
}
