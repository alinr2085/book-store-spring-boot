package ir.spring.bookstore.service.book;

import ir.spring.bookstore.dto.request.BookRequest;
import ir.spring.bookstore.dto.response.BookResponse;
import ir.spring.bookstore.exception.RuleException;
import ir.spring.bookstore.model.Book;
import ir.spring.bookstore.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

        private final BookRepository bookRepository;

        public BookServiceImpl(BookRepository bookRepository) {
                this.bookRepository = bookRepository;
        }

        @Override
        public BookResponse save(BookRequest bookRequest) {
                if (bookRepository.findByName(bookRequest.getName()) == null) {
                        Book book = Book.builder().name(bookRequest.getName()).price(bookRequest.getPrice()).build();
                        Book savedBook = bookRepository.save(book);
                        bookRepository.save(savedBook);
                        return bookMapToBookResponse(savedBook);
                }
                throw new RuleException("bookname_already_exists");
        }

        @Override
        public Page<BookResponse> findAll(Pageable pageable) {
                return bookRepository.findAll(pageable).map(this::bookMapToBookResponse);
        }

        public List<BookResponse> findByName(String name) {
                return bookRepository.findByNameContains(name).stream().map(this::bookMapToBookResponse).collect(Collectors.toList());
        }

        @Override
        public BookResponse findById(Long id) {
                return bookMapToBookResponse(findBookById(id));
        }

        private Book findBookById(Long id) {
                return bookRepository.findById(id).orElseThrow(() -> new RuleException("bookid_not_found"));
        }

        @Override
        @Transactional
        public void deleteById(Long id) {
                bookRepository.delete(findBookById(id));
        }

        private BookResponse bookMapToBookResponse(Book book) {
                return BookResponse.builder().id(book.getId()).name(book.getName()).price(book.getPrice()).build();
        }


}
