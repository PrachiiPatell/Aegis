package com.service;

import java.util.HashMap;

import java.util.LinkedHashSet;
import java.util.Map;

import com.model.User;
import com.model.Login;
import com.test.UserTest;

public class UserService {
//public UserService(String name, String email, String password, double contact_no) {
//		super(name, email, password, contact_no);
//			}

private Map<String,User> userCredentials=new HashMap<String,User>();

public void registerUser(String name, String email, String password, String contact_no) {
	User user = new User(name,email,password,contact_no);
    //userCredentials.put(User.getName(),User);
	userCredentials.put(name,user);
	userCredentials.put(email,user);
	userCredentials.put(password,user);
	userCredentials.put(contact_no,user);
    System.out.println("Registration successful. Please login to continue.");
}
//private LinkedHashSet<Login> userlogin=new LinkedHashSet<Login>();
public boolean loginUser(String email, String password) {
    if (userCredentials.containsKey(email) && userCredentials.get(email).equals(password)) {
        System.out.println("Login successful. Welcome, " + email + "!");
        return true;
    } else {
        System.out.println("Invalid username or password. Please try again.");
        return false;
    }


}
}
