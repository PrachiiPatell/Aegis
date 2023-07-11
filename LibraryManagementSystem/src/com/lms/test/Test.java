package com.lms.test;
import java.util.List;
import com.lms.Exception.LibraryException;
import com.lms.model.Book;
import com.lms.model.IssuedBook;
import com.lms.model.User;
import com.lms.service.LibraryManagement;

public class Test {
    public static void main(String[] args) {
        LibraryManagement libraryManagement = new LibraryManagement();
        User user = new User();

        while (true) {
        	
            System.out.println("========= Library Management System =========");
            System.out.println("1. Add User");
            System.out.println("2. Get Users");
            System.out.println("3. Add Book");
            System.out.println("4. Get Books");
            System.out.println("5. Issue Book");
            System.out.println("6. Return Book");
            System.out.println("0. Exit");
            System.out.println("============================================");
            System.out.print("Enter your choice: ");

            int choice = libraryManagement.scanner.nextInt();
            libraryManagement.scanner.nextLine(); // Consume the newline character

            try {
                switch (choice) {
                
                    case 1:
                        System.out.print("Enter name: ");
                        user.setName(libraryManagement.scanner.nextLine());
                        System.out.print("Enter address: ");
                        user.setAddress(libraryManagement.scanner.nextLine());
                        System.out.print("Enter user type (librarian/member): ");
                        user.setUserType(libraryManagement.scanner.nextLine());
                        libraryManagement.addUser(user);
                        System.out.println("User Added Successfully.");
                        break;
                        
                    case 2:
                        List<User> users = libraryManagement.getUsers();
                        System.out.println("Users:");
                        for (User user1 : users) {
                            System.out.println(user1);
                        }
                        break;
                        
                    case 3:
                        Book book = new Book();
                        System.out.print("Enter book title: ");
                        book.setTitle(libraryManagement.scanner.nextLine());
                        System.out.print("Enter book author: ");
                        book.setAuthor(libraryManagement.scanner.nextLine());
                        libraryManagement.addBook(book);
                        System.out.println("Book Added Successfully.");
                        break;
                        
                    case 4:
                        List<Book> books = libraryManagement.getBooks();
                        System.out.println("Books:");
                        for (Book book1 : books) {
                            System.out.println(book1);
                        }
                        break;
                        
                    case 5:
                        System.out.print("Enter user ID: ");
                        int user_Id = libraryManagement.scanner.nextInt();
                        System.out.print("Enter book ID: ");
                        int book_Id = libraryManagement.scanner.nextInt();
                        System.out.print("Enter user type (librarian/member): ");
                       user.setUserType(libraryManagement.scanner.nextLine());
                       libraryManagement.issueBook(new User(), new Book());
                        break;
                        
                    case 6:

                    	System.out.print("Enter issued book ID: ");
                        int issuedBookId = libraryManagement.scanner.nextInt();
                        libraryManagement.scanner.nextLine(); // Consume the newline character
                        IssuedBook issuedBook = libraryManagement.getIssuedBookById(issuedBookId);
                        libraryManagement.returnBook(issuedBook);
                        
                        break;
                        
                    case 0:
                        System.out.println("Exiting Library Management System...");
                        System.exit(0);
                        
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }
}







