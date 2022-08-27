package com.model;

public class Customer {
	private int custid;
	private String cust_name;
	private String account_type;
	private String address;
	private String state;
	private String city;
	private String pincode;
	private String email;
	private String status;
	private int registration_id;
	public Customer(int custid, String cust_name, String account_type, String address, String state, String city,
			String pincode, String email, String status, int registration_id) {
		this.custid = custid;
		this.cust_name = cust_name;
		this.account_type = account_type;
		this.address = address;
		this.state = state;
		this.city = city;
		this.pincode = pincode;
		this.email = email;
		this.status = status;
		this.registration_id = registration_id;
	}
	public Customer() {
		super();
	}
	public int getCustid() {
		return custid;
	}
	public void setCustid(int custid) {
		this.custid = custid;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public String getAccount_type() {
		return account_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getRegistration() {
		return registration_id;
	}
	public void setRegistration(int registration_id) {
		this.registration_id = registration_id;
	}
	@Override
	public String toString() {
		return "Customer [custid=" + custid + ", cust_name=" + cust_name + ", account_type=" + account_type
				+ ", address=" + address + ", state=" + state + ", city=" + city + ", pincode=" + pincode + ", email="
				+ email + ", status=" + status + ", registration=" + registration_id + "]";
	}
	
}
