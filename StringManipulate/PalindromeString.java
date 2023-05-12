package com.StringManipulate;

import java.util.Scanner;

public class PalindromeString {
public static void main(String[] args) {
	
	Scanner sc=new Scanner(System.in);
	System.out.println("Please Enter Any String:");
	String a=sc.nextLine();
	
	String rev="";
	char arr[]=a.toCharArray();
	
	for(int i=arr.length-1;i>=0;i--) {
		rev=rev+a.charAt(i);
	}
	
	if(a.equals(rev)) {
		System.out.println("String is Palindrome");
	}
	else {
		System.out.println("String is not Palindrome");
	}
}
}
