package com.application;

import java.util.Scanner;
import java.util.Set;

import com.connection.DBConection;
import com.controller.CustomerController;
import com.model.Customer;
import com.model.MeterConnection;

public class AdminDashboard {

	public static void home() throws Throwable {
		CustomerController ct = new CustomerController(DBConection.getConnection());
		System.out.println("----------------------- WELLCOME TO ADMIN DASHBOARD -----------------------");
		boolean b = true;
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("(State of Maharashtra) \t 1.Add-Unit(s) \t 2.All Customers \t 3.LOGOUT");
			int option = sc.nextInt();
			switch(option) {
			case 1:{
				System.out.println("------------------- Total Unit(s) Consumption ----------------------");
				System.out.print("Enter Customer Meter-Number: ");
				String meternumber = sc.next();
				
				System.out.print("Enter total consumed unit(s): ");
				float unit = sc.nextFloat();
				
				MeterConnection mc = new MeterConnection();
				mc.setUnit(unit);
				mc.setMeter_Number(meternumber);
				
				boolean bb = ct.updateConnection(mc);
				if(bb) {
					System.out.println("------------------------------------------");
					System.out.println("Unit Added Successfully.");
					System.out.println("------------------------------------------");
				}
				else {
					System.out.println("Something went wrong!!");
				}
				break;
			}
			case 2:{
				System.out.println("------------------- ALl Active Customer List ----------------------");
				Set<Customer> set = ct.getAllCustomerInfo();
				System.out.println("--------------------------------------------------------------------------------------------");
				System.out.println("Customer_Name \t Account-Type \t Email-ID \t\t\t Status");
				System.out.println("--------------------------------------------------------------------------------------------");
				for(Customer cust:set) {
					System.out.print(cust.getCust_name());
					System.out.print("\t"+cust.getAccount_type());
					System.out.print("\t"+cust.getEmail());
					System.out.println("\t   "+cust.getStatus());
				}
				System.out.println("--------------------------------------------------------------------------------------------");
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
