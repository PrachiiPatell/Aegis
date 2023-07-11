package com.fms.model;


public class Ticket {
	
    private int id;
    private int flightId;
    private String passengerName;
    private int passengerAge;
    private String passengerGender;

    public Ticket(int id, int flightId, String passengerName, int passengerAge, String passengerGender) {
        this.id = id;
        this.flightId = flightId;
        this.passengerName = passengerName;
        this.passengerAge = passengerAge;
        this.passengerGender = passengerGender;
    }

    public int getId() {
        return id;
    }

    public int getFlightId() {
        return flightId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public int getPassengerAge() {
        return passengerAge;
    }

    public String getPassengerGender() {
        return passengerGender;
    }

	public void setId(int id) {
		this.id = id;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public void setPassengerAge(int passengerAge) {
		this.passengerAge = passengerAge;
	}

	public void setPassengerGender(String passengerGender) {
		this.passengerGender = passengerGender;
	}

	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}
}

