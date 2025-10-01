package ir.spring.bookstore.repository;

import ir.spring.bookstore.model.Factor;
import ir.spring.bookstore.model.ShoppingCard;
import ir.spring.bookstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FactorRepository extends JpaRepository<Factor, Long> {
        Optional<Factor> findByUserAndPayed(User user, boolean payed);
}
