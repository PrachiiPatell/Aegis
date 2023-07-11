package com.bs.service;

import java.util.ArrayList;
import java.util.List;

import com.bs.model.Book;
import com.bs.model.Customer;

public class OrderService {
	private Customer customer;
    private List<Book> books;

    public OrderService(Customer customer) {
        this.customer = customer;
        this.books = new ArrayList<>();
    }

    

	public void addBook(Book book) {
        books.add(book);
    }

    public double calculateTotalPrice() {
        double totalPrice = 0;
        for (Book book : books) {
            totalPrice += book.getPrice();
        }
        return totalPrice;
    }

    public void displayOrderDetails() {
        System.out.println("Order details:");
        System.out.println("Customer: " + customer.getName() + " (" + customer.getEmail() + ")");
        System.out.println("Books:");
        for (Book book : books) {
            System.out.println("- " + book.getTitle() + " by " + book.getAuthor());
        }
        System.out.println("Total price: $" + calculateTotalPrice());
    }



	public Customer getCustomer() {
		return customer;
	}

	
}
