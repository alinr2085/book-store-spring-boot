package ir.spring.bookstore.service.user;

import ir.spring.bookstore.dto.response.UserResponse;
import ir.spring.bookstore.model.User;

public interface UserService {
        UserResponse save(User user);
        User findByUsername(String username);

}
