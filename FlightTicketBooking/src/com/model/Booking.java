package com.model;

public class Booking {
private String passengername;
private String passengeremail;
private int passengermobileno;


public String getPassengername() {
	return passengername;
}
public void setPassengername(String passengername) {
	this.passengername = passengername;
}
public String getPassengeremail() {
	return passengeremail;
}
public void setPassengeremail(String passengeremail) {
	this.passengeremail = passengeremail;
}
public int getPassengermobileno() {
	return passengermobileno;
}
public void setPassengermobileno(int passengermobileno) {
	this.passengermobileno = passengermobileno;
}


public Booking(String passengername, String passengeremail, int passengermobileno) {
	super();
	this.passengername = passengername;
	this.passengeremail = passengeremail;
	this.passengermobileno = passengermobileno;
}


}
