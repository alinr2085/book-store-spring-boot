package ir.spring.bookstore.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ShoppingCardReqeust {
        @NotNull(message = "userid_is_null")
        private Long user_id;
        @NotNull(message = "bookid_is_null")
        private Long book_id;
        @NotNull(message = "countid_is_null")
        @Min(value = 1, message = "invalid_count")
        private Integer count;
}
