package ir.spring.bookstore.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class ShoppingCardResponse {
        private final Long shoppingCardId;
        private final Long facultyId;
}
