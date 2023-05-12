package com.model;

public class Ticket {
private int ticketnumber;
private int passengername;
private int flightno;


public int getTicketnumber() {
	return ticketnumber;
}
public void setTicketnumber(int ticketnumber) {
	this.ticketnumber = ticketnumber;
}
public int getPassengername() {
	return passengername;
}
public void setPassengername(int passengername) {
	this.passengername = passengername;
}
public int getFlightno() {
	return flightno;
}
public void setFlightno(int flightno) {
	this.flightno = flightno;
}


public Ticket(int ticketnumber, int passengername, int flightno) {
	super();
	this.ticketnumber = ticketnumber;
	this.passengername = passengername;
	this.flightno = flightno;
}


}
