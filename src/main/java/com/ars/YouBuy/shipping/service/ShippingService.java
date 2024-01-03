package com.ars.YouBuy.shipping.service;


import com.ars.YouBuy.shipping.mapper.ShippingMapper;
import com.ars.YouBuy.shipping.model.ShippingModel;
import com.ars.YouBuy.shipping.repository.ShippingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShippingService {
private final ShippingMapper shippingMapper;
private final ShippingRepository shippingRepository;

public void save (ShippingModel shipping){
    shippingRepository.save(shippingMapper.modelToEntity(shipping));
}


public List<ShippingModel> findAll(){
    return shippingRepository.findAll().stream()
            .map(shippingMapper::entityToModel)
            .toList();
}

public Optional<ShippingModel> findById(Integer id){
    return shippingRepository.findById(id)
    .map(shippingMapper::entityToModel);
}
public void productDelete(Integer id){
    shippingRepository.deleteById(id);
    }
}
