package ir.spring.bookstore.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserRequest {
        @NotNull(message = "{usernameـisـnull}")
        @NotEmpty(message = "{usernameـisـempty}")
        private final String username;
        @NotNull(message = "{passwordـisـnull}")
        @NotEmpty(message = "{passwordـisـempty}")
        private final String password;
}
