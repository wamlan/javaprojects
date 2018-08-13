package com.rs.fer.main;

import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class DeleteExpenseMain {

	public static void main(String[] args) {
		FERService ferService = new FERServiceImpl();
		boolean deleteExpense = ferService.deleteExpense(20);

		if (deleteExpense) {
			System.out.println("delete successfully");
		} else {
			System.out.println("delete failure");
		}

	}
}
