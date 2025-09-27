package ir.spring.bookstore.repository;

import ir.spring.bookstore.model.ShoppingCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCardRepository extends JpaRepository<ShoppingCard, Long> {
}
