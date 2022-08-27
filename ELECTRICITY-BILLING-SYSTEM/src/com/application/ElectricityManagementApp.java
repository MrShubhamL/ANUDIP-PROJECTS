package com.application;

import java.sql.SQLException;
import java.util.Scanner;

import com.connection.DBConection;
import com.controller.CustomerController;
import com.controller.DatabaseController;
import com.model.Registration;

public class ElectricityManagementApp {
	
	public void createTable() throws Throwable {
		DatabaseController dc = new DatabaseController(DBConection.getConnection());
		try {
		boolean create = dc.createRegistrationTable();
		if(create) {
			System.out.println("Table Created Successfully.");
		}
		else {
			System.out.println("Something wents wrong. Please try again!!");
		}
		}catch(SQLException s) {System.out.println("(" + s.getMessage()+")");}
	}
	
	public static void registration() throws Throwable{
		// Register new Registration
		System.out.println("---------------------- REGISTRATION -----------------------");
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter username: ");
		String username = sc.next();
		
		System.out.print("Enter your name: ");
		String name = sc.next();
		String name2 = sc.nextLine();
		String customerName = name+name2;
		
		System.out.print("Create password: ");
		String password = sc.next();
		
		String myRole = null;
		System.out.println("Select Your Role: ");
		System.out.print("Customer(Press 1) | Admin(Press 2) : ");
		int option = sc.nextInt();
		switch(option) {
		case 1:{
			myRole = "CUSTOMER";
			break;
		}
		case 2:{
			myRole = "ADMIN";
			break;
		}
		}
		
		Registration cust = new Registration();
		cust.setUsername(username);
		cust.setCust_name(customerName);
		cust.setPassword(password);
		cust.setUser_role(myRole);
		
		try {
			CustomerController ct = new CustomerController(DBConection.getConnection());
			boolean b = ct.register(cust);
			if(b) {
				System.out.println("-----------------------------------");
				System.out.println("Registration created successfully.");
				System.out.println("-----------------------------------");
			}
			else {
				System.out.println("Something wents wrong. Please try again!!");
			}
		}catch(SQLException s) {
			System.out.println("Username already exist." + "("+s.getMessage()+")");
		}
	}
	
	public static void login() throws Throwable {
		Scanner sc = new Scanner(System.in);
		System.out.print("Username: ");
		String username = sc.next();
		System.out.print("Password: ");
		String password = sc.next();
		System.out.println("Select Your Role\n Customer(Press 1)  :  Admin(Press 2)");
		String userRole = "N/A";
		int i = sc.nextInt();
		switch(i) {
		case 1:{
			 userRole = "CUSTOMER";
			 break;
		}
		case 2:{
			 userRole = "ADMIN";
			 break;
		}
		default:{
			System.out.println("Invalid Option!!");
		}
		}
//		System.out.println("username : " + username + " password : " + password + " Role: " + userRole);
		CustomerController c = new CustomerController(DBConection.getConnection());
		Registration registration = c.login(username, password, userRole);
		if(registration != null) {
			if(registration.getUser_role().equals("CUSTOMER")==true) {
				CustomerDashboard.home(registration);
			}
			else if(registration.getUser_role().equals("ADMIN")==true) {
				AdminDashboard.home();
			}
			else {
				return;
			}
			
		}
		else {
			
			System.out.println("Invalid Details!!");
		}
	}

	public static void main(String[] args) throws Throwable {
		Scanner sc = new Scanner(System.in);
		System.out.println("---------------- ELECTRICITY MANAGEMENT SYSTEM ----------------");
		boolean b = true;
		do {
			System.out.println("1. Login (Press 1)");
			System.out.println("2. Registration (Press 2)");
			System.out.println("3. Exit");
			int i = sc.nextInt();
			switch(i) {
			case 1:{
				login();
				break;
			}
			case 2:{
				registration();
				break;
			}
			case 3:{
				b = false;
				System.out.println("-------------- THANK YOU ---------------");
				break;
			}
			default:{
				System.out.println("Invalid Option!!");
			}
			}
		}while(b);
	}

}
