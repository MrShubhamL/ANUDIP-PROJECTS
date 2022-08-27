package com.model;

public class Book {
	private long book_id;
	private String title;
	private String publisher;
	private String author;
	private String bookNumber;
	private String publishDate;
	private String bookStatus;
	public Book(long book_id, String title, String publisher, String author, String bookNumber, String publishDate,
			String bookStatus) {
		super();
		this.book_id = book_id;
		this.title = title;
		this.publisher = publisher;
		this.author = author;
		this.bookNumber = bookNumber;
		this.publishDate = publishDate;
		this.bookStatus = bookStatus;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getBook_id() {
		return book_id;
	}
	public void setBook_id(long book_id) {
		this.book_id = book_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getBookNumber() {
		return bookNumber;
	}
	public void setBookNumber(String bookNumber) {
		this.bookNumber = bookNumber;
	}
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	public String getStatus() {
		return bookStatus;
	}
	public void setStatus(String bookStatus) {
		this.bookStatus = bookStatus;
	}
	
	@Override
	public String toString() {
		return "Book [book_id=" + book_id + ", title=" + title + ", publisher=" + publisher + ", author=" + author
				+ ", bookNumber=" + bookNumber + ", publishDate=" + publishDate + ", status=" + bookStatus + "]";
	}
	
	
}
