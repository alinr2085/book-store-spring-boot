package ir.spring.bookstore.controller;

import ir.spring.bookstore.dto.request.ShoppingCardReqeust;
import ir.spring.bookstore.model.ShoppingCard;
import ir.spring.bookstore.service.shoppingcard.ShoppingCardService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shoppingCard")
public class ShoppingCardController {

        private final ShoppingCardService shoppingCardService;


        public ShoppingCardController(ShoppingCardService shoppingCardService) {
                this.shoppingCardService = shoppingCardService;
        }

        @PostMapping
        public ResponseEntity<?> addShoppingCard(@RequestBody @Valid ShoppingCardReqeust shoppingCardReqeust) {
                return ResponseEntity.ok(shoppingCardService.addShoppingCard(shoppingCardReqeust));
        }
}
