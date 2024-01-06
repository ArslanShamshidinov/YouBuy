package com.ars.YouBuy.order.rest.controller;

import com.ars.YouBuy.order.mapper.OrderMapper;
import com.ars.YouBuy.order.rest.dto.dto.OrderResponse;
import com.ars.YouBuy.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/")
    public List<OrderResponse> getAll() {
        return orderService.findAll().stream().map(OrderMapper::modelToDto).toList();
    }

    @GetMapping("/{id}")
    public Optional<OrderResponse> getById(@PathVariable Integer id) {
        return orderService.findById(id).map(OrderMapper::modelToDto);
    }
}
