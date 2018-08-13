package com.rs.fer.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.Expense;
import com.rs.fer.bean.PersonalInfo;
import com.rs.fer.bean.User;
import com.rs.fer.util.DBUtil;

public class FERServiceImpl implements FERService {

	static Logger log = Logger.getLogger(FERServiceImpl.class.getName());

	@Override
	public boolean registration(User user) {

		boolean isRegister = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		log.debug("user:" + user);
		try {
			// step1
			connection = DBUtil.getConnection();
			// step3
			System.out.println("Creating a statement");
			String query = "insert into userdetails(firstName,middleName,lastName,emailId,userName,passWord,mobileNo) values(?,?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(query);

			// step4
			System.out.println("Inserting records into the table");

			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getMiddleName());
			preparedStatement.setString(3, user.getLastName());
			preparedStatement.setString(4, user.getEmailId());
			preparedStatement.setString(5, user.getUserName());
			preparedStatement.setString(6, user.getPassWord());
			preparedStatement.setString(7, user.getMobileNo());

			int totalNumber = preparedStatement.executeUpdate();
			System.out.println("total number :" + totalNumber);

			isRegister = totalNumber > 0;

		} catch (SQLException e) {

			log.error("SQLException :" + e.getMessage());
		} finally {
			DBUtil.closeConnection(connection);
		}
		log.info("isRegister:" + isRegister);
		return isRegister;
	}

	@Override
	public boolean login(String username, String password) {

		boolean isValidUser = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		log.debug("username :" + username);
		try {
			// step1
			connection = DBUtil.getConnection();
			// step3
			System.out.println("Creating a statement");

			String query = "select * from userdetails where userName=? and passWord=? ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);

			ResultSet set = preparedStatement.executeQuery();
			while (set.next()) {
				isValidUser = true;
			}

		} catch (SQLException e) {

			log.error("SQLException :" + e.getMessage());
		} finally {
			DBUtil.closeConnection(connection);
		}
		log.info("ValidUser :" + isValidUser);
		return isValidUser;
	}

	@Override
	public boolean addExpense(Expense expense) {

		boolean isAddExpense = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		log.debug("Add Expense :" + expense);
		try {
			// step1
			connection = DBUtil.getConnection();
			// step3
			System.out.println("Creating a statement");
			String query = "insert into addexpense(expenseType,date,price,noOfItems,totalAccount,userId,byWhom) values(?,?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(query);

			// step4
			System.out.println("Inserting records into the table");

			preparedStatement.setString(1, expense.getExpenseType());
			preparedStatement.setString(2, expense.getDate());
			preparedStatement.setInt(3, expense.getPrice());
			preparedStatement.setInt(4, expense.getNoOfItems());
			preparedStatement.setInt(5, expense.getTotalAccount());
			preparedStatement.setInt(6, expense.getUserId());
			preparedStatement.setString(7, expense.getByWhom());

			int totalNumber = preparedStatement.executeUpdate();
			System.out.println("total number :" + totalNumber);

			isAddExpense = totalNumber > 0;

		} catch (SQLException e) {

			log.error("SQLException" + e.getMessage());
		} finally {
			DBUtil.closeConnection(connection);
		}
		log.info("Add Expense :" + isAddExpense);
		return isAddExpense;
	}

	@Override
	public boolean editExpense(Expense expense) {

		boolean isEditExpense = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		log.debug("Edit Expense :" + expense);
		try {
			// step1
			connection = DBUtil.getConnection();

			System.out.println("Connecting ta a selected database ");
			// step3
			System.out.println("Creating a statement");
			String query = "update addexpense SET expenseType=?,date=?,price=?,noOfItems=?,totalAccount=?,userId=?,byWhom=? WHERE id=?";
			preparedStatement = connection.prepareStatement(query);

			// preparedStatement.setInt(1, 1);

			// step4
			System.out.println("Inserting records into the table");

			preparedStatement.setString(1, expense.getExpenseType());
			preparedStatement.setString(2, expense.getDate());
			preparedStatement.setInt(3, expense.getPrice());
			preparedStatement.setInt(4, expense.getNoOfItems());
			preparedStatement.setInt(5, expense.getTotalAccount());
			preparedStatement.setInt(6, expense.getUserId());
			preparedStatement.setString(7, expense.getByWhom());
			preparedStatement.setInt(8, expense.getId());

			int totalNumber = preparedStatement.executeUpdate();
			isEditExpense = totalNumber > 0;
		} catch (SQLException e) {

			log.error("SQLException" + e.getMessage());
		} finally {
			DBUtil.closeConnection(connection);
		}
		log.info("Edit Expense" + isEditExpense);
		return isEditExpense;
	}

	@Override
	public boolean deleteExpense(int id) {

		boolean isDeleteExpense = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		log.debug("Delete Expense" + id);
		try {
			// step1
			connection = DBUtil.getConnection();
			System.out.println("Connecting ta a selected database ");
			// step3
			System.out.println("Creating a statement");
			String query = "delete from addexpense where id=?";
			preparedStatement = connection.prepareStatement(query);

			// step4
			System.out.println("Deleting records into the table");

			preparedStatement.setInt(1, id);

			int totalNumber = preparedStatement.executeUpdate();
			System.out.println("total number :" + totalNumber);

			isDeleteExpense = totalNumber > 0;
		} catch (SQLException e) {

			log.error("SQLException" + e.getMessage());
		} finally {
			DBUtil.closeConnection(connection);
		}
		log.info("Delete Expense" + isDeleteExpense);
		return isDeleteExpense;
	}

	@Override
	public List<Expense> getExpenses(int userId) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		log.debug("Get Expenses :" + userId);
		List<Expense> getExpenses = new ArrayList<Expense>();
		try {
			connection = DBUtil.getConnection();
			// step3
			System.out.println("Creating a statement");

			String query = "select * from addexpense where userId=? ";
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1, userId);

			// step4
			System.out.println("Inserting records into the table");

			ResultSet set = preparedStatement.executeQuery();

			Expense expense = null;
			while (set.next()) {
				expense = new Expense();

				expense.setExpenseType(set.getString("expenseType"));
				expense.setDate(set.getString("date"));
				expense.setPrice(set.getInt("price"));
				expense.setNoOfItems(set.getInt("noOfItems"));
				expense.setTotalAccount(set.getInt("totalAccount"));
				expense.setUserId(set.getInt("userId"));
				expense.setByWhom(set.getString("byWhom"));
				getExpenses.add(expense);
			}
		} catch (SQLException e) {

			log.error("SQLException :" + e.getMessage());
		} finally {
			DBUtil.closeConnection(connection);
		}
		log.info("Get Expenses :" + getExpenses);
		return getExpenses;
	}

	@Override
	public Expense getExpense(int id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Expense expense = null;

		log.debug("Get Expense :" + id);

		try {
			connection = DBUtil.getConnection();
			// step3
			System.out.println("Creating a statement");

			String query = "select * from addexpense where id=? ";
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1, id);

			// step4
			System.out.println("Inserting records into the table");

			ResultSet set = preparedStatement.executeQuery();

			while (set.next()) {
				expense = new Expense();
				expense.setExpenseType(set.getString("expenseType"));
				expense.setDate(set.getString("date"));
				expense.setPrice(set.getInt("price"));
				expense.setNoOfItems(set.getInt("noOfItems"));
				expense.setTotalAccount(set.getInt("totalAccount"));
				expense.setUserId(set.getInt("userId"));
				expense.setByWhom(set.getString("byWhom"));
				expense.setId(set.getInt("id"));
			}
		} catch (SQLException e) {

			log.error("SQLException :" + e.getMessage());
		} finally {
			DBUtil.closeConnection(connection);
		}
		log.info("Get Expense :" + expense);
		return expense;
	}

	@Override
	public List<Expense> getExpenseReport(String type, String fromDate, String toDate) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		List<Expense> expenseReport = new ArrayList<Expense>();
		// ResultSet resultSet = null;

		log.debug("Type :" + type + "From Date :" + fromDate + "ToDate :" + toDate);
		try {
			connection = DBUtil.getConnection();

			String query = "select * from addexpense where expenseType=? and date between ? and ?";

			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, type);
			preparedStatement.setString(2, fromDate);
			preparedStatement.setString(3, toDate);
			System.out.println("selecting records");

			ResultSet resultSet = preparedStatement.executeQuery();
			Expense expense = null;
			while (resultSet.next()) {
				expense = new Expense();
				expense.setExpenseType(resultSet.getString("ExpenseType"));
				expense.setDate(resultSet.getString("date"));
				expense.setPrice(resultSet.getInt("price"));
				expense.setNoOfItems(resultSet.getInt("noOfItems"));
				expense.setTotalAccount(resultSet.getInt("totalAccount"));
				expense.setId(resultSet.getInt("userId"));
				expense.setByWhom(resultSet.getString("byWhom"));

				expenseReport.add(expense);
			}
		} catch (SQLException e) {
			log.error("SQLException :" + e.getMessage());
		} finally {
			DBUtil.closeConnection(connection);
		}
		log.info("Expense Report :" + expenseReport);
		return expenseReport;
	}

	@Override
	public boolean resetPassword(int id, String currentPassword, String newPassword) {

		boolean isResetPassword = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		log.debug("Id :" + id + "Current Password :" + currentPassword + "New Password :" + newPassword);

		try {
			// step1
			connection = DBUtil.getConnection();
			// step3

			String query = "UPDATE userdetails SET passWord=? WHERE id=? AND passWord=?";
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, newPassword);

			preparedStatement.setInt(2, id);

			preparedStatement.setString(3, currentPassword);
			// step4
			System.out.println("Inserting records into the table");

			int resetPassWord = preparedStatement.executeUpdate();
			System.out.println("total number :" + resetPassWord);

			isResetPassword = resetPassWord > 0;

		} catch (SQLException e) {

			log.error("SQLException :" + e.getMessage());
		} finally {
			DBUtil.closeConnection(connection);
		}
		log.info("Reset password :" + isResetPassword);
		return isResetPassword;
	}

	public PersonalInfo getPersonalInfo(int id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		log.debug("Get Personal Info :" + id);

		PersonalInfo info = new PersonalInfo();
		try {
			// step1
			connection = DBUtil.getConnection();
			// step3
			System.out.println("Creating a statement");
			String query = "SELECT u.*,a.* FROM USERDETAILS u LEFT JOIN USERADDRESSINFO a ON u.id=a.id where u.id=a.id";
			preparedStatement = connection.prepareStatement(query);
			// preparedStatement.setInt(1,3);

			// step4
			System.out.println("Inserting records into the table");

			ResultSet set = preparedStatement.executeQuery();
			while (set.next()) {

				User user = new User();
				user.setId(set.getInt("id"));
				user.setFirstName(set.getString("firstName"));
				user.setMiddleName(set.getString("middleName"));
				user.setLastName(set.getString("lastName"));
				user.setEmailId(set.getString("emailId"));
				user.setUserName(set.getString("userName"));
				user.setPassWord(set.getString("passWord"));
				user.setMobileNo(set.getString("mobileNo"));

				Address address = new Address();
				address.setId(set.getInt("id"));
				address.setAddressLineOne(set.getString("addresslineOne"));
				address.setAddressLineTwo(set.getString("addressLineTwo"));
				address.setCity(set.getString("city"));
				address.setState(set.getString("state"));
				address.setZipCode(set.getString("zipCode"));
				address.setCountry(set.getString("country"));

				// set.getInt(1);
				info.setAddress(address);
				info.setUser(user);
				if (address.getId() == user.getId()) {
					return info;
				}
			}
		} catch (SQLException e) {

			log.error("SQLException :" + e.getMessage());
		} finally {
			DBUtil.closeConnection(connection);
		}
		log.info("Get Personal Info :" + null);
		return null;

	}

	@Override
	public boolean updatePersonalInfo(User user, Address address) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		boolean isUpdate = false;
		log.debug("User :" + user + "Address :" + address);

		try {
			connection = DBUtil.getConnection();
			connection.setAutoCommit(false);

			String query = "UPDATE USERDETAILS set firstName=?,middleName=?,lastName=?,emailId=?,userName=?,passWord=?,mobileNo=? where id=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getMiddleName());
			preparedStatement.setString(3, user.getLastName());
			preparedStatement.setString(4, user.getEmailId());
			preparedStatement.setString(5, user.getUserName());
			preparedStatement.setString(6, user.getPassWord());
			preparedStatement.setString(7, user.getMobileNo());
			preparedStatement.setInt(8, user.getId());

			int updatePersonal = preparedStatement.executeUpdate();

			isUpdate = updatePersonal > 0;
			String query1 = " ";

			if (address.getId() == 0) {
				query1 = "insert into useraddressinfo(addressLineOne,addressLineTwo,city,state,zipCode,country) values (?,?,?,?,?,?)";
				preparedStatement = connection.prepareStatement(query1);

				preparedStatement.setString(1, address.getAddressLineOne());
				preparedStatement.setString(2, address.getAddressLineTwo());
				preparedStatement.setString(3, address.getCity());
				preparedStatement.setString(4, address.getState());
				preparedStatement.setString(5, address.getZipCode());
				preparedStatement.setString(6, address.getCountry());
				// preparedStatement.setInt(1, address.getId());
				int i = preparedStatement.executeUpdate();
				isUpdate = i > 0;

			} else {
				query1 = "update useraddressinfo set addressLineOne=?,addressLineTwo=?,city=?,state=?,zipCode=?,country=? where id=?";
				preparedStatement = connection.prepareStatement(query1);

				preparedStatement.setString(1, address.getAddressLineOne());
				preparedStatement.setString(2, address.getAddressLineTwo());
				preparedStatement.setString(3, address.getCity());
				preparedStatement.setString(4, address.getState());
				preparedStatement.setString(5, address.getZipCode());
				preparedStatement.setString(6, address.getCountry());
				preparedStatement.setInt(7, address.getId());
				int i = preparedStatement.executeUpdate();
				isUpdate = i > 0;
				if (isUpdate) {
					connection.commit();
				} else {
					connection.rollback();
				}
			}

		} catch (SQLException e) {

			log.error("SQLException :" + e.getMessage());
		} finally {
			DBUtil.closeConnection(connection);
		}
		log.info("Update Personal Info :" + isUpdate);
		return isUpdate;

	}

}
