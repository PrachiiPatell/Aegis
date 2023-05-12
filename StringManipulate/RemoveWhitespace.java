package com.StringManipulate;

import java.util.Scanner;

public class RemoveWhitespace {
public static void main(String[] args) {
	
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter any String:");
	String str=sc.nextLine();
	
	str=str.replaceAll("\\s","");
	System.out.println(str);
}
}
