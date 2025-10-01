package ir.spring.bookstore.service.shoppingcard;

import ir.spring.bookstore.dto.request.ShoppingCardReqeust;
import ir.spring.bookstore.dto.response.ShoppingCardResponse;
import ir.spring.bookstore.exception.RuleException;
import ir.spring.bookstore.model.Book;
import ir.spring.bookstore.model.Factor;
import ir.spring.bookstore.model.ShoppingCard;
import ir.spring.bookstore.model.User;
import ir.spring.bookstore.repository.BookRepository;
import ir.spring.bookstore.repository.FactorRepository;
import ir.spring.bookstore.repository.ShoppingCardRepository;
import ir.spring.bookstore.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ShoppingCardServiceImpl implements ShoppingCardService {

        private final ShoppingCardRepository shoppingCardRepository;
        private final FactorRepository factorRepository;
        private final UserRepository userRepository;
        private final BookRepository bookRepository;

        public ShoppingCardServiceImpl(ShoppingCardRepository shoppingCardRepository,
                                       FactorRepository factorRepository, UserRepository userRepository, BookRepository bookRepository) {
                this.shoppingCardRepository = shoppingCardRepository;
                this.factorRepository = factorRepository;
                this.userRepository = userRepository;
                this.bookRepository = bookRepository;
        }

        @Override
        @Transactional
        public ShoppingCardResponse addShoppingCard(ShoppingCardReqeust shoppingCardReqeust) {
                User user = userRepository.findById(shoppingCardReqeust.getUser_id()).
                        orElseThrow(() -> new RuleException("user_not_found"));
                Book book = bookRepository.findById(shoppingCardReqeust.getBook_id()).
                        orElseThrow(() -> new RuleException("book_not_found"));
                Optional<Factor> userPayed = factorRepository.findByUserAndPayed(user, false);
                Factor factor = userPayed.orElseGet(() -> createFactor(user));
                factorRepository.save(factor);
                ShoppingCard shoppingCard = createShoppingCard(shoppingCardReqeust, book, factor);
                return createShoppingCardResponse(shoppingCardRepository.save(shoppingCard), factor);

        }

        private ShoppingCard createShoppingCard(ShoppingCardReqeust shoppingCardReqeust, Book book, Factor factor) {
                return ShoppingCard.builder().book(book).factor(factor).count(shoppingCardReqeust.getCount()).build();
        }

        private Factor createFactor(User user) {
                return Factor.builder().user(user).build();
        }

        private ShoppingCardResponse createShoppingCardResponse(ShoppingCard shoppingCard, Factor factor) {
                return ShoppingCardResponse.builder().shoppingCardId(shoppingCard.getId()).facultyId(factor.getId()).build();
        }


}
