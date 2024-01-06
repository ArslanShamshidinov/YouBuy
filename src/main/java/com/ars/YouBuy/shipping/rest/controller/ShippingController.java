package com.ars.YouBuy.shipping.rest.controller;

import com.ars.YouBuy.shipping.mapper.ShippingMapper;
import com.ars.YouBuy.shipping.rest.dto.dto.ShippingResponse;
import com.ars.YouBuy.shipping.service.ShippingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/shipping")
@RequiredArgsConstructor
public class ShippingController {

    private final ShippingService shippingService;

    @GetMapping("/")
    public List<ShippingResponse> getAll() {
        return shippingService.findAll().stream().map(ShippingMapper::modelToDto).toList();
    }

    @GetMapping("/{id}")
    public Optional<ShippingResponse> getById(@PathVariable Integer id) {
        return shippingService.findById(id).map(ShippingMapper::modelToDto);
    }
}
