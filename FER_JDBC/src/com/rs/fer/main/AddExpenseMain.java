package com.rs.fer.main;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class AddExpenseMain {

	public static void main(String[] args) {

		FERService ferService = new FERServiceImpl();
		Expense expense = new Expense();

		expense.setExpenseType("nonveg");
		expense.setDate("12-06-2018");
		expense.setPrice(600);
		expense.setNoOfItems(6);
		expense.setTotalAccount(10000);
		expense.setUserId(1);
		expense.setByWhom("BigBasket");

		boolean addexpenses = ferService.addExpense(expense);

		if (addexpenses) {
			System.out.println("added successfully");
		} else {
			System.out.println("add failure");
		}
	}
}
