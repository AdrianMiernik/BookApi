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
        books.add(new Book(1L, "9788324631766", "Thiniking	in	Java", "Bruce	Eckel", "Helion", "programming"));
        books.add(new Book(2L, "9788324627738", "Rusz	glowa	Java.", "Sierra	Kathy,	Bates	Bert", "Helion",
                "programming"));
        books.add(new Book(3L, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion",
                "programming"));
    }

    //Pobieranie listy wszystkich książek
    @Override
    public List<Book> listBooks() {
        return books;
    }

    //Pobieranie obiektu po wskazanym identyfikatorze.
    @Override
    public Optional<Book> getBook(Long id) {
        return books.stream().filter(item -> item.getId().equals(id)).findFirst();
    }

    //Tworzenie nowe książki
    @Override
    public void addBook(Book book) {
        book.setId(nextId++);
        books.add(book);

    }

    //Edycje obiektu.
    @Override
    public Book updateBook(Book book) {
        if (this.getBook(book.getId()).isPresent()) {
            int indexOf = books.indexOf(this.getBook(book.getId()).get());
            books.set(indexOf, book);
        }
        return book;
    }

    //Usuwanie obiektu.
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
