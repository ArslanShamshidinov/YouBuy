package com.ars.YouBuy.order.mapper;

import com.ars.YouBuy.order.rest.dto.dto.OrderItemResponse;
import com.ars.YouBuy.order.entity.OrderItem;
import com.ars.YouBuy.order.model.OrderItemModel;
import org.springframework.stereotype.Component;

@Component
public class OrderItemMapper {
    public OrderItemModel entityToModel(OrderItem orderItem){
        return OrderItemModel.builder()
                .id(orderItem.getId())
                .price(orderItem.getPrice())
                .productId(orderItem.getProductId())
                .quantity(orderItem.getQuantity())
                .build();
    }

    public OrderItem modelToEntity(OrderItemModel orderItem){
        return OrderItem.builder()
                .id(orderItem.getId())
                .price(orderItem.getPrice())
                .productId(orderItem.getProductId())
                .quantity(orderItem.getQuantity())
                .build();
    }

    public OrderItemModel dtoToModel(OrderItemResponse orderItem){
        return OrderItemModel.builder()
                .id(orderItem.getId())
                .price(orderItem.getPrice())
                .productId(orderItem.getProductId())
                .quantity(orderItem.getQuantity())
                .build();
    }

    public OrderItemResponse modelToDto(OrderItemModel orderItem){
        return OrderItemResponse.builder()
                .id(orderItem.getId())
                .price(orderItem.getPrice())
                .productId(orderItem.getProductId())
                .quantity(orderItem.getQuantity())
                .build();
    }
}
