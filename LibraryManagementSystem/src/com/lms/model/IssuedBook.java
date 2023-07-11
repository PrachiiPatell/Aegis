package com.lms.model;

import java.time.LocalDate;

public class IssuedBook {
	private int id;
    private int user_Id;
    private int book_Id;
    private LocalDate issueDate;
    private LocalDate returnDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_Id() {
		return user_Id;
	}
	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
	}
	public int getBook_Id() {
		return book_Id;
	}
	public void setBook_Id(int book_Id) {
		this.book_Id = book_Id;
	}
	public void setBookId(int bookId) {
		this.book_Id = bookId;
	}
	public LocalDate getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}
	public LocalDate getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}
	public IssuedBook() {
		super();
		this.id = id;
		this.user_Id = user_Id;
		this.book_Id = book_Id;
		this.issueDate = issueDate;
		this.returnDate = returnDate;
	}
	@Override
	public String toString() {
		return "IssuedBook [id=" + id + ", user_Id=" + user_Id + ", book_Id=" + book_Id + ", issueDate=" + issueDate
				+ ", returnDate=" + returnDate + "]";
	}
    
    
    
}
