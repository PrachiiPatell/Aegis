package com.lms.service;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lms.model.Book;
import com.lms.model.IssuedBook;
import com.lms.model.User;

public class LibraryManagement {
	private Connection connection;
public Scanner scanner=new Scanner(System.in);
    public LibraryManagement() {
    	
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "123");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        users = new ArrayList<>();
        books = new ArrayList<>();
        issuedBooks = new ArrayList<>();
    }

    public void addUser(User user) throws LibraryException {

        String userType = scanner.nextLine();
        
        try {
        	
        	if (userType.equalsIgnoreCase("librarian")) {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM users WHERE user_type = 'librarian'");
                resultSet.next();
                int librarianCount = resultSet.getInt(1);
                if (librarianCount > 0) {
                    throw new LibraryException("A librarian already exists. Only one person can act as a librarian.");
                }
            }

            if (userType.equalsIgnoreCase("member")) {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM users WHERE user_type = 'member' AND subscription_paid = true");
                resultSet.next();
                int subscribedMemberCount = resultSet.getInt(1);
                
                if (subscribedMemberCount < 0) {
                    throw new LibraryException("A member with a paid subscription can access library.");
                }
            }
            PreparedStatement statement = connection.prepareStatement("INSERT INTO users (name, address, user_type) VALUES (?, ?, ?)");
            statement.setString(1, user.getName());
            statement.setString(2, user.getAddress());
            statement.setString(3, user.getUserType());
            statement.executeUpdate();
            
        } catch (SQLException e) {
            throw new LibraryException("Failed to add user: " + e.getMessage());
        }
    }

    public List<User> getUsers() throws LibraryException {
        List<User> users = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
            while (resultSet.next()) {
                User user = new User();
                user.setUser_Id(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setAddress(resultSet.getString("address"));
                user.setUserType(resultSet.getString("user_type"));
                users.add(user);
            }
        } catch (SQLException e) {
            throw new LibraryException("Failed to retrieve users: " + e.getMessage());
        }
        return users;
    }
       
    private List<User> users;

    public User getUserById(int user_Id) {
    	for (User user : users) {
            if (user.getUser_Id() == user_Id) {
                return user;
            }
        }
    	return null;
    }   

    public void addBook(Book book) throws LibraryException {

        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO books (title, author, available) VALUES (?, ?, ?)");
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setBoolean(3, book.isAvailable());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new LibraryException("Failed to add book: " + e.getMessage());
        }
    }

    public List<Book> getBooks() throws LibraryException {
        List<Book> books = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM books");
            while (resultSet.next()) {
                Book book = new Book();
                book.setBook_Id(resultSet.getInt("id"));
                book.setTitle(resultSet.getString("title"));
                book.setAuthor(resultSet.getString("author"));
                book.setAvailable(resultSet.getBoolean("available"));
                books.add(book);
            }
        } catch (SQLException e) {
            throw new LibraryException("Failed to retrieve books: " + e.getMessage());
        }
        return books;
    }
    private List<Book> books;

    public Book getBookById(int bookId) {
        for (Book book : books) {
            if (book.getBook_Id() == bookId) {
                return book;
            }
        }
        return null;
    }
    
    
    public int getIssuedBookCount(User user) throws LibraryException {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT COUNT(*) FROM issued_books WHERE user_id = ?");
            statement.setInt(1, user.getUser_Id());
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return resultSet.getInt(1);
        } catch (SQLException e) {
            throw new LibraryException("Failed to get issued book count: " + e.getMessage());
        }
    }
    
    

    public void issueBook(User user, Book book) throws LibraryException {
        if (user.getUserType().equals("librarian") && book.isAvailable()) {
        	if (user.getUserType().equals("member")) {
                    int issuedBookCount = getIssuedBookCount(user);
                    if (issuedBookCount >= 2) {
                        throw new LibraryException("A member can have only 2 issued books.");
                    }
                } 
        	
                try {
                    PreparedStatement statement = connection.prepareStatement("INSERT INTO issued_books (user_id, book_id, issue_date) VALUES (?, ?, ?)");
                    statement.setInt(1, user.getUser_Id());
                    statement.setInt(2, book.getBook_Id());
                    statement.setDate(3, Date.valueOf(LocalDate.now()));
                    statement.executeUpdate();

                    PreparedStatement updateStatement = connection.prepareStatement("UPDATE books SET available = true WHERE id = ?");
                    updateStatement.setInt(1, book.getBook_Id());
                    updateStatement.executeUpdate();
                } catch (SQLException e) {
                    throw new LibraryException("Failed to issue book: " + e.getMessage());
                }
            } else {
                throw new LibraryException("Book is not available or user is not a librarian.");
            }}
        
    List<IssuedBook> issuedBooks ;

    public IssuedBook getIssuedBookById(int issuedBookId) {

        for (IssuedBook issuedBook : issuedBooks) {
            if (issuedBook.getId() == issuedBookId) {
                return issuedBook;
            }
        }
        
        return null; 
    }

    
    public void returnBook(IssuedBook issuedBook) throws LibraryException {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE issued_books SET return_date = ? WHERE id = ?");
            statement.setDate(1, Date.valueOf(LocalDate.now()));
            statement.setInt(2, issuedBook.getId());
            statement.executeUpdate();

            PreparedStatement updateStatement = connection.prepareStatement("UPDATE books SET available = true WHERE id = ?");
            updateStatement.setInt(1, issuedBook.getBook_Id());
            updateStatement.executeUpdate();
            
            System.out.println("Book returned successfully.");
            
        } catch (SQLException e) {
            throw new LibraryException("Failed to return book: " + e.getMessage());
        }
    }


class LibraryException extends Exception {
    public LibraryException(String message) {
        super(message);
    }
}

}
