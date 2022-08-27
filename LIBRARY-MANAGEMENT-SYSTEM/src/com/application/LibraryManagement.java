package com.application;

import java.sql.SQLException;
import java.util.Scanner;

import com.conn.DBConnection;
import com.controller.StudentController;
import com.model.Student;

public class LibraryManagement {
	public static Scanner sc = new Scanner(System.in);
	
	public static void Login() throws Throwable {
		Student stud = new Student();
		System.out.println("------ Please Enter your Username and Password ------");
		System.out.print("Username: ");
		String username = sc.next();
		stud.setEmail(username);
		System.out.print("Password: ");
		String password = sc.next();
		stud.setPassword(password);
		
		// login login starts here....
		StudentController st = new StudentController(DBConnection.getConnection());
		System.out.println("Please wait we are in process...");
		try {Thread.sleep(3000);}catch(Exception e){}
		Student student = st.login(username, password);
		if(student != null) {
			StudentDashboard.dashboard(student);
		}
		else {
			System.out.println("Username or Password is Invalid!!");
		}
	}
	
	public static void Registration() throws Throwable {
		Student stud = new Student();
		System.out.println("------ Please Enter Your Details ------");
		System.out.print("First Name : ");
		String firstName = sc.next();
		stud.setFname(firstName);
		
		System.out.print("Last Name : ");
		String lastName = sc.next();
		stud.setLname(lastName);
		
		System.out.print("Gender : ");
		String gender = sc.next();
		stud.setGender(gender);
		
		System.out.print("Age : ");
		int age = sc.nextInt();
		stud.setAge(age);
		
		System.out.print("Address : ");
		String address = sc.next();
		String address2 = sc.nextLine();
		stud.setAddress(address+address2);
		
		
		System.out.print("Email : ");
		String email = sc.next();
		stud.setEmail(email);
		
		System.out.print("Password : ");
		String password = sc.next();
		stud.setPassword(password);
		
		StudentController st = new StudentController(DBConnection.getConnection());
		System.out.println("Please wait we are in process...");
		try {Thread.sleep(3000);}catch(Exception e){}
		boolean b = st.createStudent(stud);
		if(b) {
			System.out.println("-----------------------------------");
			System.out.println("Student Register Successfully.");
			System.out.println("-----------------------------------");
		}
		else {
			System.out.println("-----------------------------------");
			System.out.println("Something wents wrong!!");
			System.out.println("-----------------------------------");
		}
	}

	public static void main(String[] args) throws Throwable {
		boolean b = false;
		System.out.println("--------- Welcome to Library Management System -----------");
		do {
			System.out.println("1. Login");
			System.out.println("2. New Registration");
			System.out.println("3. Exit");
			System.out.print("Select your option : ");
			int option = sc.nextInt();
			switch (option) {
			case 1: {
				System.out.println("Please wait we are redirecting....");
				try {Thread.sleep(3000);} catch (InterruptedException e) {}
				Login();
				break;
			}
			case 2: {
				System.out.println("Please wait we are in process....");
				try {Thread.sleep(3000);} catch (InterruptedException e) {}
				Registration();
				break;
			}
			case 3: {
				System.out.println("Please wait we are redirecting....");
				try {Thread.sleep(3000);} catch (InterruptedException e) {}
				b = true;
				System.out.println("Thank You..");
				break;
			}
			}
		}while(b==false);
	}
}
