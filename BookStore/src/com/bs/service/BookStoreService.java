package com.bs.service;

import java.util.ArrayList;
import java.util.List;

import com.bs.exception.BookNotFoundException;
import com.bs.model.Book;
import com.bs.model.Customer;

public class BookStoreService {
	private List<Book> books;
    private List<OrderService> orders;

    public BookStoreService() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void placeOrder(Customer customer, List<Book> books) {
        OrderService order = new OrderService(customer);
        for (Book book : books) {
            order.addBook(book);
        }
        order.displayOrderDetails();
}
    public Book findBookByTitle(String title) throws BookNotFoundException {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        
        throw new BookNotFoundException("Book not found in the bookstore: " + title);
    }
    public double calculateTotalPriceForCustomer(String customerEmail) {
        double totalPrice = 0;
        for (OrderService order : orders) {
            if (order.getCustomer().getEmail().equalsIgnoreCase(customerEmail)) {
                totalPrice += order.calculateTotalPrice();
            }
        }
        return totalPrice;
    }
    
}