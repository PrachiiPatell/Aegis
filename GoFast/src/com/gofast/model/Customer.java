package com.gofast.model;

public class Customer {
	private int customerId;
    private String name;
    private String address;
    private String contactNumber;
    
    
		public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

		public String getName() {
		return name;
	}
		
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	
	public Customer(String name, String address, String contactNumber) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.address = address;
		this.contactNumber = contactNumber;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", address=" + address + ", contactNumber="
				+ contactNumber + "]";
	}
	
    
    
}
