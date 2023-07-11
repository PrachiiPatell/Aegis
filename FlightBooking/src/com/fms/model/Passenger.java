package com.fms.model;


public class Passenger {
	
	private int id;
    private int flightId;
    private String name;
    private int age;
    private String gender;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Passenger(int id, int flightId, String name, int age, String gender) {
		//super();
		this.id = id;
		this.flightId = flightId;
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	public Passenger() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}

