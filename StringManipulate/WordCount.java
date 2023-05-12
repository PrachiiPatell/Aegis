package com.StringManipulate;

import java.util.Scanner;

public class WordCount {
public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
System.out.println("Enter String:");
String str=sc.nextLine();

char arr[]=str.toCharArray();

System.out.println("Number of Words:" + arr.length);
}
}
