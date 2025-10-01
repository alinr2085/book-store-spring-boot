package ir.spring.bookstore.controller;

import ir.spring.bookstore.dto.request.BookRequest;
import ir.spring.bookstore.dto.response.BookResponse;
import ir.spring.bookstore.service.book.BookService;
import ir.spring.bookstore.service.book.BookServiceImpl;
import ir.spring.bookstore.service.user.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {
        private final BookService bookService;

        public BookController(BookService bookService) {
                this.bookService = bookService;
        }

        @PostMapping
        public ResponseEntity<BookResponse> addAndSaveBook(@RequestBody @Valid BookRequest bookRequest) {
                return ResponseEntity.ok(bookService.save(bookRequest));
        }
}
