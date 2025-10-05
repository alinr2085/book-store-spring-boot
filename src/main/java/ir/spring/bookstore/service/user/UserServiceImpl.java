package ir.spring.bookstore.service.user;

import ir.spring.bookstore.dto.request.UserRequest;
import ir.spring.bookstore.dto.response.UserResponse;
import ir.spring.bookstore.exception.RuleException;
import ir.spring.bookstore.model.User;
import ir.spring.bookstore.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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
                throw new RuleException("username_already_exists");
        }

        @Override
        public void login(UserRequest userRequest) {
                User user = userRepository.findByUsername(userRequest.getUsername());
                if (user != null) {
                        if (!user.getPassword().equals(userRequest.getPassword())) {
                                throw new RuleException("wrong_password");
                        } else if (!user.isEnabled()) {
                                throw new RuleException("user_is_disabled");
                        }
                } else {
                        throw new RuleException("user_not_found");
                }
        }

        @Override
        public void changeEnable(Long id, boolean enable) {
                User user = userRepository.findById(id).orElseThrow(() -> new RuleException("user_not_found"));
                user.setEnabled(enable);
                userRepository.save(user);
        }

        @Override
        public Page<User> findAll(Pageable pageable) {
                return userRepository.findAll(pageable);
        }


}
