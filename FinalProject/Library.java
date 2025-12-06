import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Library {
    private ArrayList<Book> collection;
    private final String FILE_NAME = "books.txt";

    public Library() {
        this.collection = new ArrayList<>();
        loadFromFile();  // Load books automatically
    }

    public void addBook(String title, String author) {
        collection.add(new Book(title, author));
        Collections.sort(collection); // Sort alphabetically
        saveToFile();
        System.out.println("Book added!");
    }

    public void removeBook(String title) {
        for (int i = 0; i < collection.size(); i++) {
            if (collection.get(i).getTitle().equalsIgnoreCase(title)) {
                collection.remove(i);
                saveToFile();
                System.out.println("Book removed!");
                return;
            }
        }
        System.out.println("No book found with that title.");
    }

    public void listBooks() {
        if (collection.isEmpty()) {
            System.out.println("Your library is empty.");
            return;
        }

        Collections.sort(collection);

        System.out.println("\nYour Books:");
        for (Book book : collection) {
            System.out.println(" - " + book);
        }
    }

    public void search(String keyword) {
        boolean found = false;
        for (Book book : collection) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                book.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println("Found: " + book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books matched your search.");
        }
    }

    public void markBookRead(String title) {
        for (Book book : collection) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.markRead();
                saveToFile();
                System.out.println("Marked as read.");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void markBookUnread(String title) {
        for (Book book : collection) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.markUnread();
                saveToFile();
                System.out.println("Marked as unread.");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    private void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Book book : collection) {
                writer.println(
                        book.getTitle() + ";" +
                        book.getAuthor() + ";" +
                        book.isRead()
                );
            }
        } catch (IOException e) {
            System.out.println("Error saving library: " + e.getMessage());
        }
    }

    private void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return; 

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");

                if (parts.length == 3) {
                    String title = parts[0];
                    String author = parts[1];
                    boolean isRead = Boolean.parseBoolean(parts[2]);

                    collection.add(new Book(title, author, isRead));
                }
            }

        } catch (IOException e) {
            System.out.println("Error loading library: " + e.getMessage());
        }
    }
}
