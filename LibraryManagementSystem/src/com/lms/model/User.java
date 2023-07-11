package com.lms.model;

public class User {
	private int user_Id;
    private String name;
    private String address;
    private String userType;
    
    
		public int getUser_Id() {
		return user_Id;
	}
	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
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
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public User() {
		super();
		this.user_Id = user_Id;
		this.name = name;
		this.address = address;
		this.userType = userType;
	}
	@Override
	public String toString() {
		return "User [user_Id=" + user_Id + ", name=" + name + ", address=" + address + ", userType=" + userType + "]";
	}
    
    
}
