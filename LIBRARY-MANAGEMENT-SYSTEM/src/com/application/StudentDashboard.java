package com.application;

import java.io.Serializable;
import java.util.Scanner;

import com.conn.DBConnection;
import com.controller.BookController;
import com.model.Book;
import com.model.Status;
import com.model.Student;

public class StudentDashboard {
	public static Scanner sc = new Scanner(System.in);

	public static void dashboard(Student st) throws Throwable {
		boolean f = false;
		System.out.println("------ Welcome to Student Dashboard ------");
		System.out.println("---------------------------------------------------------------------");
		System.out.println("Student Name : " + st.getFname() + " " + st.getLname() + " \t\t" + "Student Email : "
				+ st.getEmail());
		System.out.println("---------------------------------------------------------------------");
		do {
			System.out.println("1. Donate Book");
			System.out.println("2. Your Profile");
			System.out.println("3. Your Recieved Books");
			System.out.println("4. Return Book");
			System.out.println("5. Logout");
			System.out.print("Select Option: ");
			int options = sc.nextInt();
			switch (options) {
			case 1: {
				Book b = new Book();
				System.out.println("------- Add New Book ------");
				System.out.println("Enter Book Details : ");
				
				System.out.print("Book Title: ");
				String title = sc.next();
				String title2 = sc.nextLine();
				b.setTitle(title+title2);
				
				System.out.print("Publisher: ");
				String publisher = sc.next();
				String publisher2 = sc.nextLine();
				b.setPublisher(publisher+publisher2);
				
				System.out.print("Author: ");
				String author = sc.next();
				String author2 = sc.nextLine();
				b.setAuthor(author+author2);
				
				System.out.print("Book Number: ");
				String bookNum = sc.next();
				b.setBookNumber(bookNum);
				
				System.out.print("Publish date: ");
				String pDate = sc.next();
				b.setPublishDate(pDate);
				
				System.out.print("Book Status: ");
				String bookStatus = sc.next();
				String bookStatus2 = sc.nextLine();
				b.setStatus(bookStatus+bookStatus2);
				
				
				BookController bc = new BookController(DBConnection.getConnection());
				System.out.println("Please wait we are in process....");
				try {Thread.sleep(3000);} catch (InterruptedException e) {}
				boolean bool = bc.addBook(b);
				if(bool) {
					System.out.println("------------------------------");
					System.out.println("Book Added Successfully.");
				}
				else {
					System.out.println("------------------------------");
					System.out.println("Something wents Wrong...!!");
				}
				break;
			}
			case 2: {
				System.out.println("------- List of Books ------");
				break;
			}
			case 3: {
				System.out.println("------- List of Books ------");
				break;
			}
			case 4: {
				System.out.println("------- List of Books ------");
				break;
			}
			case 5: {
				System.out.println("------- Your Are Successfully Logout ------");
				f = true;
			}
			}
		} while (f == false);

	}
}
