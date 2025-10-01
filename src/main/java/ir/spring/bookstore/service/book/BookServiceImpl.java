package ir.spring.bookstore.service.book;

import ir.spring.bookstore.dto.request.BookRequest;
import ir.spring.bookstore.dto.response.BookResponse;
import ir.spring.bookstore.exception.RuleException;
import ir.spring.bookstore.model.Book;
import ir.spring.bookstore.repository.BookRepository;
import org.springframework.stereotype.Service;

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
                        return BookResponse.builder().id(savedBook.getId()).name(savedBook.getName()).price(savedBook.getPrice()).build();
                }
                throw new RuleException("bookname_already_exists");
        }


}
