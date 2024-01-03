package com.ars.YouBuy.order.service;

import com.ars.YouBuy.order.mapper.OrderMapper;
import com.ars.YouBuy.order.model.OrderModel;
import com.ars.YouBuy.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;

    public void save (OrderModel order){
        orderRepository.save(orderMapper.modelToEntity(order));
    }

    public List<OrderModel> findAll(){
        return orderRepository.findAll().stream()
                .map(orderMapper::entityToModel)
                .toList();
    }

    public Optional<OrderModel> findById(Integer id){
        return orderRepository.findById(id)
                .map(orderMapper::entityToModel);
    }
    public void productDelete(Integer id){
        orderRepository.deleteById(id);
    }
}
