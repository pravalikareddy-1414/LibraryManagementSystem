package LibraryManagementySystem;

public class Main {
    public static void main(String[] args) {
        // Create books
        Book b1 = new Book(1, "Java Basics", "James Gosling", true);
        Book b2 = new Book(2, "Effective Java", "Joshua Bloch", true);
        Book b3 = new Book(3, "Clean Code", "Robert C. Martin", true);
        Book b4 = new Book(4, "Head First Java", "Kathy Sierra", true);

        // Create members
        Memeber m1 = new Memeber(101, "Alice");
        Memeber m2 = new Memeber(102, "Bob");
        Memeber m3 = new Memeber(103, "Charlie");

        // Create library
        Library lib = new Library();

        // Add books
        lib.addBook(b1);
        lib.addBook(b2);
        lib.addBook(b3);
        lib.addBook(b4);

        // Add members
        lib.addMember(m1);
        lib.addMember(m2);
        lib.addMember(m3);

        // List books
        lib.listBook();

        // Borrow book
        lib.borrowBook();

        // List books again to see updated availability
        lib.listBook();
        
        lib.returnBook();
        
        lib.listBook();
    }
}
