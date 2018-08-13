package com.rs.fer.service;

import java.util.List;

import org.junit.Test;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.Expense;
import com.rs.fer.bean.PersonalInfo;
import com.rs.fer.bean.User;

import junit.framework.Assert;

public class FERServiceImplTest {
	FERService ferService = new FERServiceImpl();

	// login-----------------------------------
	@Test
	public void TestLoginSuccess() {

		String username = "bablu";
		String password = "amrit@45";
		boolean isValidUser = ferService.login(username, password);
		Assert.assertEquals(true, isValidUser);

	}

	@Test
	public void TestLoginWithInvalidUsername() {

		String username = "bablu573895398637996739";
		String password = "amrit@45";
		boolean isValidUser = ferService.login(username, password);
		Assert.assertEquals(false, isValidUser);

	}

	@Test
	public void TestLoginWithInvalidPassword() {

		String username = "bablu";
		String password = "amrit@45sglshlghlskghlrhgiioegwetewt";
		boolean isValidUser = ferService.login(username, password);
		Assert.assertEquals(false, isValidUser);

	}

	@Test
	public void TestLoginWithInvalidUsernameAndPassword() {

		String username = "bablu367789564767963496775";
		String password = "amrit@45skhekthergheiogheorgerj";
		boolean isValidUser = ferService.login(username, password);
		Assert.assertEquals(false, isValidUser);

	}

	// registration-------------------------------------------
	@Test
	public void TestRegistrationSuccess() {

		User user = new User();

		user.setFirstName("alok");
		user.setLastName("barik");
		user.setEmailId("amlandassk143@gmail.com");
		user.setMobileNo("9437437490");
		user.setPassWord("amlan@94");
		user.setUserName("Tablu");
		boolean isRegister = ferService.registration(user);

		Assert.assertEquals(true, isRegister);

	}

	@Test
	public void TestRegistrationFailure() {

		User user = new User();

		user.setFirstName("alokg");
		user.setLastName(null);
		user.setEmailId("s@gmail.com");
		user.setMobileNo("9437437490j");
		user.setPassWord("amlan@94");
		user.setUserName("Tablu");
		boolean isRegister = ferService.registration(user);

		Assert.assertEquals(false, isRegister);

	}

	// add expense----------------------------------------------------
	@Test
	public void TestAddExpenseSuccess() {

		Expense expense = new Expense();

		expense.setExpenseType("nonveg");
		expense.setDate("12-06-2018");
		expense.setPrice(600);
		expense.setNoOfItems(6);
		expense.setTotalAccount(10000);
		expense.setUserId(1);
		expense.setByWhom("BigBasket");
		boolean isAddExpense = ferService.addExpense(expense);

		Assert.assertEquals(true, isAddExpense);

	}

	@Test
	public void TestAddExpenseFailure() {

		Expense expense = new Expense();

		expense.setExpenseType("nonveg");
		expense.setDate("12-06-2018");
		expense.setPrice(600);
		expense.setNoOfItems(6);
		expense.setTotalAccount(10000);
		expense.setUserId(1);
		expense.setByWhom("BigBasket");
		boolean isAddExpense = ferService.addExpense(expense);

		Assert.assertEquals(true, isAddExpense);

	}

	// edit expense----------------------------------------
	@Test
	public void TestEditExpenseSuccess() {

		Expense expense = new Expense();

		expense.setExpenseType("grocery");
		expense.setDate("14-06-2018");
		expense.setPrice(800);
		expense.setNoOfItems(6);
		expense.setTotalAccount(50000);
		expense.setUserId(2);
		expense.setByWhom("Bigbasket");
		expense.setId(1);
		boolean isEditExpense = ferService.editExpense(expense);

		Assert.assertEquals(true, isEditExpense);

	}

	@Test
	public void TestEditExpenseFailure() {

		Expense expense = new Expense();

		expense.setExpenseType("groceryfhesufhhhhhhhhhhhhhhhhhhhhawwwwwwwwwwwwioennnnnnnnjgjkgiugi");
		expense.setDate("14-06-2018");
		expense.setPrice(800);
		expense.setNoOfItems(6);
		expense.setTotalAccount(50000);
		expense.setUserId(2);
		expense.setByWhom("Bigbasket");
		expense.setId(1);
		boolean isEditExpense = ferService.editExpense(expense);

		Assert.assertEquals(false, isEditExpense);

	}

	// delete expense----------------------------------------------------
	@Test
	public void TestDeleteExpenseSuccess() {

		FERService ferService = new FERServiceImpl();
		boolean deleteExpense = ferService.deleteExpense(10);

		if (deleteExpense) {
			System.out.println("delete successfully");
		} else {
			System.out.println("delete failure");
		}

		Assert.assertEquals(true, deleteExpense);

	}

	@Test
	public void TestDeleteExpenseFailure() {

		FERService ferService = new FERServiceImpl();
		boolean deleteExpense = ferService.deleteExpense(100);

		if (deleteExpense) {
			System.out.println("delete successfully");
		} else {
			System.out.println("delete failure");
		}

		Assert.assertEquals(false, deleteExpense);

	}

	// get expense--------------------------------------------
	@Test
	public void TestGetExpenseSuccess() {

		FERService ferService = new FERServiceImpl();
		Expense expense = ferService.getExpense(1);
		System.out.println(expense.getByWhom());

		Assert.assertNotNull(expense);

	}

	@Test
	public void TestGetExpenseFailure() {

		FERService ferService = new FERServiceImpl();
		Expense expense = ferService.getExpense(12);

		Assert.assertNull(expense);

	}

	// get expense report------------------------------------------------
	@Test
	public void TestGetExpenseReportSuccess() {

		FERService ferService = new FERServiceImpl();
		List<Expense> expenses = ferService.getExpenseReport("grocery", "09/06/2018", "12/06/2018");

		Assert.assertNotNull(expenses);
	}

	@Test
	public void TestGetExpenseReportFailure() {

		FERService ferService = new FERServiceImpl();
		List<Expense> expenses = ferService.getExpenseReport("grocery", "09/055/2018", "12/0888/2018");

		Assert.assertNull(expenses);
	}

	// get Expenses-------------------------------------------------------------
	@Test
	public void TestGetExpensesSuccess() {

		FERService ferService = new FERServiceImpl();
		List<Expense> expenses = ferService.getExpenses(2);

		Assert.assertNotNull(expenses);
	}

	@Test
	public void TestGetExpensesFailure() {

		FERService ferService = new FERServiceImpl();
		List<Expense> expenses = ferService.getExpenses(50);

		Assert.assertNull(expenses);
	}

	// get personal info--------------------------------------------------------
	@Test
	public void TestGetPersonalInfoSuccess() {

		FERService ferService = new FERServiceImpl();
		PersonalInfo info = ferService.getPersonalInfo(3);
		Assert.assertNotNull(info);
	}

	@Test
	public void TestGetPersonalInfoFailure() {

		FERService ferService = new FERServiceImpl();
		PersonalInfo info = ferService.getPersonalInfo(29);
		Assert.assertNull(info);
	}

	// reset password-------------------------------------
	@Test
	public void TestResetPasswordSuccess() {

		FERService ferService = new FERServiceImpl();
		boolean isResetPassword = ferService.resetPassword(1, "amrit@45", "sai");
		if (isResetPassword) {
			System.out.println("success");
		} else {
			System.out.println("failed");
		}
		Assert.assertNotNull(isResetPassword);

	}

	@Test
	public void TestResetPasswordFailure() {
		FERService ferService = new FERServiceImpl();
		boolean isResetPassword = ferService.resetPassword(1, "amrit@45", null);
		if (isResetPassword) {
			System.out.println("success");
		} else {
			System.out.println("failed");
		}
		Assert.assertNull(isResetPassword);
	}

	// update personal
	// info---------------------------------------------------------
	@Test
	public void TestUpdatePersonalInfoSuccess() {

		User user = new User();
		user.setFirstName("amresh");
		user.setMiddleName("ddd");
		user.setLastName("mohanty");
		user.setEmailId("amresh345@gmail.com");
		user.setUserName("amresh");
		user.setPassWord("amresh@45");
		user.setMobileNo("8093308342");
		user.setId(1);

		Address address = new Address();

		address.setAddressLineOne("medical road");
		address.setAddressLineTwo("banki");
		address.setCity("cuttack");
		address.setState("odisha");
		address.setZipCode("751026");
		address.setCountry("india");

		// address.setId(user.getId());

		address.setId(1);
		FERService ferService = new FERServiceImpl();

		boolean updatePersonalInfo = ferService.updatePersonalInfo(user, address);

		Assert.assertEquals(true, updatePersonalInfo);

	}

	@Test
	public void TestUpdatPersonalInfoFailure() {

		User user = new User();
		user.setFirstName("amresh");
		user.setMiddleName("ddd");
		user.setLastName("mohanty");
		user.setEmailId("amresh345@gmail.com");
		user.setUserName("amresh");
		user.setPassWord("amresh@45");
		user.setMobileNo("8093308342");
		user.setId(2);

		Address address = new Address();

		address.setAddressLineOne("medical road");
		address.setAddressLineTwo("banki");
		address.setCity("cuttack");
		address.setState("odisha");
		address.setZipCode("751026");
		address.setCountry("india");

		// address.setId(user.getId());

		address.setId(1);
		FERService ferService = new FERServiceImpl();

		boolean updatePersonalInfo = ferService.updatePersonalInfo(user, address);

		Assert.assertEquals(false, updatePersonalInfo);
	}

}
