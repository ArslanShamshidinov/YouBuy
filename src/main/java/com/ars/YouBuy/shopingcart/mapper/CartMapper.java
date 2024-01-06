package com.ars.YouBuy.shopingcart.mapper;

import com.ars.YouBuy.shopingcart.rest.dto.dto.CartResponse;
import com.ars.YouBuy.shopingcart.entity.Cart;
import com.ars.YouBuy.shopingcart.model.CartModel;
import org.springframework.stereotype.Component;

@Component()
public class CartMapper {
    public CartModel entityToModel(Cart cart){
        return CartModel.builder()
                .id(cart.getId())
                .items(cart.getItems())
                .build();
    }
    public Cart modelToEntity(CartModel shoppingCart){
        return Cart.builder()
                .id(shoppingCart.getId())
                .items(shoppingCart.getItems())
                .build();
    }

    public static CartResponse modelToDto(CartModel shoppingCart){
        return CartResponse.builder()
                .id(shoppingCart.getId())
                .items(shoppingCart.getItems())
                .build();
    }
     public CartModel dtoToModel(CartResponse shoppingCart){
        return CartModel.builder()
                .id(shoppingCart.getId())
                .items(shoppingCart.getItems())
                .build();
    }


}
