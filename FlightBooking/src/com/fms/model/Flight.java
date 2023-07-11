package com.fms.model;

import java.util.Date;




public class Flight {
	
	
    private long flight_id;
    private String source;
    private String destination;
    private Date travelDate;

    public Flight(long flight_id, String source, String destination, Date travelDate) {
        this.flight_id = flight_id;
        this.source = source;
        this.destination = destination;
        this.travelDate = travelDate;
    }

    public long getId() {
        return flight_id;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public Date getTravelDate() {
        return travelDate;
    }

	public Flight() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setId(long id) {
		this.flight_id = id;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}
}


