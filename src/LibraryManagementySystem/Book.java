package LibraryManagementySystem;


public class Book {
    private int id;
    private String title;
    private String author;
    private boolean isAvaialable;

    public Book() {}

    public Book(int id, String title, String author, boolean isAvailable) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isAvaialable = isAvailable;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public boolean isAvaialable() { return isAvaialable; }
    public void setAvaialable(boolean isAvaialable) { this.isAvaialable = isAvaialable; }
}
