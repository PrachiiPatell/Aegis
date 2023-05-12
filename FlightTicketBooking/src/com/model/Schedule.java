package com.model;

import java.util.Date;

public class Schedule {
	private String origin;
	private String destination;
	private Date departuredate;
	private Date arrivaldate;
    private Flight flight;
    
    
public String getOrigin() {
	return origin;
}
public void setOrigin(String origin) {
	this.origin = origin;
}
public String getDestination() {
	return destination;
}
public void setDestination(String destination) {
	this.destination = destination;
}
public Date getDeparturedate() {
	return departuredate;
}
public void setDeparturedate(Date departuredate) {
	this.departuredate = departuredate;
}
public Date getArrivaldate() {
	return arrivaldate;
}
public void setArrivaldate(Date arrivaldate) {
	this.arrivaldate = arrivaldate;
}
public Flight getFlight() {
	return flight;
}
public void setFlight(Flight flight) {
	this.flight = flight;
}


public Schedule(String origin, String destination, Date departuredate, Date arrivaldate, Flight flight) {
	super();
	this.origin = origin;
	this.destination = destination;
	this.departuredate = departuredate;
	this.arrivaldate = arrivaldate;
	this.flight = flight;
}

}
