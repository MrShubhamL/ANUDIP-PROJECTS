package com.model;

public class Student {
	private long stud_id;
	private String fname;
	private String lname;
	private String gender;
	private int age;
	private String address;
	private String email;
	private String password;
	public Student(long stud_id, String fname, String lname, String gender, int age, String address, String email,
			String password) {
		super();
		this.stud_id = stud_id;
		this.fname = fname;
		this.lname = lname;
		this.gender = gender;
		this.age = age;
		this.address = address;
		this.email = email;
		this.password = password;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getStud_id() {
		return stud_id;
	}
	public void setStud_id(long stud_id) {
		this.stud_id = stud_id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Student [stud_id=" + stud_id + ", fname=" + fname + ", lname=" + lname + ", gender=" + gender + ", age="
				+ age + ", address=" + address + ", email=" + email + ", password=" + password + "]";
	}
	
	

}
