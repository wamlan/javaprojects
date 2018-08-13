package com.rs.fer.main;

import java.util.List;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class GetExpensesMain {

	public static void main(String[] args) {

		FERService ferService = new FERServiceImpl();
		List<Expense> expenses = ferService.getExpenses(1);

		if (expenses != null && !expenses.isEmpty()) {
			for (Expense expense : expenses) {
				System.out.println("ExpenseType=" + expense.getExpenseType() + "Date=" + expense.getDate() + "Price="
						+ expense.getPrice() + "NoOfItems=" + expense.getNoOfItems() + "TotalAccount"
						+ expense.getTotalAccount() + "UserId" + expense.getUserId() + "ByWhom=" + expense.getByWhom());

				System.out.println("Getting Succefully");
			}

		} else {
			System.out.println("no such information is there");
		}
	}
}
