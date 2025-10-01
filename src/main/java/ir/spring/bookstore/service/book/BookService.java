package ir.spring.bookstore.service.book;

import ir.spring.bookstore.dto.request.BookRequest;
import ir.spring.bookstore.dto.response.BookResponse;
import ir.spring.bookstore.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {
        BookResponse save(BookRequest bookRequest);

        Page<BookResponse> findAll(Pageable pageable);

        List<BookResponse> findByName(String name);

        BookResponse findById(Long id);

        void deleteById(Long id);
}
