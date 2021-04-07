package pl.miernik.view;

import org.springframework.stereotype.Component;
import pl.miernik.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class MemoryBookService implements BookService {
    private List<Book> books;
    private static Long nextId = 4L;

    public MemoryBookService() {
        books = new ArrayList<>();
        books.add(new Book(1L, "9788328302341", "Clean Code", "Robert C. Martin", "Helion", "programming"));
        books.add(new Book(2L, "9788328365728", "Test-Driven Development", "Kent Beck", "Helion",
                "programming"));
        books.add(new Book(3L, "9788328345768", "Effective Java", "Joshua Bloch", "Helion",
                "programming"));
        books.add(new Book(4L, "9788328331303", "The Pragmatic Programmer", "Andrew Hunt, David Thomas", "Helion",
                "programming"));
    }


    //Get list of books
    @Override
    public List<Book> listBooks() {
        return books;
    }

    //Get book by id
    @Override
    public Optional<Book> getBook(Long id) {
        return books.stream().filter(item -> item.getId().equals(id)).findFirst();
    }

    //Add new book
    @Override
    public void addBook(Book book) {
        book.setId(nextId++);
        books.add(book);

    }

    //Edit book
    @Override
    public Book updateBook(Book book) {
        if (this.getBook(book.getId()).isPresent()) {
            int indexOf = books.indexOf(this.getBook(book.getId()).get());
            books.set(indexOf, book);
        }
        return book;
    }

    //Delete book
    @Override
    public void deleteBook(Long id) {
        if (getBook(id).isPresent()) {
            books.remove(this.getBook(id).get());
        }
    }

    public List<Book> getBooks() {
        return books;
    }

    public MemoryBookService setBooks(List<Book> books) {
        this.books = books;
        return this;
    }

    public static Long getNextId() {
        return nextId;
    }

    public static void setNextId(Long nextId) {
        MemoryBookService.nextId = nextId;
    }

    @Override
    public String toString() {
        return "MemoryBookService{" +
                "list=" + books +
                '}';
    }


}
