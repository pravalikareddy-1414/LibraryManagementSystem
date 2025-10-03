package LibraryManagementySystem;

import java.util.ArrayList;
import java.util.List;

public class Memeber {
    private int id;
    private String name;
    private List<String> borrowedBooks;

    // Constructor
    public Memeber(int id, String name) {
        this.id = id;
        this.name = name;
        borrowedBooks = new ArrayList<>();
    }

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<String> getBorrowedBooks() { return borrowedBooks; }
    public void setBorrowedBooks(List<String> borrowedBooks) { this.borrowedBooks = borrowedBooks; }
}

