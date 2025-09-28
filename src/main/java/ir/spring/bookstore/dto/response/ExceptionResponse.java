package ir.spring.bookstore.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class ExceptionResponse {

        private String message;
        private String errorType;
}
