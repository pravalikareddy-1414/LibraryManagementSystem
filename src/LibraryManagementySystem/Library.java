package LibraryManagementySystem;

import java.util.ArrayList;

import java.util.stream.*;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Library {

    private List<Book> Books;
    private HashMap<Integer, Memeber> members;

    public Library() {
        Books = new ArrayList<>();
        members = new HashMap<>();
    }

    // Add a book
    public void addBook(Book book) {
        Books.add(book);
        System.out.println(book.getTitle() + " added successfully.");
    }

    // List all books
    public void listBook() {
        System.out.println("Books in Library:");
        for (Book b : Books) {
            System.out.println(b.getId() + " - " + b.getTitle() + " by " + b.getAuthor() + " | Available: " + b.isAvaialable());
        }
    }

    // Add a member
    public void addMember(Memeber member) {
        members.put(member.getId(), member);
        System.out.println(member.getName() + " registered as a member.");
    }

    // Borrow a book
    public void borrowBook() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Book ID: ");
        int bookId = sc.nextInt();

        System.out.print("Enter Member ID: ");
        int memberId = sc.nextInt();

        // Find the book
        Book bookToBorrow = null;
        for (Book b : Books) {
            if (b.getId() == bookId) {
                bookToBorrow = b;
                break;
            }
        }

        if (bookToBorrow == null) {
            System.out.println("Book not found in the library.");
            return;
        }

        if (!bookToBorrow.isAvaialable()) {
            System.out.println("Book is not available.");
            return;
        }

        // Find the member
        Memeber m = members.get(memberId);
        if (m == null) {
            System.out.println("Member not found.");
            return;
        }

        // Update book and member
        bookToBorrow.setAvaialable(false);
        m.getBorrowedBooks().add(bookToBorrow.getTitle());

        System.out.println(m.getName() + " borrowed \"" + bookToBorrow.getTitle() + "\".");
    }
    
    public void returnBook() {
    	Scanner sc = new Scanner(System.in);

        System.out.print("Enter Book ID which is being returned: ");
        int bookId = sc.nextInt();

        System.out.print("Enter Member ID of return person: ");
        int memberId = sc.nextInt();
        
        Book bookreturn = null;
        
        for(Book b: Books)
        {
        	if(b.getId() ==bookId)
        	{
        		bookreturn = b;
        		break;
        	}
        }
        if (bookreturn == null) {
            System.out.println("Book not found in the library.");
            return;
        }
        
        Memeber memeber = members.get(memberId);
        if(memeber == null)
        {
        	System.out.println("Memeber not found");
        	return;
        }
        
        if(memeber.getBorrowedBooks().contains(bookreturn.getTitle())) {
        	memeber.getBorrowedBooks().remove(bookreturn.getTitle());
        	bookreturn.setAvaialable(true);
        	System.out.println(memeber.getName() + " returned " + bookreturn.getTitle());
        }
    	
    }
    
    // *public void searchBookByTitle() {
    	
    	//Scanner sc = new Scanner(System.in);
    	//System.out.println("Enter the book title search");
    	//String Title = sc.next();
    	//boolean found = false;
    	
    	//for(Book b : Books)
    	//{ 
    		//if(b.getTitle().equalsIgnoreCase(Title))
    		//{
    			//System.out.println(" Title of the book " +b.getTitle() 
    			    //  + " Author of the book " + b.getAuthor() + " Availability "  + b.isAvaialable());
    			//found = true;
    		//}
    	//}
    	//if(!found) 
    	//{
    			//System.out.println("Book not found");
    	//}
    		
    	
    	
    //} * //
    
    public void searchBookByTitle(String title) {
    	List<Book> foundBooks = Books.stream()
    			                .filter(b->b.getTitle().equalsIgnoreCase(title))
    			                .collect(Collectors.toList());
    	
    	if(foundBooks.isEmpty())
    	{
    		System.out.println("Book not found");
    	}
    	else {
    		foundBooks.forEach(b->System.out.println(b.getTitle() + " by " 
    		    + b.getAuthor() + " | Available: " + b.isAvaialable()));
    	}
    } 
    
    
    public void searchBookBYAuthor() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter the book Author search");
    	String Author = sc.next();
    	
    	boolean found = false;
    	for(Book b : Books)
    	{
    		if(b.getAuthor().equalsIgnoreCase(Author))
    		{
    			System.out.println(" Title of the book " +b.getTitle() 
			      + " Author of the book " + b.getAuthor() + " Availability "  + b.isAvaialable());
    			found = true;
    			
    		}
    		
    	}
    	if(!found)
    	{
    		System.out.println("No bboks found by this author.");
    	}
    }
    
    public void DisplayBorrowedBooks() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter the book memeber id to search");
    	int memeberId = sc.nextInt();
    	Memeber memeber = members.get( memeberId);
    	if(memeber == null)
        {
        	System.out.println("Memeber not found");
        	return;
        }
         
    	List<String> borrowed = memeber.getBorrowedBooks();
    	
    	if(borrowed.isEmpty())
    	{
    		System.out.println(memeber.getName() + "has bot borrowed any books .");
    		
    	}
    	else {
    		System.out.println(memeber.getName() + " has borrowed:" + borrowed);
    	}
    	
    }
    
    public void AvailableBooks() {
    	 Books.stream()
    	     .filter(b->b.isAvaialable())
    	     .map(Book:: getTitle)
    	     .forEach(System.out::println);  //print each title	
    	
    }
}
