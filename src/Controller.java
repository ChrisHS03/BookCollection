import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Controller {
    private BookShelf bookShelf = new BookShelf();
    private FileHandler fileHandler = new FileHandler();

    public Controller() throws FileNotFoundException {
    }

    public void addBook(String title, String author, int pages) throws IOException {
        Book book = new Book(title, author, pages);
        bookShelf.addBook(book);
        saveFile();
    }
    public void removeBook(String title) throws IOException {
        bookShelf.removeBookFromBookshelf(title);
        saveFile();
    }
    public void saveFile() throws IOException {
        fileHandler.saveFile(bookShelf.getBooks());
    }
    public String printBooks() {
        return bookShelf.printBooks();
    }
    public void readFile() throws FileNotFoundException {
        for (Book book : fileHandler.readFile()){
            bookShelf.addBook(book);
        }
    }

    public ArrayList<Book> findBook(String title){
        return bookShelf.findBook(title);
    }
}
