package com.model;

public class MeterConnection {
	private int conn_id;
	private String meter_type;
	private String meter_Number;
	private float unit;
	private int cust_id;
	public MeterConnection(int conn_id, String meter_type, String meter_Number, float unit, int cust_id) {
		super();
		this.conn_id = conn_id;
		this.meter_type = meter_type;
		this.meter_Number = meter_Number;
		this.unit = unit;
		this.cust_id = cust_id;
	}
	public MeterConnection() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getConn_id() {
		return conn_id;
	}
	public void setConn_id(int conn_id) {
		this.conn_id = conn_id;
	}
	public String getMeter_type() {
		return meter_type;
	}
	public void setMeter_type(String meter_type) {
		this.meter_type = meter_type;
	}
	public String getMeter_Number() {
		return meter_Number;
	}
	public void setMeter_Number(String meter_Number) {
		this.meter_Number = meter_Number;
	}
	public float getUnit() {
		return unit;
	}
	public void setUnit(float unit) {
		this.unit = unit;
	}
	public int getCust_id() {
		return cust_id;
	}
	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}
	@Override
	public String toString() {
		return "Connection [conn_id=" + conn_id + ", meter_type=" + meter_type + ", meter_Number=" + meter_Number
				+ ", unit=" + unit + ", cust_id=" + cust_id + "]";
	}
	
}
