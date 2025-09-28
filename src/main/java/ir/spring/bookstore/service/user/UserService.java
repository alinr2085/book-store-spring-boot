package ir.spring.bookstore.service.user;

import ir.spring.bookstore.dto.request.UserRequest;
import ir.spring.bookstore.dto.response.UserResponse;
import ir.spring.bookstore.model.User;

public interface UserService {
        UserResponse save(UserRequest userRequest);
        User findByUsername(String username);

}
