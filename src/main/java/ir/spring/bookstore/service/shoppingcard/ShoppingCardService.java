package ir.spring.bookstore.service.shoppingcard;

import ir.spring.bookstore.dto.request.ShoppingCardReqeust;
import ir.spring.bookstore.dto.response.ShoppingCardResponse;
import ir.spring.bookstore.model.ShoppingCard;

public interface ShoppingCardService {
        ShoppingCardResponse addShoppingCard(ShoppingCardReqeust shoppingCardReqeust);
}
