package ir.spring.bookstore.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserRequest {
        @NotNull(message = "username is null")
        @NotEmpty(message = "username is empty")
        private final String username;
        @NotNull(message = "password is null")
        @NotEmpty(message = "password is empty")
        private final String password;
}
