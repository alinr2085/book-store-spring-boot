package ir.spring.bookstore.repository;

import ir.spring.bookstore.model.Factor;
import ir.spring.bookstore.model.ShoppingCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactorRepository  extends JpaRepository<Factor, Long> {
}
