package ir.spring.bookstore.service.book;

import ir.spring.bookstore.dto.request.BookRequest;
import ir.spring.bookstore.dto.response.BookResponse;
import ir.spring.bookstore.model.Book;

public interface BookService {
        BookResponse save(BookRequest bookRequest);
}
