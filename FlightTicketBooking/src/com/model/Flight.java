package com.model;

import java.util.Date;

public class Flight {
private int flight_no;
private int capacity;


public int getFlight_no() {
	return flight_no;
}
public void setFlight_no(int flight_no) {
	this.flight_no = flight_no;
}
public int getCapacity() {
	return capacity;
}
public void setCapacity(int capacity) {
	this.capacity = capacity;
}


public Flight(int flight_no, int capacity) {
	super();
	this.flight_no = flight_no;
	this.capacity = capacity;
}

}
