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
    public ArrayList<Book> findBook(String title) {
        ArrayList<Book> foundBooks = new ArrayList<Book>();
        for (Book book : books) {
            if (book.getTitle().contains(title)) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    public void editBook(String search, String title, String author, int pages){

    }
    public String printBooks(){
        String printString = "";
        for (Book book : books) {
            printString += book.toString()+"\n";
        }
        if (books.isEmpty()) {
            return "The bookshelf is empty";
        }
        return printString;
    }

    public int totalBooks() {
        return books.size();
    }
    @Override
    public String toString() {
        return books.toString();
    }
}
