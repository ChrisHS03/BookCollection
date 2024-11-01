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
        saveFile(bookShelf.getBooks());
    }
    public void removeBook(String title) throws IOException {
        bookShelf.removeBookFromBookshelf(title);
        saveFile(bookShelf.getBooks());
    }
    public void editBook(String search, String title, String author, int pages) throws IOException {
        for (Book book : bookShelf.getBooks()) {
            if (book.getTitle().equals(search)) {
                book.setTitle(title);
                book.setAuthor(author);
                book.setPages(pages);
            }
        }
        saveFile(bookShelf.getBooks());
    }
    public void printBooks() {
        for (Book book : bookShelf.getBooks()) {
            System.out.println(book);
        }
        if (bookShelf.getBooks().isEmpty()) {
            System.out.println("The bookshelf is empty");
        }
    }
    public void readFile() throws FileNotFoundException {
        for (Book book : fileHandler.readFile()){
            bookShelf.addBook(book);
        }
    }
    public void saveFile(ArrayList<Book> books) throws IOException {
        fileHandler.saveFile(books);
    }
}
