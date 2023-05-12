package com.model;

public class Passenger {
private String passengername;
private int passengerage;
private String passengeremail;
private int passengermobileno;


public String getPassengername() {
	return passengername;
}
public void setPassengername(String passengername) {
	this.passengername = passengername;
}
public int getPassengerage() {
	return passengerage;
}
public void setPassengerage(int passengerage) {
	this.passengerage = passengerage;
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


public Passenger(String passengername, int passengerage, String passengeremail, int passengermobileno) {
	super();
	this.passengername = passengername;
	this.passengerage = passengerage;
	this.passengeremail = passengeremail;
	this.passengermobileno = passengermobileno;
}



}
