package com.rs.fer.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;
import com.rs.fer.util.DBUtil;

public class UpdatePersonalInfoMain {

	public static void main(String[] args) {

		User user = new User();
		user.setFirstName("amresh");
		user.setMiddleName("ddd");
		user.setLastName("mohanty");
		user.setEmailId("amresh345@gmail.com");
		user.setUserName("amresh");
		user.setPassWord("amresh@45");
		user.setMobileNo("8093308342");
		user.setId(3);

		Address address = new Address();

		address.setAddressLineOne("medical road");
		address.setAddressLineTwo("banki");
		address.setCity("cuttack");
		address.setState("odisha");
		address.setZipCode("751026");
		address.setCountry("india");

		//address.setId(user.getId());

		address.setId(3);
		FERService ferService = new FERServiceImpl();

		boolean updatePersonalInfo = ferService.updatePersonalInfo(user, address);
		if (updatePersonalInfo) {
			System.out.println("personal info updated successfully");
		} else {
			System.out.println("unable to update");
		}
	}

}
