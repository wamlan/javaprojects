package com.rs.fer.main;

import com.rs.fer.bean.PersonalInfo;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class GetPersonalInfoMain {

	public static void main(String[] args) {

		FERService ferService = new FERServiceImpl();

		PersonalInfo info = ferService.getPersonalInfo(2);
		if (info != null) {
			System.out.println(info.getUser().getFirstName());
			System.out.println(info.getUser().getMiddleName());
			System.out.println(info.getUser().getLastName());
			System.out.println(info.getUser().getEmailId());
			System.out.println(info.getUser().getUserName());
			System.out.println(info.getUser().getPassWord());
			System.out.println(info.getUser().getMobileNo());

			System.out.println(info.getAddress().getAddressLineOne());
			System.out.println(info.getAddress().getAddressLineTwo());
			System.out.println(info.getAddress().getCity());
			System.out.println(info.getAddress().getState());
			System.out.println(info.getAddress().getZipCode());
			System.out.println(info.getAddress().getCountry());

		} else {
			System.out.println("not getting info successfully");
		}
	}
}
