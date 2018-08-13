package com.rs.fer.main;

import java.util.List;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class GetExpenseReportMain {

	public static void main(String[] args) {
		FERService ferService = new FERServiceImpl();
		List<Expense> expenses = ferService.getExpenseReport("grocery", "09/06/2018", "12/06/2018");

		if (expenses != null) {
			for (Expense expense : expenses) {
				System.out.println("ExpenseType=" + expense.getExpenseType() + "Date=" + expense.getDate() + "Price="
						+ expense.getPrice() + "NoOfItems=" + expense.getNoOfItems() + "TotalAccount"
						+ expense.getTotalAccount() + "UserId" + expense.getUserId() + "ByWhom=" + expense.getByWhom());

				System.out.println("Report get");
			}
		} else {
			System.out.println("report is not matching");
		}
	}

}
