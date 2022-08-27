package com.application;

import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

import com.connection.DBConection;
import com.controller.CustomerController;
import com.model.Customer;
import com.model.MeterConnection;
import com.model.Registration;

public class CustomerDashboard {
	
	public static void home(Registration r) throws Throwable {
		System.out.println("----------------------- WELLCOME TO CUSTOMER DASHBOARD -----------------------");
		boolean b = true;
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("(State of Maharashtra) \t 1.New-Connection \t 2.PROFILE \t 3.LOGOUT");
			int option = sc.nextInt();
			switch(option) {
			case 1:{
				
				System.out.println("------------------- New Connection ----------------------");
				System.out.println("Fill up the all customer details :-");
				System.out.print("Enter customer name: ");
				String name1 = sc.next();
				String name2 = sc.nextLine();
				String customerName = name1+name2;
				
				System.out.println("Select account type (1. Commercial   2.Domestic  3. Industrial)");
				System.out.print("Choose option: ");
				String accountType = null;
				int op = sc.nextInt();
				switch(op) {
				case 1:{
					accountType = "COMMERCIAL";
					break;
				}
				case 2:{
					accountType = "DOMESTIC";
					break;
				}
				case 3:{
					accountType = "INDUSTRIAL";
					break;
				}
				default:{
					System.out.println("INVALID OPTION!!");
				}
				}
				System.out.print("Enter your address: ");
				String ad1 = sc.next();
				String ad2 = sc.nextLine();
				String address = ad1+ad2;
				
				System.out.print("Enter your state: ");
				String state = sc.next();
				System.out.print("Enter your city: ");
				String city = sc.next();
				System.out.print("Enter your pincode: ");
				String pincode = sc.next();
				System.out.print("Enter your email ID: ");
				String email = sc.next();
				
				Customer ct = new Customer();
				ct.setCust_name(customerName);
				ct.setAccount_type(accountType);
				ct.setAddress(address);
				ct.setCity(city);
				ct.setState(state);
				ct.setPincode(pincode);
				ct.setEmail(email);
				ct.setStatus("ACTIVE");
				ct.setRegistration(r.getCust_id());
				//--------------------------------------------------//
				
				Random rand = new Random();
				int randomInt = rand.nextInt(100) + 1;
				CustomerController cc = new CustomerController(DBConection.getConnection());
				try{
					boolean bb1 = cc.newConnection(ct);
					if(bb1) {
						System.out.println("-------------------------------------------");
						System.out.println("New Connection Created Successfully.");
						System.out.println("-------------------------------------------");
						
						Customer customerInfo = cc.getCustomerInfo(r.getCust_id());
						MeterConnection mt = new MeterConnection();
						mt.setMeter_type(accountType);
						String meterNumber = "MTR0000" + randomInt;
						mt.setMeter_Number(meterNumber);
						mt.setUnit(2.3f);
						mt.setCust_id(customerInfo.getCustid());
						boolean bb2 = cc.connection(mt);
					}
					else {
						System.out.println("Something went wrong. Please try again!!");
					}
				
				}
				catch(SQLException s){
					System.out.println("------------------------------------------------------------------");
					System.out.println("You have already applied for connection."+"("+s.getMessage()+")");
					System.out.println("------------------------------------------------------------------");
				}
				break;
			}
			case 2:{
				System.out.println("------------------- PORFILE ----------------------");
				System.out.println();
				System.out.println();
				System.out.println();
				break;
			}
			case 3:{
				b = false;
				System.out.println("----------------------------------");
				System.out.println("You are successfully logout.");
				System.out.println("----------------------------------");
				break;
			}
			}
		}while(b);
	}
}
