package com.ars.YouBuy.shopingcart.mapper;

import com.ars.YouBuy.shopingcart.rest.dto.dto.CartItemResponse;
import com.ars.YouBuy.shopingcart.entity.CartItem;
import com.ars.YouBuy.shopingcart.model.CartItemModel;
import org.springframework.stereotype.Component;

@Component()
public class CartItemMapper {
    public CartItemModel entityToModel(CartItem cartItem){
        return CartItemModel.builder()
                .id(cartItem.getId())
                .productId(cartItem.getProductId())
                .quantity(cartItem.getQuantity())
                .build();
    }
    public static CartItem modelToEntity(CartItemModel shoppingCartItem){
        return CartItem.builder()
                .id(shoppingCartItem.getId())
                .productId(shoppingCartItem.getProductId())
                .quantity(shoppingCartItem.getQuantity())
                .build();
    }

    public CartItemResponse modelToDto(CartItemModel shoppingCartItem){
        return CartItemResponse.builder()
                .id(shoppingCartItem.getId())
                .productId(shoppingCartItem.getProductId())
                .quantity(shoppingCartItem.getQuantity())
                .build();
    }
    public static CartItemModel dtoToModel(CartItemResponse shoppingCartItem){
        return CartItemModel.builder()
                .id(shoppingCartItem.getId())
                .productId(shoppingCartItem.getProductId())
                .quantity(shoppingCartItem.getQuantity())
                .build();
    }


}
