package pl.miernik.view;

import pl.miernik.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> listBooks();

    Optional<Book> getBook(Long id);

    void addBook(Book book);

    Book updateBook(Book book);

    void deleteBook(Long id);

}
