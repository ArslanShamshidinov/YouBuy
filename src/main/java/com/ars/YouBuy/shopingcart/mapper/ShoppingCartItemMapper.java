package com.ars.YouBuy.shopingcart.mapper;

import com.ars.YouBuy.shopingcart.dto.ShoppingCartItemResponse;
import com.ars.YouBuy.shopingcart.entity.ShoppingCartItem;
import com.ars.YouBuy.shopingcart.model.ShoppingCartItemModel;
import org.springframework.stereotype.Component;

@Component()
public class ShoppingCartItemMapper {
    public ShoppingCartItemModel entityToModel(ShoppingCartItem shoppingCartItem){
        return ShoppingCartItemModel.builder()
                .id(shoppingCartItem.getId())
                .productId(shoppingCartItem.getProductId())
                .quantity(shoppingCartItem.getQuantity())
                .build();
    }
    public ShoppingCartItem modelToEntity(ShoppingCartItemModel shoppingCartItem){
        return ShoppingCartItem.builder()
                .id(shoppingCartItem.getId())
                .productId(shoppingCartItem.getProductId())
                .quantity(shoppingCartItem.getQuantity())
                .build();
    }

    public ShoppingCartItemResponse modelToDto(ShoppingCartItemModel shoppingCartItem){
        return ShoppingCartItemResponse.builder()
                .id(shoppingCartItem.getId())
                .productId(shoppingCartItem.getProductId())
                .quantity(shoppingCartItem.getQuantity())
                .build();
    }
    public ShoppingCartItemModel dtoToModel(ShoppingCartItemResponse shoppingCartItem){
        return ShoppingCartItemModel.builder()
                .id(shoppingCartItem.getId())
                .productId(shoppingCartItem.getProductId())
                .quantity(shoppingCartItem.getQuantity())
                .build();
    }


}
