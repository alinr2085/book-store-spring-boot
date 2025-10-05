package ir.spring.bookstore.repository;

import ir.spring.bookstore.model.ShoppingCard;
import ir.spring.bookstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
        User findByUsername(String username);
}
