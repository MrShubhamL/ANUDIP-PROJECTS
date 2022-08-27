package com.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.model.Book;
import com.model.Status;

public class BookController {
	public Connection conn;

	public BookController(Connection conn) {
		super();
		this.conn = conn;
	}
	
	
public boolean addBook(Book b) throws Throwable {
	boolean f = false;
	String query = "insert into book (book_title, publisher, author, book_number, publish_date, book_status)"
			+ " values(?,?,?,?,?,?)";
	PreparedStatement ps = conn.prepareStatement(query);
	ps.setString(1, b.getTitle());
	ps.setString(2, b.getPublisher());
	ps.setString(3, b.getAuthor());
	ps.setString(4, b.getBookNumber());
	ps.setString(5, b.getPublishDate());
	ps.setString(6, b.getStatus());
	int i = ps.executeUpdate();
	if(i==1) {
		f = true;
	}
	return f;
}
}
