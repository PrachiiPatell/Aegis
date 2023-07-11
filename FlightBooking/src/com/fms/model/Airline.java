package com.fms.model;

public class Airline {
	
private long airline_id;
private String airline_name;
public long getAirline_id() {
	return airline_id;
}
public void setAirline_id(long airline_id) {
	this.airline_id = airline_id;
}
public String getAirline_name() {
	return airline_name;
}
public void setAirline_name(String airline_name) {
	this.airline_name = airline_name;
}
public Airline(long airline_id, String airline_name) {
	super();
	this.airline_id = airline_id;
	this.airline_name = airline_name;
}
public Airline() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Airline [airline_id=" + airline_id + ", airline_name=" + airline_name + "]";
}




}
