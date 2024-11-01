import java.util.ArrayList;

public class BookShelf {
    private ArrayList<Book> books = new ArrayList<Book>();

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
    }
    public void removeBookFromBookshelf(String title) {
        for (Book book : books) {
            if (book.getTitle().contains(title)) {
                removeBook(book);
                break;
            }
        }
    }
    public void removeBook(Book book) {
        books.remove(book);
    }

    public int totalBooks() {
        return books.size();
    }
    @Override
    public String toString() {
        return books.toString();
    }
}
