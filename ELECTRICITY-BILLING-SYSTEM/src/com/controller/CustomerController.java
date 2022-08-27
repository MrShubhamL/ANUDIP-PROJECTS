package com.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

import com.model.Customer;
import com.model.MeterConnection;
import com.model.Registration;

public class CustomerController {
	public Connection conn;

	public CustomerController(Connection conn) {
		super();
		this.conn = conn;
	}
	
	
public boolean register(Registration c) throws Throwable {
	boolean b = false;
	String query = "INSERT INTO registration (username,name,password,user_role) VALUES (?,?,?,?)";
	PreparedStatement ps = conn.prepareStatement(query);
	ps.setString(1, c.getUsername());
	ps.setString(2, c.getCust_name());
	ps.setString(3, c.getPassword());
	ps.setString(4, c.getUser_role());
	int i = ps.executeUpdate();
	if(i==1) {
		b = true;
	}
	return b;
}

public Registration login(String username, String password, String userRole) throws Throwable {
	Registration c = null;
	String query = "select * from registration where username = ? and password = ? and user_role=?";
	PreparedStatement ps = conn.prepareStatement(query);
	ps.setString(1, username);
	ps.setString(2, password);
	ps.setString(3, userRole);
	ResultSet rs = ps.executeQuery();
	while(rs.next()) {
		c = new Registration();
		c.setCust_id(rs.getInt(1));
		c.setUsername(rs.getString(2));
		c.setCust_name(rs.getString(3));
		c.setUser_role(rs.getString(5));
	}
	return c;
}

public synchronized boolean newConnection(Customer c) throws Throwable {
	boolean b = false;
	String query = "insert into customer (cust_name, account_type, address, "
			+ "state,city,pincode,email_id,status, registration_id) values (?,?,?,?,?,?,?,?,?)";
	PreparedStatement ps = conn.prepareStatement(query);
	ps.setString(1, c.getCust_name());
	ps.setString(2, c.getAccount_type());
	ps.setString(3, c.getAddress());
	ps.setString(4, c.getState());
	ps.setString(5, c.getCity());
	ps.setString(6, c.getPincode());
	ps.setString(7, c.getEmail());
	ps.setString(8, c.getStatus());
	ps.setObject(9, c.getRegistration());
	int i = ps.executeUpdate();
	if(i==1) {
		b=true;
	}
	return b;
}

public Customer getCustomerInfo(int id) throws Throwable {
	Customer cust = null;
	String query = "select * from customer where registration_id = ?";
	PreparedStatement ps = conn.prepareStatement(query);
	ps.setInt(1, id);
	ResultSet rs = ps.executeQuery();
	while(rs.next()) {
		cust = new Customer();
		cust.setCustid(rs.getInt(1));
		cust.setCust_name(rs.getString(2));
		cust.setAccount_type(rs.getString(3));
		cust.setAddress(rs.getString(4));
		cust.setState(rs.getString(5));
		cust.setCity(rs.getString(6));
		cust.setPincode(rs.getString(7));
		cust.setEmail(rs.getString(8));
		cust.setStatus(rs.getString(9));
		cust.setRegistration(rs.getInt(10));
	}
	return cust;
}

public Set<Customer> getAllCustomerInfo() throws Throwable {
	Customer cust = null;
	Set<Customer> set = new HashSet<>();
	String query = "select * from customer";
	PreparedStatement ps = conn.prepareStatement(query);
	ResultSet rs = ps.executeQuery();
	while(rs.next()) {
		cust = new Customer();
		cust.setCustid(rs.getInt(1));
		cust.setCust_name(rs.getString(2));
		cust.setAccount_type(rs.getString(3));
		cust.setAddress(rs.getString(4));
		cust.setState(rs.getString(5));
		cust.setCity(rs.getString(6));
		cust.setPincode(rs.getString(7));
		cust.setEmail(rs.getString(8));
		cust.setStatus(rs.getString(9));
		cust.setRegistration(rs.getInt(10));
		set.add(cust);
	}
	return set;
}

public synchronized boolean connection(MeterConnection m) throws Throwable {
	boolean b = false;
	String sql = "insert into connection (meter_type, meter_number, unit, cust_id)"
			+ " values (?,?,?,?)";
	PreparedStatement ps = conn.prepareStatement(sql);
	ps.setString(1, m.getMeter_type());
	ps.setString(2, m.getMeter_Number());
	ps.setFloat(3, m.getUnit());
	ps.setInt(4, m.getCust_id());
	int i = ps.executeUpdate();
	if(i==1) {
		b=true;
	}
	return b;
}

public boolean updateConnection(MeterConnection m) throws Throwable {
	boolean b = false;
	String sql = "update connection set unit = ? where meter_number = ?";
	PreparedStatement ps = conn.prepareStatement(sql);
	ps.setFloat(1, m.getUnit());
	ps.setString(2, m.getMeter_Number());
	int i = ps.executeUpdate();
	if(i==1) {
		b = true;
	}
	return b;
}


}