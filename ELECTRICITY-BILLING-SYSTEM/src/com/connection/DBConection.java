package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConection {
	public static Connection conn;
	
	public static Connection getConnection() throws Throwable {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/electricity_management",
				"root", "root");
		return conn;
	}
}
