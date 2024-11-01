import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    File file = new File("Bookshelf.txt");
    Scanner scanner = new Scanner(file);

    public FileHandler() throws FileNotFoundException {
    }

    public ArrayList<Book> readFile() throws FileNotFoundException {
        ArrayList<Book> books = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] words = line.split(",");
            String title = words[0];
            String author = words[1];
            int pages = Integer.parseInt(words[2]);
            books.add(new Book(title, author, pages));
        }
        return books;
    }

    public void saveFile(ArrayList<Book> books) throws IOException {
        FileWriter fileWriter = new FileWriter("Bookshelf.txt");
        for (Book book : books) {
            fileWriter.write(book.getTitle() + "," + book.getAuthor() + "," + book.getPages() + "\n");
        }
        fileWriter.close();
    }
}
