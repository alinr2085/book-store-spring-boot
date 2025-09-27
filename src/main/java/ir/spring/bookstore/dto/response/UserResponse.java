package ir.spring.bookstore.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserResponse {
        private final Long id;
        private final String username;
}
