package ir.spring.bookstore.service.user;

import ir.spring.bookstore.dto.request.UserRequest;
import ir.spring.bookstore.dto.response.UserResponse;
import ir.spring.bookstore.exception.RuleException;
import ir.spring.bookstore.model.User;
import ir.spring.bookstore.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

        private final UserRepository userRepository;

        public UserServiceImpl(UserRepository userRepository) {
                this.userRepository = userRepository;
        }

        @Override
        public UserResponse save(UserRequest userRequest) {
                if (userRepository.findByUsername(userRequest.getUsername()) == null) {
                        User user = User.builder().username(userRequest.getUsername()).password(userRequest.getPassword()).build();
                        User saved = userRepository.save(user);
                        return UserResponse.builder().id(saved.getId()).username(saved.getUsername()).build();
                }
                throw new RuleException("username_already_exist");
        }

        @Override
        public User findByUsername(String username) {
                return userRepository.findByUsername(username);
        }
}
