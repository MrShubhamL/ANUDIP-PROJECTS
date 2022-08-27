package com.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.model.Student;

public class StudentController {
	public Connection conn;

	public StudentController(Connection conn) {
		super();
		this.conn = conn;
	}
	

	public boolean createStudent(Student s) throws Throwable {
		boolean f = false;
		String query = "insert into student (fname,lname,gender,age,address,email,password)"
				+ " values (?,?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, s.getFname());
		ps.setString(2, s.getLname());
		ps.setString(3, s.getGender());
		ps.setInt(4, s.getAge());
		ps.setString(5, s.getAddress());
		ps.setString(6, s.getEmail());
		ps.setString(7, s.getPassword());
		int i = ps.executeUpdate();
		if(i == 1) {
			f = true;
		}
		return f;
	}
	
	public Student login(String username, String password) throws Throwable {
		Student st = null;
		String query = "select * from student where email = ? and password = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, username);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			st = new Student();
			st.setFname(rs.getString(2));
			st.setLname(rs.getString(3));
			st.setGender(rs.getString(4));
			st.setAge(rs.getInt(5));
			st.setAddress(rs.getString(6));
			st.setEmail(rs.getString(7));
		}
		return st;
	}
	
}
