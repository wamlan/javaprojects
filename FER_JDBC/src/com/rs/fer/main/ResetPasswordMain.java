package com.rs.fer.main;

import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class ResetPasswordMain {

	public static void main(String[] args) {

		FERService ferService = new FERServiceImpl();
		boolean isResetPassword = ferService.resetPassword(1, "amresh@45", "sai");
		if (isResetPassword) {
			System.out.println("success");
		} else {
			System.out.println("failed");
		}

	}
}
