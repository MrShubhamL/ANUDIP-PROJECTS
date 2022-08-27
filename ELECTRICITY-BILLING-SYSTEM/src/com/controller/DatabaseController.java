package com.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DatabaseController {
	public Connection conn;

	public DatabaseController(Connection conn) {
		super();
		this.conn = conn;
	}
	
	
// create table for registration
	public boolean createRegistrationTable() throws Throwable {
		boolean f = false;
		String query = "CREATE TABLE registration (ID INT PRIMARY KEY AUTO_INCREMENT,"
				+ "USERNAME VARCHAR(45) NOT NULL, NAME VARCHAR(45) NOT NULL,"
				+ " PASSWORD VARCHAR(45) NOT NULL, USER_ROLE VARCHAR(20) NOT NULL,"
				+ " CHECK(USER_ROLE = 'CUSTOMER' or USER_ROLE = 'ADMIN'))";
		PreparedStatement ps = conn.prepareStatement(query);
		boolean b = ps.execute();
		if(b) {
			f = true;
		}
		return f;
	}
}
