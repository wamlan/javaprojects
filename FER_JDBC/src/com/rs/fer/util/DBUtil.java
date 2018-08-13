package com.rs.fer.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/familyexpense";

	static final String USERNAME = "root";
	static final String PASSWORD = "root";

	public static Connection getConnection() {

		Connection connection = null;
		try {
			// step1
			Class.forName(JDBC_DRIVER);
			// step2
			connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

			// System.out.println("Connecting ta a selected database ");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return connection;
	}

	public static void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
}
