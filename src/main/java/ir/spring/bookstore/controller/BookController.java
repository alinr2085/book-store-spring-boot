package ir.spring.bookstore.controller;

import java.util.List;

import ir.spring.bookstore.dto.request.BookRequest;
import ir.spring.bookstore.dto.response.BookResponse;
import ir.spring.bookstore.service.book.BookService;
import ir.spring.bookstore.service.book.BookServiceImpl;
import ir.spring.bookstore.service.user.UserService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

        @GetMapping("/getAll")
        public ResponseEntity<Page<BookResponse>> getAllBook(Pageable pageable) {
                return ResponseEntity.ok(bookService.findAll(pageable));
        }

        @GetMapping("/{name}")
        public ResponseEntity<List<BookResponse>> findByName(@PathVariable String name) {
                return ResponseEntity.ok(bookService.findByName(name));
        }
}
