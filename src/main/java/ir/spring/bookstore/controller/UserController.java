package ir.spring.bookstore.controller;

import ir.spring.bookstore.dto.request.UserRequest;
import ir.spring.bookstore.dto.response.UserResponse;
import ir.spring.bookstore.model.User;
import ir.spring.bookstore.service.user.UserService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

        private final UserService userService;

        public UserController(UserService userService) {
                this.userService = userService;
        }

        @PostMapping
        public ResponseEntity<UserResponse> signupAndSave(@RequestBody @Valid UserRequest userRequest) {
                return ResponseEntity.ok(userService.save(userRequest));
        }

        @GetMapping("/login")
        public ResponseEntity<?> login(@RequestBody @Valid UserRequest userRequest) {
                userService.login(userRequest);
                return ResponseEntity.ok().build();
        }

        @PutMapping("/enabled/{id}/{enable}")
        public ResponseEntity<?> setEnable(@PathVariable Long id, @PathVariable boolean enable) {
                userService.changeEnable(id, enable);
                return ResponseEntity.ok().build();
        }

        @GetMapping
        public ResponseEntity<Page<User>> getAllUsers(Pageable pageable) {
                return ResponseEntity.ok(userService.findAll(pageable));
        }
}
