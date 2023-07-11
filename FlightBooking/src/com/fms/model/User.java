package com.fms.model;


public class User {
	
    private int user_id;
    private String username;
    private String password;

    public User(int user_id, String username, String password) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
    }
    
    

    public User() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int getId() {
        return user_id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
