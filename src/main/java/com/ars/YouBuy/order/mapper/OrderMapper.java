package com.ars.YouBuy.order.mapper;

import com.ars.YouBuy.order.dto.OrderResponse;
import com.ars.YouBuy.order.entity.Order;
import com.ars.YouBuy.order.model.OrderModel;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public OrderModel entityToModel(Order order){
        return OrderModel.builder()
                .id(order.getId())
                .created(order.getCreated())
                .userId(order.getUserId())
                .items(order.getItems())
                .shippingId(order.getShippingId())
                .build();
    }

    public Order modelToEntity(OrderModel order){
        return Order.builder()
                .id(order.getId())
                .created(order.getCreated())
                .userId(order.getUserId())
                .items(order.getItems())
                .shippingId(order.getShippingId())
                .build();
    }

    public OrderModel dtoToModel(OrderResponse order){
        return OrderModel.builder()
                .id(order.getId())
                .created(order.getCreated())
                .userId(order.getUserId())
                .items(order.getItems())
                .shippingId(order.getShippingId())
                .build();
    }

    public OrderResponse modelToDto(OrderModel order){
        return OrderResponse.builder()
                .id(order.getId())
                .created(order.getCreated())
                .userId(order.getUserId())
                .items(order.getItems())
                .shippingId(order.getShippingId())
                .build();
    }
}
