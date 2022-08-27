package com.model;

public class Registration {
	
	private int cust_id;
	private String username;
	private String cust_name;
	private String password;
	private String user_role;
	
	public Registration(int cust_id, String username, String cust_name, String password, String user_role) {
		this.cust_id = cust_id;
		this.username = username;
		this.cust_name = cust_name;
		this.password = password;
		this.user_role = user_role;
	}

	public Registration() {
		super();
	}

	public int getCust_id() {
		return cust_id;
	}

	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCust_name() {
		return cust_name;
	}

	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUser_role() {
		return user_role;
	}

	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}

	@Override
	public String toString() {
		return "Registration [cust_id=" + cust_id + ", username=" + username + ", cust_name=" + cust_name + ", password="
				+ password + ", user_role=" + user_role + "]";
	}
	
	
	
	
	
	

}
