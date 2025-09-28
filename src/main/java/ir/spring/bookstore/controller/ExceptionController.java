package ir.spring.bookstore.controller;

import ir.spring.bookstore.dto.response.ExceptionResponse;
import ir.spring.bookstore.exception.RuleException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.*;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionController {

        @ExceptionHandler(RuleException.class)
        public ResponseEntity<List<ExceptionResponse>> handleRuleException(RuleException ex) {
                return ResponseEntity.status(409).body(Collections.singletonList(getRuleExceptionResponse(ex)));
        }

        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<List<ExceptionResponse>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
                return ResponseEntity.status(400).body(getMethodArgumentNotValidExceptionResponse(ex));
        }

        private List<ExceptionResponse> getMethodArgumentNotValidExceptionResponse(MethodArgumentNotValidException ex) {
                return ex.getFieldErrors().stream().map(err -> ExceptionResponse.builder().message(err.getDefaultMessage()).errorType(err.getField()).build()).collect(Collectors.toList());
        }

        private ExceptionResponse getRuleExceptionResponse(RuleException ex) {
                return ExceptionResponse.builder().message(ex.getMessage()).errorType(ex.getMessage()).build();
        }
}
