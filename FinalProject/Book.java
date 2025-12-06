import java.io.Serializable;

public class Book implements Serializable, Comparable<Book> {
    private String title;
    private String author;
    private boolean isRead;

    public Book(String title, String author, boolean isRead) {
        this.title = title;
        this.author = author;
        this.isRead = isRead;
    }

    public Book(String title, String author) {
        this(title, author, false);
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isRead() {
        return isRead;
    }

    public void markRead() {
        this.isRead = true;
    }

    public void markUnread() {
        this.isRead = false;
    }

    @Override
    public String toString() {
        return title + " by " + author + (isRead ? " (Read)" : " (Unread)");
    }

    @Override
    public int compareTo(Book other) {
        return this.getTitle().compareToIgnoreCase(other.getTitle());
    }
}
