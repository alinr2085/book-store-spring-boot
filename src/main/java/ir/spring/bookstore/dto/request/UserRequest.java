package ir.spring.bookstore.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserRequest {
        @NotNull
        @NotEmpty
        private final String username;
        @NotNull
        @NotEmpty
        private final String password;
}
