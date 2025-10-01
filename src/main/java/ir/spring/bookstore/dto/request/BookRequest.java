package ir.spring.bookstore.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BookRequest {
        @NotNull(message = "{book_name_is_null}")
        @NotBlank(message = "{book_name_is_blank}")
        private String name;
        @NotNull(message = "{book_price_is_null}")
        @Min(value = 0, message = "{invalid_price}")
        private double price;
}
