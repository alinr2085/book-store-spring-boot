package ir.spring.bookstore.repository;

import ir.spring.bookstore.model.Book;
import ir.spring.bookstore.model.ShoppingCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository  extends JpaRepository<Book, Long> {
        Book findByName(String name);
}
