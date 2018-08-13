package com.rs.fer.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.rs.fer.util.DBUtil;

public class InsertAddressInfoMain {

	public static void main(String[] args) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			// step1
			connection = DBUtil.getConnection();
			// step3
			System.out.println("Creating a statement");
			String query = "insert into useraddressinfo(addressLineOne,addressLineTwo,city,state,zipCode,country) values(?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(query);

			// step4
			System.out.println("Inserting records into the table");

			preparedStatement.setString(1, "jagamara");
			preparedStatement.setString(2, "khandsgiri");
			preparedStatement.setString(3, "bhubaneswar");
			preparedStatement.setString(4, "odisha");
			preparedStatement.setString(5, "751030");
			preparedStatement.setString(6, "india");

			int totalNumber = preparedStatement.executeUpdate();
			System.out.println("total number :" + totalNumber);

			if (totalNumber > 0) {
				System.out.println("added successfully");
			} else {
				System.out.println("failed");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
	}
}
