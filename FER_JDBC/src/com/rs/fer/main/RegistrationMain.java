package com.rs.fer.main;

import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class RegistrationMain {

	public static void main(String[] args) {
		FERService ferService = new FERServiceImpl();
		User user = new User();

		
		user.setFirstName("akash");
		user.setLastName("singh");
		user.setEmailId("arijit123@gmail.com");
		user.setMobileNo("5686859954");
		user.setPassWord("amlan@94");
		user.setUserName("arijit");
		boolean isRegister = ferService.registration(user);
		if (isRegister) {
			System.out.println("Registration done successfully");
		} else {
			System.out.println("Registration Failed");
		}

	}
}
