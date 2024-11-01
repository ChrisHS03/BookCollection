import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UI {
    public void startProgram() throws IOException {
        boolean running = true;
        Controller controller = new Controller();
        Scanner scanner = new Scanner(System.in);
        controller.readFile();

        System.out.println("Welcome to your digital book database");

        while(running){
            System.out.println("1: Add a book");
            System.out.println("2: Remove a book");
            System.out.println("3: Edit a book");
            System.out.println("4: See your book database");
            System.out.println("5: Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            //choice = scanner.nextLine();
            switch (choice){
                case 1 -> {
                    System.out.println("Enter the book title");
                    String name = scanner.nextLine();
                    System.out.println("Enter the book author");
                    String author = scanner.nextLine();
                    System.out.println("Enter the number of pages");
                    int pages = scanner.nextInt();
                    controller.addBook(name, author, pages);
                    System.out.println("Book added successfully");
                }
                case 2 -> {
                    System.out.println("Enter the book title, you want to remove");
                    String name = scanner.nextLine();
                    controller.removeBook(name);
                }
                case 3 -> {
                    System.out.println("Enter the title of the book you want to edit");
                    String search = scanner.next();

                    System.out.println("Enter the book title, you want to edit");
                    String title = scanner.next();
                    System.out.println("Enter the book author, you want to edit");
                    String author = scanner.next();
                    System.out.println("Enter the number of pages, you want to edit");
                    int pages = scanner.nextInt();

                    controller.editBook(search, title, author, pages);
                    System.out.println("Book edit went successfully");
                }
                case 4 -> {
                    controller.printBooks();
                }
                case 5 -> {
                    running = false;
                }
            }
        }
    }
}
