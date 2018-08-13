package com.rs.fer.main;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class EditExpenseMain {

	public static void main(String[] args) {
		FERService ferService = new FERServiceImpl();
		Expense expense = new Expense();
		
		expense.setExpenseType("grocery");
		expense.setDate("18-06-2018");
		expense.setPrice(800);
		expense.setNoOfItems(8);
		expense.setTotalAccount(6000);
		expense.setUserId(2);
		expense.setByWhom("basket");
		expense.setId(5);

		boolean editExpense = ferService.editExpense(expense);
		if (editExpense) {
			System.out.println("edited successfully");
		} else {
			System.out.println("edit failed");
		}

	}
}
