package com.ars.YouBuy.shipping.mapper;

import com.ars.YouBuy.shipping.dto.ShippingResponse;
import com.ars.YouBuy.shipping.entity.Shipping;
import com.ars.YouBuy.shipping.model.ShippingModel;
import org.springframework.stereotype.Component;

@Component
public class ShippingMapper {
    public ShippingModel entityToModel(Shipping shipping){
        return ShippingModel.builder()
                .id(shipping.getId())
                .name(shipping.getName())
                .build();
    }

    public Shipping modelToEntity(ShippingModel shipping){
        return Shipping.builder()
                .id(shipping.getId())
                .name(shipping.getName())
                .build();
    }

    public ShippingModel dtoToModel(ShippingResponse shipping){
        return ShippingModel.builder()
                .id(shipping.getId())
                .name(shipping.getName())
                .build();
    }

    public ShippingResponse modelToDto(ShippingModel shipping){
        return ShippingResponse.builder()
                .id(shipping.getId())
                .name(shipping.getName())
                .build();
    }

}
