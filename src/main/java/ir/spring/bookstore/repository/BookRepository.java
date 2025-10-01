package ir.spring.bookstore.repository;

import java.util.List;
import ir.spring.bookstore.model.Book;
import ir.spring.bookstore.model.ShoppingCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository  extends JpaRepository<Book, Long> {
        Book findByName(String name);

        @Query("select b from Book b where b.name like concat('%', :name, '%')")
        List<Book> findByNameContains(String name);
}
