package com.rs.fer.main;

import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class LoginMain {

	public static void main(String[] args) {

		FERService ferService = new FERServiceImpl();

		boolean isValidUser = ferService.login("amresh", "amresh@45");
		if (isValidUser) {
			System.out.println("Login Successfully");
		} else {
			System.out.println("Login Failed");
		}
	}
}
