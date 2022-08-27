package com.model;

public class Status {
	private long status_id;
	private String statusName;
	private Book book;
	public Status(long status_id, String statusName, Book book) {
		super();
		this.status_id = status_id;
		this.statusName = statusName;
		this.book = book;
	}
	public Status() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getStatus_id() {
		return status_id;
	}
	public void setStatus_id(long status_id) {
		this.status_id = status_id;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	@Override
	public String toString() {
		return "Status [status_id=" + status_id + ", statusName=" + statusName + ", book=" + book + "]";
	}
	
}
