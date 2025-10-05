package ir.spring.bookstore.service.user;

import java.util.List;

import ir.spring.bookstore.dto.request.UserRequest;
import ir.spring.bookstore.dto.response.UserResponse;
import ir.spring.bookstore.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
        UserResponse save(UserRequest userRequest);

        void login(UserRequest userRequest);

        void changeEnable(Long id, boolean enable);

        Page<User> findAll(Pageable pageable);

}
