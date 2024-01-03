package com.ars.YouBuy.shopingcart.mapper;

import com.ars.YouBuy.shopingcart.dto.ShoppingCartResponse;
import com.ars.YouBuy.shopingcart.entity.ShoppingCart;
import com.ars.YouBuy.shopingcart.model.ShoppingCartModel;
import org.springframework.stereotype.Component;

@Component()
public class ShoppingCartMapper{
    public ShoppingCartModel entityToModel(ShoppingCart shoppingCart){
        return ShoppingCartModel.builder()
                .id(shoppingCart.getId())
                .items(shoppingCart.getItems())
                .build();
    }
    public ShoppingCart modelToEntity(ShoppingCartModel shoppingCart){
        return ShoppingCart.builder()
                .id(shoppingCart.getId())
                .items(shoppingCart.getItems())
                .build();
    }

    public ShoppingCartResponse modelToDto(ShoppingCartModel shoppingCart){
        return ShoppingCartResponse.builder()
                .id(shoppingCart.getId())
                .items(shoppingCart.getItems())
                .build();
    }
     public ShoppingCartModel dtoToModel(ShoppingCartResponse shoppingCart){
        return ShoppingCartModel.builder()
                .id(shoppingCart.getId())
                .items(shoppingCart.getItems())
                .build();
    }


}
