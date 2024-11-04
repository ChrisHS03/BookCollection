import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UI {
    public void startProgram() throws IOException {
        boolean running = true;
        Controller controller = new Controller();
        Scanner scanner = new Scanner(System.in);
        controller.readFile();

        System.out.println("Welcome to your digital book database");

        while (running) {
            System.out.println("1: Add a book");
            System.out.println("2: Remove a book");
            System.out.println("3: Edit a book");
            System.out.println("4: See your book database");
            System.out.println("5: Find book by title");
            System.out.println("6: Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
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
                    String search = scanner.nextLine();
                    int counter = 0;

                    ArrayList<Book> bookArrayList = controller.findBook(search);

                    if (!bookArrayList.isEmpty()){
                        for (Book book : bookArrayList ){
                            counter++;
                            System.out.println(counter + ". " + book);
                        }
                        if (bookArrayList.size()>=2) {
                            System.out.println("Choose a number that is referring to the book you want to edit");
                            int input = scanner.nextInt();
                            scanner.nextLine();
                            Book bookEdit = bookArrayList.get(input-1);

                            System.out.println("Enter the book title, you want to edit");
                            bookEdit.setTitle(scanner.nextLine());
                            System.out.println("Enter the book author, you want to edit");
                            bookEdit.setAuthor(scanner.nextLine());
                            System.out.println("Enter the number of pages, you want to edit");
                            bookEdit.setPages(scanner.nextInt());
                        } else {
                            Book bookEdit = bookArrayList.getFirst();
                            System.out.println("Enter the book title, you want to edit");
                            bookEdit.setTitle(scanner.nextLine());
                            System.out.println("Enter the book author, you want to edit");
                            bookEdit.setAuthor(scanner.nextLine());
                            System.out.println("Enter the number of pages, you want to edit");
                            bookEdit.setPages(scanner.nextInt());
                        }
                    }
                    controller.saveFile();
                }
                case 4 -> {
                    System.out.println(controller.printBooks());
                }
                case 5 -> {
                    System.out.println("Enter the title of the book you want to find");
                    String search = scanner.nextLine();
                    if (!controller.findBook(search).isEmpty()) {
                        for (Book book : controller.findBook(search)) {
                            System.out.println(book);
                        }
                    } else {
                        System.out.println("Book not found");
                    }
                }
                case 6 -> {
                    running = false;
                }
            }
        }
    }
}
