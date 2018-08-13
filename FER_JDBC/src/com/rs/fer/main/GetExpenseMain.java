package com.rs.fer.main;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class GetExpenseMain {

	public static void main(String[] args) {

		FERService ferService = new FERServiceImpl();
		Expense expense = ferService.getExpense(1);
		System.out.println(expense.getByWhom());
	}
}
