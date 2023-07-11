package com.lms.model;

public class Book {
	private int book_Id;
    private String title;
    private String author;
    private boolean available;
	
    public int getBook_Id() {
		return book_Id;
	}

	public void setBook_Id(int book_Id) {
		this.book_Id = book_Id;
	}

	public String getTitle() {
		return title;
	}
    
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public Book() {
		super();
		this.book_Id = book_Id;
		this.title = title;
		this.author = author;
		this.available = true;
	}

	@Override
	public String toString() {
		return "Book [book_Id=" + book_Id + ", title=" + title + ", author=" + author + ", available=" + available
				+ "]";
	}
    
    
}
