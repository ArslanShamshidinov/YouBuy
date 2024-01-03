package com.ars.YouBuy.order.service;

import com.ars.YouBuy.order.mapper.OrderItemMapper;
import com.ars.YouBuy.order.model.OrderItemModel;
import com.ars.YouBuy.order.repository.OrderItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderItemService {

        private final OrderItemMapper orderItemMapper;
        private final OrderItemRepository orderItemRepository;

        public void save (OrderItemModel orderItem){
            orderItemRepository.save(orderItemMapper.modelToEntity(orderItem));
        }

        public List<OrderItemModel> findAll(){
            return orderItemRepository.findAll().stream()
                    .map(orderItemMapper::entityToModel)
                    .toList();
        }

        public Optional<OrderItemModel> findById(Integer id){
            return orderItemRepository.findById(id)
                    .map(orderItemMapper::entityToModel);
        }
        public void productDelete(Integer id){
            orderItemRepository.deleteById(id);
        }
}
