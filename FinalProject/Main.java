import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Library library = new Library(); // Loads saved books automatically

        while (true) {
            System.out.println("\n--- Personal Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. List All Books");
            System.out.println("4. Search Books");
            System.out.println("5. Mark Book as Read");
            System.out.println("6. Mark Book as Unread");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            String choice = input.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter title: ");
                    String title = input.nextLine();

                    System.out.print("Enter author: ");
                    String author = input.nextLine();

                    library.addBook(title, author);
                    break;

                case "2":
                    System.out.print("Enter title to remove: ");
                    library.removeBook(input.nextLine());
                    break;

                case "3":
                    library.listBooks();
                    break;

                case "4":
                    System.out.print("Enter keyword: ");
                    library.search(input.nextLine());
                    break;

                case "5":
                    System.out.print("Enter title to mark read: ");
                    library.markBookRead(input.nextLine());
                    break;

                case "6":
                    System.out.print("Enter title to mark unread: ");
                    library.markBookUnread(input.nextLine());
                    break;

                case "7":
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
